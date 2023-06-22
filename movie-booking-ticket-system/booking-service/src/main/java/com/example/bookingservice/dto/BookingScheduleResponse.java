package com.example.bookingservice.dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingScheduleResponse {
    private Long scheduleId;
    private String date;
    private String startTime;
    private String endTime;
    private String cinema;
    private String room;
}
