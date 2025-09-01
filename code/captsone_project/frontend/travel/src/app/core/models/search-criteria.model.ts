export interface SearchCriteria {
  origin: string;
  destination: string;
  date: string;
  nonStop?: boolean;
  airlines?: string[];
  minPrice?: number;
  maxPrice?: number;
}