package com.artemnizhnyk.restjakartapractice.repository.impl;

import com.artemnizhnyk.restjakartapractice.domain.model.User;
import com.artemnizhnyk.restjakartapractice.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class UserRepositoryImpl implements UserRepository {

//    @PersistenceContext
//    EntityManager entityManager;

    @Override
    public User getUserById(Long id) {
        EntityManagerFactory entityManagerFactory = getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        User user = entityManager.find(User.class, id);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return user;
    }

    @Override
    public User createUser(User transientUser) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("default");
    }

}