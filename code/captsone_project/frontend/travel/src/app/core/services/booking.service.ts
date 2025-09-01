import { Injectable } from '@angular/core';
import { Observable, timer } from 'rxjs';
import { switchMap, takeWhile } from 'rxjs/operators';
import { ApiService } from './api.service';
import { environment } from '../../../environments/environment';
import { Booking } from '../models/booking.model';
import { Passenger } from '../models/passenger.model';

@Injectable({
  providedIn: 'root'
})
export class BookingService {
  constructor(private api: ApiService) {}

  createBooking(flightId: number, passengers: Passenger): Observable<Booking> {
    return this.api.post<Booking>(environment.endpoints.createBooking, passengers, { flightId });
  }

  getBookingById(id: number): Observable<Booking> {
    return this.api.get<Booking>(environment.endpoints.bookingById(id));
  }

  getStatus(id: number): Observable<{ status: string }> {
    return this.api.get<{ status: string }>(environment.endpoints.bookingStatus(id));
  }

  pollStatus(id: number, intervalMs = 1000, timeoutMs = 30000): Observable<{ status: string }> {
    const start = Date.now();
    return timer(0, intervalMs).pipe(
      switchMap(() => this.getStatus(id)),
      takeWhile(() => Date.now() - start < timeoutMs, true)
    );
  }
}