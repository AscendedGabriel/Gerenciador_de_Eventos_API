package br.com.neki_selecao.gerenciador_de_eventos_api.dto.patch;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "DTO de requisição para atualização parcial dos eventos")
public class EventoPatchDTO {
	
	@NotBlank(message = "É obrigatório preencher a data")
	@Schema(description = "Data do evento", example = "2026-08-14")
	private LocalDate data;
	
	@NotBlank(message = "É obrigatório preencher a localização")
	@Schema(description = "Nome do evento", example = "Casa de Festas Spazio Itanhangá")
	private String localizacao;
}
