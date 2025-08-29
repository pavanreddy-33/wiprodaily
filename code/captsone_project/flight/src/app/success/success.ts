import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Bookingservice } from '../bookingservice';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-success',
  imports: [CommonModule],
  templateUrl: './success.html',
  styleUrl: './success.css'
})
export class Success {
  bookingId = '';
  booking: any = null;
  constructor(private route: ActivatedRoute, private bookingService: Bookingservice) {}
  ngOnInit(): void {
    this.bookingId = this.route.snapshot.paramMap.get('bookingId') || '';
    if (this.bookingId) {
      this.bookingService.getBooking(this.bookingId).subscribe(b => this.booking = b);
    }
  }

  downloadTicket() {
  if (!this.booking) return;
  const blob = new Blob([JSON.stringify(this.booking, null, 2)], { type: 'application/json' });
  const url = URL.createObjectURL(blob);
  const a = document.createElement('a');
  a.href = url;
  a.download = `ticket-${this.booking.bookingId}.json`;
  a.click();
  URL.revokeObjectURL(url);
}
}
