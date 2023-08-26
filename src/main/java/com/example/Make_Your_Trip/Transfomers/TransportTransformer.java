package com.example.Make_Your_Trip.Transfomers;

import com.example.Make_Your_Trip.Models.Transport;
import com.example.Make_Your_Trip.RequestDtos.AddTransportDto;
import com.example.Make_Your_Trip.ResponceDtos.FlighResultDto;

public class TransportTransformer
{
    public static Transport dtoEntityConverter(AddTransportDto addTransportDto)
    {
        Transport transport=Transport.builder()
                .modeOfTransport(addTransportDto.getModeOfTransport())
                .journeyDate(addTransportDto.getJourneyDate())
                .journeyTime(addTransportDto.getJourneyTime())
                .CompaneyName(addTransportDto.getCompaneyName())
                .startTime(addTransportDto.getStartTime()).build();
        return transport;

    }
    public static FlighResultDto TransportToFlightResultDto(Transport transport)
    {
        FlighResultDto flighResultDto=FlighResultDto.builder()
                .startTime(transport.getStartTime())
                .companeyName(transport.getCompaneyName())
                .journeyDate(transport.getJourneyDate())
                .journeyTime(transport.getJourneyTime())
                .build();
        return flighResultDto;
    }
}
