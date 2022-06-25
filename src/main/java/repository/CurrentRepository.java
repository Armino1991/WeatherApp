package repository;

import model.Current;

import javax.persistence.*;
import java.util.Scanner;

public class CurrentRepository {

    public Current saveCurrent(Current current) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WeatherEM");

        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(current);

        entityManager.getTransaction().commit();

        return current;
    }

    public Current getCurrentByLocation(){
        System.out.println("----PLEASE GIVE THE LOCATION :----");
        Scanner scanner = new Scanner(System.in);
        String city = scanner.next();

        System.out.println("----PLEASE GIVE THE DATE ON FORMAT yyyy-mm-dd :----");
        Scanner scanner1 = new Scanner(System.in);
        String date = scanner1.next();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WeatherEM");

        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("select c from Current c where c.date = '"+date+"' and c.city= '"+city+"'",Current.class);

        Current current = (Current) query.getSingleResult();
        entityManager.getTransaction().commit();

        return current;
    }
}
