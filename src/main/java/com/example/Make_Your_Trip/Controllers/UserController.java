package com.example.Make_Your_Trip.Controllers;

import com.example.Make_Your_Trip.RequestDtos.User.AddUserRequestDto;
import com.example.Make_Your_Trip.Service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserServices userServices;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(AddUserRequestDto addUserRequestDto)
    {
        userServices.addUser(addUserRequestDto);

        return new ResponseEntity<>("User has been added to the Database Successfully", HttpStatus.CREATED);
    }
}
