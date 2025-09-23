package com.api.Aluno.ElitonBrighenti.alunos.controllers;

import com.api.Aluno.ElitonBrighenti.alunos.dtos.AlunoDto;
import com.api.Aluno.ElitonBrighenti.alunos.models.AlunoModel;
import com.api.Aluno.ElitonBrighenti.alunos.services.AlunoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/listar")
    public List<AlunoModel> listar() {
        return alunoService.listar();
    }

    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(
            @RequestBody @Valid AlunoDto dto) {
        AlunoModel alunoSalvo = alunoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoSalvo);
    }

    @PostMapping("/editar/{id}")
    public ResponseEntity<?> editar(
            @RequestBody @Valid AlunoDto dto,
            @PathVariable(value = "id") UUID id
    ) {
        try {
            AlunoModel alunoEditado = alunoService.atualizar(dto, id);
            return ResponseEntity.status(HttpStatus.CREATED).body(alunoEditado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro: " + e.getMessage());
        }
    }

    @PostMapping("/apagar/{id}")
    public ResponseEntity<String> apagar(@PathVariable UUID id) {
        try {
            alunoService.deletar(id);
            return ResponseEntity.ok("Aluno apagado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Deu ruim: " + e.getMessage());
        }
    }

    @GetMapping("/buscar")
    public List<AlunoModel> buscar(@RequestParam String nomeBusca) {
        return alunoService.buscarPorNome(nomeBusca);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AlunoModel> buscarPorId(@PathVariable UUID id) {
        return alunoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
