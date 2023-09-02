package com.movie.dataprocessing.DataProcessing.Controller;


import com.movie.dataprocessing.DataProcessing.DTO.MovieRequest;
import com.movie.dataprocessing.DataProcessing.Service.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/watchlist")
public class WatchlistController {

    @Autowired
    WatchlistService watchlistService;

    @PostMapping("/add_movie")
    public ResponseEntity<?> addMovieToWatchlist(MovieRequest request){
        if(request == null){
            return new ResponseEntity<>("request body cannot be empty", HttpStatus.BAD_GATEWAY);
        }
        boolean response = watchlistService.addMovie(request);

        if(response == false){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Movie added successfully ",HttpStatus.OK);
    }

}
