package com.artemnizhnyk.restjakartapractice.repository.impl;

import com.artemnizhnyk.restjakartapractice.domain.model.User;
import com.artemnizhnyk.restjakartapractice.domain.model.task.Task;
import com.artemnizhnyk.restjakartapractice.repository.TaskRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Named
@ApplicationScoped
public class TaskRepositoryImpl implements TaskRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Task getTaskById(final Long id) {
        return entityManager.find(Task.class, id);
    }

    @Override
    public Task getTaskByName(final String name) {
        return (Task) entityManager.createQuery("select t from Task t where t.name = :name")
                .setParameter("name", name)
                .getSingleResult();
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
