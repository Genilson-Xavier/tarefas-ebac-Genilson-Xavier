package br.com.ebac.animalservice.controllers;

import br.com.ebac.animalservice.entidades.Animal;
import br.com.ebac.animalservice.repositorios.AnimalRepository;
import br.com.ebac.animalservice.repositorios.FuncionariosDto;
import br.com.ebac.animalservice.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    private AnimalRepository repository;

    private AnimalService service;

    private AnimalController(AnimalRepository repository, AnimalService service){
        this.repository = repository;
        this.service = service;
    }

    @GetMapping
    private List<Animal> findAll(){
        return repository.findAll();
    }

    @PostMapping
    @ExceptionHandler(Exception.class)
    private Animal create(@RequestBody Animal animal) throws Exception{
        try {
            return service.create(animal);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new Animal();
        }
        //return repository.save(animal);
    }

    @GetMapping("/not-adoted")
    private List<Animal> findNotAdoted(){
        return repository.findNotAdoted();
    }

    @GetMapping("/adoted")
    private List<Animal> findAdoted(){
        return repository.findAdoted();
    }

    // Fixo 365 dias na query em Animal
    @GetMapping("/recebidos")
    private List<FuncionariosDto> findRecebidosPorFuncionarios(){
        return repository.findRecebidosPorFuncionarios();
    }
}
