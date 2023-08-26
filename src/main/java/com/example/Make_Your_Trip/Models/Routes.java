package com.example.Make_Your_Trip.Models;

import com.example.Make_Your_Trip.Enums.City;
import com.example.Make_Your_Trip.Enums.ModeOfTransport;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder //this will help you for the Transformer things it also need AllArgsContrucotr;
@Table(name="routes")
@AllArgsConstructor
@NoArgsConstructor
public class Routes
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer routeId;
    @Enumerated(value = EnumType.STRING)
    private City fromCity;

    @Enumerated(value = EnumType.STRING)
    private City toCity;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "mode")
    private ModeOfTransport modeOfTransport;
    private String listOfStopsInBetween;

    @OneToMany(mappedBy = "route",cascade = CascadeType.ALL)
    List<Transport> transportList=new ArrayList<>();
}
