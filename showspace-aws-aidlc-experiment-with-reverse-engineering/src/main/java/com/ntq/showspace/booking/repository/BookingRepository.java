package com.ntq.showspace.booking.repository;

import com.ntq.showspace.booking.model.Booking;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface BookingRepository {
    Booking save(Booking booking);
    Booking findById(Integer id);
    void updateStatusAndPrice(Integer id, String status, java.math.BigDecimal totalPrice);
}