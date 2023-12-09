package com.jeferson.cadastro.controller;

import com.jeferson.cadastro.entities.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping(value = "/search", produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Get user by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List users", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = User.class)))
        }),
        @ApiResponse(responseCode = "400", description = "User not found", content = @Content)
    })
    public ResponseEntity findUserById(@RequestHeader HttpHeaders headers, @RequestParam(required = true) String userId) {
        return new ResponseEntity<>("Hello world" + userId, HttpStatus.OK);
    }

}
