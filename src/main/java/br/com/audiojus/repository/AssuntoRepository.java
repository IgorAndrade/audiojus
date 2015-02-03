package br.com.audiojus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.audiojus.model.Assunto;
import br.com.audiojus.model.Sumula;

public interface AssuntoRepository extends JpaRepository<Assunto, Long> {


}
