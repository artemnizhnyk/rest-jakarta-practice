package com.artemnizhnyk.restjakartapractice.repository.impl;

import com.artemnizhnyk.restjakartapractice.domain.model.user.User;
import com.artemnizhnyk.restjakartapractice.repository.UserRepository;
import jakarta.ejb.Stateful;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

//@Named
//@ApplicationScoped
@Stateful
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserById(final Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getUserByUsername(final String username) {
        return (User) entityManager.createQuery("select u from User u where u.username = :username")
                .setParameter("username", username)
                .getSingleResult();
    }

//    @Transactional
    @Override
    public User createUser(User transientUser) {
        entityManager.persist(transientUser);
        return transientUser;
    }

//    @Transactional
    @Override
    public User updateUser(final User user) {
        return entityManager.merge(user);
    }

//    @Transactional
    @Override
    public boolean deleteUser(final User user) {
        User mergedUser = entityManager.merge(user);
        entityManager.remove(mergedUser);
        return true;
    }
}