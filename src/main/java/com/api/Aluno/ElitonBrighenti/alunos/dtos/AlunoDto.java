package com.api.Aluno.ElitonBrighenti.alunos.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AlunoDto {

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, message = "O nome deve ter pelo menos 3 caracteres")
    private String nome;

    @NotBlank(message = "O curso é obrigatório")
    @Size(min = 3, message = "O curso deve ter pelo menos 3 caracteres")
    private String curso;

    private String telefone;
}
