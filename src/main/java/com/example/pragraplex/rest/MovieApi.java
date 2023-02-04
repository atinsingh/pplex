package com.example.pragraplex.rest;

import com.example.pragraplex.entity.Movie;
import com.example.pragraplex.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MovieApi {

    private final MovieService movieService;

    @PostMapping("/movie")
    public Optional<Movie> createMovie(@RequestBody Movie movie){
        return movieService.createMovie(movie);
    }


    @GetMapping("/movie")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }
    @GetMapping("/movie/{id}")
    public Optional<Movie> getMovieById(@PathVariable(name = "id") Integer id){
        return movieService.getMovieByID(id);
    }
}
