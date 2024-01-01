package com.jeferson.cadastro.controller;

import com.jeferson.cadastro.entities.User;
import com.jeferson.cadastro.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
@Tag(name = "User", description = "User data API")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/search", produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Get user by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List users", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = User.class)))
        }),
        @ApiResponse(responseCode = "400", description = "User not found", content = @Content)
    })
    public ResponseEntity<?> findUserById(@RequestHeader HttpHeaders headers, @RequestParam(required = true) Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping(value = "/findAll", produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Find all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List users", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = User.class)))
            }),
            @ApiResponse(responseCode = "404", description = "Users not found", content = @Content)
    })
    public ResponseEntity<?> findAll(@RequestHeader HttpHeaders headers) {
        return userService.findAllUsers();
    }

    @PostMapping(value = "/save", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Save")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Save a new user", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = User.class)))}),
        @ApiResponse(responseCode = "404", description = "Save user error", content = @Content)
    })
    public ResponseEntity<?> createUser(@RequestHeader HttpHeaders headers, @RequestBody User user){
        return userService.createUser(user);
    }

    @DeleteMapping(value = "/remove", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Remove")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Remove user by id", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = User.class)))}),
        @ApiResponse(responseCode = "404", description = "Error remove user", content = @Content)
    })
    public ResponseEntity<?> removeUserById(@RequestHeader HttpHeaders headers, @RequestParam(required = true) Long userId){
        return userService.removeUser(userId);
    }
}
