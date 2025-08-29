export interface Booking {
    id?: number;
  bookingId?: string;
  flightId: number;
  passengerName: string;
  travelDate: string; 
  amount?: number;
  status?: string; 
  createdAt?: string;
}
