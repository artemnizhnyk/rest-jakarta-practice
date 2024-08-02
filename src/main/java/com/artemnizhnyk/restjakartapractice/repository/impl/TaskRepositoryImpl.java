package com.artemnizhnyk.restjakartapractice.repository.impl;

import com.artemnizhnyk.restjakartapractice.domain.model.User;
import com.artemnizhnyk.restjakartapractice.domain.model.task.Task;
import com.artemnizhnyk.restjakartapractice.repository.TaskRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

@ApplicationScoped
public class TaskRepositoryImpl implements TaskRepository {

    @Override
    public Task getTaskById(final Long id) {
        Task task;
        try (EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
             EntityManager entityManager = entityManagerFactory.createEntityManager()
        ) {
            entityManager.getTransaction().begin();

            task = entityManager.find(Task.class, id);

            entityManager.getTransaction().commit();
            return task;
        }
    }

    @Override
    public List<Task> getTasksByUser(final User user) {
        try (EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
             EntityManager entityManager = entityManagerFactory.createEntityManager()
        ) {
            entityManager.getTransaction().begin();

            List<Task> tasks = entityManager.createQuery(
                            "SELECT t FROM Task t WHERE t.user = :user", Task.class)
                    .setParameter("user", user)
                    .getResultList();

            entityManager.getTransaction().commit();
            return tasks;
        }
    }

    @Override
    public Task createTask(final Task transientTask) {
        try (EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
             EntityManager entityManager = entityManagerFactory.createEntityManager()
        ) {
            entityManager.getTransaction().begin();

            entityManager.persist(transientTask);
            Task task = entityManager.find(Task.class, transientTask.getId());

            entityManager.getTransaction().commit();
            return task;
        }
    }

    @Override
    public Task updateTask(final Task task) {
        try (EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
             EntityManager entityManager = entityManagerFactory.createEntityManager()
        ) {
            entityManager.getTransaction().begin();

            Task updatedTask = entityManager.merge(task);

            entityManager.getTransaction().commit();
            return updatedTask;
        }
    }

    @Override
    public boolean deleteTask(final Task task) {
        try (EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
             EntityManager entityManager = entityManagerFactory.createEntityManager()
        ) {
            entityManager.getTransaction().begin();

            Task mergedTask = entityManager.merge(task);
            entityManager.remove(mergedTask);

            entityManager.getTransaction().commit();
            return true;
        }
    }
}
