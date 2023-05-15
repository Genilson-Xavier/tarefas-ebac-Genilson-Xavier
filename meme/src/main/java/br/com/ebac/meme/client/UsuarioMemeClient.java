package br.com.ebac.meme.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

@Configuration
@EnableFeignClients
@EnableDiscoveryClient
public class UsuarioMemeClient {
    @Autowired
    private ClienteMeme cliente;

    @FeignClient(name = "usuario")
    interface ClienteMeme{
        @RequestMapping(path = "/usuario/nome", method = RequestMethod.GET)
        @ResponseBody
        Object retornaPorNome(@RequestParam("nome") String nome);
    }

    public Object usuarioPorNome(String nome){
        return cliente.retornaPorNome(nome);
    }
}
