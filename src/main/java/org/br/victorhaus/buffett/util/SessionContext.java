package org.br.victorhaus.buffett.util;

import java.io.IOException;
import java.io.OutputStream;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class SessionContext {

	private static SessionContext instance;

	public static SessionContext getInstance() {
		if (instance == null) {
			instance = new SessionContext();
		}

		return instance;
	}

	private SessionContext() {

	}

	private ExternalContext currentExternalContext() {
		if (FacesContext.getCurrentInstance() == null) {
			throw new RuntimeException("O FacesContext nao pode ser chamado fora de uma requisicao HTTP");
		} else {
			return FacesContext.getCurrentInstance().getExternalContext();
		}
	}

	public void encerrarSessao() {
		currentExternalContext().invalidateSession();
	}

	public Object getAttribute(String nome) {
		return currentExternalContext().getSessionMap().get(nome);
	}

	public void setAttribute(String nome, Object valor) {
		currentExternalContext().getSessionMap().put(nome, valor);
	}

	public void removeAttribute(String chave) {
		currentExternalContext().getSessionMap().remove(chave);
	}

	public OutputStream getResponseOutputStream() throws IOException {
		return currentExternalContext().getResponseOutputStream();
	}

	public void setResponseContentType(String contentType) {
		currentExternalContext().setResponseContentType(contentType);
	}

	public String getRealPath(String path) {
		return currentExternalContext().getRealPath(path);
	}

}