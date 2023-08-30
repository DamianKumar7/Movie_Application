package com.movie.dataprocessing.DataProcessing.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;
import org.springframework.stereotype.Service;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LikeRequest {
    @JsonProperty("userEmail")
    private String userEmail;

    @JsonProperty("movieDetails")
    private MovieDetails movieDetails;
}
