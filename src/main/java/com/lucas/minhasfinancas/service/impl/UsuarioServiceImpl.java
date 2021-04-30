package com.lucas.minhasfinancas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucas.minhasfinancas.exeption.ErroAutenticacao;
import com.lucas.minhasfinancas.exeption.RegraNegocioException;
import com.lucas.minhasfinancas.model.entity.Lancamento;
import com.lucas.minhasfinancas.model.entity.Usuario;
import com.lucas.minhasfinancas.model.enums.StatusLancamento;
import com.lucas.minhasfinancas.model.repository.UsuarioRepository;
import com.lucas.minhasfinancas.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	private UsuarioRepository repository;
	
	@Autowired
	public UsuarioServiceImpl(UsuarioRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Usuario autenticar(String email, String senha) {
		Optional<Usuario> usuario = repository.findByEmail(email);
		
		if(usuario.isPresent()) {
			throw new ErroAutenticacao("Ussário não encontrado para o email informado.");
		}
		
		if(!usuario.get().getSenha().equals(senha)) {
			throw new ErroAutenticacao("Senha inválida.");
		}
		
		
		return usuario.get();
	}

	@Override
	@Transactional
	public Usuario salvarUsuario(Usuario usuario) {
		validarEmail(usuario.getEmail());
		return repository.save(usuario);
	}

	@Override
	public void validarEmail(String email) {
		boolean existe = repository.existsByEmail(email);
		if(existe) {
			throw new RegraNegocioException("Já existe um usuário cadastrado com esse email.");
		}
	}

	@Override
	public Optional<Usuario> obterPorId(Long id) {
		return repository.findById(id);
	}

	@Override
	public void validar(Lancamento lancamento) {
		// TODO Auto-generated method stub
		
	}

	public Lancamento salvar1(Lancamento lancamentoASalvar) {
		return lancamentoASalvar;
		// TODO Auto-generated method stub
		
	}

	public Lancamento salvar(Lancamento lancamentoASalvar) {
		// TODO Auto-generated method stub
		return null;
	}

	public void atualizar(Lancamento lancamentoSalvo) {
		// TODO Auto-generated method stub
		
	}

	public void deletar(Lancamento lancamento) {
		// TODO Auto-generated method stub
		
	}

	public List<Lancamento> buscar(Lancamento lancamento) {
		// TODO Auto-generated method stub
		return null;
	}

	public void atualizarStatus(Lancamento lancamento, StatusLancamento novoStatus) {
		// TODO Auto-generated method stub
		
	}
	
}
