package com.movie.dataprocessing.DataProcessing.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieDetails {

    @JsonProperty("movieId")
    private String movieId;

    @JsonProperty("movieTitle")
    private String movieTitle;

    @JsonProperty("releaseDate")
    private String releaseDate;

    @JsonProperty("moviePoster")
    private String moviePoster;

}
