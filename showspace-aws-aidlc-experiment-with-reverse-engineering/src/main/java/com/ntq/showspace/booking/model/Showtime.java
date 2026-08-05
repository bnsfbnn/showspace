package com.ntq.showspace.booking.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Showtime {
    private Integer id;
    private Integer movieId;
    private Integer cinemaId;
    private LocalDateTime startTime;
    private String formatType;
    private String audioLanguage;
    private BigDecimal basePrice;

    public Showtime() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getMovieId() { return movieId; }
    public void setMovieId(Integer movieId) { this.movieId = movieId; }

    public Integer getCinemaId() { return cinemaId; }
    public void setCinemaId(Integer cinemaId) { this.cinemaId = cinemaId; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public String getFormatType() { return formatType; }
    public void setFormatType(String formatType) { this.formatType = formatType; }

    public String getAudioLanguage() { return audioLanguage; }
    public void setAudioLanguage(String audioLanguage) { this.audioLanguage = audioLanguage; }

    public BigDecimal getBasePrice() { return basePrice; }
    public void setBasePrice(BigDecimal basePrice) { this.basePrice = basePrice; }
}