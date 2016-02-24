package org.br.victorhaus.buffett.model.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "carteira", schema = "sc_buffett")
@SequenceGenerator(name = "carteira_sequence", initialValue = 1, allocationSize = 1, schema = "sc_buffett", sequenceName = "carteira_sequence")
public class Carteira {

	private Long id;
	private TipoAtivo tipo;
	private int mes;
	private int ano;
	private List<CotacaoAtivo> ativos;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carteira_sequence")
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_tipo", nullable = false, updatable = true, insertable = false)
	public TipoAtivo getTipo() {
		return tipo;
	}

	public void setTipo(TipoAtivo tipo) {
		this.tipo = tipo;
	}

	@Column(name = "mes", nullable = false)
	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	@Column(name = "ano", nullable = false)
	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		return "Carteira [id=" + id + ", tipo=" + tipo + ", mes=" + mes + ", ano=" + ano + "]";
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
		Carteira other = (Carteira) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@OneToMany(mappedBy = "carteira", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<CotacaoAtivo> getAtivos() {
		return ativos;
	}

	public void setAtivos(List<CotacaoAtivo> ativos) {
		this.ativos = ativos;
	}

}
