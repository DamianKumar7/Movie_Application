package com.movie.dataprocessing.DataProcessing.Service;


import com.movie.dataprocessing.DataProcessing.DTO.MovieDetails;
import com.movie.dataprocessing.DataProcessing.DTO.MovieRequest;
import com.movie.dataprocessing.DataProcessing.Model.Movie;
import com.movie.dataprocessing.DataProcessing.Model.Watchlist;
import com.movie.dataprocessing.DataProcessing.Repository.WatchlistRespository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WatchlistService {
    @Autowired
    WatchlistRespository watchlistRespository;

    public Boolean addMovie(@NotNull MovieRequest movieRequest) throws Exception {
        MovieDetails movieDetails = movieRequest.getMovieDetails();
        if(movieDetails== null){
            throw new Exception("Empty Movie Details");
        }
        Watchlist movie = new Watchlist();
        movie.setMovieId(movieDetails.getMovieId());
        movie.setMoviePoster(movieDetails.getMoviePoster());
        movie.setMovieTitle(movieDetails.getMovieTitle());
        watchlistRespository.save(movie);
        return true;
    }

    public boolean removeMovie(MovieRequest movieRequest) throws Exception {
        MovieDetails movieDetails = movieRequest.getMovieDetails();
        if(movieDetails== null){
            throw new Exception("Empty Movie Details");
        }
        Watchlist movie = new Watchlist();
        movie.setMovieId(movieDetails.getMovieId());
        movie.setMoviePoster(movieDetails.getMoviePoster());
        movie.setMovieTitle(movieDetails.getMovieTitle());
        watchlistRespository.delete(movie);
        return true;
    }
}
