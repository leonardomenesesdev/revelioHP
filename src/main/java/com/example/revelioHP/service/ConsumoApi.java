package com.example.revelioHP.service;
//Revisando conceitos --- Essa classe (ConsumoApi) serve para o meu código realizar a leitura da url,
//fazer a busca e obter os dados em json.
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {
    public String obterDados(String endereco){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = null;
        try{
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        }catch (IOException | InterruptedException e){
            throw new RuntimeException(e);
        }
        String json = response.body();
        return json;
    }
}
