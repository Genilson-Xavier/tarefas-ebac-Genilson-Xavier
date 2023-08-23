package br.com.ebac.dao;

import br.com.ebac.domain.Acessorio;
import br.com.ebac.domain.Carro;

import java.util.List;

public interface IAcessorioDAO {
    public Acessorio cadastrar(Acessorio acessorio);

    public List<Acessorio> listarPorCarro(Carro carro);
}
