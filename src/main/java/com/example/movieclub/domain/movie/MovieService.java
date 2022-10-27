package com.example.movieclub.domain.movie;

import com.example.movieclub.domain.movie.dto.MovieDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDto> findAllPromotedMovies() {
        return movieRepository.findAllByPromotedIsTrue()
                .stream()
                .map(MovieDtoMapper::map)
                .toList();
    }

    public Optional<MovieDto> findMovieById(long id){
        return movieRepository.findById(id).map(MovieDtoMapper::map);
    }

    public List<MovieDto> findAllByGenreName(String name){
        return movieRepository.findAllByGenre_NameIgnoreCase(name).stream()
                .map(MovieDtoMapper::map)
                .toList();
    }
}
