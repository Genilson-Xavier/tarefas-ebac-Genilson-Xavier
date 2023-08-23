package br.com.ebac.dao;

import br.com.ebac.domain.Carro;
import br.com.ebac.domain.Marca;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class MarcaDAO implements IMarcaDAO{

    @Override
    public Marca cadastrar(Marca marca) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Mod32");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(marca);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return marca;
    }

    @Override
    public Marca buscarPorCarro(Carro carro) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Mod32");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT m FROM MARCA m");
        sb.append("INNER JOIN CARRO c ON c = m.carro");
        sb.append("WHERE c = :carro");
        entityManager.getTransaction().begin();
        TypedQuery<Marca> query = entityManager.createQuery(sb.toString(), Marca.class);
        query.setParameter("carro", carro);
        Marca marca = query.getSingleResult();

        entityManager.close();
        entityManagerFactory.close();
        return marca;
    }
}
