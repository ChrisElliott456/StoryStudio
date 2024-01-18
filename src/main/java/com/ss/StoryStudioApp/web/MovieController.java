package com.ss.StoryStudioApp.web;

import com.ss.StoryStudioApp.entity.Movie;
import com.ss.StoryStudioApp.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/StoryStudio/store")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovies(){
        return new ResponseEntity<>(movieService.getMovies(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id){
        return new ResponseEntity<>(movieService.getMovieById(id), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        return new ResponseEntity<>(movieService.addMovie(movie), HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Movie> deleteMovieById(@PathVariable Long id){
        movieService.deleteMovieById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovieById(@PathVariable Long id, @RequestBody Movie movie){
        return new ResponseEntity<>(movieService.updateMovieById(id, movie), HttpStatus.ACCEPTED);
    }
}
