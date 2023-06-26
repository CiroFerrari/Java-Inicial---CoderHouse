package com.ferrari.externalrestapi.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferrari.externalrestapi.service.CharacterService;

@RestController
@RequestMapping("/api/v1/characters")
public class CharactersController {
    @Autowired
    private CharacterService charactersService;

    @GetMapping
    public ResponseEntity<HashMap<String, Object>> getCharacters(){
        var characters = charactersService.getCharacters();
        return ResponseEntity.ok(characters);
    }

    @GetMapping(path = "{characterId}")
    public ResponseEntity<HashMap<String, Object>> getCharacters(@PathVariable("characterId") Integer id){
        var characters = charactersService.getCharacterById(id);
        return ResponseEntity.ok(characters);
    }
}
