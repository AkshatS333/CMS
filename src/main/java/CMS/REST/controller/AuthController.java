package CMS.REST.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CMS.REST.payload.JWTAuthReponse;
import CMS.REST.payload.LoginDto;
import CMS.REST.payload.RegisterDto;
import CMS.REST.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/cms/auth")
@Tag(
    name = "CRUD REST APIs for Authorisation Resource"
)
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService){
        this.authService= authService;
    }


    // Build login REST api
    @Operation(
        summary = "User Login",
        description = "Authenticates a user using email/username and password and returns a JWT access token upon successful authentication."
    )
    
    @ApiResponse(responseCode = "200", description = "Login successful")

    @PostMapping(value= {"/login", "/signin"})
    public ResponseEntity<JWTAuthReponse> login(@RequestBody LoginDto loginDto){
        String token = authService.login(loginDto);

        JWTAuthReponse jwtAuthReponse = new JWTAuthReponse();

        jwtAuthReponse.setAccessToken(token);
        return ResponseEntity.ok(jwtAuthReponse); 
    }


    // Build Register REST api
    @Operation(
        summary = "User Registration",
        description = "Registers a new user using the provided details such as email, username, and password."
    )

    @ApiResponse(
        responseCode = "201",
        description = "User registered successfully"
    )
    
    @PostMapping(value = {"/register","/signup"})
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
