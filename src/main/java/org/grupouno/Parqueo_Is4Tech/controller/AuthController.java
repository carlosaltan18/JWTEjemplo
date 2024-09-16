package org.grupouno.Parqueo_Is4Tech.controller;
import org.grupouno.Parqueo_Is4Tech.dto.LoginResponse;
import org.grupouno.Parqueo_Is4Tech.dto.LoginUserDto;
import org.grupouno.Parqueo_Is4Tech.dto.RegisterUserDto;
import org.grupouno.Parqueo_Is4Tech.model.User;
import org.grupouno.Parqueo_Is4Tech.security.AuthenticationService;
import org.grupouno.Parqueo_Is4Tech.security.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;
    public AuthController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        // Generar el token JWT
        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }

}
