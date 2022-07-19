// package com.telecom.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.telecom.model.User;
// import com.telecom.model.Response;
// import com.telecom.service.implementation.UserServiceImpl;

// import java.util.*;

// import javax.validation.Valid;

// import static org.springframework.http.HttpStatus.OK;
// import static org.springframework.http.HttpStatus.CREATED;
// import static java.time.LocalDateTime.now;

// @RestController
// @RequestMapping("/users")
// @CrossOrigin(origins = "http://localhost:4200")
// public class UserController {

// @Autowired
// private UserServiceImpl userService;

// @GetMapping("/list")
// public ResponseEntity<Response> getUsers() {

// return ResponseEntity.ok(
// Response.builder()
// .timeStamp(now())
// .data(new HashMap<String, List<?>>() {
// {
// put("Users", userService.list(30));
// }
// })
// .message("Users Retrieved")
// .status(OK)
// .statusCode(OK.value())
// .build());

// }

// @PostMapping("/save")
// // Use valid to check if the new user is up to validation standards (from
// // model)
// public ResponseEntity<Response> saveUsers(@RequestBody @Valid User user) {

// return ResponseEntity.ok(
// Response.builder()
// .timeStamp(now())
// .data(new HashMap<String, User>() {
// {
// put("User", userService.create(user));
// }
// })
// .message("User Created")
// .status(CREATED)
// .statusCode(CREATED.value())
// .build());
// }

// @GetMapping("/id/{id}")
// public ResponseEntity<Response> getUser(@PathVariable("id") Long id) {

// return ResponseEntity.ok(
// Response.builder()
// .timeStamp(now())
// .data(new HashMap<String, User>() {
// {
// put("User", userService.get(id));
// }
// })
// .message("User Retrieved")
// .status(OK)
// .statusCode(OK.value())
// .build());
// }

// @DeleteMapping("/delete/{id}")
// public ResponseEntity<Response> deleteUser(@PathVariable("id") Long id) {

// return ResponseEntity.ok(
// Response.builder()
// .timeStamp(now())
// .data(new HashMap<String, Boolean>() {
// {
// put("Deleted", userService.delete(id));
// }
// })
// .message("User Deleted")
// .status(OK)
// .statusCode(OK.value())
// .build());
// }

// @GetMapping("/email/{email}")
// public ResponseEntity<Response> getEmail(@PathVariable("email") String email)
// {

// return ResponseEntity.ok(
// Response.builder()
// .timeStamp(now())
// .data(new HashMap<String, User>() {
// {
// put("User", userService.findByEmail(email));
// }
// })
// .message("Email Retrieved")
// .status(OK)
// .statusCode(OK.value())
// .build());
// }

// }
