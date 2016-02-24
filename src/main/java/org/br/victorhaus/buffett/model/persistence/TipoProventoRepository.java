package org.br.victorhaus.buffett.model.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.br.victorhaus.buffett.model.domain.TipoProvento;
import org.br.victorhaus.buffett.util.AbstractPersistence;

@Stateless
public class TipoProventoRepository extends AbstractPersistence<TipoProvento, Integer> {

	@PersistenceContext(name = "buffett-pu")
	private EntityManager entityManager;

	public TipoProventoRepository() {
		super(TipoProvento.class);
	}

	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

}
