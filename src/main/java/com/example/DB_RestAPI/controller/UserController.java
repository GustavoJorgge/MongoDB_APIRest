package com.example.DB_RestAPI.controller;

import com.example.DB_RestAPI.model.UserEntity;
import com.example.DB_RestAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntity> obterTodos(){
        return userService.obterTodos();
    }

    @GetMapping("/{id}")
    public UserEntity obterPorId(@PathVariable String id){
        return userService.obterPorId(id);
    }

    @PostMapping
    public UserEntity inserir(@RequestBody UserEntity user){
        return userService.inserir(user);
    }

    @PutMapping("/{id}")
    public UserEntity atualizar(@PathVariable String id, @RequestBody UserEntity user){
        return userService.atualizar(id,user);
    }

    @DeleteMapping
    public void deletar(@PathVariable String id){
        userService.delete(id);
    }
}