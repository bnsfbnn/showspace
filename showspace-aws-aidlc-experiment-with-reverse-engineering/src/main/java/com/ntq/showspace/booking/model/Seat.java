package com.ntq.showspace.booking.model;

public class Seat {
    private Integer id;
    private Integer showtimeId;
    private String seatNumber;
    private SeatStatus status;
    private String seatType;

    public Seat() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getShowtimeId() { return showtimeId; }
    public void setShowtimeId(Integer showtimeId) { this.showtimeId = showtimeId; }

    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }

    public SeatStatus getStatus() { return status; }
    public void setStatus(SeatStatus status) { this.status = status; }

    public String getSeatType() { return seatType; }
    public void setSeatType(String seatType) { this.seatType = seatType; }
}