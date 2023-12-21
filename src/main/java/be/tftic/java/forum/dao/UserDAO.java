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
        EntityManager em = entityManagerFactory.createEntityManager();
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public Optional<User> getOne(Long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        return Optional.ofNullable( em.find(User.class, id) );
    }

    @Override
    public void update(Long id, User entity) {
        EntityManager em = entityManagerFactory.createEntityManager();
        entity.setId(id);
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Optional<User> delete(Long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        User toDelete = em.find(User.class, id);
        if( toDelete != null ){
            em.getTransaction().begin();
            em.remove(toDelete);
            em.getTransaction().commit();
        }
        em.close();
        return Optional.ofNullable( toDelete );
    }
}
