package com.movie.dataprocessing.DataProcessing.Repository;

import com.movie.dataprocessing.DataProcessing.Model.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchlistRespository extends JpaRepository<Watchlist,String> {
}
