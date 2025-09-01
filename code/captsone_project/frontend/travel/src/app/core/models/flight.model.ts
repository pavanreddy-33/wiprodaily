export interface Flight {
    id: number;
    flightNumber: string;
    airline: string;
    origin: string;
    destination: string;
    departureDate: string;
    departureTime: string;
    arrivalTime: string;
    durationMinutes: number;
    price: number;
    stops: number;
    aircraftName: string;
}