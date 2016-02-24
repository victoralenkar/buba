package org.br.victorhaus.buffett.control.services;

import javax.inject.Inject;

import org.br.victorhaus.buffett.model.domain.TipoProvento;
import org.br.victorhaus.buffett.model.persistence.TipoProventoRepository;

public class TipoProventoService extends BasicService<TipoProvento, Integer> {

	@Inject
	private TipoProventoRepository tipoProventoRepository;

	public TipoProventoRepository getTipoProventoRepository() {
		return tipoProventoRepository;
	}

	public void setTipoProventoRepository(TipoProventoRepository balancoRepository) {
		this.tipoProventoRepository = balancoRepository;
	}

	@Override
	public TipoProventoRepository getBasicService() {
		return this.tipoProventoRepository;
	}

}
