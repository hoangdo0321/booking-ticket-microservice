package com.example.scheduleMovieservice.controller;


import com.example.scheduleMovieservice.dto.BookingSeatResponse;
import com.example.scheduleMovieservice.dto.ScheduleMovieRequest;
import com.example.scheduleMovieservice.dto.ScheduleMovieResponse;
import com.example.scheduleMovieservice.entity.ScheduleMovie;
import com.example.scheduleMovieservice.service.ScheduleMovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
@Slf4j
public class ScheduleMovieController {
    @Autowired
    ScheduleMovieService scheduleMovieService;
    @GetMapping(value = "/movie")
    @ResponseStatus(HttpStatus.OK)
    public List<ScheduleMovieResponse> getScheduledMovies(@RequestParam Long id){
        log.info("Received movie request by movieId: {}", id);
        return scheduleMovieService.getSchedule(id);
    }

    @GetMapping(value = "/seat")
    @ResponseStatus(HttpStatus.OK)
    public BookingSeatResponse getBookingSeat(@RequestParam Long id){
        log.info("Received get seat request by scheduleId: {}", id);
        return scheduleMovieService.getSeat(id);
    }


    @PostMapping(value ="/create")
    public ResponseEntity<String> createScheduleMovie(@RequestBody ScheduleMovieRequest scheduleMovieRequest){

        return ResponseEntity.ok("Movie scheduled success!!");
    }

}
