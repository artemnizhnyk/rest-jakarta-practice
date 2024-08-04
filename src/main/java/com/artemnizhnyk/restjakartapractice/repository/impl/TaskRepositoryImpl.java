package com.artemnizhnyk.restjakartapractice.repository.impl;

import com.artemnizhnyk.restjakartapractice.domain.model.User;
import com.artemnizhnyk.restjakartapractice.domain.model.task.Task;
import com.artemnizhnyk.restjakartapractice.repository.TaskRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Named
@ApplicationScoped
public class TaskRepositoryImpl implements TaskRepository {

    @PersistenceContext
    private EntityManager entityManager;

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
        return entityManager.createQuery(
                        "SELECT t FROM Task t WHERE t.user = :user", Task.class)
                .setParameter("user", user)
                .getResultList();
    }

    @Override
    public Task createTask(final Task transientTask) {
        entityManager.persist(transientTask);
        return entityManager.find(Task.class, transientTask.getId());
    }

    @Override
    public Task updateTask(final Task task) {
        return entityManager.merge(task);
    }

    @Override
    public boolean deleteTask(final Task task) {
            Task mergedTask = entityManager.merge(task);
            entityManager.remove(mergedTask);
            return true;
    }
}
