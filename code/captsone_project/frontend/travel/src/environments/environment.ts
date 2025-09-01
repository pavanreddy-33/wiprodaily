export const environment = {
  production: false,
  apiBaseUrl: 'http://localhost:8080',
  endpoints: {
    search: '/booking/search',
    createBooking: '/booking/create',
    initiatePayment: '/booking/payments',
    bookingById: (id: number | string) => `/booking/bookings/${id}`,
    bookingStatus: (id: number | string) => `/booking/bookings/${id}/status`,
  }
} as const;
