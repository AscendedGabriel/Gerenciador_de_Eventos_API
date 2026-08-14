package br.com.neki_selecao.gerenciador_de_eventos_api.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDTO {
	
	private String email;
	private String senha;
}
