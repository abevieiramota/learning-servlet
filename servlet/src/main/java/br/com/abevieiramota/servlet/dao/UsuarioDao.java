package br.com.abevieiramota.servlet.dao;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import br.com.abevieiramota.servlet.model.Usuario;

public class UsuarioDao {

	private static Map<Long, Usuario> database = new ConcurrentHashMap<Long, Usuario>();
	private static AtomicLong _id = new AtomicLong();

	static {
		Usuario usuario = new Usuario(_id.getAndIncrement(), "abevieiramota@gmail.com", "123456");
		database.put(usuario.getId(), usuario);
	}

	public Usuario busca(String email, String senha) {
		
		for(Usuario usuario: database.values()) {
			if(usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
				return usuario;
			}
		}
		
		return null;
	}

}
