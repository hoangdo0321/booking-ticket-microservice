package com.demo.cinemaservice.controller;

import com.demo.cinemaservice.dto.RoomResponse;
import com.demo.cinemaservice.dto.SeatResponse;
import com.demo.cinemaservice.service.RoomService;
import com.demo.cinemaservice.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cinema")
@RequiredArgsConstructor
public class CinemaController {

    private final RoomService roomService;
    private final SeatService seatService;

    @GetMapping("/all")
    public ResponseEntity<List<RoomResponse>> getAllCinema(){
        return ResponseEntity.ok(roomService.getAllCinema());
    }

    @GetMapping("/seat")
    @ResponseStatus(HttpStatus.OK)
    public List<SeatResponse> getSeats(@RequestParam Long room_id){
        return roomService.getSeats(room_id);

    }
}
