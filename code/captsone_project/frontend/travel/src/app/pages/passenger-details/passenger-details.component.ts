import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Passenger } from '../../core/models/passenger.model';
import { BookingService } from '../../core/services/booking.service';

@Component({
  selector: 'app-passenger-details',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './passenger-details.component.html',
  styleUrls: ['./passenger-details.component.css']
})

export class PassengerDetailsComponent {
  flightId = 0;
  passenger: Passenger = {
    fullName: '',
    dateOfBirth: '',
    gender: '',
    email: '',
    phoneNumber: '',
    address: '',
    passportId: '',
    specialRequests: ''
  };
  constructor(
    private route: ActivatedRoute, 
    private router: Router, 
    private bookingService: BookingService
  ) {
    this.route.queryParamMap.subscribe(p => {
      const qid = p.get('flightId');
      if (qid) {
        this.flightId = +qid;
      } else {
        const saved = localStorage.getItem('selectedFlight');
        if (saved) this.flightId = JSON.parse(saved)?.id || 0;
      }
    });
  }
  submit() {
    if (!this.flightId) { alert('Flight not selected'); return; }
    this.bookingService.createBooking(this.flightId, this.passenger).subscribe({
      next: (b) => {
        localStorage.setItem('bookingId', String(b.id));
        this.router.navigate(['/payment'], { queryParams: { bookingId: b.id } });
      },
      error: () => alert('Failed to create booking')
    });
  }
}