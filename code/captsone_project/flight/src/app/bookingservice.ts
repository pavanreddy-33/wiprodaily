import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Booking } from './booking';

@Injectable({
  providedIn: 'root'
})
export class Bookingservice {
  private base = 'http://localhost:9010/booking-ms/api/booking';
  constructor(private http: HttpClient) {}

  searchFlights(source: string, destination: string, date: string): Observable<any[]> {
    const url = `${this.base}/search?source=${encodeURIComponent(source)}&destination=${encodeURIComponent(destination)}&date=${encodeURIComponent(date)}`;
    return this.http.get<any[]>(url);
  }

  createBooking(payload: any): Observable<Booking> {
    return this.http.post<Booking>(`${this.base}/book`, payload);
  }

  getBooking(bookingId: string): Observable<Booking> {
    return this.http.get<Booking>(`${this.base}/${bookingId}`);
  }

}
