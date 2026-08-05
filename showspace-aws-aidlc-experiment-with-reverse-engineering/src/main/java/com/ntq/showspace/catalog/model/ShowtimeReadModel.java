package com.ntq.showspace.catalog.model;

import java.time.LocalDateTime;

public class ShowtimeReadModel {
    private Integer id;
    private String externalShowtimeId;
    private String externalCinemaId;
    private Integer movieId;
    private LocalDateTime startTime;
    private String formatType;
    private String audioLanguage;

    public ShowtimeReadModel() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getExternalShowtimeId() { return externalShowtimeId; }
    public void setExternalShowtimeId(String externalShowtimeId) { this.externalShowtimeId = externalShowtimeId; }

    public String getExternalCinemaId() { return externalCinemaId; }
    public void setExternalCinemaId(String externalCinemaId) { this.externalCinemaId = externalCinemaId; }

    public Integer getMovieId() { return movieId; }
    public void setMovieId(Integer movieId) { this.movieId = movieId; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public String getFormatType() { return formatType; }
    public void setFormatType(String formatType) { this.formatType = formatType; }

    public String getAudioLanguage() { return audioLanguage; }
    public void setAudioLanguage(String audioLanguage) { this.audioLanguage = audioLanguage; }
}