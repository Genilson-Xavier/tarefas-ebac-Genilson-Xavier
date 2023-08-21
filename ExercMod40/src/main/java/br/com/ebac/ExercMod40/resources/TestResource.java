package br.com.ebac.ExercMod40.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResource {

    @GetMapping(path = "/test")
    public String teste(){
        return "Exercicio 40 EBAC";
    }
}
