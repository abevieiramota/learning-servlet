package br.com.abevieiramota.servlet.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.abevieiramota.servlet.dao.UsuarioDao;
import br.com.abevieiramota.servlet.model.Usuario;

@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		Usuario usuario = new UsuarioDao().busca(email, senha);

		PrintWriter writer = resp.getWriter();
		writer.print("<html><body>");
		if (usuario == null) {
			writer.print("Usuário não encontrado");
		} else {
			writer.print("Usuário logado: " + email);
			Cookie cookie = new Cookie("usuario.logado", email);
			// dura 10 segundos
			cookie.setMaxAge(10);
			resp.addCookie(cookie);
		}
		writer.print("</body></html>");
	}
}
