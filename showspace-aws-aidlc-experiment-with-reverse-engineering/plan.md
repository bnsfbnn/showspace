# Implementation Plan: Booking Unit (Spring MVC)

- [x] **Step 1:** Establish the Logical Design for the Booking unit based on `inception/units/booking_unit.md` (since `/construction/booking/logical_design.md` is currently missing) and make reasonable assumptions.
  - [Question]: Should I mock the user authentication (just assuming a hardcoded `userId` for now), or do you want me to build a simple session-based user context for the booking?
  - [Answer]: to build a simple session-based user context for the booking
  - [Question]: Since we need to show Showtimes and Seats, I will create simple tables for `showtimes`, `seats`, and `bookings` in PostgreSQL. Is this approach acceptable?
  - [Answer]: yes
- [x] **Step 2:** Generate the PostgreSQL schema for Booking (Showtimes, Seats, Bookings, Tickets) and append it to `src/main/resources/schema.sql` and `data.sql`.
- [x] **Step 3:** Implement the Domain/Model Layer for Booking (`Showtime`, `Seat`, `Booking`, `Ticket`) in `src/main/java/com/ntq/showspace/booking/model/`.
- [x] **Step 4:** Implement the Repository Layer for Booking using `JdbcTemplate` in `src/main/java/com/ntq/showspace/booking/repository/`.
- [x] **Step 5:** Implement the Service Layer for Booking (`BookingService`) to handle seat locking, price calculation, and ticket generation.
- [x] **Step 6:** Implement the Controller Layer (`BookingController`) to map the web endpoints (e.g., `/movies/{id}/showtimes`, `/showtimes/{id}/seats`).
- [x] **Step 7:** Implement the View Layer (JSP files) for the Booking flow (`showtimes.jsp`, `seats.jsp`, `ticket.jsp`).
- [x] **Step 8:** Update Spring's component scanning in `app-servlet.xml` and `app-context.xml` to include the new `booking` packages.