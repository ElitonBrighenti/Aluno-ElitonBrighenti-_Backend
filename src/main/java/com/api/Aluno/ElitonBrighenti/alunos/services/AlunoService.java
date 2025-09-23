package com.api.Aluno.ElitonBrighenti.alunos.services;


import com.api.Aluno.ElitonBrighenti.alunos.dtos.AlunoDto;
import com.api.Aluno.ElitonBrighenti.alunos.models.AlunoModel;
import com.api.Aluno.ElitonBrighenti.alunos.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public AlunoModel create(AlunoDto dto) {
        AlunoModel aluno = new AlunoModel();
        aluno.setNome(dto.getNome());
        aluno.setCurso(dto.getCurso());
        aluno.setTelefone(dto.getTelefone());
        return alunoRepository.save(aluno);
    }

    public List<AlunoModel> listar() {
        return alunoRepository.findAll();
    }

    public AlunoModel atualizar(AlunoDto dto, UUID id) {
        AlunoModel existente = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        existente.setNome(dto.getNome());
        existente.setCurso(dto.getCurso());
        existente.setTelefone(dto.getTelefone());

        return alunoRepository.save(existente);
    }

    public void deletar(UUID id) {
        AlunoModel existente = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        alunoRepository.deleteById(existente.getId());
    }

    public List<AlunoModel> buscarPorNome(String nomeBusca) {
        return alunoRepository.findByNomeContainingIgnoreCase(nomeBusca);
    }
    public Optional<AlunoModel> buscarPorId(UUID id) {
        return alunoRepository.findById(id);
    }

}
