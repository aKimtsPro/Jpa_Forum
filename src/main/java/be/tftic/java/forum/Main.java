package be.tftic.java.forum;

import be.tftic.java.forum.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("forum_db")) {

            EntityManager em = emf.createEntityManager();

            // Read
            // GET ONE
            User user = em.find(User.class, 1);
            em.detach(user);

            List<User> users = em.createQuery( // JPQL - HQL
                    "SELECT u FROM User u WHERE u.address.number > 10",
                    User.class
            ).getResultList();

            // MODIFY
            User user1 = new User();
            user1.setUsername("newUser2");
            user1.setPassword("firstPass");

            // INSERT
            em.getTransaction().begin();
            em.persist(user1);
            em.getTransaction().commit();
            // UPDATE
            em.getTransaction().begin();
            user1.setPassword("new pass");
            em.getTransaction().commit();
            // DELETE
            em.getTransaction().begin();
            em.remove(user1);
            em.getTransaction().commit();

            em.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            System.out.println("EMF ended");
        }

    }
}
