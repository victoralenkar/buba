package org.br.victorhaus.buffett.control.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class BasicBean implements Serializable {

	private static final long serialVersionUID = -4380845501689072274L;

	/*
	 * private ResourceBundle getBundle() { ResourceBundle bundle =
	 * ResourceBundle.getBundle("languages.language",
	 * FacesContext.getCurrentInstance().getViewRoot().getLocale()); return
	 * bundle; }
	 */
	public void dispararErro(String tituloMensagem, String mensagem) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, tituloMensagem, mensagem);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void dispararMensagem(String tituloMensagem, String mensagem) {

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, tituloMensagem, mensagem);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void dispararAviso(String tituloMensagem, String mensagem) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, tituloMensagem, mensagem);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}