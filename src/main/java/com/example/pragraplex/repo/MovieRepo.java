package com.example.pragraplex.repo;

import com.example.pragraplex.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer> {
}
