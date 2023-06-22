package com.example.bookingservice.service;

import com.example.bookingservice.dto.BookingScheduleResponse;
import com.example.bookingservice.dto.BookingSeatResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final WebClient.Builder webClientBuilder;
//    private final WebClient webClient;
    public List<BookingScheduleResponse> getSchedule(Long id){
        BookingScheduleResponse[] responses = webClientBuilder.build().get()
                                                .uri("http://schedule-service/api/schedule/movie",
                                                        uriBuilder -> uriBuilder.queryParam("id", id).build())
                                                .retrieve()
                                                .bodyToMono(BookingScheduleResponse[].class)
                                                .block();
        System.out.println(responses[0].getCinema());

        return Arrays.asList(responses);
    }

    public BookingSeatResponse bookingSeat(Long id) {
        BookingSeatResponse response = webClientBuilder.build().get()
                .uri("http://schedule-service/api/schedule/seat",
                        uriBuilder -> uriBuilder.queryParam("id", id).build())
                .retrieve()
                .bodyToMono(BookingSeatResponse.class)
                .block();
        return response;
    }
}
