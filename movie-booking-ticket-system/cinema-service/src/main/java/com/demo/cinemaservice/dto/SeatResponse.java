package com.demo.cinemaservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatResponse {
    private String row;
    private int number;
    private String seatType;
    private boolean isAvailable;
}
