package com.santana.uml_album.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_artista")
public class Artista implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String nacionalidade;
	
	@ManyToMany
	@JoinTable(name="tb_album_participante",
			joinColumns = @JoinColumn(name="artista_id"),
			inverseJoinColumns = @JoinColumn(name="album_id")
			)
	private Set<Album> albuns = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name="tb_autores_musicas",
		joinColumns = @JoinColumn(name="autores_id"),
		inverseJoinColumns = @JoinColumn(name="musica_id")
			)	
	private List<Musica> musicasComoAutor = new ArrayList<>();
	
	public Artista() {

	}

	public Artista(Integer id, String nome, String nacionalidade) {
		this.id = id;
		this.nome = nome;
		this.nacionalidade = nacionalidade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public Set<Album> getAlbuns() {
		return albuns;
	}
	
	public List<Musica> getMusicasComoAutor() {
		return musicasComoAutor;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artista other = (Artista) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
