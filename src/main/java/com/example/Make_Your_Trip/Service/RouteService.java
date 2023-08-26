package com.example.Make_Your_Trip.Service;

import com.example.Make_Your_Trip.Models.Routes;
import com.example.Make_Your_Trip.Repositories.RouteRepository;
import com.example.Make_Your_Trip.RequestDtos.AddRouteDto;
import com.example.Make_Your_Trip.Transfomers.RouteTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService
{
    @Autowired
    private RouteRepository routeRepository;
    public String addRoute(AddRouteDto addRouteDto)
    {
        Routes route= RouteTransformer.convertAddRouteDtoToEntity(addRouteDto);
        routeRepository.save(route);
        return "Route is Created Successfully!!!";
    }
}
