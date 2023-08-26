package com.example.Make_Your_Trip.CutomException.RoutesExceptions;

public class FlightNotFoundException extends Exception{
    public FlightNotFoundException(String message) {
        super(message);
    }
}
