package com.example.Make_Your_Trip.Controllers;

import com.example.Make_Your_Trip.RequestDtos.SeatDto.SeatRequestDto;
import com.example.Make_Your_Trip.Service.SeatServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
