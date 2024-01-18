package com.ss.StoryStudioApp.service;

import com.ss.StoryStudioApp.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getMovies();
    Movie getMovieById (Long id);
    Movie addMovie(Movie movie);
    void deleteMovieById(Long id);
    Movie updateMovieById(Long id, Movie movie);
}
