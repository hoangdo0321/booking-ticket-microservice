package com.example.scheduleMovieservice.service;

import com.example.scheduleMovieservice.dto.*;
import com.example.scheduleMovieservice.entity.ScheduleMovie;
import com.example.scheduleMovieservice.repo.ScheduleMovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ScheduleMovieService {
    private final ScheduleMovieRepository scheduleRepository;
    private final WebClient.Builder webClientBuilder;
    public List<ScheduleMovieResponse> getSchedule(Long id){
        List<ScheduleMovie> scheduleMovies = scheduleRepository.findAllByMovieIdOrderByCinemaIdAsc(id);
        List<ScheduleMovieResponse> responses = new ArrayList<>();


        for(ScheduleMovie smov: scheduleMovies){
            ScheduleMovieResponse sMovResponse = ScheduleMovieResponse.builder()
                    .scheduleId(smov.getId())
                    .date(new SimpleDateFormat("dd/MM/yyyy").format(smov.getDate()))
                    .startTime(DateTimeFormatter.ofPattern("HH:mm").format(smov.getStartTime()))
                    .endTime(DateTimeFormatter.ofPattern("HH:mm").format(smov.getEndTime()))
                    .cinema(smov.getCinemaName())
                    .build();
            responses.add(sMovResponse);
        }
        return responses;
    }

    public BookingSeatResponse getSeat(Long id) {
        ScheduleMovie movie = scheduleRepository.findById(id).get();
         SeatResponse[] seatResponses = webClientBuilder.build().get()
                .uri("http://cinema-service/api/cinema/seat",
                        uriBuilder -> uriBuilder.queryParam("room_id", id).build())
                .retrieve()
                .bodyToMono(SeatResponse[].class)
                .block();
        List<SeatResponse> seatResponseList = Arrays.asList(seatResponses);
        BookingSeatResponse bookingSeatResponse = BookingSeatResponse.builder()
                .scheduleId(id)
                .date(new SimpleDateFormat("dd/MM/yyyy").format(movie.getDate()))
                .startTime(DateTimeFormatter.ofPattern("HH:mm").format(movie.getStartTime()))
                .endTime(DateTimeFormatter.ofPattern("HH:mm").format(movie.getEndTime()))
                .cinema(movie.getCinemaName())
                .room(movie.getRoomName())
                .seats(seatResponseList)
                .build();
        return bookingSeatResponse;
    }
}
