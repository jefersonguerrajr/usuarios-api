package com.jeferson.cadastro.service;

import com.jeferson.cadastro.entities.User;
import com.jeferson.cadastro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> createUser(User user) {
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> getUserById(Long id) {
        Optional<User> user;
        user = userRepository.findById(id);

        if(user.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(user.get());
    }

    public ResponseEntity<?> findAllUsers(){
        List<User> user;
        user = (List<User>) userRepository.findAll();

        if(user.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(user);
    }


    public ResponseEntity<?> removeUser(Long userId){
        userRepository.deleteById(userId);
        return ResponseEntity.ok().build();
    }

}
