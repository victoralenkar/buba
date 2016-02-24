package org.br.victorhaus.buffett.control.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.br.victorhaus.buffett.control.services.TipoAtivoService;
import org.br.victorhaus.buffett.model.domain.TipoAtivo;

@ManagedBean(name = "taBean")
@ViewScoped
public class TipoAtivoBean extends BasicBean {

	private static final long serialVersionUID = -7647421272055353132L;
	@Inject
	private TipoAtivoService tipoAtivoService;
	private String nomeNovoTipoAtivo;
	private List<TipoAtivo> tiposAtivo;

	public TipoAtivoBean() {
		this.nomeNovoTipoAtivo = "";
	}

	@PostConstruct
	public void init() {
		this.tiposAtivo = this.tipoAtivoService.listarTodos();
	}

	public void salvar() {
		TipoAtivo novoTipoAtivo = new TipoAtivo();
		novoTipoAtivo.setNome(nomeNovoTipoAtivo);
		this.tipoAtivoService.salvar(novoTipoAtivo);
		this.tiposAtivo.add(novoTipoAtivo);
	}

	public void deletarTipoAtivo(int idTipoAtivo) {
		TipoAtivo tipoAtivo = new TipoAtivo();
		tipoAtivo.setId(idTipoAtivo);
		this.tipoAtivoService.remover(tipoAtivo);
		this.tiposAtivo.remove(tipoAtivo);
	}

	public TipoAtivoService getTipoAtivoBussiness() {
		return tipoAtivoService;
	}

	public void setTipoAtivoBussiness(TipoAtivoService balancoService) {
		this.tipoAtivoService = balancoService;
	}

	public TipoAtivoService getTipoAtivoService() {
		return tipoAtivoService;
	}

	public void setTipoAtivoService(TipoAtivoService balancoService) {
		this.tipoAtivoService = balancoService;
	}

	public List<TipoAtivo> getTiposAtivo() {
		return tiposAtivo;
	}

	public void setTiposAtivo(List<TipoAtivo> tiposProvento) {
		this.tiposAtivo = tiposProvento;
	}

	public String getNomeNovoTipoAtivo() {
		return nomeNovoTipoAtivo;
	}

	public void setNomeNovoTipoAtivo(String nomeNovoTipoAtivo) {
		this.nomeNovoTipoAtivo = nomeNovoTipoAtivo;
	}

}
