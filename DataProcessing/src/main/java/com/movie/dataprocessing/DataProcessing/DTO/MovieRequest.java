package com.movie.dataprocessing.DataProcessing.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieRequest {
    @JsonProperty("userEmail")
    private String userEmail;

    @JsonProperty("movieDetails")
    private MovieDetails movieDetails;
}
