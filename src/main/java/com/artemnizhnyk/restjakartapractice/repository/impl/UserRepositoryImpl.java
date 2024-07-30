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

    @PersistenceContext(name = "task-list")
    private EntityManager entityManager;

    @Override
    public User getUserById(Long id) {
//        EntityManagerFactory entityManagerFactory = getEntityManagerFactory();
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//        entityManager.getTransaction().begin();
//
        User user = entityManager.find(User.class, id);
//
//        entityManager.getTransaction().commit();
//        entityManager.close();
//        entityManagerFactory.close();
        return user;
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("default");
    }

}