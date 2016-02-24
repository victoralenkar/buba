package org.br.victorhaus.buffett.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	public LoginFilter() {
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hreq = (HttpServletRequest) request;
		HttpServletResponse hresp = (HttpServletResponse) response;
		HttpSession session = hreq.getSession();

		hreq.getPathInfo();
		String paginaAtual = new String(hreq.getRequestURL());

		String user = null;
		if (((UsuarioLogado) session.getAttribute("usuarioLogado")) != null) {
			user = ((UsuarioLogado) session.getAttribute("usuarioLogado")).getLogin();
		}
		if (paginaAtual.contains("/admin")) {
			hresp.sendRedirect(((HttpServletRequest) request).getContextPath() + "/view/login.xhtml");
			return;
		}
		if (paginaAtual != null && paginaAtual != null && !paginaAtual.endsWith("/") && !paginaAtual.contains("/view/login.xhtml")
				&& !paginaAtual.contains("/view/sessaoExpirada.xhtml") && !paginaAtual.contains("/view/tokenInvalido.xhtml")
				&& !paginaAtual.contains("javax.faces.resource")) {
			if ((user == null) || (user.equals(""))) {
				session.setAttribute("expired", "true");
				String contextPath = ((HttpServletRequest) request).getContextPath();
				hresp.sendRedirect(contextPath + "/view/sessaoExpirada.xhtml");
				return;
			}
		}
		chain.doFilter(request, response);
	}
}
