package com.example.revelioHP.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;

//Aqui é onde vou criar o obterLista para conseguir uma lista do formato que eu quero

public class ConverteDados implements ConverteDadosInterface {
    private ObjectMapper mapper = new ObjectMapper(); //Similar ao from gson/to gson

    @Override
    public <T> List<T> obterLista(String json, Class<T> classe) {
        CollectionType listaPersonagens = mapper.getTypeFactory()
                .constructCollectionType(List.class, classe);
        try{
            return mapper.readValue(json, listaPersonagens);
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }
}
