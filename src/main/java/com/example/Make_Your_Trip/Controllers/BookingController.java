package com.example.Make_Your_Trip.Controllers;

import com.example.Make_Your_Trip.RequestDtos.Booking.BookingRequestDto;
import com.example.Make_Your_Trip.RequestDtos.SeatDto.AvailableSeatRequestDto;
import com.example.Make_Your_Trip.ResponceDtos.Seat.AvailableSeatsResponceDto;
import com.example.Make_Your_Trip.Service.BookingServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
@Slf4j
public class BookingController
{
    @Autowired
    private BookingServices bookingServices;


   @PutMapping("/search-available-flights")
    public ResponseEntity searchForFlights(@RequestBody AvailableSeatRequestDto availableSeatRequestDto)
   {
       try
       {
           List<AvailableSeatsResponceDto>responceDto=bookingServices.searchAvailableSeats(availableSeatRequestDto);
           log.info("You have the List ");
           return new ResponseEntity(responceDto, HttpStatus.ACCEPTED);
       }catch (Exception e)
       {
            log.error("Unable To Find the Available Seats",e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
   }


   @PostMapping("/make-a-booking")
    public ResponseEntity makeBooking(@RequestBody BookingRequestDto bookingRequestDto)
   {
       try
       {
           String responce= bookingServices.makeBooking(bookingRequestDto);
           return new ResponseEntity(responce,HttpStatus.ACCEPTED);
       }
       catch (Exception e)
       {
            log.error("error Found ",e.getMessage());
       }
       return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
   }
}
