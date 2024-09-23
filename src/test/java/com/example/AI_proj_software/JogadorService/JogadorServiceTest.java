package com.example.AI_proj_software.JogadorService;
import com.example.AI_proj_software.jogador.Jogador;
import com.example.AI_proj_software.jogador.JogadorRepository;
import com.example.AI_proj_software.jogador.JogadorService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class JogadorServiceTest {

    @Mock
    private JogadorRepository jogadorRepository;

    @InjectMocks
    private JogadorService jogadorService;

    @Test
    public void testSalvarJogador() {
        // Criação do objeto jogador, id = null para novo jogador
        Jogador jogador = new Jogador(null, "João", 25, new ArrayList<>());

        // Mock do repositório para simular o comportamento do save
        when(jogadorRepository.save(Mockito.any(Jogador.class))).thenReturn(jogador);

        // Chamando o serviço para salvar
        Jogador jogadorSalvo = jogadorService.CadastraJogador(jogador);

        // Validação do resultado
        assertEquals("João", jogadorSalvo.getNome());
        assertEquals(25, jogadorSalvo.getIdade());
    }

    @Test
    public void testListarJogadores() {
        // Lista de jogadores simulada
        List<Jogador> lista = new ArrayList<>();
        lista.add(new Jogador(1, "Maria", 22, new ArrayList<>()));

        // Mock do método findAll para retornar a lista simulada
        when(jogadorRepository.findAll()).thenReturn(lista);

        // Chamando o serviço para listar
        List<Jogador> jogadores = jogadorService.ListaJogadores();

        // Validação do resultado
        assertEquals(1, jogadores.size());
        assertEquals("Maria", jogadores.get(0).getNome());
    }

    @Test
    public void testAdicionarTime() throws Exception {
        // Jogador com ID 1 simulado
        Jogador jogador = new Jogador(1, "Pedro", 28, new ArrayList<>());

        // Mock do método findById para retornar o jogador simulado
        when(jogadorRepository.findById(1)).thenReturn(Optional.of(jogador));

        // Chamando o serviço para adicionar um time ao jogador
        jogadorService.adicionarTime(1, "Flamengo");

        // Validação do resultado
        assertEquals(1, jogador.getTimes().size());
        assertEquals("Flamengo", jogador.getTimes().get(0));
    }

    @Test
    public void testAdicionarTimeJogadorNaoEncontrado() {
        // Simulando o jogador não encontrado ao buscar pelo ID 99
        when(jogadorRepository.findById(99)).thenReturn(Optional.empty());

        // Validação da exceção lançada ao tentar adicionar um time a um jogador inexistente
        Exception exception = null;
        try {
            jogadorService.adicionarTime(99, "Flamengo");
        } catch (Exception e) {
            exception = e;
        }

        assertEquals("Jogador não encontrado", exception.getMessage());
    }
}
