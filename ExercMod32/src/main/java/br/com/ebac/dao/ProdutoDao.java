package br.com.ebac.dao;

import br.com.ebac.domain.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProdutoDao implements IProdutoDao{
    @Override
    public Produto cadastrar(Produto produto) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Mod32");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return produto;
    }
}
