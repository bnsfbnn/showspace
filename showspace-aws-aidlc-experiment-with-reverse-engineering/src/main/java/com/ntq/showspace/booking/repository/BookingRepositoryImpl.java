package com.ntq.showspace.booking.repository;

import com.ntq.showspace.booking.model.Booking;
import com.ntq.showspace.booking.model.BookingStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
public class BookingRepositoryImpl implements BookingRepository {

    private final JdbcTemplate jdbcTemplate;

    public BookingRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Booking> rowMapper = new RowMapper<Booking>() {
        @Override
        public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
            Booking booking = new Booking();
            booking.setId(rs.getInt("id"));
            booking.setUserId(rs.getInt("user_id"));
            booking.setShowtimeId(rs.getInt("showtime_id"));
            booking.setTotalPrice(rs.getBigDecimal("total_price"));
            booking.setStatus(BookingStatus.valueOf(rs.getString("status")));
            if (rs.getTimestamp("booking_time") != null) {
                booking.setBookingTime(rs.getTimestamp("booking_time").toLocalDateTime());
            }
            return booking;
        }
    };

    @Override
    public Booking save(Booking booking) {
        String sql = "INSERT INTO bookings (user_id, showtime_id, total_price, status) VALUES (?, ?, ?, ?) RETURNING id, booking_time";
        
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO bookings (user_id, showtime_id, total_price, status) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, booking.getUserId());
            ps.setInt(2, booking.getShowtimeId());
            ps.setBigDecimal(3, booking.getTotalPrice());
            ps.setString(4, booking.getStatus().name());
            return ps;
        }, keyHolder);
        
        if (keyHolder.getKeys() != null) {
            booking.setId((Integer) keyHolder.getKeys().get("id"));
        }
        return booking;
    }

    @Override
    public Booking findById(Integer id) {
        List<Booking> results = jdbcTemplate.query("SELECT * FROM bookings WHERE id = ?", rowMapper, id);
        return results.isEmpty() ? null : results.get(0);
    }

    @Override
    public void updateStatusAndPrice(Integer id, String status, java.math.BigDecimal totalPrice) {
        jdbcTemplate.update("UPDATE bookings SET status = ?, total_price = ? WHERE id = ?", status, totalPrice, id);
    }
}