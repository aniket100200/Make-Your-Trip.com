package com.example.Make_Your_Trip.RequestDtos.SeatDto;

import lombok.Data;

@Data
public class SeatRequestDto
{
    private Integer noOfEconomySeats;
    private Integer noOfBusinessSeats;
    private Integer priceOfEconomySeat;
    private Integer priceOfBusinessSeat;

    private int transportId;
}
