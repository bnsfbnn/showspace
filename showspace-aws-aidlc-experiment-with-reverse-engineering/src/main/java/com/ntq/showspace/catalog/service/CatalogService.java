package com.ntq.showspace.catalog.service;

import com.ntq.showspace.catalog.model.Movie;
import com.ntq.showspace.catalog.model.MovieStatus;
import com.ntq.showspace.catalog.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {

    private final MovieRepository movieRepository;

    public CatalogService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getNowShowingMovies() {
        return movieRepository.findByStatus(MovieStatus.NOW_SHOWING.name());
    }

    public List<Movie> getComingSoonMovies() {
        return movieRepository.findByStatus(MovieStatus.COMING_SOON.name());
    }

    public Movie getMovieDetails(Integer id) {
        return movieRepository.findById(id);
    }
}