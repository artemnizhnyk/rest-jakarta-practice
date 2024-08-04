package com.artemnizhnyk.restjakartapractice.repository.impl;

import com.artemnizhnyk.restjakartapractice.domain.model.User;
import com.artemnizhnyk.restjakartapractice.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
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

    @Transactional
    @Override
    public User updateUser(final User user) {
        return entityManager.merge(user);
    }

    @Transactional
    @Override
    public boolean deleteUser(final User user) {
            User mergedUser = entityManager.merge(user);
            entityManager.remove(mergedUser);
            return true;
    }
}