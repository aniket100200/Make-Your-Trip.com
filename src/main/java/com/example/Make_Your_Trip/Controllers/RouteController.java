package com.example.Make_Your_Trip.Controllers;

import com.example.Make_Your_Trip.RequestDtos.AddRouteDto;
import com.example.Make_Your_Trip.Service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/route")
public class RouteController
{
    @Autowired
    private RouteService routeService;

    @PostMapping("/add")
    public String addRoute(@RequestBody AddRouteDto addRouteDto)
    {
        return routeService.addRoute(addRouteDto);
    }
}
