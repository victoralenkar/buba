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
@Table(name = "cotacao_ativo", schema = "sc_buffett")
@SequenceGenerator(name = "cotacao_ativo_sequence", initialValue = 1, allocationSize = 1, schema = "sc_buffett", sequenceName = "cotacao_ativo_sequence")
public class CotacaoAtivo {

	private Long id;
	private Ativo ativo;
	private Date dataCotacao;
	private double valorCotacao;
	private Carteira carteira;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cotacao_ativo_sequence")
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
	@Column(name = "data_cotacao")
	public Date getDataCotacao() {
		return dataCotacao;
	}

	public void setDataCotacao(Date data) {
		this.dataCotacao = data;
	}

	@Column(name = "valor_cotacao", precision = 2)
	public double getValorCotacao() {
		return valorCotacao;
	}

	public void setValorCotacao(double valor) {
		this.valorCotacao = valor;
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
		CotacaoAtivo other = (CotacaoAtivo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CotacaoAtivo [id=" + id + ", ativo=" + ativo + ", dataCotacao=" + dataCotacao + ", valorCotacao=" + valorCotacao + "]";
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_carteira", nullable = false, updatable = false, insertable = false)
	public Carteira getCarteira() {
		return carteira;
	}

	public void setCarteira(Carteira carteira) {
		this.carteira = carteira;
	}

}
