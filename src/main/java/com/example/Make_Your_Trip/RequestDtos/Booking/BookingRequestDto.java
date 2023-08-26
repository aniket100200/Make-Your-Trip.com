package com.example.Make_Your_Trip.RequestDtos.Booking;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class BookingRequestDto
{
    private String seatNo; //comma separated values... 1A,2A, 3B..
    private LocalDate journeyDate;
    private Integer transportId;


    //we'll also need the user who is booking seats.. here we go..

    private  Integer userId;
}
