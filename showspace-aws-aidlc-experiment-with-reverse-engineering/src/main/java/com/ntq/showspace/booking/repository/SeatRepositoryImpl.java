package com.ntq.showspace.booking.repository;

import com.ntq.showspace.booking.model.Seat;
import com.ntq.showspace.booking.model.SeatStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SeatRepositoryImpl implements SeatRepository {

    private final JdbcTemplate jdbcTemplate;

    public SeatRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Seat> rowMapper = new RowMapper<Seat>() {
        @Override
        public Seat mapRow(ResultSet rs, int rowNum) throws SQLException {
            Seat seat = new Seat();
            seat.setId(rs.getInt("id"));
            seat.setShowtimeId(rs.getInt("showtime_id"));
            seat.setSeatNumber(rs.getString("seat_number"));
            seat.setStatus(SeatStatus.valueOf(rs.getString("status")));
            seat.setSeatType(rs.getString("seat_type"));
            return seat;
        }
    };

    @Override
    public List<Seat> findByShowtimeId(Integer showtimeId) {
        return jdbcTemplate.query("SELECT * FROM booking_seats WHERE showtime_id = ? ORDER BY seat_number", rowMapper, showtimeId);
    }

    @Override
    public Seat findById(Integer id) {
        List<Seat> results = jdbcTemplate.query("SELECT * FROM booking_seats WHERE id = ?", rowMapper, id);
        return results.isEmpty() ? null : results.get(0);
    }

    @Override
    public void updateStatus(Integer id, SeatStatus status) {
        jdbcTemplate.update("UPDATE booking_seats SET status = ? WHERE id = ?", status.name(), id);
    }
}