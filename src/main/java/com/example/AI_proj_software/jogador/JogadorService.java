package com.example.AI_proj_software.jogador;

import com.example.AI_proj_software.time.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {
    @Autowired TimeService timeService;
    @Autowired JogadorRepository jogadorRepository;

    public Jogador CadastraJogador(Jogador jogador){
        if (jogador.getNome().equals("")
                || jogador.getIdade()==(null)){
            throw  new RuntimeException("Dados invalidos");
        } else {
            return jogadorRepository.save(jogador);
        }

    }

    public List<Jogador> ListaJogadores(){
        return jogadorRepository.findAll();
    }


    public Jogador adicionarTime(Integer jogadorId, String time) throws Exception {
        Optional<Jogador> jogadorOpt = jogadorRepository.findById(jogadorId);
        if (!jogadorOpt.isPresent()) {
            throw new Exception("Jogador não encontrado");
        }
        Jogador jogador = jogadorOpt.get();
        jogador.getTimes().add(time);
        return jogadorRepository.save(jogador);
    }
}
