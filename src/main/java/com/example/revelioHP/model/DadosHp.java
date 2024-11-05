package com.example.revelioHP.model;

//Aqui é onde declaro os dados que eu gostaria de pegar e uso o @JsonAlias para pegar dados
//da API que estão definidos com 'declarações' diferentes EX: 'name' -> vai virar minha string nome


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosHp(
                      @JsonAlias("name") String nome,
                      @JsonAlias("house") String casa,
                      @JsonAlias("patronus") String patrono,
                      @JsonAlias("ancestry") String ancestralidade) {}
