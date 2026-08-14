package br.com.neki_selecao.gerenciador_de_eventos_api.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import br.com.neki_selecao.gerenciador_de_eventos_api.dto.request.EventoRequestDTO;
import br.com.neki_selecao.gerenciador_de_eventos_api.dto.response.EventoResponseDTO;
import br.com.neki_selecao.gerenciador_de_eventos_api.model.Evento;

@Mapper(componentModel = "spring")
public interface EventoMapper {
	
	@Mapping(source = "adminId.id", target = "adminId")
	EventoResponseDTO toResponseDTO(Evento evento);
	
	List<EventoResponseDTO> toResponseDTOList(List<Evento> eventos);
	
	@Mapping(target = "id", ignore = true)
	Evento toEntity(EventoRequestDTO requestDTO);
	
	@Mapping(target = "id", ignore = true)
	void updateEntityFromDTO(EventoRequestDTO requestDTO, @MappingTarget Evento evento);
}
