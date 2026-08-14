package br.com.neki_selecao.gerenciador_de_eventos_api.model;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "evento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Entidade que representa os eventos registrados")
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "even_cd_id")
	@Schema(description = "ID único do evento", example = "1")
	private Long id;
	
	@Column(name = "even_tx_nome", nullable = false, length = 50)
	@Schema(description = "Nome do evento", example = "Festa de 15 Anos")
	private String nome;
	
	@Column(name = "even_dt_data", nullable = false)
	@Schema(description = "Data do evento", example = "2026-08-14")
	private LocalDate data;
	
	@Column(name = "even_tx_localizacao", nullable = false, length = 80)
	@Schema(description = "Nome do evento", example = "Petrópolis-RJ")
	private String localizacao;
	
	@Column(name = "even_img_imagem", nullable = false, length = 80)
	@Schema(description = "Nome do evento", example = "{URL da imagem}")
	private String imagem;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "admi_cd_id", nullable = false)
	@Schema(description = "ID do administrador responsável por esse evento")
	private Administrador adminId;
}
