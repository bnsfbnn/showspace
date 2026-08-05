package com.ntq.showspace.catalog.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Movie {
    private Integer id;
    private String title;
    private String synopsis;
    private LocalDateTime releaseDate;
    private String trailerUrl;
    private String posterImageUrl;
    private MovieStatus status;
    private MovieMetadata metadata;
    private List<MovieFormatMapping> formats = new ArrayList<>();

    public Movie() {
        this.metadata = new MovieMetadata();
    }

    // Business Logic
    public void addFormat(String formatType, String languageType) {
        this.formats.add(new MovieFormatMapping(this.id, formatType, languageType));
    }

    public void updateStatusByReleaseDate(LocalDateTime currentDate) {
        if (currentDate.isBefore(this.releaseDate)) {
            this.status = MovieStatus.COMING_SOON;
        } else {
            this.status = MovieStatus.NOW_SHOWING;
        }
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getSynopsis() { return synopsis; }
    public void setSynopsis(String synopsis) { this.synopsis = synopsis; }

    public LocalDateTime getReleaseDate() { return releaseDate; }
    public void setReleaseDate(LocalDateTime releaseDate) { this.releaseDate = releaseDate; }

    public String getTrailerUrl() { return trailerUrl; }
    public void setTrailerUrl(String trailerUrl) { this.trailerUrl = trailerUrl; }

    public String getPosterImageUrl() { return posterImageUrl; }
    public void setPosterImageUrl(String posterImageUrl) { this.posterImageUrl = posterImageUrl; }

    public MovieStatus getStatus() { return status; }
    public void setStatus(MovieStatus status) { this.status = status; }

    public MovieMetadata getMetadata() { return metadata; }
    public void setMetadata(MovieMetadata metadata) { this.metadata = metadata; }

    public List<MovieFormatMapping> getFormats() { return formats; }
    public void setFormats(List<MovieFormatMapping> formats) { this.formats = formats; }
}