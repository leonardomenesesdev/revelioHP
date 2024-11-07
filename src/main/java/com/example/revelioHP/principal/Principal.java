package com.example.revelioHP.principal;

import com.example.revelioHP.model.DadosFeiticos;
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
    private final String URL_Base = "https://hp-api.onrender.com/api/";
    public void roda(){
        while(true) {
            System.out.println("****MENU****");
            System.out.println("1 - Pesquisar personagem");
            System.out.println("2 - Pesquisar feitiços");
            System.out.println("3 - Encerrar menu");
            System.out.println("************");
            int escolha = sc.nextInt();
            sc.nextLine();
            if (escolha == 1) {
                System.out.println("Insira o nome do personagem desejado: ");
                String nome = sc.nextLine();
                var json = consumoApi.obterDados(URL_Base+"characters");
                var personagens = converteDados.obterLista(json, DadosHp.class);
                List<DadosHp> personagemFiltrado = personagens
                        .stream().filter(p -> p.nome().toLowerCase().contains(nome.toLowerCase()))
                        .collect(Collectors.toList());
                if(personagemFiltrado.size()==0){
                    System.out.println("Personagem não encontrado");
                }
                personagemFiltrado.stream()
                        .forEach(p -> System.out.println("Nome: " + p.nome() + " - Casa: " + p.casa() + " - Patrono: " + p.patrono() +
                                " - Ancestralidade: " + p.ancestralidade()));
            }
            if (escolha == 2) {
                System.out.println("Insira o nome do feitiço desejado: ");
                String feiticoProcurado = sc.nextLine();
                var json = consumoApi.obterDados(URL_Base+"spells");
                var feitico = converteDados.obterLista(json, DadosFeiticos.class);
                List<DadosFeiticos> feiticosEncontrados = feitico.stream()
                        .filter(f -> f.nome().toLowerCase().contains(feiticoProcurado.toLowerCase()))
                        .collect(Collectors.toList());
                if(feiticosEncontrados.size()==0){
                    System.out.println("Feitiço não encontrado!");
                }
                feiticosEncontrados.stream()
                        .forEach(f -> System.out.println("Feitiço: " + f.nome() + " - Função: " + f.descricao()));
            }
            if (escolha == 3) {
                break;
            }
            if (escolha!=1||escolha!=2||escolha!=3){
                System.out.println("Opção inválida, tente outra!");
            }
        }
    }
}
