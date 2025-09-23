package com.api.Aluno.ElitonBrighenti.alunos.repository;

import com.api.Aluno.ElitonBrighenti.alunos.models.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AlunoRepository extends JpaRepository<AlunoModel, UUID> {

    // Busca alunos cujo nome contenha o valor informado (ignora maiúsculas/minúsculas)
    List<AlunoModel> findByNomeContainingIgnoreCase(String nome);
}