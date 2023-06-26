package com.ferrari.externalrestapi.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferrari.externalrestapi.externalApi.CharactersRestApi;

@Service
public class CharacterService {
    @Autowired
    private CharactersRestApi charactersRestApi;

    public HashMap<String, Object> getCharacters(){
        return charactersRestApi.getCharacters();
    }

    public HashMap<String, Object> getCharacterById(int id){
        return charactersRestApi.getCharacterById(id);
    }
}
