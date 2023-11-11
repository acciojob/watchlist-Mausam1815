package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie){
        movieRepository.addMovie(movie);
        return "Movie added successfully";
    }

    public String addDirector(Director director) {
        movieRepository.addDirector(director);
        return "Director added Successfully";
    }

    public String addMovieDirectorPair(String movieName, String directorName) {
        movieRepository.addMovieDirectorPair(movieName, directorName);
        return "Movie and Director added Successfully";
    }

    public Movie getMovieByName(String name) {
        Movie movie = movieRepository.getMovieByName(name);
        return movie;
    }

    public Director getDirectorByName(String name) {
        Director director = movieRepository.getDirectorByName(name);
        return director;
    }

    public List<String> getMoviesByDirectorName(String director) {
        List<String> list = movieRepository.getMoviesByDirectorName(director);
        return list;
    }

    public List<String> findAllMovies() {
        List<String> list = movieRepository.findAllMovies();
        return list;
    }

    public String deleteDirectorByName(String name) {
        movieRepository.deleteDirectorByName(name);
        return "Director and Movie removed Successfully";
    }

    public String deleteAllDirectors() {
        movieRepository.deleteAllDirectors();
        return "All Record Deleted";
    }
}