package com.example.Make_Your_Trip.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Booking
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;
    private String seatNo; //comma separated values... 1A,2A, 3B..
    private LocalDate journeyDate;
    private Integer transportId;


    @ManyToOne
    @JoinColumn
    private Transport transport;

    @ManyToOne
    @JoinColumn
    private User user;


    @OneToOne(mappedBy = "booking",cascade = CascadeType.ALL)
    private Ticket ticket;


}
