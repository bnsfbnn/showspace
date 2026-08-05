# Integration Contract

## Overview
This document outlines the high-level API endpoints exposed by each of the loosely coupled units. Following the requested MVC project base style, the endpoints define standard web controller routes to facilitate inter-unit communication and frontend-backend interactions.

---

## 1. Catalog Unit
**Exposes Movie Information & Showings Context**

- `GET /movies/now-showing`
  - Returns a list of currently active movies.
- `GET /movies/coming-soon`
  - Returns a list of upcoming movies.
- `GET /movies/{movieId}`
  - Returns specific metadata (genre, duration, format, age rating) for a given movie.
- `GET /movies/{movieId}/formats`
  - Returns the available formats (2D, Dubbed, Subtitled) for a specific movie.

---

## 2. Facility / Cinema Unit
**Exposes Physical Locations & Layouts**

- `GET /cinemas`
  - Returns a list of all cinema branches.
- `GET /cinemas/search?name={query}`
  - Returns cinemas matching the search query.
- `GET /cinemas/{cinemaId}/halls/{hallId}/layout`
  - Returns the seating map/layout for a specific hall, which the Booking unit uses to overlay seat status.

---

## 3. Booking Unit
**Manages Transactions & Ticketing**

- `GET /cinemas/{cinemaId}/movies/{movieId}/showtimes`
  - Retrieves available dates and showtimes for a specific movie at a specific cinema.
- `GET /showtimes/{showtimeId}/seats`
  - Retrieves real-time seat availability (Available, Booked, Selected) for a specific showtime.
- `POST /bookings/reserve`
  - Temporarily locks selected seats to prevent double booking.
- `POST /bookings/confirm`
  - Finalizes the transaction, triggers price calculation, and generates the ticket.
- `GET /bookings/tickets/{ticketId}`
  - Returns the digital ticket details and QR/Barcode for Omni-channel scanning.

---

## 4. CRM & Identity Unit
**Manages User Accounts & Loyalty Status**

- `POST /auth/register`
  - Creates a new member account (defaults to C'Friend).
- `POST /auth/login`
  - Authenticates the user and initiates an active session.
- `GET /members/profile`
  - Returns the authenticated user's profile, including their membership tier (C'Friend / C'VIP) and points balance.
- `GET /members/{memberId}/benefits`
  - Returns the active perks available for the specific user based on their tier.

---

## 5. Promotions Unit
**Manages Pricing Modifiers & Campaigns**

- `GET /promotions`
  - Returns a list of active campaigns and offers for the frontend.
- `POST /promotions/apply`
  - **Payload:** `{ memberId, ticketType, showtimeId, ... }`
  - Validates eligibility (e.g., Member Day, Student verification flag) and returns the discounted total or specific pricing modifier to the Booking Unit during checkout.