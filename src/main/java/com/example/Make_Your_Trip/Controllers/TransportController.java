package com.example.Make_Your_Trip.Controllers;

import com.example.Make_Your_Trip.RequestDtos.AddTransportDto;
import com.example.Make_Your_Trip.RequestDtos.SearchFlighDto;
import com.example.Make_Your_Trip.ResponceDtos.FlighResultDto;
import com.example.Make_Your_Trip.Service.TransportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transport")
@Slf4j
public class TransportController
{
    @Autowired
    private TransportService transportService;
    @PostMapping("/add")
    public ResponseEntity addTransport(@RequestBody AddTransportDto addTransportDto){
        try
        {
            String responce=transportService.addTransport(addTransportDto);
            log.info("Transport added Successfully",responce);
            return new ResponseEntity(responce,HttpStatus.CREATED);

        }catch (Exception e)
        {
            log.error("Unable to add Your Transport",e.getMessage());
          return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/search-flights")
    public ResponseEntity searchFlights(@RequestBody SearchFlighDto flighDto)
    {
        try
        {
            List<FlighResultDto>resultDtos=transportService.searchFlights(flighDto);
            log.info("You have the List Of Flights");
            return new ResponseEntity<>(resultDtos,HttpStatus.ACCEPTED);
        }
        catch (Exception e)
        {
            log.error("OOPs!! Something Went wrong"+e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
