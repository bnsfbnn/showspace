package com.ntq.showspace.catalog.model;

public class MovieMetadata {
    private String genre;
    private Integer durationInMinutes;
    private String countryOfOrigin;
    private String ageRating;

    public MovieMetadata() {}

    public MovieMetadata(String genre, Integer durationInMinutes, String countryOfOrigin, String ageRating) {
        this.genre = genre;
        this.durationInMinutes = durationInMinutes;
        this.countryOfOrigin = countryOfOrigin;
        this.ageRating = ageRating;
    }

    // Getters and Setters
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public Integer getDurationInMinutes() { return durationInMinutes; }
    public void setDurationInMinutes(Integer durationInMinutes) { this.durationInMinutes = durationInMinutes; }

    public String getCountryOfOrigin() { return countryOfOrigin; }
    public void setCountryOfOrigin(String countryOfOrigin) { this.countryOfOrigin = countryOfOrigin; }

    public String getAgeRating() { return ageRating; }
    public void setAgeRating(String ageRating) { this.ageRating = ageRating; }
}