package com.movie.dataprocessing.DataProcessing.Repository;

import com.movie.dataprocessing.DataProcessing.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikedMoviesRepository extends JpaRepository<Movie,String> {
    @Query("SELECT m FROM Movie m WHERE m.userEmail = :userEmail")
    List<Movie> findMoviesLikedByUserEmail(@Param("userEmail") String userEmail);

    @Query("SELECT m.movieTitle FROM Movie m GROUP BY m.movieTitle " +
            "ORDER BY COUNT(DISTINCT m.userEmail) DESC")
    List<String> findMovieLikesCount();

    Movie findByMovieTitle(String movieTitle);
}
