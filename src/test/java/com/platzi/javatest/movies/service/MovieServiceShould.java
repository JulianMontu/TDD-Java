package com.platzi.javatest.movies.service;

import com.platzi.javatest.movies.data.MovieRepository;
import com.platzi.javatest.movies.model.Genre;
import com.platzi.javatest.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MovieServiceShould {
    MovieService movieService;

    @Before
    public void setUp() throws Exception {
        MovieRepository repository = Mockito.mock(MovieRepository.class);

        Mockito.when(repository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION),
                        new Movie(2, "Memento", 113, Genre.THRILLER),
                        new Movie(3, "There's Something About Mary", 119, Genre.COMEDY),
                        new Movie(4, "super 8", 112, Genre.THRILLER),
                        new Movie(5, "Scream", 111, Genre.HORROR),
                        new Movie(6, "Home Alone", 103, Genre.COMEDY),
                        new Movie(7, "Superman", 136, Genre.ACTION)
                )
        );
        movieService = new MovieService(repository);
    }

    @Test
    public void return_movies_by_genre() {


        Collection<Movie> movies = movieService.findMoviesByeGenre(Genre.COMEDY);

        assertThat(geetMoviesIds(movies), CoreMatchers.is(Arrays.asList(3, 6)));
    }

    @Test
    public void return_movies_by_lenght() {
        Collection<Movie> movies = movieService.findMoviesByeLenght(119);
        assertThat(geetMoviesIds(movies), CoreMatchers.is(Arrays.asList(2, 3, 4, 5, 6)));
    }

    @Test
    public void return_movies_by_name() {
        Collection <Movie> movies = movieService.findMovieByName("super");
        assertThat(geetMoviesIds(movies),CoreMatchers.is((Arrays.asList(4,7))));

    }

    @Test
    public void retirn_movies_by_director() {
Collection <Movie> movies = movieService.findMovieByDirector("");

    }

    private static List<Integer> geetMoviesIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }

}