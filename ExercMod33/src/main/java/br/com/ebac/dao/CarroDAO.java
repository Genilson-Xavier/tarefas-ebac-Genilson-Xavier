package br.com.ebac.dao;

import br.com.ebac.domain.Carro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class CarroDAO implements ICarroDAO{
    @Override
    public Carro cadastrar(Carro carro) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Mod32");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(carro);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return carro;
    }

    @Override
    public Carro buscar(Long id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Mod32");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT c FROM Carro c ");
        sb.append("WHERE c.id = :id");
        entityManager.getTransaction().begin();
        TypedQuery<Carro> query = entityManager.createQuery(sb.toString(), Carro.class);
        query.setParameter("id",id);
        Carro retorno = query.getSingleResult();
        entityManager.close();
        entityManagerFactory.close();
        return retorno;
    }

}
