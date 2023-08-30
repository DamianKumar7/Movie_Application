package com.movie.dataprocessing.DataProcessing.Service;

import com.movie.dataprocessing.DataProcessing.DTO.LikeRequest;
import com.movie.dataprocessing.DataProcessing.DTO.MovieDetails;
import com.movie.dataprocessing.DataProcessing.Model.Movie;
import com.movie.dataprocessing.DataProcessing.Repository.LikedMoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    @Autowired
    LikedMoviesRepository likedMoviesRepository;

    public Boolean addMovie(LikeRequest likeRequest) {
        MovieDetails movieDetails = likeRequest.getMovieDetails();
        if(movieDetails== null){
            return false;
        }
        Movie movie = new Movie();
        movie.setMovieId(movieDetails.getMovieId());
        movie.setMoviePoster(movieDetails.getMoviePoster());
        movie.setMovieTitle(movieDetails.getMovieTitle());
        likedMoviesRepository.save(movie);
        return null;
    }
}
