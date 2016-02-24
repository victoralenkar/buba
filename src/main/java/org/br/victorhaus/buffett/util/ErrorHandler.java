package org.br.victorhaus.buffett.util;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class ErrorHandler {

	public String getStatusCode() {
		String val = String.valueOf((Integer) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("javax.servlet.error.status_code"));
		return val;
	}

	public String getMessage() {
		String val = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("javax.servlet.error.message");
		return val;
	}

	public String getExceptionType() {
		Object obj = (Object) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("javax.servlet.error.exception_type");
		String val = "Não informado";
		if (obj != null) {
			val = obj.toString();
		}
		return val;
	}

	public String getException() {
		Exception e = (Exception) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("javax.servlet.error.exception");
		String val = "Não informado";
		if (e != null) {
			val = e.toString();
		}
		return val;
	}

	public String getRequestURI() {
		return (String) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("javax.servlet.error.request_uri");
	}

	public String getServletName() {
		return (String) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("javax.servlet.error.servlet_name");
	}

}