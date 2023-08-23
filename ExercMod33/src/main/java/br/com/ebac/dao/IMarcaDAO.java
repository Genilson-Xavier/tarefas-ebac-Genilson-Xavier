package br.com.ebac.dao;

import br.com.ebac.domain.Carro;
import br.com.ebac.domain.Marca;

public interface IMarcaDAO {
    public Marca cadastrar(Marca marca);

    public Marca buscarPorCarro(Carro carro);
}
