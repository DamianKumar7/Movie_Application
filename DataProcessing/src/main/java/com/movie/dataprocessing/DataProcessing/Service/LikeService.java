package com.movie.dataprocessing.DataProcessing.Service;

import com.movie.dataprocessing.DataProcessing.DTO.MovieRequest;
import com.movie.dataprocessing.DataProcessing.DTO.MovieDetails;
import com.movie.dataprocessing.DataProcessing.Model.Movie;
import com.movie.dataprocessing.DataProcessing.Repository.LikedMoviesRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    @Autowired
    LikedMoviesRepository likedMoviesRepository;

    public Boolean addMovie(@NotNull MovieRequest movieRequest) throws Exception {
        MovieDetails movieDetails = movieRequest.getMovieDetails();
        if(movieDetails== null){
            throw new Exception("Empty Movie Details");
        }
        Movie movie = new Movie();
        movie.setMovieId(movieDetails.getMovieId());
        movie.setMoviePoster(movieDetails.getMoviePoster());
        movie.setMovieTitle(movieDetails.getMovieTitle());
        likedMoviesRepository.save(movie);
        return true;
    }

    public boolean removeMovie(MovieRequest movieRequest) throws Exception {
        MovieDetails movieDetails = movieRequest.getMovieDetails();
        if(movieDetails== null){
            throw new Exception("Empty Movie Details");
        }
        Movie movie = new Movie();
        movie.setMovieId(movieDetails.getMovieId());
        movie.setMoviePoster(movieDetails.getMoviePoster());
        movie.setMovieTitle(movieDetails.getMovieTitle());
        likedMoviesRepository.delete(movie);
        return true;
    }
}
