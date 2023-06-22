package com.example.scheduleMovieservice.dto;

import jakarta.persistence.ElementCollection;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponse {
    private String title;
    private List<String> director;
    private List<String> cast;
    private List<String> category;
    private String  premiereDate;
    private Integer durationTime;
    private String language;
    private String rated;
}
