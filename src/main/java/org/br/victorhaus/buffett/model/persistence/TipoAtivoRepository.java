package org.br.victorhaus.buffett.model.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.br.victorhaus.buffett.model.domain.TipoAtivo;
import org.br.victorhaus.buffett.util.AbstractPersistence;

@Stateless
public class TipoAtivoRepository extends AbstractPersistence<TipoAtivo, Integer> {

	@PersistenceContext(name = "buffett-pu")
	private EntityManager entityManager;

	public TipoAtivoRepository() {
		super(TipoAtivo.class);
	}

	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

}
