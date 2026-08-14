package br.com.neki_selecao.gerenciador_de_eventos_api.dto.response;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "DTO de resposta com os dados dos eventos")
public class EventoResponseDTO {
	
	@Schema(description = "Nome do evento", example = "Festa de 15 Anos")
	private String nome;
	
	@Schema(description = "Data do evento", example = "2026-08-14")
	private LocalDate data;
	
	@Schema(description = "Nome do evento", example = "Casa de Festas Spazio Itanhangá")
	private String localizacao;
	
	@Schema(description = "Nome do evento", example = "Casa de Festas Spazio Itanhangá")
	private String imagem;
	
	@Schema(description = "Identificador do administrador responsável pelo evento", example = "1")
	private Long adminId;
}
