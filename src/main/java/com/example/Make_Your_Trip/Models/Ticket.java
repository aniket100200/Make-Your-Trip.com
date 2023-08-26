package com.example.Make_Your_Trip.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ticket
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer ticketId;
    private String routeDetails;
   private LocalDate journeyDate;
   private LocalTime startTime;
   private Integer totalCostPaid;
   private String allSeatNos;

   //it's mapping with the Booking...
    @OneToOne
    @JoinColumn
    private  Booking booking;

}
