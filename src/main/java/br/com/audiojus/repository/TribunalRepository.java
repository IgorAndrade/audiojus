package br.com.audiojus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.audiojus.model.Tribunal;

public interface TribunalRepository extends JpaRepository<Tribunal, Long> {


}
