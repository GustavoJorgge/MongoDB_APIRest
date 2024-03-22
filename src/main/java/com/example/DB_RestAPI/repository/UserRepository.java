package com.example.DB_RestAPI.repository;

import com.example.DB_RestAPI.model.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {
      List<UserEntity> findByNome(String nome);
    List<UserEntity> findByEmail(String email);
    
    List<UserEntity> findByNomeAndEmailAllIgnoreCase(String nome, String email);

    List<UserEntity> findByNomeStartingWithIgnoreCase(String prefixo);

    List<UserEntity> findByNomeContainingIgnoreCase(String contem);

    // Métodos de CRUD já estão disponíveis
}
