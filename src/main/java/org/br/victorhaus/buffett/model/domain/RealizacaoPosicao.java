package org.br.victorhaus.buffett.model.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "realizacao_posicao", schema = "sc_buffett")
@SequenceGenerator(name = "realizacao_posicao_sequence", initialValue = 1, allocationSize = 1, schema = "sc_buffett", sequenceName = "realizacao_posicao_sequence")
public class RealizacaoPosicao {

	private Long id;
	private Ativo ativo;
	private Date dataRealizacao;
	private double valorRealizacao;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "realizacao_posicao_sequence")
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_ativo", nullable = false, updatable = true, insertable = false)
	public Ativo getAtivo() {
		return ativo;
	}

	public void setAtivo(Ativo ativo) {
		this.ativo = ativo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_realizacao")
	public Date getDataRealizacao() {
		return dataRealizacao;
	}

	public void setDataRealizacao(Date data) {
		this.dataRealizacao = data;
	}

	@Column(name = "valor_realizacao", precision = 2)
	public double getValorRealizacao() {
		return valorRealizacao;
	}

	public void setValorRealizacao(double valor) {
		this.valorRealizacao = valor;
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
		RealizacaoPosicao other = (RealizacaoPosicao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CotacaoAtivo [id=" + id + ", ativo=" + ativo + ", dataRealizacao=" + dataRealizacao + ", valorRealizacao=" + valorRealizacao + "]";
	}

}
