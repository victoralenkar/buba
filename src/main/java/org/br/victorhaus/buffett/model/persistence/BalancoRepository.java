package org.br.victorhaus.buffett.model.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.br.victorhaus.buffett.model.domain.Balanco;
import org.br.victorhaus.buffett.util.AbstractPersistence;

@Stateless
public class BalancoRepository extends AbstractPersistence<Balanco, Long> {

	@PersistenceContext(name = "buffett-pu")
	private EntityManager entityManager;

	public BalancoRepository() {
		super(Balanco.class);
	}

	public Balanco obterPorAno(int ano) {
		Balanco b = null;
		Query q = this.entityManager.createNamedQuery("Balanco.obterPorAno", Balanco.class);
		q.setParameter("ano", ano);
		b = (Balanco) q.getSingleResult();
		return b;
	}

	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

}
