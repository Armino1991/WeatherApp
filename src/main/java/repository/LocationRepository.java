package repository;

import model.Current;
import model.Location;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class LocationRepository {
    public Location saveLocation(Location location) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WeatherEM");

        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(location);

        entityManager.getTransaction().commit();

        return location;
    }

    public List<Location> getLocations(){
        EntityManagerFactory emf =Persistence.createEntityManagerFactory("WeatherEM");

        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        String query ="Select distinct s.name From Location s";
        Query query1 = (Query) entityManager.createQuery(query);
        List<Location> locations =query1.getResultList();

        entityManager.getTransaction().commit();

        return locations;
    }
}
