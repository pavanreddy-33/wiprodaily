import { CommonModule } from '@angular/common';
import { Component, NgModule } from '@angular/core';
import { FormsModule, NgModel } from '@angular/forms';
import { Router } from '@angular/router';
import { Flightservice } from '../flightservice';

@Component({
  selector: 'app-home',
  imports: [FormsModule,CommonModule],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home {
  source = '';
  destination = '';
  date: string = '';

  error = '';

  constructor(private flightService: Flightservice, private router: Router) {}

  searchFlights() {
    this.error = '';
    if (!this.source || !this.destination || !this.date) {
      this.error = 'Please enter source, destination and travel date.';
      return;
    }

    this.flightService.search(this.source.trim(), this.destination.trim(), this.date).subscribe(
      (results) => {
        // navigate to results and pass data through history state
        this.router.navigate(['/results'], { state: { results }});
      },
      (err) => {
        console.error(err);
        this.error = 'Error searching flights. Please try later.';
      }
    );
  }
}
