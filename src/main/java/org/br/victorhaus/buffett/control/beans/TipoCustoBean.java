package org.br.victorhaus.buffett.control.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.br.victorhaus.buffett.control.services.TipoCustoService;
import org.br.victorhaus.buffett.model.domain.TipoCusto;

@ManagedBean(name = "tcBean")
@ViewScoped
public class TipoCustoBean extends BasicBean {

	private static final long serialVersionUID = -7647421272055353132L;
	@Inject
	private TipoCustoService tipoCustoService;
	private String nomeNovoTipoCusto;
	private List<TipoCusto> tiposCusto;

	public TipoCustoBean() {
		this.nomeNovoTipoCusto = "";
	}

	@PostConstruct
	public void init() {
		this.tiposCusto = this.tipoCustoService.listarTodos();
	}

	public void salvar() {
		TipoCusto novoTipoCusto = new TipoCusto();
		novoTipoCusto.setNome(nomeNovoTipoCusto);
		this.tipoCustoService.salvar(novoTipoCusto);
		this.tiposCusto.add(novoTipoCusto);
	}

	public void deletarTipoCusto(int idTipoCusto) {
		TipoCusto tipoCusto = new TipoCusto();
		tipoCusto.setId(idTipoCusto);
		this.tipoCustoService.remover(tipoCusto);
		this.tiposCusto.remove(tipoCusto);
	}

	public TipoCustoService getTipoCustoBussiness() {
		return tipoCustoService;
	}

	public void setTipoCustoBussiness(TipoCustoService balancoService) {
		this.tipoCustoService = balancoService;
	}

	public TipoCustoService getTipoCustoService() {
		return tipoCustoService;
	}

	public void setTipoCustoService(TipoCustoService balancoService) {
		this.tipoCustoService = balancoService;
	}

	public List<TipoCusto> getTiposCusto() {
		return tiposCusto;
	}

	public void setTiposCusto(List<TipoCusto> tiposProvento) {
		this.tiposCusto = tiposProvento;
	}

	public String getNomeNovoTipoCusto() {
		return nomeNovoTipoCusto;
	}

	public void setNomeNovoTipoCusto(String nomeNovoTipoCusto) {
		this.nomeNovoTipoCusto = nomeNovoTipoCusto;
	}

}
