import javax.persistence.*;
import java.util.List;

public class PersonRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");

    public void addPerson(PersonEntity person) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        em.close();
    }

    public void updatePerson(PersonEntity person) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
        em.close();
    }

    public void deletePerson(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        PersonEntity person = em.find(PersonEntity.class, id);
        if (person != null) {
            em.remove(person);
        }
        em.getTransaction().commit();
        em.close();
    }

    public List<PersonEntity> getAllPersons() {
        EntityManager em = emf.createEntityManager();
        List<PersonEntity> persons = em.createQuery("SELECT p FROM PersonEntity p", PersonEntity.class).getResultList();
        em.close();
        return persons;
    }
}

