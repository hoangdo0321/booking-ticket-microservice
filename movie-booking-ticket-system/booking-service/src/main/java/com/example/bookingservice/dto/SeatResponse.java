package com.example.bookingservice.dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeatResponse {
    private String row;
    private int number;
    private String seatType;
    private int isAvailable;
}
