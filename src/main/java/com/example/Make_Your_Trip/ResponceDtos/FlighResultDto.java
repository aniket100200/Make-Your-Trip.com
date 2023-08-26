package com.example.Make_Your_Trip.ResponceDtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class FlighResultDto
{
    private LocalDate journeyDate;
    private LocalTime startTime;
    private String companeyName;
    private double journeyTime;
    private String listOfStopsInBetween;
}
