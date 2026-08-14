package br.com.neki_selecao.gerenciador_de_eventos_api.model;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "administrador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Entidade que representa os administradores registrados no sistema")
public class Administrador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admi_cd_id")
	@Schema(description = "ID único do administrador", example = "1")
	private Long id;
	
	@Column(name = "admi_tx_nome", nullable = false, length = 50)
	@Schema(description = "Nome do administrador", example = "João Carlos")
	private String nome;
	
	@Column(name = "admi_tx_email", nullable = false, length = 50)
	@Schema(description = "E-mail do administrador", example = "jcarlos@gmail.com")
	private String email;
	
	@Column(name = "admi_tx_senha", nullable = false, length = 255)
	@Schema(description = "Senha do administrador", example = "carlos1234")
	private String senha;
	
	@OneToMany(mappedBy = "adminId",fetch = FetchType.LAZY)
	@Schema(description = "ID dos eventos dos quais esse administrador é responsável ")
	private List<Evento> eventoId;
	
}
