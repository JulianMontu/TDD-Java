package com.platzi.javatest.movies.data;

import com.platzi.javatest.movies.model.Genre;
import com.platzi.javatest.movies.model.Movie;
import org.h2.tools.Script;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class MovieRepositoryIntegrationTest {
    @Test
    public void load_all_movies() throws SQLException {
        //Conexion base de datos en memoria
        DataSource dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");
        //script ejecutado en mi base de datos
        ScriptUtils.executeSqlScript(dataSource.getConnection(),new ClassPathResource("test-data.sql"));
        //template que necesita mi repositorio
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        MovieRepositoryJdbc movieRepository = new MovieRepositoryJdbc(jdbcTemplate);
        //Recupero las peliculas obtenidas sean las correctas
        Collection<Movie> movies = movieRepository.findAll();
        assertThat(movies, CoreMatchers.is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION),
                new Movie(2, "Memento", 113, Genre.THRILLER),
                new Movie(3, "Matrix", 136, Genre.ACTION)
        )));
    }
}