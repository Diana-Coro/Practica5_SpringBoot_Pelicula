package com.diana.practica5.practica5.Service;

import com.diana.practica5.practica5.Entity.Pelicula;
import com.diana.practica5.practica5.Repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    public List<Pelicula> listar() {
        return peliculaRepository.findAll();
    }

    public Pelicula buscarPorId(Long id) {
        return peliculaRepository.findById(id).orElse(null);
    }

    public Pelicula guardar(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public Pelicula actualizar(Long id, Pelicula pelicula) {
        Pelicula existente = peliculaRepository.findById(id).orElse(null);

        if (existente != null) {
            existente.setTitulo(pelicula.getTitulo());
            existente.setDirector(pelicula.getDirector());
            existente.setAnioLanzamiento(pelicula.getAnioLanzamiento());
            existente.setGenero(pelicula.getGenero());
            existente.setSinopsis(pelicula.getSinopsis());

            return peliculaRepository.save(existente);
        }

        return null;
    }

    public void eliminar(Long id) {
        peliculaRepository.deleteById(id);
    }
}