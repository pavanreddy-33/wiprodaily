import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Flightservice } from '../flightservice';
import { Bookingservice } from '../bookingservice';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-booking',
  imports: [FormsModule,CommonModule],
  templateUrl: './booking.html',
  styleUrl: './booking.css'
})
export class Booking implements OnInit{
 flight: any = null;
  passengerName = '';
  travelDate = '';
  cardNumber = '';
  expiry = ''; // MM/yyyy
  error = '';
  submitting = false;

  constructor(private route: ActivatedRoute, private bookingService: Bookingservice, private router: Router) {}

  ngOnInit(): void {
    this.flight = history.state.flight || null;
    // if no flight in state, could fetch by id - omitted for brevity
  }

  validateCard(): boolean {
    this.error = '';
    if (!this.passengerName) { this.error = 'Passenger name required'; return false; }
    if (!this.travelDate) { this.error = 'Travel date required'; return false; }
    if (!this.cardNumber || this.cardNumber.replace(/\s+/g,'').length !== 16) { this.error = 'Card number must be 16 digits'; return false; }
    if (!this.expiry || !this.checkExpiry(this.expiry)) { this.error = 'Expiry must be in MM/yyyy format and later than today'; return false; }
    return true;
  }

  checkExpiry(expiry: string): boolean {
    try {
      const parts = expiry.split('/');
      if (parts.length !== 2) return false;
      const mm = Number(parts[0]);
      const yyyy = Number(parts[1]);
      if (!mm || !yyyy || mm < 1 || mm > 12) return false;
      const now = new Date();
      const lastDay = new Date(yyyy, mm, 0); // last day of month
      return lastDay > now;
    } catch (e) { return false; }
  }

  onBook() {
    if (!this.validateCard()) return;
    this.submitting = true;
    const payload = {
      flightId: this.flight.id,
      passengerName: this.passengerName,
      travelDate: this.travelDate,
      cardNumber: this.cardNumber.replace(/\s+/g,''),
      expiry: this.expiry,
      paymentMode: 'CARD'
    };
    this.bookingService.createBooking(payload).subscribe({
      next: (b:any) => {
        this.submitting = false;
        // navigate to payment page and start polling there
        this.router.navigate(['/payment', b.bookingId]);
      },
      error: err => {
        console.error(err);
        this.submitting = false;
        this.error = 'Failed to create booking. Try again.';
      }
    });
  }
}
