package br.com.neki_selecao.gerenciador_de_eventos_api.security;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import br.com.neki_selecao.gerenciador_de_eventos_api.dto.request.LoginRequestDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthenticationManager authenticationManager;
	private final JwtService jwtService;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginRequestDTO request) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						request.getEmail(), request.getSenha())
				);
		String token = jwtService.generateToken((org.springframework.security.core.userdetails.UserDetails)
				authentication.getPrincipal());
		return ResponseEntity.ok(token);
	}
}
