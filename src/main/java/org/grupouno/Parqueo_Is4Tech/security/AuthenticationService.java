package org.grupouno.Parqueo_Is4Tech.security;

import org.grupouno.Parqueo_Is4Tech.model.Profile;
import org.grupouno.Parqueo_Is4Tech.model.User;
import org.grupouno.Parqueo_Is4Tech.dto.*;
import org.grupouno.Parqueo_Is4Tech.repository.UserRepository;
import org.grupouno.Parqueo_Is4Tech.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;

import java.util.Collections;
import java.util.List;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    private RoleService roleService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(RegisterUserDto input) {
        User user = new User();
        user.setName(input.getName());
        user.setSurname(input.getSurname());
        user.setAge(input.getAge());
        user.setDpi(input.getDpi());
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setStatus(true);
        return userRepository.save(user);
    }

    public User authenticate(LoginUserDto input) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );
        User user = (User) authentication.getPrincipal();
        Profile profile = user.getIdPorfile();

        List<GrantedAuthority> authorities;
        if (profile != null) {
            Long profileId = profile.getProfileId();
            authorities = roleService.getRolesByProfileId(profileId);
        } else {
            authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
        }
        user.setAuthorities(authorities);
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                user.getUsername(),
                user.getPassword(),
                authorities
        );
        SecurityContextHolder.getContext().setAuthentication(authToken);

        return user;
    }

}
