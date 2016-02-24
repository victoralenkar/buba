package org.br.victorhaus.buffett.control.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.br.victorhaus.buffett.control.services.TipoProventoService;
import org.br.victorhaus.buffett.model.domain.TipoProvento;

@ManagedBean(name = "tpBean")
@ViewScoped
public class TipoProventoBean extends BasicBean {

	private static final long serialVersionUID = -7647421272055353132L;
	@Inject
	private TipoProventoService tipoProventoService;
	private String nomeNovoTipoProvento;
	private List<TipoProvento> tiposProvento;

	public TipoProventoBean() {
		this.nomeNovoTipoProvento = "";
	}

	@PostConstruct
	public void init() {
		this.tiposProvento = this.tipoProventoService.listarTodos();
	}

	public void salvar() {
		TipoProvento novoTipoProvento = new TipoProvento();
		novoTipoProvento.setNome(nomeNovoTipoProvento);
		this.tipoProventoService.salvar(novoTipoProvento);
		this.tiposProvento.add(novoTipoProvento);
	}

	public void deletarTipoProvento(int idTipoProvento) {
		TipoProvento tipoProvento = new TipoProvento();
		tipoProvento.setId(idTipoProvento);
		this.tipoProventoService.remover(tipoProvento);
		this.tiposProvento.remove(tipoProvento);
	}

	public TipoProventoService getTipoProventoBussiness() {
		return tipoProventoService;
	}

	public void setTipoProventoBussiness(TipoProventoService balancoService) {
		this.tipoProventoService = balancoService;
	}

	public TipoProventoService getTipoProventoService() {
		return tipoProventoService;
	}

	public void setTipoProventoService(TipoProventoService balancoService) {
		this.tipoProventoService = balancoService;
	}

	public List<TipoProvento> getTiposProvento() {
		return tiposProvento;
	}

	public void setTiposProvento(List<TipoProvento> tiposProvento) {
		this.tiposProvento = tiposProvento;
	}

	public String getNomeNovoTipoProvento() {
		return nomeNovoTipoProvento;
	}

	public void setNomeNovoTipoProvento(String nomeNovoTipoProvento) {
		this.nomeNovoTipoProvento = nomeNovoTipoProvento;
	}

}
