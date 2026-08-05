package com.ntq.showspace.booking.repository;

import com.ntq.showspace.booking.model.Ticket;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TicketRepositoryImpl implements TicketRepository {

    private final JdbcTemplate jdbcTemplate;

    public TicketRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Ticket> rowMapper = new RowMapper<Ticket>() {
        @Override
        public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
            Ticket ticket = new Ticket();
            ticket.setId(rs.getInt("id"));
            ticket.setBookingId(rs.getInt("booking_id"));
            ticket.setSeatId(rs.getInt("seat_id"));
            ticket.setTicketCode(rs.getString("ticket_code"));
            return ticket;
        }
    };

    @Override
    public void saveAll(List<Ticket> tickets) {
        String sql = "INSERT INTO booking_tickets (booking_id, seat_id, ticket_code) VALUES (?, ?, ?)";
        for (Ticket ticket : tickets) {
            jdbcTemplate.update(sql, ticket.getBookingId(), ticket.getSeatId(), ticket.getTicketCode());
        }
    }

    @Override
    public List<Ticket> findByBookingId(Integer bookingId) {
        return jdbcTemplate.query("SELECT * FROM booking_tickets WHERE booking_id = ?", rowMapper, bookingId);
    }
}