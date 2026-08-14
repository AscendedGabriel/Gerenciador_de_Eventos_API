package br.com.neki_selecao.gerenciador_de_eventos_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.neki_selecao.gerenciador_de_eventos_api.dto.patch.EventoPatchDTO;
import br.com.neki_selecao.gerenciador_de_eventos_api.dto.request.EventoRequestDTO;
import br.com.neki_selecao.gerenciador_de_eventos_api.dto.response.EventoResponseDTO;
import br.com.neki_selecao.gerenciador_de_eventos_api.mapper.EventoMapper;
import br.com.neki_selecao.gerenciador_de_eventos_api.model.Administrador;
import br.com.neki_selecao.gerenciador_de_eventos_api.model.Evento;
import br.com.neki_selecao.gerenciador_de_eventos_api.repository.AdministradorRepository;
import br.com.neki_selecao.gerenciador_de_eventos_api.repository.EventoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EventoService {
	private final EventoRepository eventoRepository;
	private final EventoMapper eventoMapper;
	private final AdministradorRepository adminRepository;
	
	public List<EventoResponseDTO> buscarTodosEventos(){
		List<Evento> eventos = eventoRepository.findAll();
		return eventoMapper.toResponseDTOList(eventos);
	}
	
	public Optional<EventoResponseDTO> buscarEventoPorId(Long id){
		return eventoRepository.findById(id)
				.map(eventoMapper::toResponseDTO);
	}
	
	@Transactional
	public EventoResponseDTO registrarEvento(EventoRequestDTO requestDTO) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		Administrador admin = adminRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Administrador não encontrado"));
		
		Evento eventoNovo = eventoMapper.toEntity(requestDTO);
		eventoNovo.setAdminId(admin);
		Evento eventoSalvo = eventoRepository.save(eventoNovo);
		//System.out.println("ADMIN_ID: " + eventoSalvo.getAdminId().getId());
		return eventoMapper.toResponseDTO(eventoSalvo);
	}
	
	@Transactional
	public Optional<EventoResponseDTO> atualizarEvento(Long id, EventoPatchDTO patchDTO){
		return eventoRepository.findById(id)
				.map(evento -> {
					if(patchDTO.getData() != null) {
						evento.setData(patchDTO.getData());
					}
					if(patchDTO.getLocalizacao() != null) {
						evento.setLocalizacao(patchDTO.getLocalizacao());
					}
					Evento eventoAtualizado = eventoRepository.save(evento);
					return eventoMapper.toResponseDTO(eventoAtualizado);
				});
	}
	
	@Transactional
	public boolean deletarEventoPorId(Long id) {
		return eventoRepository.findById(id)
				.map(evento ->{
					eventoRepository.deleteById(id);
					return true;
				})
				.orElse(false);
	}
}
