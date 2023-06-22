package com.demo.cinemaservice.service;

import com.demo.cinemaservice.dto.SeatResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatService {

    public List<SeatResponse> getSeats(Long room_id) {
        return null;
    }
}
