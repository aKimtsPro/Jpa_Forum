package be.tftic.java.forum;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

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
