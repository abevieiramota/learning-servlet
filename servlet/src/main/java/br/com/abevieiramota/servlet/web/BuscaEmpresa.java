package br.com.abevieiramota.servlet.web;

import java.util.Collection;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.abevieiramota.servlet.dao.EmpresaDao;
import br.com.abevieiramota.servlet.model.Empresa;

@WebServlet("/busca")
public class BuscaEmpresa implements Tarefa {
	

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String filtro = req.getParameter("filtro");
		Collection<Empresa> empresas = new EmpresaDao().buscaPorSimilaridade(filtro);
		req.setAttribute("empresas", empresas);
		
		return "/WEB-INF/paginas/buscaEmpresas.jsp";
	}

}
