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

import org.br.victorhaus.buffett.util.AbstractEntity;

@Entity
@Table(name = "resultado_gpc", schema = "sc_buffett")
@SequenceGenerator(name = "resultado_gpc_sequence", initialValue = 1, allocationSize = 1, schema = "sc_buffett", sequenceName = "resultado_gpc_sequence")
public class ResultadoGanhoPerdaCapital implements AbstractEntity {

	private static final long serialVersionUID = -7329400339547586958L;
	private Long id;
	private String nome;
	private double valor;
	private DemonstrativoResultado demonstrativoResultado;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resultado_gpc_sequence")
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "valor")
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_dre", nullable = false, updatable = true, insertable = true)
	public DemonstrativoResultado getDemonstrativoResultado() {
		return demonstrativoResultado;
	}

	public void setDemonstrativoResultado(DemonstrativoResultado demonstrativoResultado) {
		this.demonstrativoResultado = demonstrativoResultado;
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
		ResultadoGanhoPerdaCapital other = (ResultadoGanhoPerdaCapital) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
