package com.example.Make_Your_Trip.Repositories;

import com.example.Make_Your_Trip.Enums.City;
import com.example.Make_Your_Trip.Enums.ModeOfTransport;
import com.example.Make_Your_Trip.Models.Routes;
import com.example.Make_Your_Trip.Models.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.util.RouteMatcher;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Routes,Integer>
{

    //@Query(value = "select *  from routes  where fromCity=:fromCity and toCity=:toCity and mode=:mode",nativeQuery = true)
    List<Routes> findRoutesByFromCityAndToCityAndModeOfTransport(@Param("fromCity") City fromCity, @Param("toCity") City toCity, @Param("mode") ModeOfTransport modeOfTransport);

}
