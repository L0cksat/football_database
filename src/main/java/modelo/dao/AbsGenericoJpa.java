package modelo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public abstract class AbsGenericoJpa {
	protected EntityManagerFactory emf;
	protected EntityManager em;
	protected EntityTransaction tx;
	protected Query query;
	protected String jpql;
	protected int filas;
	
	public AbsGenericoJpa() {
		emf = Persistence.createEntityManagerFactory("Football_Database1");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}
}
