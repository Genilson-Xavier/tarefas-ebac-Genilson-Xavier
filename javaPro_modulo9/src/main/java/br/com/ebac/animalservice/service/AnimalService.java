package br.com.ebac.animalservice.service;

import br.com.ebac.animalservice.entidades.Animal;
import br.com.ebac.animalservice.model.Porte;
import br.com.ebac.animalservice.model.RacaCaes;
import br.com.ebac.animalservice.model.RacaGatos;
import br.com.ebac.animalservice.model.TipoAnimal;
import br.com.ebac.animalservice.repositorios.AnimalRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;

@Service
public class AnimalService {
    private AnimalRepository repository;

    private AnimalService(AnimalRepository repository){
        this.repository = repository;
    }

    public Animal create(Animal animal) throws Exception{
        return repository.save(parseAnimal(animal));
    }

    private Animal parseAnimal(Animal animal) throws Exception{
        boolean resposta = contemTipoAnimal(animal.getTipoAnimal().toString());
        boolean existeRaca;
        if(resposta){
            animal.setTipoAnimal(animal.getTipoAnimal().toString().toUpperCase());
            // Checa raça do animal
            existeRaca = verificaRaca(animal.getRaca().toString());
            if(!existeRaca){ throw new Exception(" Não existe a raça informada ");}
            // Poderia colocar o tipo de animal pela raça mas não fiz por causa do SND que me forçaria a deixar sem valor no tipo de animal
            animal.setPorte(animal.getPorte().toString().toUpperCase());
        }else{
            throw new Exception(" Animal não reconhecido ");
        }
        return animal;
    }

    private boolean contemTipoAnimal(String tipoAnimal){
        return  Arrays.stream(TipoAnimal.values()).anyMatch(e -> e.toString().equalsIgnoreCase(tipoAnimal.toUpperCase()));
    }

    private boolean verificaRaca(String raca){
        boolean resposta = false;
        resposta = Arrays.stream(RacaCaes.values()).anyMatch(e -> e.toString().equalsIgnoreCase(raca.toUpperCase()));
        if(!resposta){
            resposta = Arrays.stream(RacaGatos.values()).anyMatch(e -> e.toString().equalsIgnoreCase(raca.toUpperCase()));
        }
        return resposta;
    }
}
