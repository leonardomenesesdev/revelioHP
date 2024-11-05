package com.example.revelioHP.principal;

import com.example.revelioHP.model.DadosHp;
import com.example.revelioHP.service.ConsumoApi;
import com.example.revelioHP.service.ConverteDados;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    Scanner sc = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();
    private final String URL_Base = "https://hp-api.onrender.com/api/characters";
    public void roda(){
        System.out.println("Insira o nome do personagem desejado: ");
        String nome = sc.nextLine();
        var json = consumoApi.obterDados(URL_Base);
        var personagens = converteDados.obterLista(json, DadosHp.class);
        List<DadosHp> personagemFiltrado = personagens
                .stream().filter(p -> p.nome().toLowerCase().contains(nome.toLowerCase()))
                .collect(Collectors.toList());
        personagemFiltrado.stream()
                .forEach(p -> System.out.println("Nome: "+p.nome()+" - Casa: "+p.casa()+" - Patrono: "+p.patrono()+
                        " - Ancestralidade: "+p.ancestralidade()));
    }
}
