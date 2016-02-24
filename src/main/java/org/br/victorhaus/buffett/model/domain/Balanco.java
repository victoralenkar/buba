package org.br.victorhaus.buffett.model.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.br.victorhaus.buffett.util.AbstractEntity;

@Entity
@NamedQueries({ @NamedQuery(name = "Balanco.obterPorAno", query = "SELECT b FROM Balanco b where b.ano = :ano"),
		@NamedQuery(name = "Balanco.obterUltimo", query = "SELECT b FROM Balanco b where b.ano = max(b.ano)") })
@Table(name = "balanco", schema = "sc_buffett")
@SequenceGenerator(name = "balanco_sequence", initialValue = 1, allocationSize = 1, schema = "sc_buffett", sequenceName = "balanco_sequence")
public class Balanco implements AbstractEntity {

	private static final long serialVersionUID = 4886130898608434511L;
	private Long id;
	private int ano;
	private double capitalSocial;
	private double obrigacoes;
	private double lucroPrejuizoAcumulados;
	private List<AtivoBalanco> ativoBalancos;
	private DemonstrativoResultadoAnual demonstrativoResultadoAnual;

	public Balanco() {
		super();
		this.ano = Calendar.getInstance().get(Calendar.YEAR);
		this.ativoBalancos = new ArrayList<AtivoBalanco>();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "balanco_sequence")
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "ano", unique = true)
	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	@Column(name = "capital_social")
	public double getCapitalSocial() {
		return this.capitalSocial;
	}

	public void setCapitalSocial(double capitalSocial) {
		this.capitalSocial = capitalSocial;
	}

	@Column(name = "obrigacoes")
	public double getObrigacoes() {
		return obrigacoes;
	}

	public void setObrigacoes(double obrigacoes) {
		this.obrigacoes = obrigacoes;
	}

	@OneToMany(mappedBy = "balanco", cascade = CascadeType.ALL)
	public List<AtivoBalanco> getAtivos() {
		return ativoBalancos;
	}

	@Transient
	public void addAtivo(AtivoBalanco ativoBalanco) {
		ativoBalanco.setBalanco(this);
		this.ativoBalancos.add(ativoBalanco);
	}

	public void setAtivos(List<AtivoBalanco> ativoBalancos) {
		this.ativoBalancos = ativoBalancos;
	}

	@Column(name = "lpa")
	public double getLucroPrejuizoAcumulados() {
		return this.lucroPrejuizoAcumulados;
	}

	public void setLucroPrejuizoAcumulados(double lucroPrejuizoAcumulados) {
		this.lucroPrejuizoAcumulados = lucroPrejuizoAcumulados;
	}

	@ManyToOne(optional = true)
	@JoinColumn(name = "id_drea", nullable = true, updatable = true, insertable = true)
	public DemonstrativoResultadoAnual getDemonstrativoResultadoAnual() {
		return this.demonstrativoResultadoAnual;
	}

	public void setDemonstrativoResultadoAnual(DemonstrativoResultadoAnual demonstrativoResultadoAnual) {
		this.demonstrativoResultadoAnual = demonstrativoResultadoAnual;
	}

	@Transient
	public double getPassivoPatrimonioLiquido() {
		return this.getPassivoPatrimonioLiquido() + this.getObrigacoes();
	}

	@Transient
	public double getTotalAtivos() {
		double total = 0.0;
		for (Iterator<AtivoBalanco> iterator = ativoBalancos.iterator(); iterator.hasNext();) {
			AtivoBalanco ativoBalanco = iterator.next();
			total += ativoBalanco.getValor();
		}
		return total;
	}

	@Transient
	public double getPatrimonioLiquido() {
		return this.getCapitalSocial() - this.getLucroPrejuizoAcumulados();
	}

	@Transient
	public boolean verificarBalanco() {
		return (this.getPassivoPatrimonioLiquido() == this.getTotalAtivos());
	}

	@Override
	public String toString() {
		return "Balanco [id=" + id + ", ano=" + ano + ", capitalSocial=" + capitalSocial + ", obrigacoes=" + obrigacoes + ", lucroPrejuizoAcumulados="
				+ lucroPrejuizoAcumulados + ", ativoBalancos=" + ativoBalancos + ", demonstrativoResultadoAnual=" + demonstrativoResultadoAnual + "]";
	}

}
