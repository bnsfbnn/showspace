package com.ntq.showspace.booking.repository;

import com.ntq.showspace.booking.model.Seat;
import com.ntq.showspace.booking.model.SeatStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface SeatRepository {
    List<Seat> findByShowtimeId(Integer showtimeId);
    Seat findById(Integer id);
    void updateStatus(Integer id, SeatStatus status);
}