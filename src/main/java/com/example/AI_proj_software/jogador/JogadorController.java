package com.example.AI_proj_software.jogador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    // Rota para salvar um novo jogador
    @PostMapping("/jogador")
    public ResponseEntity<Jogador> salvarJogador(@RequestBody Jogador jogador) {
        Jogador jogadorSalvo = jogadorService.CadastraJogador(jogador);
        return ResponseEntity.ok(jogadorSalvo);
    }

    // Rota para listar todos os jogadores
    @GetMapping("/jogador")
    public ResponseEntity<List<Jogador>> listarJogadores() {
        List<Jogador> jogadores = jogadorService.ListaJogadores();
        return ResponseEntity.ok(jogadores);
    }

    // Rota para adicionar um jogador a um time
    @PutMapping("/{id}/time/{time}")
    public ResponseEntity<Jogador> adicionarTime(@PathVariable Integer id, @PathVariable String time) {
        try {
            Jogador jogadorAtualizado = jogadorService.adicionarTime(id, time);
            return ResponseEntity.ok(jogadorAtualizado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}

