package com.driver.services;

import com.driver.model.Director;
import com.driver.model.Movie;
import com.driver.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void addMovie(Movie movie) {
        movieRepository.addMovie(movie);
    }

    public void addDirector(Director director) {
        movieRepository.addDirector(director);
    }

    public boolean addMovieDirectorPair(String movieName, String directorName) {
        return movieRepository.addMovieDirectorPair(movieName, directorName);
    }

    public ResponseEntity<Movie> getMovieByName(String movieName) {
        Movie movie = movieRepository.getMovieByName(movieName);
        if(movie != null) {
            return ResponseEntity.ok(movie);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Director> getDirectorByName(String directorName) {
        Director director = movieRepository.getDirectorByName(directorName);
        if(director != null) {
            return ResponseEntity.ok(director);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<List<String>> getMoviesByDirectorName(String directorName) {
        List<String> movies = movieRepository.getMoviesByDirectorName(directorName);
        if(movies != null) {
            return ResponseEntity.ok(movies);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<List<String>> getAllMovies() {
        List<String> movies = movieRepository.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    public void deleteDirectorByName(String directorName) {
        movieRepository.deleteDirectorByName(directorName);
    }

    public void deleteAllDirectors() {
        movieRepository.deleteAllDirectors();
    }
}
