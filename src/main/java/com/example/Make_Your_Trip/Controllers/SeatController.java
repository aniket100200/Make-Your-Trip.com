package com.example.Make_Your_Trip.Controllers;

import com.example.Make_Your_Trip.Models.Seat;
import com.example.Make_Your_Trip.RequestDtos.SeatDto.SeatRequestDto;
import com.example.Make_Your_Trip.Service.SeatServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("seats")
@Slf4j
public class SeatController
{
    @Autowired
    private SeatServices seatServices;

    @PostMapping("/add")
    public ResponseEntity<String> addSeat(@RequestBody SeatRequestDto seatRequestDto){
        try{
            String response = seatServices.addSeat(seatRequestDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e){
            log.error("Oops!! Something Went Wrong",e.getMessage());
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-Seats-byTransportId")
    public ResponseEntity getSeatsByTransportId(@RequestParam("tId") Integer transportId)
    {
       try{
            List<Seat> seatList = seatServices.getSeatListByTransportId(transportId);
            return new ResponseEntity<>(seatList, HttpStatus.ACCEPTED);
        }
       catch (Exception e){
           log.error("Unable Find the Seats",e.getMessage());
           return    new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
    }


}
