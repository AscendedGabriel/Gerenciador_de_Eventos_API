package br.com.neki_selecao.gerenciador_de_eventos_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.neki_selecao.gerenciador_de_eventos_api.dto.request.AdministradorRequestDTO;
import br.com.neki_selecao.gerenciador_de_eventos_api.dto.response.AdministradorResponseDTO;
import br.com.neki_selecao.gerenciador_de_eventos_api.service.AdministradorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/administrador")
@RequiredArgsConstructor
@Tag(name = "Administradores", description = "Responsável pela gestão dos administradores")
@SecurityRequirement(name = "bearerAuth")
public class AdministradorController {
	
private final AdministradorService adminService;
	
	@GetMapping()
	@Operation(summary = "Listar todos os administradores", description = "Retorna a lista completa de administradores registrados.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista dos administradores retornada com sucesso")
    })
	public ResponseEntity<List<AdministradorResponseDTO>> listarTodosAdministradores(){
		List<AdministradorResponseDTO> admins = adminService.buscarTodosAdmins();
		return ResponseEntity.ok(admins);
	}
	
	@GetMapping("/{id}")
    @Operation(summary = "Obter dados de um administrador", description = "Retorna dados de um administrador.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Administrador encontrado"),
            @ApiResponse(responseCode = "404", description = "Administrador não encontrado")
    })
	public ResponseEntity<AdministradorResponseDTO> listarAdministradorPorId(@PathVariable Long id){
		return adminService.buscarAdminPorId(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping()
	@Operation(summary = "Atualizar os dados de um administrador", description = "Atualiza os dados de um administrador específico.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Administrador atualizado"),
            @ApiResponse(responseCode = "404", description = "Administrador não encontrado")
    })
	public ResponseEntity<AdministradorResponseDTO> registrarAdministrador(@RequestBody AdministradorRequestDTO requestDTO){
		AdministradorResponseDTO adminResponse = adminService.registrarAdmin(requestDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(adminResponse);
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Deletar os dados de um administrador", description = "Deleta os dados de um administrador específico.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Administrador deletado"),
            @ApiResponse(responseCode = "404", description = "Administrador não encontrado")
    })
	public ResponseEntity<Void> apagarAdministrador(@PathVariable Long id) {
		boolean apagado = adminService.deletarAdminPorId(id);
		return apagado ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
	}
}
