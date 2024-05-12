package com.test.gestionticket.repository;

import com.test.gestionticket.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findById(int id);
    List<Users> findAll();
    Users deleteById(int id);
    Users save(Users users);
    Users findByUsername(String username);
    Users findByEmail(String email);

}
