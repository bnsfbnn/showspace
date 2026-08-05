package com.ntq.showspace.catalog.controller;

import com.ntq.showspace.catalog.model.Movie;
import com.ntq.showspace.catalog.service.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/now-showing")
    public ModelAndView nowShowing() {
        List<Movie> movies = catalogService.getNowShowingMovies();
        ModelAndView mav = new ModelAndView("catalog/now_showing");
        mav.addObject("movies", movies);
        return mav;
    }

    @GetMapping("/coming-soon")
    public ModelAndView comingSoon() {
        List<Movie> movies = catalogService.getComingSoonMovies();
        ModelAndView mav = new ModelAndView("catalog/coming_soon");
        mav.addObject("movies", movies);
        return mav;
    }

    @GetMapping("/{id}")
    public ModelAndView movieDetails(@PathVariable Integer id) {
        Movie movie = catalogService.getMovieDetails(id);
        if (movie == null) {
            return new ModelAndView("error/404");
        }
        ModelAndView mav = new ModelAndView("catalog/movie_details");
        mav.addObject("movie", movie);
        return mav;
    }
}