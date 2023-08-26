package com.example.Make_Your_Trip.Transfomers;

import com.example.Make_Your_Trip.Models.Routes;
import com.example.Make_Your_Trip.RequestDtos.AddRouteDto;

public class RouteTransformer
{
    public  static Routes convertAddRouteDtoToEntity(AddRouteDto addRouteDto)
    {
        Routes route= Routes.builder()
                            .fromCity(addRouteDto.getFromCity())
                            .toCity(addRouteDto.getToCity())
                            .listOfStopsInBetween(addRouteDto.getStopsInBetween())
                            .modeOfTransport(addRouteDto.getModeOfTransport())
                            .build();
        return route;
    }
}
