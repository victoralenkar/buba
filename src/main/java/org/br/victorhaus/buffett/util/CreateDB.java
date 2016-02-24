package org.br.victorhaus.buffett.util;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.br.victorhaus.buffett.model.domain.Balanco;

public class CreateDB {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("buffett-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		Balanco b = new Balanco();
		b.setAno(2016);
		em.persist(b);
		t.commit();
		em.close();
		emf.close();
	}

}
