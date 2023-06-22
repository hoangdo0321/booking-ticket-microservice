package com.example.scheduleMovieservice.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheduleMovieRequest {
    private Long movieId;
    private Long roomId;
    private Date startTime;
    private Date endTime;

}
