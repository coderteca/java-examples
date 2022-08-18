package com.coderteca.phone.models.config;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Model
 */
public class Model<T> {

	public static <T> List<T> findAll(String nameClass) {
		var list = Persistence
				.createEntityManagerFactory("phones")
				.createEntityManager()
				.createQuery("SELECT a FROM " + nameClass + " a")
				.getResultList();
		return list;
	}

	public static <T> List<T> findByAttribute(String nameClass,String attr, Object value ) {
		var list = Persistence
				.createEntityManagerFactory("phones")
				.createEntityManager()
				.createQuery("SELECT a FROM " + nameClass + " a WHERE a."+attr+" = :value")
				.setParameter("value", value)
				.getResultList();
		return list;
	}

	public static void save(Object obj) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("phones");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(obj);
		entityManager.getTransaction().commit();
	}

	public static void delete(Object obj) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("phones");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.merge(obj));
		entityManager.getTransaction().commit();

	}

	public static void update(Object obj) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("phones");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(obj);
		entityManager.getTransaction().commit();

	}

}
