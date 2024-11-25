package com.spring.jpa.services.impl;

import com.spring.jpa.entities.User;
import com.spring.jpa.repositories.UserRepository;
import com.spring.jpa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository mUserRepository;

    @Override
    public User save(User user) {
        return mUserRepository.save(user);
    }

    @Override
    public User get(String userId) {
        return mUserRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found!"));
    }

    @Override
    public List<User> getAll() {
        return mUserRepository.findAll();
    }

}
