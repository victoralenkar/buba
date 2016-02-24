package org.br.victorhaus.buffett.control.services;

import java.util.List;

import org.br.victorhaus.buffett.util.AbstractEntity;
import org.br.victorhaus.buffett.util.AbstractPersistence;

public abstract class BasicService<T extends AbstractEntity, PK extends Number> {

	public abstract AbstractPersistence<T, PK> getBasicService();

	public void salvar(T o) {
		getBasicService().save(o);
	}

	public void remover(T o) {
		getBasicService().remove(o);
	}

	public List<T> listarTodos() {
		return getBasicService().findAll();
	}

	public T obterPelaPK(PK id) {
		return getBasicService().find(id);
	}

}
