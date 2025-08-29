import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Bookingservice } from '../bookingservice';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-failure',
  imports: [CommonModule],
  templateUrl: './failure.html',
  styleUrl: './failure.css'
})
export class Failure {
  bookingId = '';
  booking: any;
  constructor(private route: ActivatedRoute, private bookingService: Bookingservice) {}
  ngOnInit(): void {
    this.bookingId = this.route.snapshot.paramMap.get('bookingId') || '';
    if (this.bookingId) {
      this.bookingService.getBooking(this.bookingId).subscribe(b => this.booking = b);
    }
  }
}
