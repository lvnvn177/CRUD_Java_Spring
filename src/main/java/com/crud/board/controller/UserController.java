package com.crud.board.controller;

import com.crud.board.domain.User;
import com.crud.board.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// (1) REST API 컨트롤러 선언 
@RestController
@RequestMapping("/users")
public class UserController {
    
    private final UserService userService;

    // (2) 생성자 주입
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // (3) Create
    // POST /users
    @PostMapping
    public User createUser(@RequestBody User userRequest) {
        // JSON으로 { "name": "...", "email": "..."} 데이터를 받음 
        return userService.createUser(userRequest.getName(), userRequest.getEmail());
    }

    // (4) Read - 전체 조회
    // GET /users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // (5) Read - 단건 조회
    // GET /users/{id}
    @GetMapping("/id")
    public User getUserById(@PathVariable Long id) {
        return userService.getUser(id);
    }

    // (6) Update
    // PUT /user/{id}
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userRequest) {
        return userService.updateUser(id, userRequest.getName(), userRequest.getEmail());
    }

    // (7) Delete
    // DELETE /users/{id}
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}