package br.com.ebac.meme.client;

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
public class CategoriaMemeClient {
    @Autowired
    private CategoriaMeme categoria;

    @FeignClient(name = "categoria")
    interface CategoriaMeme{
        @RequestMapping(path = "/categoria/nome", method = RequestMethod.GET)
        @ResponseBody
        Object retornaPorNome(@RequestParam("nome") String nome);
    }

    public Object categoriaPorNome(String nome){ return categoria.retornaPorNome(nome); }
}
