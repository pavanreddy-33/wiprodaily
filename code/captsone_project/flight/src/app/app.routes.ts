import { Routes } from '@angular/router';
import { Home } from './home/home';
import { Booking } from './booking/booking';
import { Navbar } from './navbar/navbar';
import { Payment } from './payment/payment';
import { Success } from './success/success';
import { Failure } from './failure/failure';
import { SearchResults } from './search-results/search-results';

export const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: Home, title: 'Search Flights' },
  { path: 'results', component: SearchResults, title: 'Results' },
  { path: 'booking/:flightId', component: Booking, title: 'Booking' },
  { path: 'payment/:bookingId', component: Payment, title: 'Payment' },
  { path: 'success/:bookingId', component: Success, title: 'Success' },
  { path: 'failure/:bookingId', component: Failure, title: 'Failure' },
  { path: '**', redirectTo: 'home' }
];