package CMS.REST.service;

import CMS.REST.payload.LoginDto;
import CMS.REST.payload.RegisterDto;

public interface AuthService {

    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);

}
