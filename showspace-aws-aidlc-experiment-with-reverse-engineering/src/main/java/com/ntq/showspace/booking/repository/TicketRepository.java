package com.ntq.showspace.booking.repository;

import com.ntq.showspace.booking.model.Ticket;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface TicketRepository {
    void saveAll(List<Ticket> tickets);
    List<Ticket> findByBookingId(Integer bookingId);
}