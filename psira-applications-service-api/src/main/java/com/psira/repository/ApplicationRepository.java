package com.psira.repository;

import com.psira.model.Application;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ApplicationRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Application> listAll() {
        return entityManager.createQuery("SELECT a FROM Application a", Application.class).getResultList();
    }

    public Application findById(Long id) {
        return entityManager.find(Application.class, id);
    }

    @Transactional
    public void persist(Application application) {
        entityManager.persist(application);
    }

    @Transactional
    public Application merge(Application application) {
        return entityManager.merge(application);
    }

    @Transactional
    public void deleteById(Long id) {
        Application application = findById(id);
        if (application != null) {
            entityManager.remove(application);
        }
    }
}
