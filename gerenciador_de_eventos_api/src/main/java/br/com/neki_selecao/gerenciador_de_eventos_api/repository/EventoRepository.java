package br.com.neki_selecao.gerenciador_de_eventos_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.neki_selecao.gerenciador_de_eventos_api.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>{

}
