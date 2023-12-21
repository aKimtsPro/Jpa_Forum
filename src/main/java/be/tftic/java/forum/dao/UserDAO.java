package be.tftic.java.forum.dao;

import be.tftic.java.forum.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;
import java.util.Optional;

public class UserDAO implements CrudDAO<User, Long> {

    private final EntityManagerFactory entityManagerFactory;

    public UserDAO(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void insert(User toInsert) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist( toInsert );
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public Optional<User> getOne(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void update(Long aLong, User entity) {

    }

    @Override
    public Optional<User> delete(Long aLong) {
        return Optional.empty();
    }
}
