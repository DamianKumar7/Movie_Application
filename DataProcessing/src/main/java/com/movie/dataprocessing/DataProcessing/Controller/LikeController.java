package com.movie.dataprocessing.DataProcessing.Controller;


import com.movie.dataprocessing.DataProcessing.DTO.LikeRequest;
import com.movie.dataprocessing.DataProcessing.DTO.MovieDetails;
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
    public ResponseEntity<?> likeMovie(@RequestBody LikeRequest likeRequest){
        if(likeRequest == null){
            return new ResponseEntity<>("request body cannot be empty",HttpStatus.BAD_GATEWAY);
        }
        Boolean response = likeService.addMovie(likeRequest);
        return new ResponseEntity<>("Movie added successfully ",HttpStatus.OK);
    }

}
