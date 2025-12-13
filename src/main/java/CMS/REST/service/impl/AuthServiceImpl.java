package CMS.REST.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import CMS.REST.entity.Role;
import CMS.REST.entity.User;
import CMS.REST.exception.CmsAPIException;
import CMS.REST.payload.LoginDto;
import CMS.REST.payload.RegisterDto;
import CMS.REST.repository.RoleRepository;
import CMS.REST.repository.UserRepository;
import CMS.REST.security.JwtTokenProvider;
import CMS.REST.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService  {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(AuthenticationManager authenticationManager,UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider){
        this.authenticationManager= authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider= jwtTokenProvider;
    }

    @Override
    public String login(LoginDto loginDto) {
        
        Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return token;
    }

    @Override
    public String register(RegisterDto registerDto) {
    

        // check for username exists in database
        if(userRepository.existsByUsername(registerDto.getUsername())){
            throw new CmsAPIException(HttpStatus.BAD_REQUEST, "Username already exists!.");
        }

        // check for email exists in database
        if(userRepository.existsByEmail(registerDto.getEmail())){
           throw new CmsAPIException(HttpStatus.BAD_REQUEST, "Email already exists!."); 
        }

        User user = new User();

        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles = new HashSet<>();

        Role userRole = roleRepository.findByName("ROLE_USER").get();
        roles.add(userRole);
        user.setRoles(roles);

        userRepository.save(user);

        return "User registered successfully!";
        
    }

   
    

}
