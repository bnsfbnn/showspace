# Unit: Booking

## Overview
The Booking Unit handles transactional actions including showtime availability, seat reservation concurrency, ticket price calculations, and ticket code generation. It relies on the Catalog and Facility units for reference data, and CRM/Promotions units for applied pricing modifiers.

## User Stories

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

**US4.4: Omni-Channel Ticket Identification**
- **As a** moviegoer,
- **I want** to receive a digital ticket (QR code or Barcode) upon booking,
- **So that** cinema staff can easily scan and validate my ticket, tier status, and any applied promotions at the theater counter.
- *Acceptance Criteria:*
  - The system generates a scannable code linking to the user's booking details and CRM tier.
  - This bridges the online (app/web) promotion/booking experience with the offline cinema operation.
