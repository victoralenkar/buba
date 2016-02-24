package org.br.victorhaus.buffett.control.services;

import javax.inject.Inject;

import org.br.victorhaus.buffett.model.domain.TipoCusto;
import org.br.victorhaus.buffett.model.persistence.TipoCustoRepository;

public class TipoCustoService extends BasicService<TipoCusto, Integer> {

	@Inject
	private TipoCustoRepository tipoCustoRepository;

	public TipoCustoRepository getTipoCustoRepository() {
		return tipoCustoRepository;
	}

	public void setTipoCustoRepository(TipoCustoRepository balancoRepository) {
		this.tipoCustoRepository = balancoRepository;
	}

	@Override
	public TipoCustoRepository getBasicService() {
		return this.tipoCustoRepository;
	}

}
