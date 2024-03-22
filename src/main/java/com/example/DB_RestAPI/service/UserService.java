package com.example.DB_RestAPI.service;

import com.example.DB_RestAPI.model.UserEntity;
import com.example.DB_RestAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
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

    public List<UserEntity> buscarPorNome(String nome) {
        return userRepository.findByNome(nome);
    }

    public List<UserEntity> buscarPorEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<UserEntity> buscaPorNomeEEmail(String nome, String email) {
        return userRepository.findByNomeAndEmailAllIgnoreCase(nome,email);
    }

    public List<UserEntity> buscaPorNomeQueComecaCom(String prefixo) {
        return userRepository.findByNomeStartingWithIgnoreCase(prefixo);
    }

    public List<UserEntity> buscaPorNomeQueContem(String contem) {
        return userRepository.findByNomeContainingIgnoreCase(contem);
    }
}
