import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Flight } from '../../core/models/flight.model';
import { FlightService } from '../../core/services/flight.service';
import { DurationPipe } from '../../pipes/duration.pipe';
import { LoadingSpinnerComponent } from '../../components/shared/loading-spinner/loading-spinner.component';

@Component({
  selector: 'app-flight-results',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule, DurationPipe, LoadingSpinnerComponent],
  templateUrl: './flight-results.component.html',
  styleUrls: ['./flight-results.component.css']
})
export class FlightResultsComponent implements OnInit {
  origin = '';
  destination = '';
  date = '';
  loading = false;
  flights: Flight[] = [];
  filtered: Flight[] = [];

  nonStop = false;
  airlines: { name: string; checked: boolean }[] = [];
  minPrice = 0;
  maxPrice = 50000;
  price = 50000;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private flightService: FlightService,
    private toast: ToastrService
  ) {}

  ngOnInit(): void {
    this.route.queryParams.subscribe(p => {
      this.origin = p['origin'] || '';
      this.destination = p['destination'] || '';
      this.date = p['date'] || '';
      if (!this.origin || !this.destination || !this.date) {
        this.toast.error('Invalid search parameters');
        this.router.navigate(['/']);
        return;
      }
      this.fetch();
    });
  }

  fetch() {
    this.loading = true;
    this.flightService.search({ origin: this.origin, destination: this.destination, date: this.date }).subscribe({
      next: (res) => {
        this.flights = res || [];
        this.filtered = [...this.flights];
        const uniqueAirlines = [...new Set(this.flights.map(f => f.airline))].sort();
        this.airlines = uniqueAirlines.map(a => ({ name: a, checked: false }));
        const prices = this.flights.map(f => f.price);
        this.minPrice = Math.min(...prices) || 0;
        this.maxPrice = Math.max(...prices) || 50000;
        this.price = this.maxPrice;
      },
      error: () => {
        this.toast.error('Error fetching flights');
        this.loading = false;
      },
      complete: () => this.loading = false
    });
  }

  applyFilters() {
    this.filtered = this.flights.filter(f => {
      if (this.nonStop && f.stops !== 0) return false;
      const selectedAirlines = this.airlines.filter(a => a.checked).map(a => a.name);
      if (selectedAirlines.length > 0 && !selectedAirlines.includes(f.airline)) return false;
      if (f.price > this.price) return false;
      return true;
    });
  }

  clearAll() {
    this.nonStop = false;
    this.airlines.forEach(a => a.checked = false);
    this.price = this.maxPrice;
    this.applyFilters();
  }

  // book(f: Flight) {
  //   localStorage.setItem('selectedFlight', JSON.stringify(f));
  //   this.router.navigate(['/passenger-details']);
  // }

  book(f: Flight) {
localStorage.setItem('selectedFlight', JSON.stringify(f));
this.router.navigate(['/booking'], { queryParams: { flightId: f.id } });
}
}