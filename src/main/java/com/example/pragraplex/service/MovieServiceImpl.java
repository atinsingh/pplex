package com.example.pragraplex.service;

import com.example.pragraplex.entity.Movie;
import com.example.pragraplex.repo.MovieRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{

    private final MovieRepo movieRepo;

    @Override
    public Optional<Movie> createMovie(Movie movie) {
        return Optional.of(movieRepo.save(movie));

    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepo.findAll();

    }

    @Override
    public Optional<Movie> getMovieByID(Integer id) {
        return movieRepo.findById(id);
    }
}
