package com.example.bookingservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingRequest {
    private Long userId;
    private Long scheduleId;
    private Double totalPrice;
}
