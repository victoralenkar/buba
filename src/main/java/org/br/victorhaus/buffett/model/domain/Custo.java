package org.br.victorhaus.buffett.model.domain;

import java.util.Calendar;

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
@Table(name = "custo", schema = "sc_buffett")
@SequenceGenerator(name = "custo_sequence", initialValue = 1, allocationSize = 1, schema = "sc_buffett", sequenceName = "custo_sequence")
public class Custo {

	private Long id;
	private TipoCusto tipo;
	private String descricao;
	private Calendar data;
	private double valor;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custo_sequence")
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_tipo", nullable = false, updatable = true, insertable = false)
	public TipoCusto getTipo() {
		return tipo;
	}

	public void setTipo(TipoCusto tipo) {
		this.tipo = tipo;
	}

	@Column(name = "descricao", length = 60)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data")
	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	@Column(name = "valor", precision = 2)
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
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
		Custo other = (Custo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Custo [id=" + id + ", tipo=" + tipo + ", descricao=" + descricao + ", data=" + data + ", valor=" + valor + "]";
	}

}
