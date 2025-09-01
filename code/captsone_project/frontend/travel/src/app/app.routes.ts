import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { FlightResultsComponent } from './pages/flight-results/flight-results.component';
import { BookingComponent } from './pages/booking/booking.component';
import { PaymentComponent } from './pages/payment/payment.component';
import { ConfirmationComponent } from './pages/confirmation/confirmation.component';
import { FailedComponent } from './pages/failed/failed.component';


export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'flight-results', component: FlightResultsComponent },
  { path: 'booking', component: BookingComponent },
  { path: 'payment', component: PaymentComponent },
  { path: 'confirmation', component: ConfirmationComponent },
  { path: 'failed', component: FailedComponent }
];
