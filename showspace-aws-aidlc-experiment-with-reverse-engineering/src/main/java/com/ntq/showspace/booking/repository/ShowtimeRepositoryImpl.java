package com.ntq.showspace.booking.repository;

import com.ntq.showspace.booking.model.Showtime;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ShowtimeRepositoryImpl implements ShowtimeRepository {

    private final JdbcTemplate jdbcTemplate;

    public ShowtimeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Showtime> rowMapper = new RowMapper<Showtime>() {
        @Override
        public Showtime mapRow(ResultSet rs, int rowNum) throws SQLException {
            Showtime showtime = new Showtime();
            showtime.setId(rs.getInt("id"));
            showtime.setMovieId(rs.getInt("movie_id"));
            showtime.setCinemaId(rs.getInt("cinema_id"));
            showtime.setStartTime(rs.getTimestamp("start_time").toLocalDateTime());
            showtime.setFormatType(rs.getString("format_type"));
            showtime.setAudioLanguage(rs.getString("audio_language"));
            showtime.setBasePrice(rs.getBigDecimal("base_price"));
            return showtime;
        }
    };

    @Override
    public List<Showtime> findByMovieId(Integer movieId) {
        return jdbcTemplate.query("SELECT * FROM booking_showtimes WHERE movie_id = ? ORDER BY start_time", rowMapper, movieId);
    }

    @Override
    public Showtime findById(Integer id) {
        List<Showtime> results = jdbcTemplate.query("SELECT * FROM booking_showtimes WHERE id = ?", rowMapper, id);
        return results.isEmpty() ? null : results.get(0);
    }
}