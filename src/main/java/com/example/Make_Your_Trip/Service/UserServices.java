package com.example.Make_Your_Trip.Service;

import com.example.Make_Your_Trip.Models.User;
import com.example.Make_Your_Trip.Repositories.UserRepository;
import com.example.Make_Your_Trip.RequestDtos.User.AddUserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices
{
    @Autowired
    private UserRepository userRepository;

    public void addUser(AddUserRequestDto addUserRequestDto)
    {
        User user=User.builder()
                .age(addUserRequestDto.getAge())
                .name(addUserRequestDto.getName())
                .emailId(addUserRequestDto.getEmailId())
                .build();

        userRepository.save(user);
    }
}
