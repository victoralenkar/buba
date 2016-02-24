package org.br.victorhaus.buffett.model.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.br.victorhaus.buffett.model.domain.Ativo;
import org.br.victorhaus.buffett.util.AbstractPersistence;

@Stateless
public class AtivoRepository extends AbstractPersistence<Ativo, Long> {

	@PersistenceContext(name = "buffett-pu")
	private EntityManager entityManager;

	public AtivoRepository() {
		super(Ativo.class);
	}

	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

}
