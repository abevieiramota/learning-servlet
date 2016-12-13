package br.com.abevieiramota.servlet.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class Logout extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookieUsuarioLogado = new Cookies(req.getCookies()).buscaUsuarioLogado();
		PrintWriter writer = resp.getWriter();
		if (cookieUsuarioLogado == null) {
			writer.println("<html><body>Usuário não estava logado!</body></html>");
			return;
		}

		cookieUsuarioLogado.setMaxAge(0);
		resp.addCookie(cookieUsuarioLogado);
		writer.println("<html><body>Deslogado com sucesso!</body></html>");
	}
}
