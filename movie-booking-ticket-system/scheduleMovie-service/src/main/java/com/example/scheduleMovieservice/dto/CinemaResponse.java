package com.example.scheduleMovieservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CinemaResponse {
    private Long id;
    private String name;
}
