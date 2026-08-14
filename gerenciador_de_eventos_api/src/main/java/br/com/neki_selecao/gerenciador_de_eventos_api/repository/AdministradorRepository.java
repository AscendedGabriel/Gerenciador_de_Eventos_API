package br.com.neki_selecao.gerenciador_de_eventos_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.neki_selecao.gerenciador_de_eventos_api.model.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long>{
	
	Optional<Administrador> findByEmail(String email);
}
