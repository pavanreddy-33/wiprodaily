export interface AirportInfo { code: string; name: string; }
export const AIRPORTS: Record<string, AirportInfo> = {
Kolkata: { code: 'CCU', name: 'Netaji Subhas Chandra Bose International Airport' },
Chennai: { code: 'MAA', name: 'Chennai International Airport' },
Bengaluru: { code: 'BLR', name: 'Kempegowda International Airport' },
Bangalore: { code: 'BLR', name: 'Kempegowda International Airport' },
Delhi: { code: 'DEL', name: 'Indira Gandhi International Airport' },
'New Delhi': { code: 'DEL', name: 'Indira Gandhi International Airport' },
Mumbai: { code: 'BOM', name: 'Chhatrapati Shivaji Maharaj International Airport' },
Hyderabad: { code: 'HYD', name: 'Rajiv Gandhi International Airport' },
Ahmedabad: { code: 'AMD', name: 'Sardar Vallabhbhai Patel International Airport' },
Goa: { code: 'GOI', name: 'Goa International Airport' },
Kochi: { code: 'COK', name: 'Cochin International Airport' },
Pune: { code: 'PNQ', name: 'Pune International Airport' },
Jaipur: { code: 'JAI', name: 'Jaipur International Airport' },
Lucknow: { code: 'LKO', name: 'Chaudhary Charan Singh International Airport' }
};