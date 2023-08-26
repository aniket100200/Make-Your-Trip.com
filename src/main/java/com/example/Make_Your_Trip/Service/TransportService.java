package com.example.Make_Your_Trip.Service;

import com.example.Make_Your_Trip.CutomException.RoutesExceptions.FlightNotFoundException;
import com.example.Make_Your_Trip.CutomException.RoutesExceptions.RouteNotFoundException;
import com.example.Make_Your_Trip.Enums.ModeOfTransport;
import com.example.Make_Your_Trip.Models.Routes;
import com.example.Make_Your_Trip.Models.Transport;
import com.example.Make_Your_Trip.Repositories.RouteRepository;
import com.example.Make_Your_Trip.Repositories.TransportRepository;
import com.example.Make_Your_Trip.RequestDtos.AddRouteDto;
import com.example.Make_Your_Trip.RequestDtos.AddTransportDto;
import com.example.Make_Your_Trip.RequestDtos.SearchFlighDto;
import com.example.Make_Your_Trip.ResponceDtos.FlighResultDto;
import com.example.Make_Your_Trip.Transfomers.TransportTransformer;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.NaturalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TransportService
{
    @Autowired
    private TransportRepository transportRepository;

       @Autowired
    private RouteRepository routeRepository;
    public String addTransport(AddTransportDto addTransportDto)throws Exception
    {
        Transport transportObj= TransportTransformer.dtoEntityConverter(addTransportDto);

        Optional<Routes> optional=routeRepository.findById(addTransportDto.getRouteId());
        if(optional.isPresent()==false)throw new RouteNotFoundException("route is Not Present");

        Routes route=optional.get();

        //set the Route in Transport Object
        transportObj.setRoute(route);

        //as Bidirectional Mapping..
        route.getTransportList().add(transportObj);


        //because of Bidirctional mapping and cascading effect save only the parent..

        routeRepository.save(route);

        return "Transport has been added Successfully!!!";


    }

    public List<FlighResultDto> searchFlights(SearchFlighDto searchFlighDto)throws Exception
    {
        List<Routes>routes=routeRepository.findRoutesByFromCityAndToCityAndModeOfTransport(searchFlighDto.getFromCity(),searchFlighDto.getToCity(), ModeOfTransport.FLIGHT);
            if(routes.isEmpty())throw new RouteNotFoundException("There are no routes Present From"+searchFlighDto.getFromCity()+" to " +searchFlighDto.getToCity());

            //else I'll Iterate over the routes..
        List<FlighResultDto>flighResult=new ArrayList<>();

        for(Routes route:routes)
        {
          List<Transport>transportList=route.getTransportList();
          for(Transport transport:transportList)
          {
              if(searchFlighDto.getJourneyDate().equals(transport.getJourneyDate()))
              {
                  log.info("There is Flight on Date:"+transport.getJourneyDate()+" with StopsInBetweenn{}"+route.getListOfStopsInBetween());

                  FlighResultDto flighResultDto=TransportTransformer.TransportToFlightResultDto(transport);
                  flighResultDto.setListOfStopsInBetween(route.getListOfStopsInBetween());

                  flighResult.add(flighResultDto);
              }
          }
        }
     if(flighResult.isEmpty())throw new FlightNotFoundException("Flights are not Available on date:"+searchFlighDto.getJourneyDate());
        return flighResult;
    }
}
