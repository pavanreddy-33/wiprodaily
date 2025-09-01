import { CommonModule } from '@angular/common';
import { Component, ElementRef, ViewChild } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { BookingService } from '../../core/services/booking.service';
import { Booking } from '../../core/models/booking.model';
import { Flight } from '../../core/models/flight.model';
import { AIRPORTS } from '../../components/shared/airports';
import html2canvas from 'html2canvas';
import jsPDF from 'jspdf';

@Component({
selector: 'app-confirmation',
standalone: true,
imports: [CommonModule, RouterModule],
templateUrl: './confirmation.component.html',
styleUrls: ['./confirmation.component.css']
})
export class ConfirmationComponent {
@ViewChild('ticket', { static: false }) ticketRef!: ElementRef<HTMLDivElement>;

booking?: Booking;
bookingId = 0;
flight: Flight | null = null;

AIRPORTS = AIRPORTS;

pnr = '';
eTicketNo = '';
seats: string[] = [];
amountPaid = 0;
bookedOn = new Date().toLocaleDateString();

constructor(private route: ActivatedRoute, private bookingService: BookingService) {
this.route.queryParamMap.subscribe(p => {
const idStr = p.get('bookingId');
this.bookingId = idStr ? +idStr : 0;

  const saved = localStorage.getItem('selectedFlight');
  this.flight = saved ? JSON.parse(saved) : null;

  if (this.flight?.price) {
    this.amountPaid = Math.round(this.flight.price);
  }

  if (this.bookingId) {
    this.bookingService.getBookingById(this.bookingId).subscribe(b => {
      this.booking = b;
      this.initExtras();
    });
  } else {
    this.initExtras();
  }
});
}

private initExtras() {
const pnrKey = `pnr_${this.bookingId}`;
const etKey = `etk_${this.bookingId}`;
const seatKey = `seats_${this.bookingId}`;


this.pnr = localStorage.getItem(pnrKey) || this.generatePNR();
this.eTicketNo = localStorage.getItem(etKey) || this.generateEticket();

const savedSeats = localStorage.getItem(seatKey);
if (savedSeats) {
  try { this.seats = JSON.parse(savedSeats) as string[]; } catch { this.seats = []; }
}
if (!this.seats.length) {
  const count = this.booking?.passengers?.length || (JSON.parse(localStorage.getItem('passengers') || '[]') as any[]).length || 1;
  this.seats = this.generateSeats(count);
}

localStorage.setItem(pnrKey, this.pnr);
localStorage.setItem(etKey, this.eTicketNo);
localStorage.setItem(seatKey, JSON.stringify(this.seats));
}

private generatePNR(): string {
const chars = 'ABCDEFGHJKLMNPQRSTUVWXYZ23456789';
let s = '';
for (let i = 0; i < 6; i++) s += chars[Math.floor(Math.random() * chars.length)];
return s;
}

private generateEticket(): string {
const chars = 'ABCDEFGHJKLMNPQRSTUVWXYZ0123456789';
let s = '';
for (let i = 0; i < 6; i++) s += chars[Math.floor(Math.random() * chars.length)];
return s;
}

private generateSeats(count: number): string[] {
  const letters = ['A','B','C','D','E','F'];
  const seats: string[] = [];
  let row = (this.bookingId % 30) + 1;
  let colIdx = this.bookingId % letters.length;
  for (let i = 0; i < count; i++) {
    seats.push(`${row}${letters[colIdx]}`);
    colIdx++;
    if (colIdx >= letters.length) { colIdx = 0; row++; }
  }
  return seats;
}

codeFor(city: string): string {
const info = this.AIRPORTS[city];
return info ? info.code : '';
}
nameFor(city: string): string {
const info = this.AIRPORTS[city];
return info ? info.name : '';
}

formatTime(t?: string): string {
if (!t) return '';
return t.length >= 5 ? t.slice(0, 5) : t;
}
duration(mins?: number): string {
if (!mins && mins !== 0) return '';
const h = Math.floor((mins as number) / 60);
const m = (mins as number) % 60;
return `${h > 0 ? h + 'h ' : ''}${m > 0 ? m + 'm' : ''}`.trim();
}
stopsLabel(stops?: number): string {
if (stops == null) return '';
return stops === 0 ? 'Non stop' : `${stops} stop${stops > 1 ? 's' : ''}`;
}
prettyDate(d?: string): string {
if (!d) return '';
const dt = new Date(`${d}T00:00:00`);
return dt.toLocaleDateString(undefined, { weekday: 'short', month: 'short', day: 'numeric' });
}

async downloadPdf() {
if (!this.ticketRef) return;
const el = this.ticketRef.nativeElement;
const canvas = await html2canvas(el, { scale: 2, backgroundColor: '#ffffff' });
const imgData = canvas.toDataURL('image/png');
const pdf = new jsPDF('p', 'mm', 'a4');
const pdfW = 190;
const imgProps = (pdf as any).getImageProperties(imgData);
const pdfH = (imgProps.height * pdfW) / imgProps.width;
pdf.addImage(imgData, 'PNG', 10, 10, pdfW, pdfH);
pdf.save(`ticket_${this.bookingId}.pdf`);
}
}