# Unit: Facility & Cinema

## Overview
The Facility Unit is responsible for managing physical cinema locations, theater halls, and seating layouts. It is grouped independently to support dynamic physical infrastructure changes without impacting the movie catalog or booking logic.

## User Stories

**US1.1: Select Cinema**
- **As a** moviegoer,
- **I want** to view and select a cinema location from a list,
- **So that** I can see the movies and showtimes available at my preferred location.
- *Acceptance Criteria:*
  - User can view a list of available cinemas (optionally grouped by region/city).
  - User can search for a cinema by name.
  - Selecting a cinema filters the available movies and showtimes for that specific location.

*(Note: Providing seating layouts for US1.4 is also managed by this unit, serving structural hall mapping to the Booking Unit).*