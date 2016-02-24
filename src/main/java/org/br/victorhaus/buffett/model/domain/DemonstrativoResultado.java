package org.br.victorhaus.buffett.model.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.br.victorhaus.buffett.util.AbstractEntity;

@Entity
@Table(name = "demonstrativo_resultado", schema = "sc_buffett")
@SequenceGenerator(name = "demonstrativo_resultado_sequence", initialValue = 1, allocationSize = 1, schema = "sc_buffett", sequenceName = "demonstrativo_resultado_sequence")
public class DemonstrativoResultado implements AbstractEntity {

	private static final long serialVersionUID = 6964036366197276306L;
	private Long id;
	private List<ResultadoDividendos> dividendos;
	private List<ResultadoGanhoPerdaCapital> ganhoPerdaCapital;
	private List<ResultadoRealizacaoPosicao> realizacoesPosicao;
	private double despesasOperacionais;
	private double impostoRenda;

	public DemonstrativoResultado() {
		super();
		this.dividendos = new ArrayList<ResultadoDividendos>();
		this.ganhoPerdaCapital = new ArrayList<ResultadoGanhoPerdaCapital>();
		this.realizacoesPosicao = new ArrayList<ResultadoRealizacaoPosicao>();
		this.despesasOperacionais = 0.00;
		this.impostoRenda = 0.00;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "demonstrativo_resultado_sequence")
	@Column(name = "id_dre")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToMany(mappedBy = "demonstrativoResultado", cascade = CascadeType.ALL)
	public List<ResultadoDividendos> getDividendos() {
		return dividendos;
	}

	public void setDividendos(List<ResultadoDividendos> dividendos) {
		this.dividendos = dividendos;
	}

	@OneToMany(mappedBy = "demonstrativoResultado", cascade = CascadeType.ALL)
	public List<ResultadoRealizacaoPosicao> getRealizacoesPosicao() {
		return realizacoesPosicao;
	}

	public void setRealizacoesPosicao(List<ResultadoRealizacaoPosicao> realizacoesPosicao) {
		this.realizacoesPosicao = realizacoesPosicao;
	}

	@OneToMany(mappedBy = "demonstrativoResultado", cascade = CascadeType.ALL)
	public List<ResultadoGanhoPerdaCapital> getGanhoPerdaCapital() {
		return ganhoPerdaCapital;
	}

	public void setGanhoPerdaCapital(List<ResultadoGanhoPerdaCapital> ganhoPerdaCapital) {
		this.ganhoPerdaCapital = ganhoPerdaCapital;
	}

	@Column(name = "depesas_operacionais", precision = 2)
	public double getDespesasOperacionais() {
		return despesasOperacionais;
	}

	public void setDespesasOperacionais(double despesasOperacionais) {
		this.despesasOperacionais = despesasOperacionais;
	}

	@Column(name = "imposto_renda", precision = 2)
	public double getImpostoRenda() {
		return impostoRenda;
	}

	public void setImpostoRenda(double impostoRenda) {
		this.impostoRenda = impostoRenda;
	}

	@Transient
	public double getTotalDividendos() {
		double total = 0.0;
		for (Iterator<ResultadoDividendos> iterator = dividendos.iterator(); iterator.hasNext();) {
			ResultadoDividendos resultado = iterator.next();
			total += resultado.getValor();
		}
		return total;
	}

	@Transient
	public double getTotalRealizacaoPosicao() {
		double total = 0.0;
		for (Iterator<ResultadoRealizacaoPosicao> iterator = realizacoesPosicao.iterator(); iterator.hasNext();) {
			ResultadoRealizacaoPosicao resultadoRealizacaoPosicao = iterator.next();
			total += resultadoRealizacaoPosicao.getValor();
		}
		return total;
	}

	@Transient
	public double getTotalGanhoPerdaCapital() {
		double total = 0.0;
		for (Iterator<ResultadoGanhoPerdaCapital> iterator = ganhoPerdaCapital.iterator(); iterator.hasNext();) {
			ResultadoGanhoPerdaCapital resultadoRealizacaoPosicao = iterator.next();
			total += resultadoRealizacaoPosicao.getValor();
		}
		return total;
	}

	@Transient
	public double getLucroAntesIR() {
		return this.getLucroPrejuizoBruto() - this.getDespesasOperacionais();
	}

	@Transient
	public double getLucroPrejuizoBruto() {
		return this.getTotalDividendos() + this.getTotalGanhoPerdaCapital() + this.getTotalRealizacaoPosicao();
	}

	@Transient
	public double getLucroLiquido() {
		return this.getLucroAntesIR() - this.getImpostoRenda();
	}

}
