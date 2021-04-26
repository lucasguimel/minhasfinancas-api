package com.lucas.minhasfinancas.service;

import com.lucas.minhasfinancas.model.entity.Lancamento;
import com.lucas.minhasfinancas.model.entity.Usuario;

public interface UsuarioService {
	
	Usuario autenticar(String email, String senha);
	
	Usuario salvarUsuario(Usuario usuario);
	
	void validarEmail(String email);
	
	void validar(Lancamento lancamento);
}
