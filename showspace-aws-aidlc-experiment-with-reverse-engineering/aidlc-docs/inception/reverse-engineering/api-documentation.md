# API Documentation

## REST APIs

### Home Page
- **Method**: GET
- **Path**: `/home`
- **Purpose**: Display home page
- **Request**: N/A
- **Response**: `home.jsp` view

### Now Showing Movies
- **Method**: GET
- **Path**: `/movies/now-showing`
- **Purpose**: Display list of movies currently playing
- **Request**: N/A
- **Response**: `catalog/now_showing.jsp` with movies list

### Coming Soon Movies
- **Method**: GET
- **Path**: `/movies/coming-soon`
- **Purpose**: Display list of upcoming movies
- **Request**: N/A
- **Response**: `catalog/coming_soon.jsp` with movies list

### Movie Details
- **Method**: GET
- **Path**: `/movies/{id}`
- **Purpose**: Display detailed information about a specific movie
- **Request**: Path parameter `id` (movie ID)
- **Response**: `catalog/movie_details.jsp` with movie details

### Showtimes for Movie
- **Method**: GET
- **Path**: `/movies/{movieId}/showtimes`
- **Purpose**: Display available showtimes for a movie
- **Request**: Path parameter `movieId`
- **Response**: `booking/showtimes.jsp` with showtimes list

### Seats for Showtime
- **Method**: GET
- **Path**: `/showtimes/{showtimeId}/seats`
- **Purpose**: Display available seats for a showtime
- **Request**: Path parameter `showtimeId`
- **Response**: `booking/seats.jsp` with seats list and showtime info

### Create Booking
- **Method**: POST
- **Path**: `/bookings/checkout`
- **Purpose**: Process booking with selected seats
- **Request**: Form parameters `showtimeId` and `seatIds[]`
- **Response**: Redirect to `/bookings/{bookingId}/ticket`

### Ticket Details
- **Method**: GET
- **Path**: `/bookings/{bookingId}/ticket`
- **Purpose**: Display ticket confirmation
- **Request**: Path parameter `bookingId`
- **Response**: `booking/ticket.jsp` with ticket information

## Internal APIs

### CatalogService
- **Methods**:
  - `List<Movie> getNowShowingMovies()` - Retrieve movies with NOW_SHOWING status
  - `List<Movie> getComingSoonMovies()` - Retrieve movies with COMING_SOON status
  - `Movie getMovieDetails(Integer id)` - Retrieve movie by ID

### BookingService
- **Methods**:
  - `List<Showtime> getShowtimesForMovie(Integer movieId)` - Get showtimes for a movie
  - `Showtime getShowtime(Integer showtimeId)` - Get showtime by ID
  - `List<Seat> getSeatsForShowtime(Integer showtimeId)` - Get seats for a showtime
  - `Booking createBooking(Integer userId, Integer showtimeId, List<Integer> seatIds)` - Create booking with transaction
  - `List<Ticket> getTicketsForBooking(Integer bookingId)` - Get tickets for a booking

### MovieRepository
- **Methods**:
  - `List<Movie> findByStatus(String status)` - Find movies by status
  - `Movie findById(Integer id)` - Find movie by ID
  - `void save(Movie movie)` - Save movie

### BookingRepository
- **Methods**:
  - `Booking save(Booking booking)` - Save booking
  - `Booking findById(Integer id)` - Find booking by ID
  - `void updateStatusAndPrice(Integer id, String status, BigDecimal totalPrice)` - Update booking status and price

### ShowtimeRepository
- **Methods**:
  - `List<Showtime> findByMovieId(Integer movieId)` - Find showtimes by movie ID
  - `Showtime findById(Integer id)` - Find showtime by ID

### SeatRepository
- **Methods**:
  - `List<Seat> findByShowtimeId(Integer showtimeId)` - Find seats by showtime ID
  - `Seat findById(Integer id)` - Find seat by ID
  - `void updateStatus(Integer id, SeatStatus status)` - Update seat status

### TicketRepository
- **Methods**:
  - `List<Ticket> findByBookingId(Integer bookingId)` - Find tickets by booking ID
  - `void saveAll(List<Ticket> tickets)` - Save multiple tickets
  - `void save(Ticket ticket)` - Save single ticket

## Data Models

### Movie
- **Fields**:
  - `id` (Integer) - Primary key
  - `title` (String) - Movie title
  - `synopsis` (String) - Movie description
  - `releaseDate` (LocalDateTime) - Release date
  - `trailerUrl` (String) - Trailer video URL
  - `posterImageUrl` (String) - Poster image URL
  - `status` (MovieStatus) - Lifecycle status
  - `metadata` (MovieMetadata) - Movie metadata
  - `formats` (List<MovieFormatMapping>) - Available formats
- **Relationships**: Has many MovieFormatMapping
- **Validation**: Status computed based on release date

### MovieMetadata
- **Fields**:
  - `genre` (String) - Movie genre
  - `durationInMinutes` (Integer) - Running time
  - `countryOfOrigin` (String) - Production country
  - `ageRating` (String) - Age rating (PG-13, R, etc.)

### MovieFormatMapping
- **Fields**:
  - `id` (Integer) - Primary key
  - `movieId` (Integer) - Reference to movie
  - `formatType` (String) - Format (2D, 3D, IMAX)
  - `languageType` (String) - Language (DUBBED, SUBTITLED, ORIGINAL)

### Showtime
- **Fields**:
  - `id` (Integer) - Primary key
  - `movieId` (Integer) - Reference to movie
  - `cinemaId` (Integer) - Reference to cinema
  - `startTime` (LocalDateTime) - Screening start time
  - `formatType` (String) - Projection format
  - `audioLanguage` (String) - Audio language
  - `basePrice` (BigDecimal) - Base ticket price

### Seat
- **Fields**:
  - `id` (Integer) - Primary key
  - `showtimeId` (Integer) - Reference to showtime
  - `seatNumber` (String) - Seat identifier (e.g., "A1")
  - `status` (SeatStatus) - Availability status
  - `seatType` (String) - Seat type (STANDARD, VIP)

### Booking
- **Fields**:
  - `id` (Integer) - Primary key
  - `userId` (Integer) - Reference to customer
  - `showtimeId` (Integer) - Reference to showtime
  - `totalPrice` (BigDecimal) - Total ticket price
  - `status` (BookingStatus) - Transaction status
  - `bookingTime` (LocalDateTime) - Booking timestamp

### Ticket
- **Fields**:
  - `id` (Integer) - Primary key
  - `bookingId` (Integer) - Reference to booking
  - `seatId` (Integer) - Reference to seat
  - `ticketCode` (String) - Unique ticket identifier (8-char code)