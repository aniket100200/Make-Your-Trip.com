package com.example.Make_Your_Trip.RequestDtos.User;

import lombok.Data;

@Data
public class AddUserRequestDto
{
    private String name;
    private String emailId;
    private int age;
}
