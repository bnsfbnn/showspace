-- Table for Movie Aggregates (including Metadata)
CREATE TABLE IF NOT EXISTS movies (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    synopsis TEXT,
    release_date TIMESTAMP NOT NULL,
    trailer_url VARCHAR(255),
    poster_image_url VARCHAR(255),
    genre VARCHAR(100),
    duration_in_minutes INT,
    country_of_origin VARCHAR(100),
    age_rating VARCHAR(50),
    status VARCHAR(50) -- COMING_SOON, NOW_SHOWING, ARCHIVED
);

-- Table for Movie Formats and Languages
CREATE TABLE IF NOT EXISTS movie_formats (
    id SERIAL PRIMARY KEY,
    movie_id INT NOT NULL REFERENCES movies(id) ON DELETE CASCADE,
    format_type VARCHAR(50) NOT NULL, -- e.g., 2D, 3D, IMAX
    language_type VARCHAR(50) NOT NULL, -- e.g., DUBBED, SUBTITLED, ORIGINAL
    UNIQUE(movie_id, format_type, language_type)
);

-- Read Model for Showtimes (sourced from Booking Unit)
CREATE TABLE IF NOT EXISTS showtime_read_models (
    id SERIAL PRIMARY KEY,
    external_showtime_id VARCHAR(100) NOT NULL UNIQUE,
    external_cinema_id VARCHAR(100) NOT NULL,
    movie_id INT NOT NULL REFERENCES movies(id) ON DELETE CASCADE,
    start_time TIMESTAMP NOT NULL,
    format_type VARCHAR(50) NOT NULL,
    audio_language VARCHAR(50) NOT NULL
);

-- ==========================================
-- BOOKING UNIT SCHEMA
-- ==========================================

CREATE TABLE IF NOT EXISTS booking_showtimes (
    id SERIAL PRIMARY KEY,
    movie_id INT NOT NULL, -- references catalog
    cinema_id INT NOT NULL, -- references facility
    start_time TIMESTAMP NOT NULL,
    format_type VARCHAR(50) NOT NULL,
    audio_language VARCHAR(50) NOT NULL,
    base_price DECIMAL(10, 2) NOT NULL
);

CREATE TABLE IF NOT EXISTS booking_seats (
    id SERIAL PRIMARY KEY,
    showtime_id INT NOT NULL REFERENCES booking_showtimes(id) ON DELETE CASCADE,
    seat_number VARCHAR(10) NOT NULL,
    status VARCHAR(20) NOT NULL, -- AVAILABLE, BOOKED
    seat_type VARCHAR(20) NOT NULL -- STANDARD, VIP
);

CREATE TABLE IF NOT EXISTS bookings (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL, -- references CRM
    showtime_id INT NOT NULL REFERENCES booking_showtimes(id),
    total_price DECIMAL(10, 2) NOT NULL,
    status VARCHAR(20) NOT NULL, -- PENDING, CONFIRMED
    booking_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS booking_tickets (
    id SERIAL PRIMARY KEY,
    booking_id INT NOT NULL REFERENCES bookings(id) ON DELETE CASCADE,
    seat_id INT NOT NULL REFERENCES booking_seats(id),
    ticket_code VARCHAR(100) NOT NULL UNIQUE
);
