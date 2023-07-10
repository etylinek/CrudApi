package com.example.homeworkrestapi.controller;

import com.example.homeworkrestapi.model.UserModel;
import com.example.homeworkrestapi.service.UserService;
import com.example.homeworkrestapi.utils.errors.UserNotFoundExeption;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserModel>> getAllUsers() {
        try {
            List<UserModel> users = userService.getAllUsers();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable Long id) {
        Optional<UserModel> userOptional = userService.getUserById(id);
        return userOptional.map(ResponseEntity::ok)
                .orElseThrow(() -> new UserNotFoundExeption("User not Found"));

    }

    @PostMapping("/add")
    public ResponseEntity<UserModel> addUser(@RequestBody UserModel user) {
        try {
            return ResponseEntity.ok(userService.addUser(user));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<UserModel> updateUser(@RequestBody UserModel user) {
        try {
            return ResponseEntity.ok(userService.updateUser(user));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteUserById(@RequestParam Long id) {
        try {
            userService.deleteUserById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}
