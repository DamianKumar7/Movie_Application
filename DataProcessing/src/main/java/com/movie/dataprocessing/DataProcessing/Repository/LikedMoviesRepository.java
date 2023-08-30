package com.movie.dataprocessing.DataProcessing.Repository;

import com.movie.dataprocessing.DataProcessing.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikedMoviesRepository extends JpaRepository<Movie,String> {
}
