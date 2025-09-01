import { Injectable } from '@angular/core';
import { Observable, catchError, of } from 'rxjs';
import { ApiService } from './api.service';
import { Flight } from '../models/flight.model';
import { environment } from '../../../environments/environment';
import { SearchCriteria } from '../models/search-criteria.model';

@Injectable({
  providedIn: 'root'
})
export class FlightService {
  constructor(private api: ApiService) {}

  search(criteria: SearchCriteria): Observable<Flight[]> {
    return this.api.get<Flight[]>(environment.endpoints.search, criteria).pipe(
      // If backend returns 404 for no flights, surface an empty list to UI
      catchError((err) => {
        if (err?.status === 404) {
          return of([] as Flight[]);
        }
        throw err;
      })
    );
  }
}