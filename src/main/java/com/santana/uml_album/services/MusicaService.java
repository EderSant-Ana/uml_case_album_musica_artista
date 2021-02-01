package com.santana.uml_album.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santana.uml_album.domain.Musica;
import com.santana.uml_album.repositories.MusicaRepository;

@Service
public class MusicaService {

	@Autowired
	private MusicaRepository musicaRepository;
	
	public List<Musica> getAll(){
		return musicaRepository.findAll();
	}
	
	public Musica getById(Integer id) {
		Optional<Musica> obj = musicaRepository.findById(id);
		return obj.orElseThrow(() -> new RuntimeException("Objeto não encontrado " + id + ", Tipo: " + Musica.class.getName()));
		
	}
}
