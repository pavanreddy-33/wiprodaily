import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Flightservice } from '../flightservice';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-search-results',
  imports: [FormsModule,CommonModule],
  templateUrl: './search-results.html',
  styleUrl: './search-results.css'
})
export class SearchResults implements OnInit{
  results: any[] = [];
  filtered: any[] = [];
  minPrice: number | null = null;
  maxPrice: number | null = null;
  airlineFilter = '';

  constructor(private router: Router) {}

  ngOnInit(): void {
    this.results = history.state.results || [];
    this.filtered = [...this.results];
  }

  applyFilters() {
    this.filtered = this.results.filter(r => {
      let ok = true;
      if (this.minPrice != null) { ok = ok && r.price >= this.minPrice; }
      if (ok && this.maxPrice != null) { ok = ok && r.price <= this.maxPrice; }
      if (ok && this.airlineFilter) { ok = ok && r.airline?.toLowerCase().includes(this.airlineFilter.toLowerCase()); }
      return ok;
    });
  }

  clearFilters() {
    this.minPrice = null; this.maxPrice = null; this.airlineFilter = '';
    this.filtered = [...this.results];
  }

  book(flight: any) {
    // pass flight through navigation state
    this.router.navigate(['/booking', flight.id], { state: { flight } });
  }
}
