package com.diana.practica5.practica5.Controller;

import com.diana.practica5.practica5.Entity.Pelicula;
import com.diana.practica5.practica5.Service.PeliculaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
@Tag(name = "Pelicula API", description = "CRUD de la tabla Pelicula")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @Operation(summary = "Listar películas", description = "Obtiene la lista completa de películas registradas.")
    @GetMapping
    public List<Pelicula> listar() {
        return peliculaService.listar();
    }

    @Operation(summary = "Buscar película por ID", description = "Obtiene una película mediante su identificador.")
    @GetMapping("/{id}")
    public Pelicula buscarPorId(@PathVariable Long id) {
        return peliculaService.buscarPorId(id);
    }

    @Operation(summary = "Registrar película", description = "Permite registrar una nueva película.")
    @PostMapping
    public Pelicula guardar(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos de la película a registrar",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "titulo": "Avatar",
                                              "director": "James Cameron",
                                              "anioLanzamiento": 2009,
                                              "genero": "Ciencia Ficción",
                                              "sinopsis": "Película ambientada en Pandora."
                                            }
                                            """
                            )
                    )
            )
            @RequestBody Pelicula pelicula
    ) {
        return peliculaService.guardar(pelicula);
    }

    @Operation(summary = "Actualizar película", description = "Actualiza los datos de una película existente.")
    @PutMapping("/{id}")
    public Pelicula actualizar(
            @PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos actualizados de la película",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "titulo": "Avatar 2",
                                              "director": "James Cameron",
                                              "anioLanzamiento": 2022,
                                              "genero": "Ciencia Ficción",
                                              "sinopsis": "Continuación de la historia en Pandora."
                                            }
                                            """
                            )
                    )
            )
            @RequestBody Pelicula pelicula
    ) {
        return peliculaService.actualizar(id, pelicula);
    }

    @Operation(summary = "Eliminar película", description = "Elimina una película registrada mediante su ID.")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        peliculaService.eliminar(id);
    }
}