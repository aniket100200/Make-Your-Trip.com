package com.example.Make_Your_Trip.Service;

import com.example.Make_Your_Trip.CutomException.RoutesExceptions.TransportNotFoundException;
import com.example.Make_Your_Trip.Enums.SeatType;
import com.example.Make_Your_Trip.Models.Seat;
import com.example.Make_Your_Trip.Models.Transport;
import com.example.Make_Your_Trip.Repositories.SeatRepository;
import com.example.Make_Your_Trip.Repositories.TransportRepository;
import com.example.Make_Your_Trip.RequestDtos.SeatDto.SeatRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class SeatServices
{
    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private TransportRepository transportRepository;
    public String addSeat(@RequestBody SeatRequestDto seatRequestDto) throws TransportNotFoundException {
        Transport transport=transportRepository.findById(seatRequestDto.getTransportId()).get();
        if(transport==null)throw new TransportNotFoundException("UnableT To find the Transport with "+seatRequestDto.getTransportId());
        for(int i=0;i<seatRequestDto.getNoOfEconomySeats();i++){
            Seat seat=Seat.builder()
                    .seatNo("E"+(i+1))
                    .seatType(SeatType.ECONOMY)
                    .price(seatRequestDto.getNoOfEconomySeats())
                    .transport(transport)
                    .build();
            transport.getSeatList().add(seat);
        }

        for(int i=0;i<seatRequestDto.getNoOfBusinessSeats();i++)
        {
            Seat seat=Seat.builder()
                    .seatNo("B"+(i+1))
                    .seatType(SeatType.BUSINESS)
                    .price(seatRequestDto.getPriceOfBusinessSeat())
                    .transport(transport)
                    .build();
            transport.getSeatList().add(seat);
        }


        return "Seats Has Been Added to the Transport";

    }
}
