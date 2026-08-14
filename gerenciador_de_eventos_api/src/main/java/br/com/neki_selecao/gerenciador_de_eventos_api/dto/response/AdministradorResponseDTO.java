package br.com.neki_selecao.gerenciador_de_eventos_api.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "DTO de resposta com os dados do administrador de eventos")
public class AdministradorResponseDTO {
	
	@Schema(description = "ID único do administrador", example = "1")
	private Long id;
	
	@Schema(description = "Nome do administrador", example = "Jerson Moura")
	private String nome;
	
	@Schema(description = "E-mail do administrador", example = "jersonMoura@gmail.com")
	private String email;
}
