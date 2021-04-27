package com.lucas.minhasfinancas.model.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lucas.minhasfinancas.model.entity.Lancamento;
import com.lucas.minhasfinancas.model.enums.TipoLancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{
	
	@Query(value = 
			  "select sum(1.valor) from Lancamento 1 join 1.usuario u "
			+ "where u.id = :idUsuario and 1.tipo =:tipo group by u")
	BigDecimal obterSaldoPorTipoLancamentoEUsuario( 
			@Param("idUsuario") Long idUsuario, 
			@Param("tipo") TipoLancamento tipo );
	
}
