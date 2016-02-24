package org.br.victorhaus.buffett.control.services;

import javax.inject.Inject;

import org.br.victorhaus.buffett.model.domain.Ativo;
import org.br.victorhaus.buffett.model.persistence.AtivoRepository;

public class AtivoService extends BasicService<Ativo, Long> {

	@Inject
	private AtivoRepository ativoRepository;

	public AtivoRepository getAtivoRepository() {
		return ativoRepository;
	}

	public void setAtivoRepository(AtivoRepository balancoRepository) {
		this.ativoRepository = balancoRepository;
	}

	@Override
	public AtivoRepository getBasicService() {
		return this.ativoRepository;
	}

}
