-- Insert Mock Movies (idempotent)
INSERT INTO movies (id, title, synopsis, release_date, trailer_url, poster_image_url, genre, duration_in_minutes, country_of_origin, age_rating, status)
VALUES 
(1, 'Dune: Part Two', 'Paul Atreides unites with Chani and the Fremen while on a warpath of revenge against the conspirators who destroyed his family.', '2024-03-01 00:00:00', 'https://youtube.com', '', 'Sci-Fi', 166, 'USA', 'PG-13', 'NOW_SHOWING'),
(2, 'Kung Fu Panda 4', 'Po must train a new warrior when he is chosen to become the spiritual leader of the Valley of Peace.', '2024-03-08 00:00:00', 'https://youtube.com', '', 'Animation', 94, 'USA', 'PG', 'NOW_SHOWING'),
(3, 'Godzilla x Kong: The New Empire', 'Two ancient titans, Godzilla and Kong, clash in an epic battle as humans unravel their intertwined origins and connection to Skulls Island mysteries.', '2024-03-29 00:00:00', 'https://youtube.com', '', 'Action', 115, 'USA', 'PG-13', 'COMING_SOON')
ON CONFLICT (id) DO NOTHING;

-- Insert Movie Formats (idempotent via unique constraint)
INSERT INTO movie_formats (movie_id, format_type, language_type) VALUES
(1, 'IMAX', 'ORIGINAL'),
(1, '2D', 'SUBTITLED'),
(2, '3D', 'DUBBED'),
(2, '2D', 'DUBBED'),
(3, 'IMAX', 'ORIGINAL')
ON CONFLICT (movie_id, format_type, language_type) DO NOTHING;

-- ==========================================
-- BOOKING UNIT MOCK DATA
-- ==========================================

INSERT INTO booking_showtimes (id, movie_id, cinema_id, start_time, format_type, audio_language, base_price) VALUES
(1, 1, 1, '2024-03-01 18:00:00', 'IMAX', 'ORIGINAL', 15.00),
(2, 1, 1, '2024-03-01 21:00:00', '2D', 'SUBTITLED', 10.00),
(3, 2, 2, '2024-03-08 10:00:00', '2D', 'DUBBED', 8.00)
ON CONFLICT (id) DO NOTHING;

-- Mock seats for showtime 1 (Movie 1, Cinema 1)
INSERT INTO booking_seats (id, showtime_id, seat_number, status, seat_type) VALUES
(1, 1, 'A1', 'AVAILABLE', 'STANDARD'),
(2, 1, 'A2', 'AVAILABLE', 'STANDARD'),
(3, 1, 'B1', 'BOOKED', 'VIP'),
(4, 1, 'B2', 'AVAILABLE', 'VIP')
ON CONFLICT (id) DO NOTHING;

-- Mock seats for showtime 2
INSERT INTO booking_seats (id, showtime_id, seat_number, status, seat_type) VALUES
(5, 2, 'A1', 'AVAILABLE', 'STANDARD'),
(6, 2, 'A2', 'AVAILABLE', 'STANDARD')
ON CONFLICT (id) DO NOTHING;

-- Adjust sequence if using SERIAL
SELECT setval('movies_id_seq', (SELECT MAX(id) FROM movies));
SELECT setval('booking_showtimes_id_seq', (SELECT MAX(id) FROM booking_showtimes));
SELECT setval('booking_seats_id_seq', (SELECT MAX(id) FROM booking_seats));