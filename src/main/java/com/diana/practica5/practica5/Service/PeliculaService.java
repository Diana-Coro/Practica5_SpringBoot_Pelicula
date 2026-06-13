package com.diana.practica5.practica5.Service;

import com.diana.practica5.practica5.Entity.Pelicula;
import com.diana.practica5.practica5.Repository.PeliculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService {

    private final PeliculaRepository repository;

    public PeliculaService(PeliculaRepository repository) {
        this.repository = repository;
    }

    public List<Pelicula> listar() {
        return repository.findAll();
    }

    public Pelicula buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Pelicula guardar(Pelicula pelicula) {
        return repository.save(pelicula);
    }

    public Pelicula actualizar(Long id, Pelicula pelicula) {
        Pelicula existente = repository.findById(id).orElse(null);

        if (existente == null) {
            return null;
        }

        existente.setTitulo(pelicula.getTitulo());
        existente.setDirector(pelicula.getDirector());
        existente.setAnioLanzamiento(pelicula.getAnioLanzamiento());
        existente.setGenero(pelicula.getGenero());
        existente.setSinopsis(pelicula.getSinopsis());

        return repository.save(existente);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}