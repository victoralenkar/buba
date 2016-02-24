package org.br.victorhaus.buffett.util;

import java.io.Serializable;
import java.util.Date;

public class UsuarioLogado implements Serializable {

	private static final long serialVersionUID = 5245234287527759048L;
	private String login;
	private String nome;
	private Date dataHoraLogin;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataHoraLogin() {
		return dataHoraLogin;
	}

	public void setDataHoraLogin(Date dataHoraLogin) {
		this.dataHoraLogin = dataHoraLogin;
	}

	@Override
	public String toString() {
		return "UsuarioLogado [login=" + login + ", nome=" + nome + ", dataHoraLogin=" + dataHoraLogin + "]";
	}

}
