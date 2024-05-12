package com.test.gestionticket.service;

import com.test.gestionticket.model.Users;

import java.util.List;

public interface UserService {
    Users getUserById(Long id);
    List<Users> getAllUsers();
    Users createUser(Users user);
    Users updateUser(Long id, Users user);
    void deleteUser(Long id);
    Users getUserByUsername(String name);
}
