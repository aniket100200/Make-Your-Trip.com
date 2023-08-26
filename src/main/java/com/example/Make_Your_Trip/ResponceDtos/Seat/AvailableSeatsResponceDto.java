package com.example.Make_Your_Trip.ResponceDtos.Seat;

import com.example.Make_Your_Trip.Enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AvailableSeatsResponceDto
{
    String seatNo;
    SeatType seatType;
    Integer seatPrice;
}
