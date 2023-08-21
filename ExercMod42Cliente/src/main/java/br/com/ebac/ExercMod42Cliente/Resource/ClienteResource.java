package br.com.ebac.ExercMod42Cliente.Resource;

import br.com.ebac.ExercMod42Cliente.Model.Cliente;
import br.com.ebac.ExercMod42Cliente.Model.DTO.ClienteDTO;
import br.com.ebac.ExercMod42Cliente.Service.ClienteService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.websocket.server.PathParam;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class ClienteResource {
    @Autowired
    ClienteService clienteService;

    @GetMapping(path = "")
    public ResponseEntity<Optional<List<Cliente>>> todosClientes(){
        try {
            Optional<List<Cliente>> resposta = Optional.ofNullable(clienteService.findAll());
            if(resposta.isPresent()){
                return resposta.map(value -> ResponseEntity.ok().body(Optional.of(value))).orElseGet(()->ResponseEntity.noContent().build());
            }else{
                return ResponseEntity.noContent().build();
            }
        }catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Cliente>> porId(@PathVariable("id") Long id){
        try {
            Optional<Cliente> resposta = clienteService.findById(id);
            if(resposta.isPresent()){
                try {
                    Cliente cliente = new Cliente();
                    cliente.setId(resposta.get().getId());
                    cliente.setNome(resposta.get().getNome());
                    cliente.setCodigo(resposta.get().getCodigo());

                    return ResponseEntity.ok().body(Optional.of(cliente));
                }catch(EntityNotFoundException e){
                    return ResponseEntity.noContent().build();
                }
            }else{
                return ResponseEntity.noContent().build();
            }

        }catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path="")
    public ResponseEntity<Optional<Cliente>> salvar(@RequestBody ClienteDTO cliente){
        try {
            Optional<Cliente> resposta = Optional.ofNullable(clienteService.save(parseDTO(cliente)));
            return resposta.map(value -> ResponseEntity.ok().body(Optional.of(value))).orElseGet(() -> ResponseEntity.noContent().build());

        }catch(NoSuchElementException e){
            return ResponseEntity.badRequest().build();
        }
    }

    // TODO colocar o parse direto no objeto
    public Cliente parseDTO(ClienteDTO clienteDTO){
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setCodigo(clienteDTO.getCodigo());
        return cliente;
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Optional<Cliente>> atualizar(@PathVariable Long id,@RequestBody ClienteDTO clienteDTO){

        Optional<Cliente> resposta = clienteService.findById(id);
        if(resposta.isPresent()){
            try {
                resposta.get().setNome(clienteDTO.getNome());
                resposta.get().setCodigo(clienteDTO.getCodigo());
                Optional<Cliente> cliente = Optional.ofNullable(clienteService.save(resposta.get()));
                return cliente.map(value -> ResponseEntity.ok().body(Optional.of(value))).orElseGet(() -> ResponseEntity.noContent().build());
            }catch(EntityNotFoundException e){
                return ResponseEntity.noContent().build();
            }
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Optional<Cliente>> delete(@PathVariable Long id){
        try{
            clienteService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }
}
