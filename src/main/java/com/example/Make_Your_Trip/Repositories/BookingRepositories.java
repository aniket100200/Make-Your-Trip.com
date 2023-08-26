package com.example.Make_Your_Trip.Repositories;

import com.example.Make_Your_Trip.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepositories extends JpaRepository<Booking,Integer>
{
    /*
    These are custom queryes .. one is in sql and other is in JPQL
     */
    //@Query(value = "select * from booking where transportId=:transportId and journeyDate=:journeyDate",nativeQuery = true)

    // @Query("select b from booking b where transportId=:transportId and journeyDate=:journeyDate")
    List<Booking>findBookingsByTransportIdAndJourneyDate(Integer transportId, LocalDate journeyDate);
}
