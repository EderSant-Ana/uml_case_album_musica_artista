package com.santana.uml_album.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santana.uml_album.domain.Musica;
import com.santana.uml_album.services.MusicaService;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

	@Autowired
	private MusicaService musicaService;
	
	@GetMapping
	public ResponseEntity<List<Musica>> findAll(){
		List<Musica> list = musicaService.getAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Musica> getById(@PathVariable Integer id){
		Musica obj = musicaService.getById(id);
		return ResponseEntity.ok().body(obj);
	}
}
