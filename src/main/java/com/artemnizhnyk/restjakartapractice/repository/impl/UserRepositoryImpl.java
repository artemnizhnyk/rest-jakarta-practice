package com.artemnizhnyk.restjakartapractice.repository.impl;

import com.artemnizhnyk.restjakartapractice.domain.model.Task;
import com.artemnizhnyk.restjakartapractice.domain.model.User;
import com.artemnizhnyk.restjakartapractice.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public List<Task> tasksByUserId(Long userId) {
        EntityManagerFactory entityManagerFactory = getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        List<Task> tasksByUserId = entityManager.createNativeQuery("select * from tasks t where user_id=:userId", Task.class)
                .setParameter("userId", userId)
                .getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        if (Objects.isNull(tasksByUserId)) {
            return new ArrayList<>();
        }
        return tasksByUserId;

    }

    private EntityManagerFactory getEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("default");
    }

}