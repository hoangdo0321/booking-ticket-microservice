package com.example.scheduleMovieservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheduleMovieResponse {
    private Long scheduleId;
    private String date;
    private String startTime;
    private String endTime;
    private String cinema;
    private String room;
}
