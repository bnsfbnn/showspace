package com.ntq.showspace.catalog.model;

public class MovieFormatMapping {
    private Integer id;
    private Integer movieId;
    private String formatType;
    private String languageType;

    public MovieFormatMapping() {}

    public MovieFormatMapping(Integer movieId, String formatType, String languageType) {
        this.movieId = movieId;
        this.formatType = formatType;
        this.languageType = languageType;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getMovieId() { return movieId; }
    public void setMovieId(Integer movieId) { this.movieId = movieId; }

    public String getFormatType() { return formatType; }
    public void setFormatType(String formatType) { this.formatType = formatType; }

    public String getLanguageType() { return languageType; }
    public void setLanguageType(String languageType) { this.languageType = languageType; }
}