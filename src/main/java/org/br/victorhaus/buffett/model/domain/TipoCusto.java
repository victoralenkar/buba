package org.br.victorhaus.buffett.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.br.victorhaus.buffett.util.AbstractEntity;

@Entity
@Table(name = "tipo_custo", schema = "sc_buffett")
@SequenceGenerator(name = "tipo_custo_sequence", initialValue = 1, allocationSize = 1, schema = "sc_buffett", sequenceName = "tipo_custo_sequence")
public class TipoCusto implements AbstractEntity {

	private static final long serialVersionUID = -3687161748582138244L;
	private Integer id;
	private String nome;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_custo_sequence")
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "nome", length = 40)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "TipoCusto [id=" + id + ", nome=" + nome + "]";
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
		TipoCusto other = (TipoCusto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
