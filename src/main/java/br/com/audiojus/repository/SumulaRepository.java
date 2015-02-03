package br.com.audiojus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.audiojus.model.Assunto;
import br.com.audiojus.model.Sumula;
import br.com.audiojus.model.Tribunal;

public interface SumulaRepository extends JpaRepository<Sumula, Long> {

	@Query("Select sumula from Sumula sumula join sumula.assuntos assunto where assunto = :assunto")
	public List<Sumula> findByAssunto(@Param("assunto") Assunto assunto);
	@Query("Select sumula from Sumula sumula join sumula.tribunal tribunal where tribunal = :tribunal")
	public List<Sumula> findByTribunal(@Param("tribunal") Tribunal tribunal);
}
