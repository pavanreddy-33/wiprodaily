import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Bookingservice } from '../bookingservice';
import { interval, Subscription, switchMap } from 'rxjs';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-payment',
  imports: [CommonModule,FormsModule],
  templateUrl: './payment.html',
  styleUrl: './payment.css'
})
export class Payment{
  bookingId!: number;
  payment = { cardNumber: '', expiry: '', cvv: '' };

  constructor(private route: ActivatedRoute, private router: Router) {
    this.bookingId = Number(this.route.snapshot.paramMap.get('bookingId'));
  }

  pay() {
    if (this.payment.cardNumber.length === 16) {
      // In real app, call backend payment service
      this.router.navigate(['/success', this.bookingId]);
    } else {
      this.router.navigate(['/failure', this.bookingId]);
    }
  }
}
