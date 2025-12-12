package CMS.REST.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CMS.REST.payload.LoginDto;
import CMS.REST.payload.RegisterDto;
import CMS.REST.service.AuthService;

@RestController
@RequestMapping("/cms/auth")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService){
        this.authService= authService;
    }


    // Build login REST api
    @PostMapping(value= {"/login", "/signin"})
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        String response = authService.login(loginDto);
        return ResponseEntity.ok(response);
    }


    // Build Register REST api
    @PostMapping(value = {"/register","/signup"})
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
