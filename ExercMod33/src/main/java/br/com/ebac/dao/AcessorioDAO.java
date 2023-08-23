package br.com.ebac.dao;

import br.com.ebac.domain.Acessorio;
import br.com.ebac.domain.Carro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class AcessorioDAO implements IAcessorioDAO{
    @Override
    public Acessorio cadastrar(Acessorio acessorio) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Mod32");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(acessorio);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return acessorio;
    }

    @Override
    public List<Acessorio> listarPorCarro(Carro carro) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Mod32");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT a FROM Acessorio a ");
        sb.append("INNER JOIN Carro c ON c = a.carro ");
        sb.append("WHERE c = :carro");

        entityManager.getTransaction().begin();
        TypedQuery<Acessorio> query = entityManager.createQuery(sb.toString(), Acessorio.class);
        query.setParameter("carro", carro);
        List<Acessorio> acessorios = query.getResultList();
        entityManager.close();
        entityManagerFactory.close();

        return acessorios;
    }

}
