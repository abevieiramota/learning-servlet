package br.com.abevieiramota.servlet.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.abevieiramota.servlet.dao.EmpresaDao;
import br.com.abevieiramota.servlet.model.Empresa;

public class NovaEmpresa implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String nome = req.getParameter("nome");
		Empresa empresa = new EmpresaDao().adiciona(nome);

		req.setAttribute("empresa", empresa);
		return "/WEB-INF/paginas/novaEmpresa.jsp";
	}
}
