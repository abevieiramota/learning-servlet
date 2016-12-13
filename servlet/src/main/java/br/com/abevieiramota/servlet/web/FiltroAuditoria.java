package br.com.abevieiramota.servlet.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class FiltroAuditoria implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		String usuario = getUsuario(req);

		System.out.println("Usuário " + usuario + " acessando " + uri);

		chain.doFilter(request, response);
	}

	private String getUsuario(HttpServletRequest req) {
		Cookie cookie = new Cookies(req.getCookies()).buscaUsuarioLogado();
		return cookie == null ? "deslogado" : cookie.getValue();
	}

	@Override
	public void destroy() {
	}

}
