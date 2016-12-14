package br.com.abevieiramota.servlet.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.abevieiramota.servlet.dao.UsuarioDao;
import br.com.abevieiramota.servlet.model.Usuario;

public class Login implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		Usuario usuario = new UsuarioDao().busca(email, senha);

		if (usuario != null) {
			HttpSession session = req.getSession();
			session.setAttribute("usuarioLogado", usuario);
		}

		return "/WEB-INF/paginas/login.jsp";
	}
}
