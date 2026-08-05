package com.ntq.showspace.booking.controller;

import com.ntq.showspace.booking.model.Booking;
import com.ntq.showspace.booking.model.Seat;
import com.ntq.showspace.booking.model.Showtime;
import com.ntq.showspace.booking.model.Ticket;
import com.ntq.showspace.booking.service.BookingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/movies/{movieId}/showtimes")
    public ModelAndView getShowtimes(@PathVariable Integer movieId) {
        List<Showtime> showtimes = bookingService.getShowtimesForMovie(movieId);
        ModelAndView mav = new ModelAndView("booking/showtimes");
        mav.addObject("showtimes", showtimes);
        mav.addObject("movieId", movieId);
        return mav;
    }

    @GetMapping("/showtimes/{showtimeId}/seats")
    public ModelAndView getSeats(@PathVariable Integer showtimeId) {
        Showtime showtime = bookingService.getShowtime(showtimeId);
        List<Seat> seats = bookingService.getSeatsForShowtime(showtimeId);
        
        ModelAndView mav = new ModelAndView("booking/seats");
        mav.addObject("showtime", showtime);
        mav.addObject("seats", seats);
        return mav;
    }

    @PostMapping("/bookings/checkout")
    public String checkout(@RequestParam("showtimeId") Integer showtimeId,
                           @RequestParam("seatIds") List<Integer> seatIds,
                           HttpSession session) {
        // Mock user ID based on session or hardcode to 1 for now if no real auth exists
        Integer userId = 1; 

        try {
            Booking booking = bookingService.createBooking(userId, showtimeId, seatIds);
            return "redirect:/bookings/" + booking.getId() + "/ticket";
        } catch (Exception e) {
            // In a real app, use Flash Attributes to show errors
            return "redirect:/showtimes/" + showtimeId + "/seats?error=seat_unavailable";
        }
    }

    @GetMapping("/bookings/{bookingId}/ticket")
    public ModelAndView getTicket(@PathVariable Integer bookingId) {
        List<Ticket> tickets = bookingService.getTicketsForBooking(bookingId);
        ModelAndView mav = new ModelAndView("booking/ticket");
        mav.addObject("bookingId", bookingId);
        mav.addObject("tickets", tickets);
        return mav;
    }
}