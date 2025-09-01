import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Flight } from '../models/flight.model';

@Injectable({ providedIn: 'root' })
export class StateService {
private selectedFlight$ = new BehaviorSubject<Flight | null>(null);
private bookingId$ = new BehaviorSubject<number | null>(null);

setSelectedFlight(f: Flight | null) {
this.selectedFlight$.next(f);
if (f) localStorage.setItem('selectedFlight', JSON.stringify(f));
else localStorage.removeItem('selectedFlight');
}
getSelectedFlight(): Flight | null {
const mem = this.selectedFlight$.value;
if (mem) return mem;
const s = localStorage.getItem('selectedFlight');
return s ? JSON.parse(s) : null;
}

setBookingId(id: number | null) {
this.bookingId$.next(id);
if (id != null) localStorage.setItem('bookingId', String(id));
else localStorage.removeItem('bookingId');
}
getBookingId(): number | null {
const mem = this.bookingId$.value;
if (mem != null) return mem;
const s = localStorage.getItem('bookingId');
return s ? +s : null;
}
}