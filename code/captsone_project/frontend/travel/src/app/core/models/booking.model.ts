import { Passenger } from './passenger.model';

export interface Booking {
    id: number;
    flightId: number;
    status: string;
    passengers: Passenger[];
}