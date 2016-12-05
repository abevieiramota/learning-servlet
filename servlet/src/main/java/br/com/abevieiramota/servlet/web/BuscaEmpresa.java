package br.com.abevieiramota.servlet.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.abevieiramota.servlet.dao.EmpresaDao;
import br.com.abevieiramota.servlet.model.Empresa;

@WebServlet("/busca")
public class BuscaEmpresa extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.println("<html><body>");
		writer.println("resultado da busca:<br />");
		String filtro = req.getParameter("filtro");
		Collection<Empresa> empresas = new EmpresaDao().buscaPorSimilaridade(filtro);
		writer.println("<ul>");
		for (Empresa empresa : empresas) {
			writer.println("<li>" + empresa.getId() + ":" + empresa.getNome() + "</li>");
		}
		writer.println("</ul>");
		writer.println("</body></html>");
	}
}
