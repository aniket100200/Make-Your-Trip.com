package com.example.Make_Your_Trip.Service;

import com.example.Make_Your_Trip.CutomException.RoutesExceptions.SeatsAreNotAvailbleException;
import com.example.Make_Your_Trip.CutomException.RoutesExceptions.TransportNotFoundException;
import com.example.Make_Your_Trip.CutomException.RoutesExceptions.UserNotFoundException;
import com.example.Make_Your_Trip.Models.*;
import com.example.Make_Your_Trip.Repositories.BookingRepositories;
import com.example.Make_Your_Trip.Repositories.TransportRepository;
import com.example.Make_Your_Trip.Repositories.UserRepository;
import com.example.Make_Your_Trip.RequestDtos.Booking.BookingRequestDto;
import com.example.Make_Your_Trip.RequestDtos.SeatDto.AvailableSeatRequestDto;
import com.example.Make_Your_Trip.ResponceDtos.Seat.AvailableSeatsResponceDto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
@Slf4j
public class BookingServices
{
    @Autowired
    private BookingRepositories bookingRepositories;
    @Autowired
    private TransportRepository transportRepository;

    @Autowired
    private UserRepository userRepository;

    public List<AvailableSeatsResponceDto> searchAvailableSeats(AvailableSeatRequestDto availableSeatRequestDto)throws Exception
    {
        Optional<Transport> optional =transportRepository.findById(availableSeatRequestDto.getTransportId());
        if(!optional.isPresent())throw new TransportNotFoundException("Transport not Foud with transport Id"+availableSeatRequestDto.getTransportId());

        //find the Bookings for given date and transport id..
        List<Booking>bookingList=bookingRepositories.findBookingsByTransportIdAndJourneyDate(availableSeatRequestDto.getTransportId(),availableSeatRequestDto.getJourneyDate());

        if(bookingList.isEmpty())log.info("Woh!!! There are Bookings 100% Available");

        //we have already booked Seats...

        Set<String>set=new HashSet<>();
        for(Booking booking:bookingList)
        {
            String seatsNO= booking.getSeatNo();
            String[]seats=seatsNO.split(",");
            for(String seat:seats)set.add(seat);
        }

        //we have bookedSeat
        //TotalSeats-bookedSeats == AvailableSeats

        Transport transport=optional.get();

        //get the List of Seat

        List<Seat>seatList=transport.getSeatList();

        List<AvailableSeatsResponceDto>avaliableSeats=new ArrayList<>();

        for(Seat seat:seatList)
        {
            if(!set.contains(seat.getSeatNo()))
            {
                //if It is not booked means available.
                AvailableSeatsResponceDto dto= AvailableSeatsResponceDto.builder()
                        .seatNo(seat.getSeatNo())
                        .seatType(seat.getSeatType())
                        .seatPrice(seat.getPrice())
                        .build();

                    avaliableSeats.add(dto);
            }
        }

        if(avaliableSeats.isEmpty())throw new SeatsAreNotAvailbleException("All The Seats Are Booked");
        return  avaliableSeats;
    }


    public String makeBooking(BookingRequestDto bookingRequestDto)throws Exception
    {
        Booking booking=Booking.builder()
                .journeyDate(bookingRequestDto.getJourneyDate())
                .seatNo(bookingRequestDto.getSeatNo())
                .build();
        //let's find the user.

        Optional<User>optionalUser=userRepository.findById(bookingRequestDto.getUserId());
        if(!optionalUser.isPresent())throw new UserNotFoundException("There is no User with given user Id");


        User user=optionalUser.get();


        //let's find the Transport also..

        Optional<Transport>optionalTransport=transportRepository.findById(bookingRequestDto.getTransportId());

        if(!optionalTransport.isPresent())throw new TransportNotFoundException("Transport with given transportId not found!!!");

        Transport transport=optionalTransport.get();


        //set the FK variables..
        booking.setTransport(transport);
        booking.setUser(user);


        //creat Ticket Enity..

        Ticket ticketEntity=createTicketEntity(transport,bookingRequestDto);
    }

    private Ticket createTicketEntity(Transport transport, BookingRequestDto bookingRequestDto)
    {

    }

}
