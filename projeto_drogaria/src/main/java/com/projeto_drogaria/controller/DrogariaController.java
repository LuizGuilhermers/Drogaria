package com.projeto_drogaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.projeto_drogaria.entities.Drogaria;
import com.projeto_drogaria.service.DrogariaService;

public class DrogariaController {
 
private final DrogariaService drogariaService;
	
	@Autowired
	public DrogariaController (DrogariaService drogariaService) {
		this.drogariaService = drogariaService;
	}
	
    @PostMapping("/")
    public ResponseEntity<Drogaria> criarDrogaria(@RequestBody Drogaria drogaria) {
        Drogaria criarDrogaria = drogariaService.saveDrogaria(drogaria);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarDrogaria);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Drogaria> updateDrogaria(@PathVariable Long id, @RequestBody Drogaria drogaria) {
        Drogaria updatedDrogaria = drogariaService.updateDrogaria(id, drogaria);
        if (updatedDrogaria != null) {
            return ResponseEntity.ok(updatedDrogaria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDrogaria(@PathVariable Long id) {
        boolean deleted = drogariaService.deleteDrogaria(id);
        if (deleted) {
        	 return ResponseEntity.ok().body("O produto foi excluído com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
