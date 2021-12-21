package com.MiaStore.Backend.controller;

import com.MiaStore.Backend.Model.User;
import com.MiaStore.Backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("/all")
    public List<User> getAll(){
        return service.getAll();
    }

    @GetMapping("/birthday/{month}")
    public List<User> findByBirthdayMonth(@PathVariable("month") String month){
        return service.findByBirthdayMonth(month);
    }


    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") int id){
        return service.getUser(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User registrar(@RequestBody User user){
        return service.registrar(user);
    }

    @GetMapping("/{email}/{password}")
    public boolean autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password){
        return service.Autenticar(email, password);
    }

    @GetMapping("/emailexist/{email}")
    public boolean existeEmail(@PathVariable("email") String email){
        return  service.ExistenciaEmail(email);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return service.update(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return service.delete(id);
    }
}
