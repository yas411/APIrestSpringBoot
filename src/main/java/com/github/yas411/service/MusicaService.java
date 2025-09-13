package com.github.yas411.service;

import com.github.yas411.repository.entity.Musica;
import com.github.yas411.repository.MusicaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicaService {

    private final MusicaRepository musicaRepository;

    public MusicaService(MusicaRepository musicaRepository) {
        this.musicaRepository = musicaRepository;
    }

    public List<Musica> listarTodas() {
        return musicaRepository.findAll();
    }

    public Optional<Musica> buscarPorId(Long id) {
        return musicaRepository.findById(id);
    }

    public Musica salvar(Musica musica) {
        return musicaRepository.save(musica);
    }

    public Musica atualizar(Long id, Musica musicaAtualizada) {
        return musicaRepository.findById(id)
                .map(musica -> {
                    musica.setTitulo(musicaAtualizada.getTitulo());
                    musica.setArtista(musicaAtualizada.getArtista());
                    musica.setDuracao(musicaAtualizada.getDuracao());
                    musica.setGenero(musicaAtualizada.getGenero());
                    return musicaRepository.save(musica);
                }).orElseThrow(() -> new RuntimeException("Música não encontrada com id: " + id));
    }

    public void deletar(Long id) {
        musicaRepository.deleteById(id);
    }
}