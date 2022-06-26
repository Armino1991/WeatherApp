package repository;

import model.Current;

import javax.persistence.*;

public class CurrentRepository {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("WeatherEM");

    public Current saveCurrent(Current current) {

        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(current);

        entityManager.getTransaction().commit();

        return current;
    }

    public Current getCurrentByLocation(String city, String date){

        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("select c from Current c where c.date = '"+date+"' and c.city= '"+city+"'",Current.class);

        Current current = (Current) query.getSingleResult();
        entityManager.getTransaction().commit();

        return current;
    }
}
