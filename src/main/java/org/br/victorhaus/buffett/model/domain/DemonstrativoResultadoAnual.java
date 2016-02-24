package org.br.victorhaus.buffett.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "demonstrativo_resultado_anual", schema = "sc_buffett")
@SequenceGenerator(name = "demonstrativo_resultado_anual_sequence", initialValue = 1, allocationSize = 1, schema = "sc_buffett", sequenceName = "demonstrativo_resultado_anual_sequence")
public class DemonstrativoResultadoAnual {

	private Long id;
	private DemonstrativoResultado primeiroTrimestre;
	private DemonstrativoResultado segundoTrimestre;
	private DemonstrativoResultado terceiroTrimestre;
	private DemonstrativoResultado quartoTrimestre;

	public DemonstrativoResultadoAnual() {
		super();
		this.primeiroTrimestre = new DemonstrativoResultado();
		this.segundoTrimestre = new DemonstrativoResultado();
		this.terceiroTrimestre = new DemonstrativoResultado();
		this.quartoTrimestre = new DemonstrativoResultado();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "demonstrativo_resultado_anual_sequence")
	@Column(name = "id_drea")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(optional = true)
	@JoinColumn(name = "id_dre_1t", nullable = true, updatable = true, insertable = true)
	public DemonstrativoResultado getPrimeiroTrimestre() {
		return primeiroTrimestre;
	}

	public void setPrimeiroTrimestre(DemonstrativoResultado primeiroTrimestre) {
		this.primeiroTrimestre = primeiroTrimestre;
	}

	@ManyToOne(optional = true)
	@JoinColumn(name = "id_dre_2t", nullable = true, updatable = true, insertable = true)
	public DemonstrativoResultado getSegundoTrimestre() {
		return segundoTrimestre;
	}

	public void setSegundoTrimestre(DemonstrativoResultado segundoTrimestre) {
		this.segundoTrimestre = segundoTrimestre;
	}

	@ManyToOne(optional = true)
	@JoinColumn(name = "id_dre_3t", nullable = true, updatable = true, insertable = true)
	public DemonstrativoResultado getTerceiroTrimestre() {
		return terceiroTrimestre;
	}

	public void setTerceiroTrimestre(DemonstrativoResultado terceiroTrimestre) {
		this.terceiroTrimestre = terceiroTrimestre;
	}

	@ManyToOne(optional = true)
	@JoinColumn(name = "id_dre_4t", nullable = true, updatable = true, insertable = true)
	public DemonstrativoResultado getQuartoTrimestre() {
		return quartoTrimestre;
	}

	public void setQuartoTrimestre(DemonstrativoResultado quartoTrimestre) {
		this.quartoTrimestre = quartoTrimestre;
	}

	@Transient
	public double getTotalDividendos() {
		return this.primeiroTrimestre.getTotalDividendos() + this.segundoTrimestre.getTotalDividendos() + this.terceiroTrimestre.getTotalDividendos()
				+ this.quartoTrimestre.getTotalDividendos();
	}

	@Transient
	public double getTotalRealizacaoPosicao() {
		return this.primeiroTrimestre.getTotalRealizacaoPosicao() + this.segundoTrimestre.getTotalRealizacaoPosicao()
				+ this.terceiroTrimestre.getTotalRealizacaoPosicao() + this.quartoTrimestre.getTotalRealizacaoPosicao();
	}

	@Transient
	public double getTotalGanhoPerdaCapital() {
		return this.primeiroTrimestre.getTotalGanhoPerdaCapital() + this.segundoTrimestre.getTotalGanhoPerdaCapital()
				+ this.terceiroTrimestre.getTotalGanhoPerdaCapital() + this.quartoTrimestre.getTotalGanhoPerdaCapital();
	}

	@Transient
	public double getLucroAntesIR() {
		return this.primeiroTrimestre.getLucroAntesIR() + this.segundoTrimestre.getLucroAntesIR() + this.terceiroTrimestre.getLucroAntesIR()
				+ this.quartoTrimestre.getLucroAntesIR();
	}

	@Transient
	public double getTotalDespesasOperacionais() {
		return this.primeiroTrimestre.getDespesasOperacionais() + this.segundoTrimestre.getDespesasOperacionais()
				+ this.terceiroTrimestre.getDespesasOperacionais() + this.quartoTrimestre.getDespesasOperacionais();
	}

	@Transient
	public double getLucroPrejuizoBruto() {
		return this.primeiroTrimestre.getLucroPrejuizoBruto() + this.segundoTrimestre.getLucroPrejuizoBruto() + this.terceiroTrimestre.getLucroPrejuizoBruto()
				+ this.quartoTrimestre.getLucroPrejuizoBruto();
	}

	@Transient
	public double getLucroLiquido() {
		return this.primeiroTrimestre.getLucroLiquido() + this.segundoTrimestre.getLucroLiquido() + this.terceiroTrimestre.getLucroLiquido()
				+ this.quartoTrimestre.getLucroLiquido();
	}

	@Transient
	public double getTotalImpostoRenda() {
		return this.primeiroTrimestre.getImpostoRenda() + this.segundoTrimestre.getImpostoRenda() + this.terceiroTrimestre.getImpostoRenda()
				+ this.quartoTrimestre.getImpostoRenda();
	}

}
