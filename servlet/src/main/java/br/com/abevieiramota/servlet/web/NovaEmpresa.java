package br.com.abevieiramota.servlet.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.abevieiramota.servlet.dao.EmpresaDao;
import br.com.abevieiramota.servlet.model.Empresa;

@WebServlet("/novaEmpresa")
public class NovaEmpresa extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		new EmpresaDao().adiciona(nome);
		PrintWriter writer = resp.getWriter();
		writer.println("<html><body>Empresa adicionada com sucesso: " + nome + "</body></html>");
	}
}
