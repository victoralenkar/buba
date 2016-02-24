package org.br.victorhaus.buffett.model.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.br.victorhaus.buffett.model.domain.TipoCusto;
import org.br.victorhaus.buffett.util.AbstractPersistence;

@Stateless
public class TipoCustoRepository extends AbstractPersistence<TipoCusto, Integer> {

	@PersistenceContext(name = "buffett-pu")
	private EntityManager entityManager;

	public TipoCustoRepository() {
		super(TipoCusto.class);
	}

	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

}
