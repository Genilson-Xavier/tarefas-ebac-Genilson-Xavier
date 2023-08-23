package br.com.ebac.dao;

import br.com.ebac.domain.Carro;

public interface ICarroDAO {
    public Carro cadastrar(Carro carro);

    public Carro buscar(Long id);
}
