package br.com.abevieiramota.servlet.dao;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import br.com.abevieiramota.servlet.model.Empresa;

public class EmpresaDao {

	private static Map<Long, Empresa> database = new ConcurrentHashMap<Long, Empresa>();
	private static AtomicLong _id = new AtomicLong();

	static {
		Empresa empresa1 = new Empresa(_id.incrementAndGet(), "Unifor");
		Empresa empresa2 = new Empresa(_id.incrementAndGet(), "Frangolândia");

		database.put(empresa1.getId(), empresa1);
		database.put(empresa2.getId(), empresa2);
	}

	public Collection<Empresa> buscaPorSimilaridade(String filtro) {

		return database.values().stream().filter(p -> p.getNome().startsWith(filtro)).collect(Collectors.toList());
	}

	public void adiciona(String nomeEmpresa) {
		Empresa empresa = new Empresa(_id.incrementAndGet(), nomeEmpresa);
		database.put(empresa.getId(), empresa);
	}

}
