package com.movie.dataprocessing.DataProcessing.Controller;


import com.movie.dataprocessing.DataProcessing.DTO.MovieRequest;
import com.movie.dataprocessing.DataProcessing.Service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
