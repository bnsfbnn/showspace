# PostgreSQL 16 Schema for Catalog Unit

```sql
CREATE DATABASE showspace_catalog;

\c showspace_catalog

-- Table for Movie Aggregates (including Metadata)
CREATE TABLE movies (
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
CREATE TABLE movie_formats (
    id SERIAL PRIMARY KEY,
    movie_id INT NOT NULL REFERENCES movies(id) ON DELETE CASCADE,
    format_type VARCHAR(50) NOT NULL, -- e.g., 2D, 3D, IMAX
    language_type VARCHAR(50) NOT NULL, -- e.g., DUBBED, SUBTITLED, ORIGINAL
    UNIQUE(movie_id, format_type, language_type)
);

-- Read Model for Showtimes (sourced from Booking Unit)
CREATE TABLE showtime_read_models (
    id SERIAL PRIMARY KEY,
    external_showtime_id VARCHAR(100) NOT NULL UNIQUE,
    external_cinema_id VARCHAR(100) NOT NULL,
    movie_id INT NOT NULL REFERENCES movies(id) ON DELETE CASCADE,
    start_time TIMESTAMP NOT NULL,
    format_type VARCHAR(50) NOT NULL,
    audio_language VARCHAR(50) NOT NULL
);

-- Indexes for performance
CREATE INDEX idx_movies_status ON movies(status);
CREATE INDEX idx_movies_release_date ON movies(release_date);
CREATE INDEX idx_showtimes_movie_id ON showtime_read_models(movie_id);
CREATE INDEX idx_showtimes_cinema_id ON showtime_read_models(external_cinema_id);