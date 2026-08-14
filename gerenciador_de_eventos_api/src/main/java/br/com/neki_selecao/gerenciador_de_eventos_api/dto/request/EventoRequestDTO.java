package br.com.neki_selecao.gerenciador_de_eventos_api.dto.request;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "DTO de requisição para cadastro, listagem, atualização e exclusão dos eventos")
public class EventoRequestDTO {
	
	@NotBlank(message = "O nome é obrigatório")
	@Schema(description = "Nome do evento", example = "Festa de 15 Anos")
	private String nome;
	
	@NotBlank(message = "A data é obrigatória")
	@Schema(description = "Data do evento", example = "2026-08-14")
	private LocalDate data;
	
	@NotBlank(message = "A localização é obrigatória")
	@Schema(description = "Nome do evento", example = "Casa de Festas Spazio Itanhangá")
	private String localizacao;
	
	@NotBlank(message = "A imagem é obrigatória")
	@Schema(description = "Nome do evento", example = "Casa de Festas Spazio Itanhangá")
	private String imagem;
}
