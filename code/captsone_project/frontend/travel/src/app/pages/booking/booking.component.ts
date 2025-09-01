import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { DurationPipe } from '../../pipes/duration.pipe';
import { BookingService } from '../../core/services/booking.service';
import { Flight } from '../../core/models/flight.model';
import { AIRPORTS } from '../../components/shared/airports';

@Component({
  selector: 'app-booking',
  standalone: true,
  imports: [CommonModule, FormsModule, DurationPipe],
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css'],
})
export class BookingComponent {
  flight?: Flight;
  flightId = 0;

  // date max for inputs
  maxDob = new Date();
  readonly maxPassengers = 6;

  // Passengers list (supports multiple passengers)
  passengers: Array<{
    fullName: string;
    dateOfBirth: string; // set from dobStr before submit
    gender: string;
    email: string;
    phoneNumber: string;
    address: string;
    passportId: string;
    specialRequests: string;
    dobStr: string; // bound to native date input (yyyy-MM-dd)
  }> = [
    { fullName: '', dateOfBirth: '', gender: '', email: '', phoneNumber: '', address: '', passportId: '', specialRequests: '', dobStr: '' }
  ];

  submitting = false;
  AIRPORTS = AIRPORTS;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private bookingService: BookingService
  ) {
    this.route.queryParamMap.subscribe((p) => {
      const id = p.get('flightId');
      this.flightId = id ? +id : 0;
      const saved = localStorage.getItem('selectedFlight');
      this.flight = saved ? JSON.parse(saved) : undefined;
    });
  }

  codeFor(city: string): string {
    const info = this.AIRPORTS[city];
    return info ? info.code : '';
  }

  nameFor(city: string): string {
    const info = this.AIRPORTS[city];
    return info ? info.name : '';
  }

  dobValidAt(i: number): boolean {
    const dob = this.passengers[i]?.dobStr;
    if (!dob) return false;
    const d = new Date(dob);
    if (isNaN(d.getTime())) return false;
    const today = new Date();
    const dd = new Date(d.getFullYear(), d.getMonth(), d.getDate());
    const tt = new Date(today.getFullYear(), today.getMonth(), today.getDate());
    return dd.getTime() <= tt.getTime() && d.getFullYear() >= 1900;
  }

  emailValidAt(i: number): boolean {
    const email = this.passengers[i]?.email || '';
    return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
  }

  phoneValidAt(i: number): boolean {
    const phone = this.passengers[i]?.phoneNumber || '';
    return /^[0-9]{10}$/.test(phone);
  }

  formValid(): boolean {
    if (!this.passengers.length) return false;
  return this.passengers.every((p, i) =>
      !!(
        p.fullName &&
        p.gender &&
    this.emailValidAt(i) &&
    this.phoneValidAt(i) &&
    this.dobValidAt(i)
      )
    );
  }

  addPassenger() {
    if (this.passengers.length >= this.maxPassengers) {
      return;
    }
    this.passengers.push({ fullName: '', dateOfBirth: '', gender: '', email: '', phoneNumber: '', address: '', passportId: '', specialRequests: '', dobStr: '' });
  }

  removePassenger(i: number) {
    if (this.passengers.length > 1) {
      this.passengers.splice(i, 1);
    }
  }

  proceed() {
    if (!this.flightId || !this.flight) return;
    if (!this.formValid()) return;

  // Prepare DOB for each passenger
  this.passengers = this.passengers.map((p) => ({ ...p, dateOfBirth: p.dobStr }));

  // Persist all passengers for later use (PDF/ticket)
  localStorage.setItem('passengers', JSON.stringify(this.passengers));

  this.submitting = true;
  this.bookingService.createBooking(this.flightId, this.passengers as any).subscribe({
      next: (b) => {
        localStorage.setItem('bookingId', String(b.id));
        this.router.navigate(['/payment'], { queryParams: { bookingId: b.id } });
      },
      error: () => {
        this.submitting = false;
        alert('Failed to create booking');
      },
    });
  }
}