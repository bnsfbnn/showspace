# Unit: CRM & Identity

## Overview
The CRM (Customer Relationship Management) & Identity Unit is responsible for user accounts, authentication, loyalty programs (tiers, points), and member-specific benefits. It acts as the source of truth for user profiles, allowing other systems like Booking and Promotions to query user state.

## User Stories

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