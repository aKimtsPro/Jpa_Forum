package be.tftic.java.forum;

import be.tftic.java.forum.entity.Topic;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        Topic topic = new Topic();
        long id = topic.getId();


        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("forum_db")) {
            System.out.println("EMF started");
            // some code ...
        } catch (Exception ex) {
            // catch ex
        }
        finally {
            System.out.println("EMF ended");
        }

    }
}
