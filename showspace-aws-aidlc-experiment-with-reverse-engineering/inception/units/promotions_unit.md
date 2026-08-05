# Unit: Promotions & Campaigns

## Overview
The Promotions Unit manages marketing campaigns, dynamic discount rules, and segment-targeted offers (e.g., Student Discounts, Member Days). This unit exposes pricing modifiers to the Booking Unit and operates synchronously across app/web and physical cinema channels.

## User Stories

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