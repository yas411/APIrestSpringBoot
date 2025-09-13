package com.github.yas411.controller;

import com.github.yas411.repository.entity.Musica;
import com.github.yas411.service.MusicaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("musicas/")
public class MusicaController {

    private final MusicaService musicaService;

    public MusicaController(MusicaService musicaService) {
        this.musicaService = musicaService;
    }

    @GetMapping("todas")
    public List<Musica> listarTodas() {
        return musicaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Musica> buscarPorId(@PathVariable Long id) {
        return musicaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("nova")
    public Musica criar(@RequestBody Musica musica) {
        return musicaService.salvar(musica);
    }

    @PutMapping("editar/{id}")
    public Musica atualizar(@PathVariable Long id, @RequestBody Musica musica) {
        return musicaService.atualizar(id, musica);
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        musicaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}