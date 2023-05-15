package br.com.ebac.usuario.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {

    @GetMapping("/ola")
    public String ola(){
        return "ola testando zookeeper";
    }

}
