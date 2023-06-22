package com.example.movieservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String title;
    private String poster;
//    private String trailer;
    @ElementCollection
    private List<String> director;
    @ElementCollection
    private List<String> cast;
    @ElementCollection
    private List<String> category;
    private String description;
    private String  premiereDate;
    private Integer duration;
    private String language;
    private String rated;


}
