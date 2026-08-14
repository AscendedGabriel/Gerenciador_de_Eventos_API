package br.com.neki_selecao.gerenciador_de_eventos_api.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import br.com.neki_selecao.gerenciador_de_eventos_api.dto.request.AdministradorRequestDTO;
import br.com.neki_selecao.gerenciador_de_eventos_api.dto.response.AdministradorResponseDTO;
import br.com.neki_selecao.gerenciador_de_eventos_api.model.Administrador;

@Mapper(componentModel = "spring")
public interface AdministradorMapper {
	
	AdministradorResponseDTO toResponseDTO(Administrador administrador);
	
	List<AdministradorResponseDTO> toResponseDTOList(List<Administrador> administradores);
	
	@Mapping(target = "id", ignore = true)
	Administrador toEntity(AdministradorRequestDTO requestDTO);
	
	@Mapping(target = "id", ignore = true)
	void updateEntityFromDTO(AdministradorRequestDTO requestDTO, @MappingTarget Administrador administrador);
}
