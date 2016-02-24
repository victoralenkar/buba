package org.br.victorhaus.buffett.model.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.br.victorhaus.buffett.util.AbstractEntity;
import org.br.victorhaus.buffett.util.FormatUtil;

@Entity
@Table(name = "ativo", schema = "sc_buffett")
@SequenceGenerator(name = "ativo_sequence", initialValue = 1, allocationSize = 1, schema = "sc_buffett", sequenceName = "ativo_sequence")
public class Ativo implements AbstractEntity {

	private static final long serialVersionUID = 8772975054121972746L;
	private Long id;
	private TipoAtivo tipo;
	private String nome;
	private Calendar dataAquisicao;
	private double quantidade;
	private double valorAquisicao;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ativo_sequence")
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipo")
	public TipoAtivo getTipo() {
		return tipo;
	}

	public void setTipo(TipoAtivo tipo) {
		this.tipo = tipo;
	}

	@Column(name = "nome", length = 60)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Transient
	public String getDataAquisicaoString() {
		return FormatUtil.calendarToString(this.dataAquisicao);
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_aquisicao")
	public Calendar getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(Calendar data) {
		this.dataAquisicao = data;
	}

	@Column(name = "valor_aquisicao", precision = 2, nullable = false)
	public double getValorAquisicao() {
		return valorAquisicao;
	}

	public void setValorAquisicao(double valor) {
		this.valorAquisicao = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ativo other = (Ativo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ativo [id=" + id + ", tipo=" + tipo + ", nome=" + nome + ", dataAquisicao=" + dataAquisicao + ", valorAquisicao=" + valorAquisicao
				+ ", quantidade=" + quantidade + "]";
	}

	@Column(name = "quantidade", precision = 2, nullable = false)
	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	@Transient
	public String getTotal() {
		double total = this.valorAquisicao * this.quantidade;
		double totalArredondado = FormatUtil.arredondar(total, 2, 1);
		return FormatUtil.doubleToString(totalArredondado);
	}

	@Transient
	public String getValorAquisicaoString() {
		return FormatUtil.doubleToString(this.valorAquisicao);
	}

	@Transient
	public String getQuantidadeString() {
		return FormatUtil.doubleToString(this.quantidade);
	}
}
