package org.grupouno.Parqueo_Is4Tech.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DemoControlleer {

    @PostMapping("/demo")
    public String demo() {
        return "Hello World";
    }
}
