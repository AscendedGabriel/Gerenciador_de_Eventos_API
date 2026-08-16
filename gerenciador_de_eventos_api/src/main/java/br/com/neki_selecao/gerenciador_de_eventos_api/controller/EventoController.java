package br.com.neki_selecao.gerenciador_de_eventos_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.neki_selecao.gerenciador_de_eventos_api.dto.patch.EventoPatchDTO;
import br.com.neki_selecao.gerenciador_de_eventos_api.dto.request.EventoRequestDTO;
import br.com.neki_selecao.gerenciador_de_eventos_api.dto.response.EventoResponseDTO;
import br.com.neki_selecao.gerenciador_de_eventos_api.service.EventoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/eventos")
@RequiredArgsConstructor
@Tag(name = "Eventos", description = "Responsável pela gestão dos eventos")
@SecurityRequirement(name = "bearerAuth")
public class EventoController {
	
	private final EventoService eventoService;
	
	@GetMapping()
	@Operation(summary = "Listar todos os eventos", description = "Retorna a lista completa dos eventos cadastrados.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista dos eventos retornada com sucesso")
    })
	public ResponseEntity<List<EventoResponseDTO>> listarTodosEventos(){
		List<EventoResponseDTO> eventos = eventoService.buscarTodosEventos();
		return ResponseEntity.ok(eventos);
	}
	
	@GetMapping("/{id}")
    @Operation(summary = "Obter dados de um evento", description = "Retorna dados de um evento.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Evento encontrado"),
            @ApiResponse(responseCode = "404", description = "Evento não encontrado")
    })
	public ResponseEntity<EventoResponseDTO> listarEventoPorId(@PathVariable Long id){
		return eventoService.buscarEventoPorId(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/registrar")
	@Operation(summary = "Registrar dados de um evento", description = "Registra os dados de um evento e o admin responsável baseado em quem está logado no momento do registro.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Evento registrado"),
            @ApiResponse(responseCode = "404", description = "Evento não encontrado")
    })
	public ResponseEntity<EventoResponseDTO> registrarEvento(@RequestBody EventoRequestDTO requestDTO){
		EventoResponseDTO eventoResponse = eventoService.registrarEvento(requestDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(eventoResponse);
	}
	
	
	@PatchMapping("/{id}")
	@Operation(summary = "Atualizar dados de um evento", description = "Atualiza a data e a localiação de um evento.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Evento atualizado"),
            @ApiResponse(responseCode = "404", description = "Evento não encontrado")
    })
	public ResponseEntity<EventoResponseDTO> atualizarEvento(@PathVariable Long id, @RequestBody EventoPatchDTO patchDTO){
		return eventoService.atualizarEvento(id, patchDTO)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Deletar dados de um evento", description = "Deleta os dados de um evento expecífico.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Evento deletado"),
            @ApiResponse(responseCode = "404", description = "Evento não encontrado")
    })
	public ResponseEntity<Void> apagarEvento(@PathVariable Long id) {
		boolean apagado = eventoService.deletarEventoPorId(id);
		return apagado ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
	}
	
}
