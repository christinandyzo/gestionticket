package com.test.gestionticket.service;

import com.test.gestionticket.exceptions.UserNotFoundException;
import com.test.gestionticket.model.Users;
import com.test.gestionticket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    // Récupérer un utilisateur par son id
    public Users getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    // Récupérer tous les utilisateurs
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    // Créer un utilisateur
    public Users createUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    // Modifier un utilisateur
    public Users updateUser(Long id, Users user) {
        Users existingUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return userRepository.save(existingUser);
    }

    @Override
    // Supprimer un utilisateur
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    // Récupérer un utilisateur par son nom
    public Users getUserByUsername(String name) {
        return userRepository.findByUsername(name);
    }
}
