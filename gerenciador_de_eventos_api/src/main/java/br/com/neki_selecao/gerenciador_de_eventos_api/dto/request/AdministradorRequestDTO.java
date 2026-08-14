package br.com.neki_selecao.gerenciador_de_eventos_api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "DTO de requisição para cadastro e atualização do administrador de eventos")
public class AdministradorRequestDTO {
	
	@NotBlank(message = "O nome é obrigatório")
	@Schema(description = "Nome do administrador", example = "Jerson Moura", requiredMode = Schema.RequiredMode.REQUIRED)
	private String nome;
	
	@NotBlank(message = "O e-mail é obrigatório")
	@Email(message = "E-mail inválido")
	@Schema(description = "E-mail do administrador", example = "jersonMoura@gmail.com", requiredMode = Schema.RequiredMode.REQUIRED)
	private String email;
	
	@NotBlank(message = "A senha é obrigatória")
	@Schema(description = "Senha do administrador", example = "jerson1234", requiredMode = Schema.RequiredMode.REQUIRED)
	private String senha;

}
