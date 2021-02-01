package com.santana.uml_album.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santana.uml_album.domain.Album;

public interface AlbumRepository extends JpaRepository<Album, Integer>{

}
