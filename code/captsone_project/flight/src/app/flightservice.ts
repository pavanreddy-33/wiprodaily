import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class Flightservice {
  private base = 'http://localhost:9010/flight-data-ms/api/flights';
  constructor(private http: HttpClient) {}
  search(source: string, destination: string, date: string) {
    const params = new HttpParams().set('source', source).set('destination', destination).set('date', date);
    return this.http.get<any[]>(`${this.base}/search`, { params });
  }
  getFlight(id: number) { 
    return this.http.get<any>(`${this.base}/${id}`); 
  }
}
