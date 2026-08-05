package com.ntq.showspace.catalog.repository;

import com.ntq.showspace.catalog.model.Movie;
import com.ntq.showspace.catalog.model.MovieMetadata;
import com.ntq.showspace.catalog.model.MovieStatus;
import com.ntq.showspace.catalog.model.MovieFormatMapping;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

    private final JdbcTemplate jdbcTemplate;

    public MovieRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Movie> movieRowMapper = new RowMapper<Movie>() {
        @Override
        public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
            Movie movie = new Movie();
            movie.setId(rs.getInt("id"));
            movie.setTitle(rs.getString("title"));
            movie.setSynopsis(rs.getString("synopsis"));
            movie.setReleaseDate(rs.getTimestamp("release_date").toLocalDateTime());
            movie.setTrailerUrl(rs.getString("trailer_url"));
            movie.setPosterImageUrl(rs.getString("poster_image_url"));
            
            String statusStr = rs.getString("status");
            if (statusStr != null) {
                movie.setStatus(MovieStatus.valueOf(statusStr));
            }

            MovieMetadata metadata = new MovieMetadata();
            metadata.setGenre(rs.getString("genre"));
            metadata.setDurationInMinutes(rs.getInt("duration_in_minutes"));
            metadata.setCountryOfOrigin(rs.getString("country_of_origin"));
            metadata.setAgeRating(rs.getString("age_rating"));
            movie.setMetadata(metadata);

            return movie;
        }
    };

    @Override
    public List<Movie> findByStatus(String status) {
        String sql = "SELECT * FROM movies WHERE status = ?";
        List<Movie> movies = jdbcTemplate.query(sql, movieRowMapper, status);
        for (Movie movie : movies) {
            loadFormats(movie);
        }
        return movies;
    }

    @Override
    public Movie findById(Integer id) {
        String sql = "SELECT * FROM movies WHERE id = ?";
        List<Movie> movies = jdbcTemplate.query(sql, movieRowMapper, id);
        if (movies.isEmpty()) {
            return null;
        }
        Movie movie = movies.get(0);
        loadFormats(movie);
        return movie;
    }

    private void loadFormats(Movie movie) {
        String sql = "SELECT * FROM movie_formats WHERE movie_id = ?";
        List<MovieFormatMapping> formats = jdbcTemplate.query(sql, new RowMapper<MovieFormatMapping>() {
            @Override
            public MovieFormatMapping mapRow(ResultSet rs, int rowNum) throws SQLException {
                MovieFormatMapping mapping = new MovieFormatMapping();
                mapping.setId(rs.getInt("id"));
                mapping.setMovieId(rs.getInt("movie_id"));
                mapping.setFormatType(rs.getString("format_type"));
                mapping.setLanguageType(rs.getString("language_type"));
                return mapping;
            }
        }, movie.getId());
        movie.setFormats(formats);
    }

    @Override
    public void save(Movie movie) {
        // Simple mock save for completeness
        String sql = "INSERT INTO movies (title, synopsis, release_date, status) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, movie.getTitle(), movie.getSynopsis(), movie.getReleaseDate(), movie.getStatus().name());
    }
}