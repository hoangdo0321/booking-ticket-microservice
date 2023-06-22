package com.demo.cinemaservice.service;

import com.demo.cinemaservice.dto.RoomResponse;
import com.demo.cinemaservice.dto.SeatResponse;
import com.demo.cinemaservice.entity.Cinema;
import com.demo.cinemaservice.entity.Room;
import com.demo.cinemaservice.entity.Seat;
import com.demo.cinemaservice.repository.CinemaRepository;
import com.demo.cinemaservice.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;
    private final CinemaRepository cinemaRepository;

    public List<RoomResponse> getAllCinema() {
        List<Cinema> cinemas = cinemaRepository.findAll();
        List<RoomResponse> responses = new ArrayList<>();
        for(Cinema cinema: cinemas){
            responses.add(new RoomResponse(cinema.getId(), cinema.getName()));
        }
        return responses;
    }

    public List<SeatResponse> getSeats(Long room_id) {
        Set<Seat> seats = roomRepository.findById(room_id).orElseThrow().getSeats();
        List<SeatResponse> seatResponses = new ArrayList<>();
        for(Seat seat: seats){
            seatResponses.add(new SeatResponse(seat.getRowSign(), seat.getNumber(), seat.getSeatType(), seat.isAvailable()));
        }
        return seatResponses;
    }
}
