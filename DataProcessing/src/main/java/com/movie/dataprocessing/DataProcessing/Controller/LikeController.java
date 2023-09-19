package com.movie.dataprocessing.DataProcessing.Controller;


import com.movie.dataprocessing.DataProcessing.DTO.MovieRequest;
import com.movie.dataprocessing.DataProcessing.Model.Movie;
import com.movie.dataprocessing.DataProcessing.Service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LikeController {

    @Autowired
    LikeService likeService;

    @PostMapping("/like")
    public ResponseEntity<?> likeMovie(@RequestBody MovieRequest movieRequest) throws Exception {
        if(movieRequest == null){
            return new ResponseEntity<>("request body cannot be empty",HttpStatus.BAD_GATEWAY);
        }
        boolean response = likeService.addMovie(movieRequest);
        if(response == false){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Movie added successfully ",HttpStatus.OK);
    }

    @PostMapping("/dislike")
    public ResponseEntity<?> dislikeMovie(@RequestBody MovieRequest movieRequest) throws Exception {
        if(movieRequest == null){
            return new ResponseEntity<>("request body cannot be empty",HttpStatus.BAD_GATEWAY);

        }
        boolean response = likeService.removeMovie(movieRequest);
        if(response == false){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Movie removed successfully",HttpStatus.OK);
    }

    @PostMapping("/find_liked_movies_by_email")
    public ResponseEntity<?> likedMoviesByEmailId(String request) throws Exception {
        if(request.isEmpty()){
            return new ResponseEntity<>("empty emailId",HttpStatus.BAD_GATEWAY);
        }
        List<Movie> likedMovies = likeService.likedMoviesByEmail(request);
        return new ResponseEntity<>(likedMovies,HttpStatus.OK);
    }

    @PostMapping("/find_most_liked_movies")
    public ResponseEntity<?> mostLikedMovies(){
        List<Movie> likedMovies = likeService.mostLikedMovied();
        return new ResponseEntity<>(likedMovies,HttpStatus.OK);
    }

}
