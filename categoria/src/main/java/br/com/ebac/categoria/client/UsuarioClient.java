package br.com.ebac.categoria.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Configuration
@EnableFeignClients
@EnableDiscoveryClient
public class UsuarioClient {
    @Autowired
    private Cliente cliente;

    @FeignClient(name = "usuario")
    interface Cliente{
        @RequestMapping(path = "/usuario/nome", method = RequestMethod.GET)
        @ResponseBody
        Object retornaPorNome(@RequestParam("nome") String nome);
    }

    public Object usuarioPorNome(String nome){
        return cliente.retornaPorNome(nome);
    }
}
