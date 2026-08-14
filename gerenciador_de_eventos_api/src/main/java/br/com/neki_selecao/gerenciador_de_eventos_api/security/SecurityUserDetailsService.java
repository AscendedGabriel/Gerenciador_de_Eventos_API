package br.com.neki_selecao.gerenciador_de_eventos_api.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.neki_selecao.gerenciador_de_eventos_api.model.Administrador;
import br.com.neki_selecao.gerenciador_de_eventos_api.repository.AdministradorRepository;

@Service
public class SecurityUserDetailsService implements UserDetailsService{
	
	private final AdministradorRepository adminRepository;
	
	public SecurityUserDetailsService(AdministradorRepository adminRepository) {
		this.adminRepository = adminRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
		Administrador admin = adminRepository.findByEmail(email)
			.orElseThrow(() -> new UsernameNotFoundException("Administrador não encontrado"));
		
		return org.springframework.security.core.userdetails.User
				.withUsername(admin.getEmail())
				.password(admin.getSenha()).roles("ADMIN")
				.build();
	}
}
