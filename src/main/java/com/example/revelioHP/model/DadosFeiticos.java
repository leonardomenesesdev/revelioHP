package com.example.revelioHP.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosFeiticos(
        @JsonAlias("name") String nome,
        @JsonAlias("description") String descricao
) {
}
