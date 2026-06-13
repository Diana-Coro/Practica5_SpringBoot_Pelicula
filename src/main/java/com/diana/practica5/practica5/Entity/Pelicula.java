package com.diana.practica5.practica5.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pelicula")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String director;
    private Integer anioLanzamiento;
    private String genero;

    @Column(length = 1000)
    private String sinopsis;

    public Pelicula() {
    }

    public Pelicula(Long id, String titulo, String director, Integer anioLanzamiento, String genero, String sinopsis) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.anioLanzamiento = anioLanzamiento;
        this.genero = genero;
        this.sinopsis = sinopsis;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    public Integer getAnioLanzamiento() { return anioLanzamiento; }
    public void setAnioLanzamiento(Integer anioLanzamiento) { this.anioLanzamiento = anioLanzamiento; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public String getSinopsis() { return sinopsis; }
    public void setSinopsis(String sinopsis) { this.sinopsis = sinopsis; }
}