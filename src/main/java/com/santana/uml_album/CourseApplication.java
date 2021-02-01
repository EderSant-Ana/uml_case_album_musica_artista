package com.santana.uml_album;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.santana.uml_album.domain.Album;
import com.santana.uml_album.domain.Musica;
import com.santana.uml_album.repositories.AlbumRepository;
import com.santana.uml_album.repositories.MusicaRepository;



@SpringBootApplication
public class CourseApplication implements CommandLineRunner{

	@Autowired
	private AlbumRepository albumRepository;
	@Autowired
	private MusicaRepository musicaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CourseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		
		Album alb1 = new Album(null, "Bad", sdf.parse("1987"));
		Album alb2 = new Album(null, "Thriller", sdf.parse("1982"));
		Album alb3 = new Album(null, "We are the world", sdf.parse("1985"));
		
		Musica m1 = new Musica(null, "Smooth Criminal", 250);
		Musica m2 = new Musica(null, "Billie Jean", 300);
		Musica m3 = new Musica(null, "Beat It", 240);
		Musica m4 = new Musica(null, "We are the world", 390);
		
		alb1.getMusicas().addAll(Arrays.asList(m1));
		alb2.getMusicas().addAll(Arrays.asList(m2, m3));
		alb1.getMusicas().addAll(Arrays.asList(m4));
		
		m1.getAlbuns().addAll(Arrays.asList(alb1));
		m2.getAlbuns().addAll(Arrays.asList(alb2));
		m3.getAlbuns().addAll(Arrays.asList(alb2));
		m4.getAlbuns().addAll(Arrays.asList(alb3));

		albumRepository.saveAll(Arrays.asList(alb1, alb2, alb3));
		musicaRepository.saveAll(Arrays.asList(m1, m2, m3, m4));
		
	}

}
