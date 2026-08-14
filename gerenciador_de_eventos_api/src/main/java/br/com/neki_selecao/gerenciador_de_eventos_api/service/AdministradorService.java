package br.com.neki_selecao.gerenciador_de_eventos_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.neki_selecao.gerenciador_de_eventos_api.dto.request.AdministradorRequestDTO;
import br.com.neki_selecao.gerenciador_de_eventos_api.dto.response.AdministradorResponseDTO;
import br.com.neki_selecao.gerenciador_de_eventos_api.mapper.AdministradorMapper;
import br.com.neki_selecao.gerenciador_de_eventos_api.model.Administrador;
import br.com.neki_selecao.gerenciador_de_eventos_api.repository.AdministradorRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdministradorService {
	private final AdministradorRepository adminRepository;
	private final AdministradorMapper adminMapper;
	private final PasswordEncoder passwordEncoder;
	
	public List<AdministradorResponseDTO> buscarTodosAdmins(){
		List<Administrador> administradores = adminRepository.findAll();
		return adminMapper.toResponseDTOList(administradores);
	}
	
	public Optional<AdministradorResponseDTO> buscarAdminPorId(Long id){
		return adminRepository.findById(id)
				.map(adminMapper::toResponseDTO);
	}
	
	@Transactional
	public AdministradorResponseDTO registrarAdmin(AdministradorRequestDTO requestDTO) {
		Administrador adminNovo = adminMapper.toEntity(requestDTO);
		adminNovo.setSenha(passwordEncoder.encode(adminNovo.getSenha()));
		Administrador adminSalvo = adminRepository.save(adminNovo);
		return adminMapper.toResponseDTO(adminSalvo);
	}
	
	@Transactional
	public Optional<AdministradorResponseDTO> atualizarAdmin(Long id, AdministradorRequestDTO requestDTO){
		return adminRepository.findById(id)
				.map(administrador -> {
					adminMapper.updateEntityFromDTO(requestDTO, administrador);
					administrador.setId(id);
					Administrador adminAtualizado = adminRepository.save(administrador);
					return adminMapper.toResponseDTO(adminAtualizado);
		});
	}
	
	@Transactional
	public boolean deletarAdminPorId(Long id) {
		return adminRepository.findById(id)
				.map(administrador ->{
					adminRepository.deleteById(id);
					return true;
				})
				.orElse(false);
	}
}
