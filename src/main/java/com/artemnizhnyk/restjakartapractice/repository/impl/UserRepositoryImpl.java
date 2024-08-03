package com.artemnizhnyk.restjakartapractice.repository.impl;

import com.artemnizhnyk.restjakartapractice.domain.model.User;
import com.artemnizhnyk.restjakartapractice.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Named
@ApplicationScoped
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserById(final Long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public User createUser(User transientUser) {

            entityManager.persist(transientUser);
            return transientUser;
    }

    @Override
    public User updateUser(final User user) {
        try (EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
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
        try (EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
             EntityManager entityManager = entityManagerFactory.createEntityManager()
        ) {
            entityManager.getTransaction().begin();

            User mergedUser = entityManager.merge(user);
            entityManager.remove(mergedUser);

            entityManager.getTransaction().commit();
            return true;
        }
    }

}