import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiService } from './api.service';
import { environment } from '../../../environments/environment';
import { CardPayment } from '../models/payment.model';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {
  constructor(private api: ApiService) {}

  initiatePayment(bookingId: number, paymentDetails: CardPayment): Observable<any> {
    return this.api.post<any>(environment.endpoints.initiatePayment, paymentDetails, { bookingId });
  }
}