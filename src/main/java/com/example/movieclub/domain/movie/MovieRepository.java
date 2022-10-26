package com.example.movieclub.domain.movie;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends CrudRepository<Movie,Long> {
    List<Movie> findAllByPromotedIsTrue();
}
