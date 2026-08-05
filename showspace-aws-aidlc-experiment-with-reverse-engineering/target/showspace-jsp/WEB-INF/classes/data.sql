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

-- Adjust sequence if using SERIAL
SELECT setval('movies_id_seq', (SELECT MAX(id) FROM movies));