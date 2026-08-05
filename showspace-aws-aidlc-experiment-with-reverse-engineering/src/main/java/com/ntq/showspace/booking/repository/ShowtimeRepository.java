package com.ntq.showspace.booking.repository;

import com.ntq.showspace.booking.model.Showtime;
import java.util.List;

public interface ShowtimeRepository {
    List<Showtime> findByMovieId(Integer movieId);
    Showtime findById(Integer id);
}