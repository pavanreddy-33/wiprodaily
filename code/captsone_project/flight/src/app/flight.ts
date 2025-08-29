export interface Flight {
    id: number;
  airline?: string;
  flightNumber?: string;
  source: string;
  destination: string;
  price: number;
  priceEffectiveFrom?: string;
  priceEffectiveTo?: string;
}
