package com.artemnizhnyk.restjakartapractice.repository.impl;

import com.artemnizhnyk.restjakartapractice.domain.model.User;
import com.artemnizhnyk.restjakartapractice.domain.model.task.Task;
import com.artemnizhnyk.restjakartapractice.repository.TaskRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

@ApplicationScoped
public class TaskRepositoryImpl implements TaskRepository {

//    @Override
//    public Task getTaskById() {
//        Task task;
//        try (EntityManagerFactory entityManagerFactory = getEntityManagerFactory();
//             EntityManager entityManager = entityManagerFactory.createEntityManager()
//        ) {
//            entityManager.getTransaction().begin();
//
//            task = entityManager.find(User.class, id);
//
//            entityManager.getTransaction().commit();
//            return user;
//        }
//    }

    @Override
    public List<Task> getTasksByUser(final User userById) {
        return null;
    }

    @Override
    public Task createTask(final Task task) {
        return null;
    }

    @Override
    public Task updateTask(final Task task) {
        return null;
    }

    @Override
    public boolean deleteTask(final Task task) {
        return false;
    }
}
