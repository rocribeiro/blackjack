package com.example.blackjack;

import com.example.blackjack.model.Baralho;
import com.example.blackjack.model.BlackJackGame;
import com.example.blackjack.model.Carta;
import com.example.blackjack.model.Jogador;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BlackJackGameTest {

    @Test
    public void testDistribuirCartas() {
        // Criação dos objetos mockados
        Baralho baralhoMock = mock(Baralho.class);
        Jogador jogadorMock = mock(Jogador.class);
        BlackJackGame jogo = new BlackJackGame(jogadorMock, null);

        // Criação das cartas mockadas
        Carta carta1 = new Carta("A", "Espadas", 1);
        Carta carta2 = new Carta("K", "Copas", 10);
        Carta carta3 = new Carta("2", "Ouros", 2);

        // Configuração dos comportamentos esperados
        when(baralhoMock.pegarCarta()).thenReturn(carta1, carta2, carta3);
        when(carta1.getValor()).thenReturn(1);
        when(carta2.getValor()).thenReturn(10);
        when(carta3.getValor()).thenReturn(2);

        // Execução do método a ser testado
        jogo.distribuirCartas(baralhoMock);

        // Verificação dos resultados
        verify(baralhoMock, times(3)).pegarCarta();
        verify(jogadorMock, times(2)).receberUmaCarta(any(Carta.class));
        verify(jogadorMock).receberUmaCarta(carta1);
        verify(jogadorMock).receberUmaCarta(carta2);
        verify(jogadorMock, never()).receberUmaCarta(carta3);
    }
}
