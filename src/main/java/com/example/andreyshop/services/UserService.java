package com.example.andreyshop.services;

import com.example.andreyshop.domein.entities.User;
import com.example.andreyshop.domein.models.UserModel;
import com.example.andreyshop.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }
    public UserModel findByUsername (String username){
        return  this.modelMapper.map(this.userRepository.findByUsername(username)
                .orElse(new User()), UserModel.class);
    }
}
