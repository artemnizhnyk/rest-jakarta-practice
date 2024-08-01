package com.artemnizhnyk.restjakartapractice.repository.impl;

import com.artemnizhnyk.restjakartapractice.domain.model.User;
import com.artemnizhnyk.restjakartapractice.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Optional;

@ApplicationScoped
public class UserRepositoryImpl implements UserRepository {

//    @PersistenceContext
//    EntityManager entityManager;

    @Override
    public User getUserById(Long id) {

        User user;
        try (EntityManagerFactory entityManagerFactory = getEntityManagerFactory();
             EntityManager entityManager = entityManagerFactory.createEntityManager()
        ) {
            entityManager.getTransaction().begin();

            user = entityManager.find(User.class, id);

            entityManager.getTransaction().commit();
            return user;
        }
    }

    @Override
    public User createUser(User transientUser) {
        try (EntityManagerFactory entityManagerFactory = getEntityManagerFactory();
             EntityManager entityManager = entityManagerFactory.createEntityManager()
        ) {
            entityManager.getTransaction().begin();

            entityManager.persist(transientUser);
            User user = entityManager.find(User.class, transientUser.getId());

            entityManager.getTransaction().commit();
            return user;
        }
    }

    @Override
    public User updateUser(User user) {
        try (EntityManagerFactory entityManagerFactory = getEntityManagerFactory();
             EntityManager entityManager = entityManagerFactory.createEntityManager()
        ) {
            entityManager.getTransaction().begin();

            Optional.ofNullable(entityManager.find(User.class, user.getId())).orElseThrow(RuntimeException::new);

            User updatedUser = entityManager.merge(user);

            entityManager.getTransaction().commit();
            return updatedUser;
        }
    }

    @Override
    public boolean deleteByUserId(Long id) {
        return false;
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("default");
    }

}