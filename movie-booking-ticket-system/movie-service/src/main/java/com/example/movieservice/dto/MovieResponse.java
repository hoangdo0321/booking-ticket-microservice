package com.example.movieservice.dto;


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
    private String poster;
    private List<String> director;
    private List<String> cast;
    private List<String> category;
    private String description;
    private String  premiereDate;
    private Integer duration;
    private String language;
    private String rated;
}
