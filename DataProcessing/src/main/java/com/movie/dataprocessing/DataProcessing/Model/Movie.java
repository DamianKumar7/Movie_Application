package com.movie.dataprocessing.DataProcessing.Model;


import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "liked_movies")
public class Movie {
    @Id
    @Column(name = "movie_id")
    private String movieId;

    @Column(name = "movie_name")
    private String movieTitle;

    @Column(name = "movie_poster")
    private String moviePoster;

}
