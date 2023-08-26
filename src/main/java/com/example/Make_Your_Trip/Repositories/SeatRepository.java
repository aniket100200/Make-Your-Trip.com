package com.example.Make_Your_Trip.Repositories;

import com.example.Make_Your_Trip.Models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Integer>
{

}
