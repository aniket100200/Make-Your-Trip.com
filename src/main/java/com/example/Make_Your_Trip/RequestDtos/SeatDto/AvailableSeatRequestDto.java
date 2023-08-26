package com.example.Make_Your_Trip.RequestDtos.SeatDto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AvailableSeatRequestDto
{
    private LocalDate journeyDate;
    private int transportId;
}
