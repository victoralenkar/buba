package org.br.victorhaus.buffett.control.services;

import javax.inject.Inject;

import org.br.victorhaus.buffett.model.domain.Balanco;
import org.br.victorhaus.buffett.model.persistence.BalancoRepository;

public class BalancoService extends BasicService<Balanco, Long> {

	@Inject
	private BalancoRepository balancoRepository;

	public BalancoRepository getBalancoRepository() {
		return balancoRepository;
	}

	public void setBalancoRepository(BalancoRepository balancoRepository) {
		this.balancoRepository = balancoRepository;
	}

	public Balanco obterPorAno(int ano) {
		return this.balancoRepository.obterPorAno(ano);
	}

	@Override
	public BalancoRepository getBasicService() {
		return this.balancoRepository;
	}

}
