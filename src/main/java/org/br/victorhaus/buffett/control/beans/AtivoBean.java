package org.br.victorhaus.buffett.control.beans;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import org.br.victorhaus.buffett.control.services.AtivoService;
import org.br.victorhaus.buffett.control.services.TipoAtivoService;
import org.br.victorhaus.buffett.model.domain.Ativo;
import org.br.victorhaus.buffett.model.domain.TipoAtivo;
import org.br.victorhaus.buffett.util.FormatUtil;

@ManagedBean
@ViewScoped
public class AtivoBean extends BasicBean {

	private static final long serialVersionUID = -7647421272055353132L;
	@Inject
	private AtivoService ativoService;
	@Inject
	private TipoAtivoService tipoAtivoService;
	private String nomeNovoAtivo;
	private TipoAtivo tipoNovoAtivo;
	private String dataAquisicaoNovoAtivo;
	private String valorAquisicaoNovoAtivo;
	private String qtdeNovoAtivo;

	private List<SelectItem> tiposAtivo;
	private List<Ativo> ativos;

	public AtivoBean() {
		resetCampos();
		this.tiposAtivo = new ArrayList<SelectItem>();
	}

	private void resetCampos() {
		this.nomeNovoAtivo = "";
		this.tipoNovoAtivo = new TipoAtivo();
		this.dataAquisicaoNovoAtivo = "";
		this.valorAquisicaoNovoAtivo = "";
		this.qtdeNovoAtivo = "";
	}

	@PostConstruct
	public void init() {
		this.ativos = this.ativoService.listarTodos();
		List<TipoAtivo> tAtivo = this.tipoAtivoService.listarTodos();
		for (Iterator<TipoAtivo> iterator = tAtivo.iterator(); iterator.hasNext();) {
			TipoAtivo tipoAtivo = iterator.next();
			this.tiposAtivo.add(new SelectItem(tipoAtivo.getId(), tipoAtivo.getNome()));
		}
	}

	public void salvar() {
		try {
			Locale locale = new Locale("pt", "br");
			DecimalFormat df = new DecimalFormat();
			Currency cu = Currency.getInstance(locale);
			df.setCurrency(cu);
			Ativo novoAtivo = new Ativo();
			if (this.nomeNovoAtivo.length() == 0) {
				super.dispararAviso("", "O campo nome é obrigatório. Favor preencher.");
				return;
			}
			if (this.dataAquisicaoNovoAtivo.length() == 0) {
				super.dispararAviso("", "O campo data de aquisição é obrigatório. Favor preencher.");
				return;
			}
			if (this.qtdeNovoAtivo.length() == 0) {
				super.dispararAviso("", "O campo quantidade é obrigatório. Favor preencher.");
				return;
			}
			if (this.valorAquisicaoNovoAtivo.length() == 0) {
				super.dispararAviso("", "O campo valor de aquisição é obrigatório. Favor preencher.");
				return;
			}
			novoAtivo.setNome(nomeNovoAtivo);
			novoAtivo.setTipo(this.tipoAtivoService.obterPelaPK(this.tipoNovoAtivo.getId()));
			novoAtivo.setDataAquisicao(FormatUtil.stringToCalendar(this.dataAquisicaoNovoAtivo));
			novoAtivo.setQuantidade(df.parse(this.qtdeNovoAtivo).doubleValue());
			novoAtivo.setValorAquisicao(df.parse(this.valorAquisicaoNovoAtivo).doubleValue());
			this.ativoService.salvar(novoAtivo);
			this.ativos.add(novoAtivo);
			resetCampos();
		} catch (ParseException e) {
			super.dispararAviso("", "Formato inválido! Mais detalhes: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void deletarAtivo(Long idAtivo) {
		Ativo ativo = new Ativo();
		ativo.setId(idAtivo);
		this.ativoService.remover(this.ativoService.obterPelaPK(idAtivo));
		this.ativos.remove(ativo);
	}

	public AtivoService getAtivoBussiness() {
		return ativoService;
	}

	public void setAtivoBussiness(AtivoService balancoService) {
		this.ativoService = balancoService;
	}

	public AtivoService getAtivoService() {
		return ativoService;
	}

	public void setAtivoService(AtivoService balancoService) {
		this.ativoService = balancoService;
	}

	public String getNomeNovoAtivo() {
		return nomeNovoAtivo;
	}

	public void setNomeNovoAtivo(String nomeNovoAtivo) {
		this.nomeNovoAtivo = nomeNovoAtivo;
	}

	public TipoAtivo getTipoNovoAtivo() {
		return tipoNovoAtivo;
	}

	public void setTipoNovoAtivo(TipoAtivo tipoAtivo) {
		this.tipoNovoAtivo = tipoAtivo;
	}

	public String getDataAquisicaoNovoAtivo() {
		return dataAquisicaoNovoAtivo;
	}

	public void setDataAquisicaoNovoAtivo(String dataAquisicaoNovoAtivo) {
		this.dataAquisicaoNovoAtivo = dataAquisicaoNovoAtivo;
	}

	public String getValorAquisicaoNovoAtivo() {
		return valorAquisicaoNovoAtivo;
	}

	public void setValorAquisicaoNovoAtivo(String valorAquisicaoNovoAtivo) {
		this.valorAquisicaoNovoAtivo = valorAquisicaoNovoAtivo;
	}

	public String getQtdeNovoAtivo() {
		return qtdeNovoAtivo;
	}

	public void setQtdeNovoAtivo(String qtdeNovoAtivo) {
		this.qtdeNovoAtivo = qtdeNovoAtivo;
	}

	public TipoAtivoService getTipoAtivoService() {
		return tipoAtivoService;
	}

	public void setTipoAtivoService(TipoAtivoService tipoAtivoService) {
		this.tipoAtivoService = tipoAtivoService;
	}

	public List<SelectItem> getTiposAtivo() {
		return tiposAtivo;
	}

	public void setTiposAtivo(List<SelectItem> tiposAtivo) {
		this.tiposAtivo = tiposAtivo;
	}

	public List<Ativo> getAtivos() {
		return ativos;
	}

	public void setAtivos(List<Ativo> ativos) {
		this.ativos = ativos;
	}

}
