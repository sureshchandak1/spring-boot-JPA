package com.spring.jpa.services;

import com.spring.jpa.entities.User;

import java.util.List;

public interface UserService {

    User save(User user);

    User get(String userId);

    List<User> getAll();
}
