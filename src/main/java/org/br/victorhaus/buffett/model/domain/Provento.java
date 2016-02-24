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
@Table(name = "provento", schema = "sc_buffett")
@SequenceGenerator(name = "provento_sequence", initialValue = 1, allocationSize = 1, schema = "sc_buffett", sequenceName = "provento_sequence")
public class Provento {

	private Long id;
	private TipoProvento tipoProvento;
	private TipoAtivo tipoAtivo;
	private Calendar dataRecebimento;
	private double valorBruto;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "provento_sequence")
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_tipo_provento", nullable = false, updatable = true, insertable = true)
	public TipoProvento getTipoProvento() {
		return tipoProvento;
	}

	public void setTipoProvento(TipoProvento tipoProvento) {
		this.tipoProvento = tipoProvento;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_tipo_ativo", nullable = false, updatable = true, insertable = true)
	public TipoAtivo getTipoAtivo() {
		return tipoAtivo;
	}

	public void setTipoAtivo(TipoAtivo tipoAtivo) {
		this.tipoAtivo = tipoAtivo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_recebimento")
	public Calendar getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(Calendar dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	@Column(name = "valor_bruto", precision = 2)
	public double getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(double valorBruto) {
		this.valorBruto = valorBruto;
	}

	@Override
	public String toString() {
		return "Provento [id=" + id + ", tipoProvento=" + tipoProvento + ", tipoAtivo=" + tipoAtivo + ", dataRecebimento=" + dataRecebimento + ", valorBruto="
				+ valorBruto + "]";
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
		Provento other = (Provento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
