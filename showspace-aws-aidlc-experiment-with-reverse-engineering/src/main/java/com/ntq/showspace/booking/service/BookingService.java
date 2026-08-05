package com.ntq.showspace.booking.service;

import com.ntq.showspace.booking.model.Booking;
import com.ntq.showspace.booking.model.BookingStatus;
import com.ntq.showspace.booking.model.Seat;
import com.ntq.showspace.booking.model.SeatStatus;
import com.ntq.showspace.booking.model.Showtime;
import com.ntq.showspace.booking.model.Ticket;
import com.ntq.showspace.booking.repository.BookingRepository;
import com.ntq.showspace.booking.repository.SeatRepository;
import com.ntq.showspace.booking.repository.ShowtimeRepository;
import com.ntq.showspace.booking.repository.TicketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookingService {

    private final ShowtimeRepository showtimeRepository;
    private final SeatRepository seatRepository;
    private final BookingRepository bookingRepository;
    private final TicketRepository ticketRepository;

    public BookingService(ShowtimeRepository showtimeRepository, SeatRepository seatRepository,
                          BookingRepository bookingRepository, TicketRepository ticketRepository) {
        this.showtimeRepository = showtimeRepository;
        this.seatRepository = seatRepository;
        this.bookingRepository = bookingRepository;
        this.ticketRepository = ticketRepository;
    }

    public List<Showtime> getShowtimesForMovie(Integer movieId) {
        return showtimeRepository.findByMovieId(movieId);
    }

    public Showtime getShowtime(Integer showtimeId) {
        return showtimeRepository.findById(showtimeId);
    }

    public List<Seat> getSeatsForShowtime(Integer showtimeId) {
        return seatRepository.findByShowtimeId(showtimeId);
    }

    @Transactional
    public Booking createBooking(Integer userId, Integer showtimeId, List<Integer> seatIds) {
        Showtime showtime = showtimeRepository.findById(showtimeId);
        if (showtime == null) throw new IllegalArgumentException("Showtime not found");

        BigDecimal totalPrice = BigDecimal.ZERO;
        List<Ticket> tickets = new ArrayList<>();

        // Create booking record initially as PENDING
        Booking booking = new Booking();
        booking.setUserId(userId);
        booking.setShowtimeId(showtimeId);
        booking.setStatus(BookingStatus.PENDING);
        booking.setTotalPrice(BigDecimal.ZERO); // Temporary
        booking = bookingRepository.save(booking);

        for (Integer seatId : seatIds) {
            Seat seat = seatRepository.findById(seatId);
            if (seat == null || seat.getStatus() == SeatStatus.BOOKED) {
                throw new IllegalStateException("Seat " + seatId + " is already booked or invalid");
            }
            
            // Calculate price based on type (simplified)
            BigDecimal seatPrice = showtime.getBasePrice();
            if ("VIP".equals(seat.getSeatType())) {
                seatPrice = seatPrice.add(new BigDecimal("5.00")); // VIP markup
            }
            totalPrice = totalPrice.add(seatPrice);

            // Update seat status
            seatRepository.updateStatus(seat.getId(), SeatStatus.BOOKED);

            // Generate Ticket
            Ticket ticket = new Ticket();
            ticket.setBookingId(booking.getId());
            ticket.setSeatId(seat.getId());
            ticket.setTicketCode(UUID.randomUUID().toString().substring(0, 8).toUpperCase());
            tickets.add(ticket);
        }

        // Save tickets and update booking total price & status
        ticketRepository.saveAll(tickets);
        
        booking.setTotalPrice(totalPrice);
        booking.setStatus(BookingStatus.CONFIRMED);
        bookingRepository.updateStatusAndPrice(booking.getId(), BookingStatus.CONFIRMED.name(), totalPrice);
        
        return booking;
    }

    public List<Ticket> getTicketsForBooking(Integer bookingId) {
        return ticketRepository.findByBookingId(bookingId);
    }
}