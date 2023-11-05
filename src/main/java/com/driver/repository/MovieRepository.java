package com.driver.repository;

import com.driver.Director;
import com.driver.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {
    private final HashMap<String, Movie> moviesDB = new HashMap<>();
    private final HashMap<String, Director> directorsDB = new HashMap<>();
    private final HashMap<String, String> movieDirectorPair = new HashMap<>();

    public void addMovie(Movie movie) {
        moviesDB.put(movie.getName(), movie);
    }

    public void addDirector(Director director) {
        directorsDB.put(director.getName(), director);
    }

    public boolean addMovieDirectorPair(String movieName, String directorName) {
        if (moviesDB.containsKey(movieName) && directorsDB.containsKey(directorName)) {
            movieDirectorPair.put(movieName, directorName);
            return true; // Successfully paired.
        } else {
            return false; // Either the movie or director doesn't exist.
        }
    }

    public Movie getMovieByName(String movieName) {
        return moviesDB.get(movieName);
    }

    public Director getDirectorByName(String directorName) {
        return directorsDB.get(directorName);
    }

    public List<String> getMoviesByDirectorName(String directorName) {
        List<String> moviesByDirector = new ArrayList<>();
        for(Map.Entry<String, String> entry : movieDirectorPair.entrySet()) {
            if(entry.getValue().equals(directorName)) {
                moviesByDirector.add(entry.getKey());
            }
        }
        return moviesByDirector;
    }

    public void deleteDirectorByName(String directorName) {
        List<String> moviesToRemove = new ArrayList<>();
        for(Map.Entry<String, String> entry : movieDirectorPair.entrySet()) {
            if(entry.getValue().equals(directorName)) {
                moviesToRemove.add(entry.getKey());
            }
        }
        for(String movie : moviesToRemove) {
            movieDirectorPair.remove(movie);
            moviesDB.remove(movie);
        }
        directorsDB.remove(directorName);
    }

    public void deleteAllDirectors() {
        movieDirectorPair.clear();

        for(String directorName : directorsDB.keySet()) {
            List<String> moviesToRemove = new ArrayList<>();
            for(Map.Entry<String, String> entry : movieDirectorPair.entrySet()) {
                if(entry.getValue().equals(directorName)) {
                    moviesToRemove.add(entry.getKey());
                }
            }
            for(String movie : moviesToRemove) {
                movieDirectorPair.remove(movie);
            }

            for(String movie : moviesToRemove) {
                moviesDB.remove(movie);
            }
        }
        directorsDB.clear();
    }

    public List<String> getAllMovies() {
        return new ArrayList<>(moviesDB.keySet());
    }
}
