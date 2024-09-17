package org.grupouno.Parqueo_Is4Tech.controller;


import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prueba")
@RequiredArgsConstructor
public class DemoControlleer {

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/demo")
    public String demo() {
        System.out.println("Prueba");
        return "Hello World";
    }
}
