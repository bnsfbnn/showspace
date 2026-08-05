# User Stories: Movie Ticket Booking Application

## Overview
This document outlines the user stories for the movie ticket booking application, covering the core booking flow, movie listings, accounts & CRM, and promotions.

## 1. Core Booking Flow

**US1.1: Select Cinema**
- **As a** moviegoer,
- **I want** to view and select a cinema location from a list,
- **So that** I can see the movies and showtimes available at my preferred location.
- *Acceptance Criteria:*
  - User can view a list of available cinemas (optionally grouped by region/city).
  - User can search for a cinema by name.
  - Selecting a cinema filters the available movies and showtimes for that specific location.

**US1.2: Select Movie**
- **As a** moviegoer,
- **I want** to select a specific movie from the "Now Showing" list,
- **So that** I can begin the ticket booking process for that film.
- *Acceptance Criteria:*
  - User can click on a movie from the homepage or cinema page to start booking.
  - System clearly indicates the movie formats available (e.g., 2D).

**US1.3: Select Date & Showtime**
- **As a** moviegoer,
- **I want** to select a date and an available showtime for my chosen movie and cinema,
- **So that** I can schedule my movie experience.
- *Acceptance Criteria:*
  - User can see available dates (typically the next few days/week).
  - Showtimes are grouped by version format (e.g., 2D Subtitled, 2D Dubbed).
  - Past showtimes for the current day are disabled or hidden.
  - User can click on an available time slot to proceed.

**US1.4: Select Seats**
- **As a** moviegoer,
- **I want** to view a seating chart and select my preferred seats,
- **So that** I can secure my exact spots in the theater hall.
- *Acceptance Criteria:*
  - System displays a visual representation of the cinema seating layout.
  - Seats are color-coded by status (Available, Booked, Selected, VIP/Standard).
  - User can click on available seats to select/deselect them.
  - The system dynamically updates the total ticket price based on the selected seats.

## 2. Movie Listings & Metadata

**US2.1: View "Now Showing" Movies**
- **As a** moviegoer,
- **I want** to see a list of movies currently playing in theaters,
- **So that** I can choose a movie to watch today or in the near future.
- *Acceptance Criteria:*
  - The homepage displays a "Now Showing" section with movie posters.
  - Users can easily navigate to see the full list of currently playing movies.

**US2.2: View "Coming Soon" Movies**
- **As a** moviegoer,
- **I want** to see a list of upcoming movies,
- **So that** I can plan future cinema visits or watch trailers for new releases.
- *Acceptance Criteria:*
  - The homepage features a "Coming Soon" section.
  - Upcoming movies display their expected release date.

**US2.3: View Movie Metadata & Details**
- **As a** moviegoer,
- **I want** to view detailed information about a specific movie before booking,
- **So that** I can make an informed decision on what to watch.
- *Acceptance Criteria:*
  - The movie details page displays the following metadata:
    - Genre (e.g., Action, Comedy).
    - Duration/Running Time.
    - Country of Origin.
    - Available Formats (e.g., 2D).
    - Audio/Language options (Dubbed / Subtitled).
    - Age Rating (e.g., PG-13, R) to help parents and audiences.
  - The page includes a synopsis and optionally a trailer video.

## 3. Accounts & CRM

**US3.1: Member Registration & Login**
- **As a** moviegoer,
- **I want** to create an account and log in,
- **So that** I can track my bookings, accumulate points, and receive member benefits.
- *Acceptance Criteria:*
  - User can register using email/phone number and a secure password.
  - New users are assigned the default "C'Friend" tier upon registration.
  - User can log in and view their basic profile details.

**US3.2: View Membership Tier & Base Loyalty Profile**
- **As a** moviegoer,
- **I want** to view my current membership tier (C'Friend or C'VIP) and accumulated point balance,
- **So that** I know my loyalty status and potential benefits.
- *Acceptance Criteria:*
  - The profile page prominently displays the user's tier status (C'Friend / C'VIP).
  - The profile shows a placeholder/foundation for "Total Accumulated Points" and "Points Needed for Upgrade", establishing the base structure for the loyalty program.

**US3.3: View Member Benefits (F&B, Birthday, Tier Deals)**
- **As a** moviegoer,
- **I want** to see the available perks for my tier,
- **So that** I know what discounts and gifts I am eligible for (e.g., F&B discounts, Birthday gifts).
- *Acceptance Criteria:*
  - User profile displays a list of active benefits (e.g., 10% off F&B for C'VIP, Birthday combo gift).
  - During promotional flows or at a cinema counter (via QR/barcode), the tier status can be identified to apply these benefits.

## 4. Promotions & Campaigns

**US4.1: View Current Promotions & Offers**
- **As a** moviegoer,
- **I want** to browse an "Offers" or "Promotions" section on the app/web,
- **So that** I can see what discounts or special events are currently running (e.g., Student Discount, Member Day).
- *Acceptance Criteria:*
  - A dedicated promotions page lists all active campaigns with their banners, valid dates, and terms/conditions.
  - The promotions list matches the campaigns deployed simultaneously at physical cinemas.

**US4.2: Apply Target Segment Promotion (e.g., Member Day)**
- **As a** logged-in member,
- **I want** the system to automatically recognize my eligibility for specific campaigns (like Member Day discounts),
- **So that** I receive the promotional ticket price without needing to enter a complex code manually.
- *Acceptance Criteria:*
  - On predefined "Member Days," the booking flow automatically updates ticket prices for logged-in users.
  - The checkout/seat selection overview visibly highlights the discount applied.

**US4.3: Apply Student/Verification Promotion**
- **As a** moviegoer (Student),
- **I want** to select a "Student Ticket" during the booking flow,
- **So that** I receive the student rate (with the understanding that cinema staff will verify my student ID at the theater).
- *Acceptance Criteria:*
  - When choosing ticket types (if applicable) or seats, a "Student Discount" option is available.
  - A prompt warns the user that physical Student ID verification is required at the cinema.

**US4.4: Omni-Channel Ticket Identification**
- **As a** moviegoer,
- **I want** to receive a digital ticket (QR code or Barcode) upon booking,
- **So that** cinema staff can easily scan and validate my ticket, tier status, and any applied promotions at the theater counter.
- *Acceptance Criteria:*
  - The system generates a scannable code linking to the user's booking details and CRM tier.
  - This bridges the online (app/web) promotion/booking experience with the offline cinema operation.
