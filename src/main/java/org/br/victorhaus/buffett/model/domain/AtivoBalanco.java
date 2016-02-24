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
@Table(name = "ativo_balanco", schema = "sc_buffett")
@SequenceGenerator(name = "ativo_balanco_sequence", initialValue = 1, allocationSize = 1, schema = "sc_buffett", sequenceName = "ativo_balanco_sequence")
public class AtivoBalanco {

	private Long id;
	private String nome;
	private double valor;
	private int ordem;
	private Balanco balanco;

	public AtivoBalanco(String nome) {
		this.nome = nome;
	}

	public AtivoBalanco() {
		super();
	}

	public AtivoBalanco(int i, String nome) {
		this.ordem = i;
		this.nome = nome;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ativo_balanco_sequence")
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
	@JoinColumn(name = "id_balanco", nullable = false, updatable = true, insertable = true)
	public Balanco getBalanco() {
		return balanco;
	}

	public void setBalanco(Balanco balanco) {
		this.balanco = balanco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ordem;
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
		AtivoBalanco other = (AtivoBalanco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ordem != other.ordem)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AtivoBalanco [id=" + id + ", nome=" + nome + ", valor=" + valor + ", ordem=" + ordem + ", balanco=" + balanco + "]";
	}

	@Transient
	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

}
