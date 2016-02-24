package org.br.victorhaus.buffett.control.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.br.victorhaus.buffett.control.services.BalancoService;
import org.br.victorhaus.buffett.model.domain.AtivoBalanco;
import org.br.victorhaus.buffett.model.domain.Balanco;
import org.br.victorhaus.buffett.util.SessionContext;

@ManagedBean
@ViewScoped
public class BalancoBean extends BasicBean {

	private static final long serialVersionUID = -7647421272055353132L;
	@Inject
	private BalancoService balancoService;
	private Balanco balanco;
	private Balanco balancoAtual;
	private String novoAtivo;

	public BalancoBean() {
		this.balancoAtual = (Balanco) SessionContext.getInstance().getAttribute("balancoAtual");
		if (balancoAtual == null) {
			this.balancoAtual = new Balanco();
		}
		this.balanco = new Balanco();
		this.balanco.addAtivo(new AtivoBalanco(1, "Dinheiro e equivalentes"));
		this.balanco.addAtivo(new AtivoBalanco(2, "Tesouro Direto (TD)"));
		this.balanco.addAtivo(new AtivoBalanco(3, "Fundos"));
		this.balanco.addAtivo(new AtivoBalanco(4, "Opções"));
		this.balanco.addAtivo(new AtivoBalanco(5, "Ações"));
	}

	public String salvar() {
		this.balancoService.salvar(this.balanco);
		SessionContext.getInstance().setAttribute("balancoAtual", this.balanco);
		return "balancoAtual.xhtml";
	}

	public void deletarAtivo(int ativoOrdem) {
		AtivoBalanco ativoBalanco = new AtivoBalanco();
		ativoBalanco.setOrdem(ativoOrdem);
		this.balanco.getAtivos().remove(ativoBalanco);
	}

	public void adicionarAtivo() {
		AtivoBalanco novoAtivo = new AtivoBalanco(this.novoAtivo);
		novoAtivo.setOrdem(this.balanco.getAtivos().size() + 1);
		this.balanco.addAtivo(novoAtivo);
		SessionContext.getInstance().setAttribute("balancoAtual", this.balanco);
	}

	public BalancoService getBalancoBussiness() {
		return balancoService;
	}

	public void setBalancoBussiness(BalancoService balancoService) {
		this.balancoService = balancoService;
	}

	public BalancoService getBalancoService() {
		return balancoService;
	}

	public void setBalancoService(BalancoService balancoService) {
		this.balancoService = balancoService;
	}

	public Balanco getBalanco() {
		return balanco;
	}

	public void setBalanco(Balanco balanco) {
		this.balanco = balanco;
	}

	public Balanco getBalancoAtual() {
		return balancoAtual;
	}

	public void setBalancoAtual(Balanco balancoAtual) {
		this.balancoAtual = balancoAtual;
	}

	public String getNovoAtivo() {
		return novoAtivo;
	}

	public void setNovoAtivo(String novoAtivo) {
		this.novoAtivo = novoAtivo;
	}

}
