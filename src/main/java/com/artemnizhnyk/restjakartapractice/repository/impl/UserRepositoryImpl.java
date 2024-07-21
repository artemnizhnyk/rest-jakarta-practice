package com.artemnizhnyk.restjakartapractice.repository.impl;

import com.artemnizhnyk.restjakartapractice.domain.model.User;
import com.artemnizhnyk.restjakartapractice.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UserRepositoryImpl implements UserRepository {

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

    private EntityManagerFactory getEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("default");
    }

}