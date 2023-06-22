package com.example.bookingservice.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class BookingSeatResponse {
    private Long scheduleId;
    private String date;
    private String startTime;
    private String endTime;
    private String cinema;
    private String room;
    private List<SeatResponse> seats;
}
