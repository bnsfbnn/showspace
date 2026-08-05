package com.ntq.showspace.catalog.repository;

import com.ntq.showspace.catalog.model.Movie;
import java.util.List;

public interface MovieRepository {
    List<Movie> findByStatus(String status);
    Movie findById(Integer id);
    void save(Movie movie);
}