import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AIRPORTS } from '../../components/shared/airports';

type AirportOption = { city: string; code: string; name: string };

@Component({
selector: 'app-home',
standalone: true,
imports: [CommonModule, FormsModule],
templateUrl: './home.component.html',
styleUrls: ['./home.component.css']
})
export class HomeComponent {
// Build airport list from shared constants
allAirports: AirportOption[] = Object.entries(AIRPORTS).map(([city, a]) => ({
city, code: a.code, name: a.name
}));

fromText = '';
toText = '';
fromSel: AirportOption | null = null;
toSel: AirportOption | null = null;

fromResults: AirportOption[] = [];
toResults: AirportOption[] = [];
showFrom = false;
showTo = false;

today = new Date();
minDateStr = this.toIso(this.today);
dateStr = this.minDateStr;

submitted = false;
readonly maxSuggestions = 12;

constructor(private router: Router) {}

private toIso(d: Date): string {
const yyyy = d.getFullYear();
const mm = String(d.getMonth() + 1).padStart(2, '0');
const dd = String(d.getDate()).padStart(2, '0');
return `${yyyy}-${mm}-${dd}`;
}

// No minimum length; show full list when term is empty
private filterAirports(term: string): AirportOption[] {
const t = term.trim().toLowerCase();
const list = !t
? this.allAirports
: this.allAirports.filter(a =>
a.city.toLowerCase().includes(t) ||
a.code.toLowerCase().includes(t) ||
a.name.toLowerCase().includes(t)
);
return list.slice(0, this.maxSuggestions);
}

onFromFocus() {
this.fromResults = this.filterAirports(this.fromText);
this.showFrom = true;
}
onToFocus() {
this.toResults = this.filterAirports(this.toText);
this.showTo = true;
}

onFromInput(v: string) {
this.fromText = v;
this.fromSel = null;
this.fromResults = this.filterAirports(v);
this.showFrom = true;
}
onToInput(v: string) {
this.toText = v;
this.toSel = null;
this.toResults = this.filterAirports(v);
this.showTo = true;
}

chooseFrom(a: AirportOption) {
this.fromSel = a;
this.fromText = `${a.city} (${a.code})`;
this.showFrom = false;
}
chooseTo(a: AirportOption) {
this.toSel = a;
this.toText = `${a.city} (${a.code})`;
this.showTo = false;
}

swap() {
const f = this.fromSel, t = this.toSel;
const ft = this.fromText, tt = this.toText;
this.fromSel = t; this.toSel = f;
this.fromText = tt; this.toText = ft;
}

dateValid(): boolean {
return !!this.dateStr && this.dateStr >= this.minDateStr;
}

formValid(): boolean {
return !!(this.fromSel && this.toSel && this.fromSel.city !== this.toSel.city && this.dateValid());
}

submit() {
this.submitted = true;
	this.closeLists();
if (!this.formValid()) return;
this.router.navigate(['/flight-results'], {
queryParams: {
origin: this.fromSel!.city,
destination: this.toSel!.city,
date: this.dateStr
}
});
}

closeLists() {
this.showFrom = false;
this.showTo = false;
}

// Keep lists open when clicking inside card
stopClose(e: Event) {
e.stopPropagation();
}
}

