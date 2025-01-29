import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Создаем и сохраняем
        Person person1 = new Person("Alice", 30);
        Person person2 = new Person("Bob", 25);

        em.persist(person1);
        em.persist(person2);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}

