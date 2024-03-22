package com.example.DB_RestAPI.controller;

import com.example.DB_RestAPI.model.UserEntity;
import com.example.DB_RestAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

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

    @GetMapping("/buscaPorNome/{nome}")
    public List<UserEntity> buscarPorNome(@PathVariable String nome){
        return userService.buscarPorNome(nome);
    }

    @GetMapping("/buscaPorEmail/{email}")
    public List<UserEntity> buscarPorEmail(@PathVariable String email){
        return userService.buscarPorEmail(email);
    }

    @GetMapping("/buscaPorNomeEEmail")
    public List<UserEntity> buscaPorNomeEEmail(@RequestParam("nome") String nome, @RequestParam("email") String email){
        return userService.buscaPorNomeEEmail(nome,email);
    }

    @GetMapping("/buscaPorNomeQueComecaCom/{prefixo}")
    public List<UserEntity> buscaPorNomeQueComecaCom(@PathVariable String prefixo){
        return userService.buscaPorNomeQueComecaCom(prefixo);
    }

    @GetMapping("/buscaPorNomeQueContem/{contem}")
    public List<UserEntity> buscaUsuariosPorNomeQueContem(@PathVariable String contem) {
        return userService.buscaPorNomeQueContem(contem);
    }
}
