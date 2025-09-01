import { CommonModule } from '@angular/common';
import { Component, OnDestroy } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { BookingService } from '../../core/services/booking.service';
import { PaymentService } from '../../core/services/payment.service';
import { CardPayment } from '../../core/models/payment.model';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-payment',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnDestroy {
  bookingId = 0;
  loading   = false;
  sub?: Subscription;

  methods = [
    { key: 'UPI',         label: 'UPI',         enabled: false },
    { key: 'CREDIT_CARD', label: 'Credit Card', enabled: true  },
    { key: 'DEBIT_CARD',  label: 'Debit Card',  enabled: false },
    { key: 'NET_BANKING', label: 'Net Banking', enabled: false },
    { key: 'WALLET',      label: 'Wallets',     enabled: false }
  ];
  activeMethod = 'CREDIT_CARD';

  payment: CardPayment = {
    amount:      0,
    method:      'CREDIT_CARD',
    cardNumber:  '',
    nameOnCard:  '',
    expiryMonth: '',
    expiryYear:  '',
    cvv:         ''
  };

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private toastr: ToastrService,
    private bookingService: BookingService,
    private paymentService: PaymentService
  ) {
    this.route.queryParamMap.subscribe(p => {
      const id = p.get('bookingId') || localStorage.getItem('bookingId');
      this.bookingId = id ? +id : 0;
      if (!this.bookingId) {
        this.toastr.error('Booking Id missing');
      }
    });

    const selected = localStorage.getItem('selectedFlight');
    const price = selected ? JSON.parse(selected).price : 5500;
    this.payment.amount = Math.round(price || 5500);
  }

  ngOnDestroy(): void {
    this.sub?.unsubscribe();
  }

  chooseMethod(key: string, enabled: boolean) {
    if (!enabled) {
      this.toastr.info('Only Credit Card is enabled for demo');
      return;
    }
    this.activeMethod = key;
    this.payment.method = key;
  }

  // Clear reason why the button is disabled (null means OK)
  get disabledReason(): string | null {
    if (!this.bookingId) return 'Missing booking id';

    const n = (this.payment.cardNumber || '').replace(/\s+/g, '');
    if (!/^\d{16}$/.test(n)) return 'Enter 16‑digit card number';

    if (!this.payment.nameOnCard || this.payment.nameOnCard.trim().length < 2) {
      return 'Enter cardholder name';
    }

    const m = Number(this.payment.expiryMonth || 0);
    const y = Number(this.payment.expiryYear || 0);
    if (!(m >= 1 && m <= 12)) return 'Enter valid expiry month (01‑12)';

    const now = new Date();
    const future =
      y > now.getFullYear() || (y === now.getFullYear() && m >= now.getMonth() + 1);
    if (!future) return 'Expiry must be in the future';

    if (!/^\d{3}$/.test(this.payment.cvv || '')) return 'Enter 3‑digit CVV';
    if (!(this.payment.amount > 0)) return 'Invalid amount';

    return null;
  }

  pay() {
    if (this.disabledReason) {
      this.toastr.error(this.disabledReason);
      return;
    }
    this.loading = true;

    // Pad month to two digits (safe; backend accepts both)
    const payload: CardPayment = {
      ...this.payment,
      expiryMonth: String(this.payment.expiryMonth).padStart(2, '0')
    };

    this.paymentService.initiatePayment(this.bookingId, payload).subscribe({
      next: () => {
        this.toastr.info('Payment initiated...');
        this.sub = this.bookingService.pollStatus(this.bookingId, 1000, 30000).subscribe({
          next: (res) => {
            if (!res) return;
            if (res.status === 'successful') {
              this.sub?.unsubscribe();
              this.toastr.success('Payment successful');
              this.router.navigate(['/confirmation'], { queryParams: { bookingId: this.bookingId } });
            } else if (res.status === 'failed') {
              this.sub?.unsubscribe();
              this.toastr.error('Payment failed');
              this.router.navigate(['/failed'], { queryParams: { bookingId: this.bookingId } });
            }
          },
          complete: () => { this.loading = false; },
          error:    () => { this.loading = false; this.toastr.error('Error checking status'); }
        });
      },
      error: () => { this.loading = false; this.toastr.error('Failed to initiate payment'); }
    });
  }

  // Input sanitizers (optional but helpful)
  sanitizeCard() { this.payment.cardNumber  = (this.payment.cardNumber  || '').replace(/[^0-9]/g, '').slice(0, 16); }
  sanitizeMonth(){ this.payment.expiryMonth = (this.payment.expiryMonth || '').replace(/[^0-9]/g, '').slice(0,  2); }
  sanitizeYear() { this.payment.expiryYear  = (this.payment.expiryYear  || '').replace(/[^0-9]/g, '').slice(0,  4); }
  sanitizeCvv()  { this.payment.cvv         = (this.payment.cvv         || '').replace(/[^0-9]/g, '').slice(0,  3); }
}