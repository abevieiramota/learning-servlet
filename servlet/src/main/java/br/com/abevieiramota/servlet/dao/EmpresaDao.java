package br.com.abevieiramota.servlet.dao;

import java.util.Arrays;
import java.util.Collection;

import br.com.abevieiramota.servlet.model.Empresa;

public class EmpresaDao {

	public Collection<Empresa> buscaPorSimilaridade(String filtro) {
		Empresa empresa1;
		Empresa empresa2;
		if ("doceria".equals(filtro)) {
			empresa1 = new Empresa(1l, "Unifor");
			empresa2 = new Empresa(2l, "Frangolândia");
		} else {
			empresa1 = new Empresa(3l, "Carlomano Lojas");
			empresa2 = new Empresa(4l, "Iguatemi");
		}

		return Arrays.asList(empresa1, empresa2);
	}

}
