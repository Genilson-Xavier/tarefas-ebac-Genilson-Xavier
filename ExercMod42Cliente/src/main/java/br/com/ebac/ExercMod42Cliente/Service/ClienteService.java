package br.com.ebac.ExercMod42Cliente.Service;

import br.com.ebac.ExercMod42Cliente.Model.Cliente;
import br.com.ebac.ExercMod42Cliente.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public void delete(Long id){
        clienteRepository.deleteById(id);
    }

    public Optional<Cliente> findById(Long id){
        return Optional.of(clienteRepository.getById(id));
    }



}
