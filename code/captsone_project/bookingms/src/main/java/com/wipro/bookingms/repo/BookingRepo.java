package com.wipro.bookingms.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.bookingms.entity.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {
	Optional<Booking> findByBookingId(String bookingId);
}
