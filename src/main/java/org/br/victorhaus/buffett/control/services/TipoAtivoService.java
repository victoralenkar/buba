package org.br.victorhaus.buffett.control.services;

import javax.inject.Inject;

import org.br.victorhaus.buffett.model.domain.TipoAtivo;
import org.br.victorhaus.buffett.model.persistence.TipoAtivoRepository;

public class TipoAtivoService extends BasicService<TipoAtivo, Integer> {

	@Inject
	private TipoAtivoRepository tipoAtivoRepository;

	public TipoAtivoRepository getTipoAtivoRepository() {
		return tipoAtivoRepository;
	}

	public void setTipoAtivoRepository(TipoAtivoRepository balancoRepository) {
		this.tipoAtivoRepository = balancoRepository;
	}

	@Override
	public TipoAtivoRepository getBasicService() {
		return this.tipoAtivoRepository;
	}

}
