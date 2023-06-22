package com.example.movieservice.service;

import com.example.movieservice.dto.MovieResponse;
import com.example.movieservice.entity.Movie;
import com.example.movieservice.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<MovieResponse> getAll() {
        List<Movie> movies = movieRepository.findAll();
        List<MovieResponse> movieResponses = new ArrayList<>();
        for(Movie movie: movies){
            movieResponses.add(modelMapper.map(movie, MovieResponse.class));
        }
        return movieResponses;
    }
}
