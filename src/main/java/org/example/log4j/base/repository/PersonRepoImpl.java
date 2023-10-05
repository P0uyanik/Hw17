package org.example.log4j.base.repository;



import org.example.log4j.base.domain.Person;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PersonRepoImpl<T extends Person> implements PersonRepo<T> {
    private static final Logger logger = Logger.getLogger(PersonRepoImpl.class.getName());

    private final EntityManager entityManager;

    public PersonRepoImpl(EntityManager em) {
        entityManager = em;
    }

    @Override
    public T save(T person) {
        try {
            entityManager.persist(person);
            logger.info("Saved person ");
        } catch (Exception e) {
            logger.warning("Person couldn't be saved");
        }
        return person;
    }

    @Override
    public void update(T person) {
        try {
            logger.log(Level.INFO,"Person is updated.");
            entityManager.merge(person);
        } catch (Exception e) {
            logger.warning("Person couldn't be updated");
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            logger.log(Level.INFO,"Person is deleted by id.");
            Person person = entityManager.find(Person.class, id);
            entityManager.remove(person);
        } catch (Exception e) {
            logger.warning("Person couldn't be deleted.");
        }
    }

    @Override
    public Collection<T> loadAll(Class<T> clazz) {
        try {
            logger.log(Level.INFO,"loadAll.");
            return entityManager.createQuery("from " + clazz.getSimpleName(), clazz)
                    .getResultList();
        } catch (Exception e) {
            logger.warning("warning.");
            return null;
        }
    }


    @Override
    public boolean contains(T person) {
        try {
            logger.log(Level.INFO,"containse.");
            return entityManager.find(Person.class, person) != null;
        } catch (Exception e) {
            logger.warning("doesn't contain");
            return false;
        }
    }

    @Override
    public void beginTransaction() {
        try {
            logger.log(Level.INFO,"beginTransaction.");
            if (!entityManager.getTransaction().isActive())
                entityManager.getTransaction().begin();
        } catch (Exception e) {
            logger.warning("Transaction s error.");
        }

    }

    @Override
    public void commitTransaction() {
        try {
            logger.log(Level.INFO," committed.");
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().commit();
            }
        } catch (Exception e) {
            logger.warning("couldn't commit.");
        }

    }

    @Override
    public void rollBack() {
        logger.log(Level.INFO,"rollBack.");
        if (entityManager.getTransaction().isActive())
            entityManager.getTransaction().rollback();
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

}