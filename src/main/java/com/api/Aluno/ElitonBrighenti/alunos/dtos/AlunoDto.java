package com.api.Aluno.ElitonBrighenti.alunos.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AlunoDto {

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotBlank(message = "O curso é obrigatório")
    @Size(min = 3, max = 100, message = "O curso deve ter entre 3 e 100 caracteres")
    private String curso;

    @Size(max = 20, message = "O telefone não pode passar de 20 caracteres")
    private String telefone;
}
