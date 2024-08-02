package com.artemnizhnyk.restjakartapractice.repository.impl;

import com.artemnizhnyk.restjakartapractice.domain.model.User;
import com.artemnizhnyk.restjakartapractice.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@ApplicationScoped
public class UserRepositoryImpl implements UserRepository {

//    @PersistenceContext
//    EntityManager entityManager;

    @Override
    public User getUserById(final Long id) {

        User user;
        try (EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");;
             EntityManager entityManager = entityManagerFactory.createEntityManager()
        ) {
            entityManager.getTransaction().begin();

            user = entityManager.find(User.class, id);

            entityManager.getTransaction().commit();
            return user;
        }
    }

    @Override
    public User createUser(final User transientUser) {
        try (EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");;
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
    public User updateUser(final User user) {
        try (EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");;
             EntityManager entityManager = entityManagerFactory.createEntityManager()
        ) {
            entityManager.getTransaction().begin();

            User updatedUser = entityManager.merge(user);

            entityManager.getTransaction().commit();
            return updatedUser;
        }
    }

    @Override
    public boolean deleteUser(final User user) {
        try (EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");;
             EntityManager entityManager = entityManagerFactory.createEntityManager()
        ) {
            entityManager.getTransaction().begin();

            User merged = entityManager.merge(user);
            entityManager.remove(merged);

            entityManager.getTransaction().commit();
            return true;
        }
    }

}