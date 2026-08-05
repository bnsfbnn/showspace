# Unit: Catalog

## Overview
The Catalog Unit manages the core movie content, metadata, and lifecycle states (Now Showing vs. Coming Soon). This unit is highly read-optimized and decoupled from the ticketing and facility systems.

## User Stories

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

**US1.2: Select Movie (Catalog context)**
- **As a** moviegoer,
- **I want** to select a specific movie from the "Now Showing" list,
- **So that** I can begin the ticket booking process for that film.
- *Acceptance Criteria:*
  - User can click on a movie from the homepage to view formats.
  - System clearly indicates the movie formats available (e.g., 2D).
