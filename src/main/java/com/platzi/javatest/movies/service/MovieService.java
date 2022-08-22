package com.platzi.javatest.movies.service;

import com.platzi.javatest.movies.data.MovieRepository;
import com.platzi.javatest.movies.model.Genre;
import com.platzi.javatest.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByeGenre(Genre genre) {
        return movieRepository.findAll().stream().filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());

    }

    public Collection<Movie> findMoviesByeLenght(int lenght) {
        return movieRepository.findAll().stream().filter(movie -> movie.getMinutes() <= lenght).collect(Collectors.toList());

    }
}
