package com.example.DB_RestAPI.service;

import com.example.DB_RestAPI.model.UserEntity;
import com.example.DB_RestAPI.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    public List<UserEntity> obterTodos() {
        return userRepository.findAll();
    }

    public UserEntity obterPorId(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserEntity inserir(UserEntity user) {
        return userRepository.save(user);
    }

    public UserEntity atualizar(String id, UserEntity newUser) {
        UserEntity existingUser = userRepository.findById(id).orElse(null);

        if(existingUser != null){
         existingUser.setNome(newUser.getNome());
         existingUser.setEmail(newUser.getEmail());
         return userRepository.save(existingUser);
        }else{
            return null;
        }
    }

    public void delete(String id){
        userRepository.deleteById(id);
    }
}
