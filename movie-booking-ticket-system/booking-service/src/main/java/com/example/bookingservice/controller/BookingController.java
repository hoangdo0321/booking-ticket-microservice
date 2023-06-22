package com.example.bookingservice.controller;


import com.example.bookingservice.dto.BookingRequest;
import com.example.bookingservice.dto.BookingScheduleResponse;
import com.example.bookingservice.dto.BookingSeatResponse;
import com.example.bookingservice.service.BookingService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/showtime/{movie_id}")
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallBackMethod")
    @TimeLimiter(name = "inventory")
    @Retry(name = "inventory")
    public CompletableFuture<ResponseEntity<List<BookingScheduleResponse>>> getMovieSchedule(@PathVariable("movie_id") Long id){
        return CompletableFuture.supplyAsync(()->ResponseEntity.ok(bookingService.getSchedule(id)));
    }

//    @GetMapping("/showtime/{movie_id}")
//    @CircuitBreaker(name = "inventory", fallbackMethod = "fallBackMethod")
//    public ResponseEntity<List<BookingScheduleResponse>> getMovieSchedule(@PathVariable("movie_id") Long id){
//        return ResponseEntity.ok(bookingService.getSchedule(id));
//    }

    public ResponseEntity<Object> fallBackMethod(Long id, RuntimeException runtimeException){
        return new ResponseEntity<Object>("Something went wrong, please do the booking later", HttpStatus.FORBIDDEN);
    }

    @GetMapping("/bookingSeat/{schedule_id}")
    public ResponseEntity<BookingSeatResponse> bookingSeat(@PathVariable("schedule_id") Long id){
        return ResponseEntity.ok(bookingService.bookingSeat(id));
    }



//    @PostMapping("/booking")
//    public ResponseEntity<BookingSeatResponse> createBooking(@RequestBody BookingRequest){
//        return null;
//    }

}
