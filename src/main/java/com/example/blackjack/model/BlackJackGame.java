package com.example.blackjack.model;

import org.springframework.stereotype.Component;

@Component
public class BlackJackGame {
    private Jogador banca;
    private Jogador jogador;
    public BlackJackGame(Jogador jogadorMock, Object o) {
        banca = new Jogador("Banca da Casa");
        jogador = new Jogador();
    }

    public void distribuirCartas(Baralho baralho){
        for(int i =0; i<2;i++){
            Carta carta = baralho.pegarCarta();
            if(carta.getValor() == 1){
                carta.setValor(11);
                jogador.receberUmaCarta(carta);
            }else{
                jogador.receberUmaCarta(carta);
            }

        }
        banca.receberUmaCarta(baralho.pegarCarta());
    }
    public ResultadoJogo verificarPontuacaoJogo(Jogador jogador, Jogador banca) {
        int pontosJogador = jogador.getPontuacao();
        int pontosBanca = banca.getPontuacao();

        // Verificar se algum dos jogadores estourou (pontuação maior que 21)
        if (pontosJogador > 21 && pontosBanca > 21) {
            // Ambos estouraram, retorna ESTOURO
            return ResultadoJogo.ESTOURO;
        } else if (pontosJogador > 21) {
            // Jogador estourou, Banca vence
            return ResultadoJogo.VITORIA_BANCA;
        } else if (pontosBanca > 21) {
            // Banca estourou, Jogador vence
            return ResultadoJogo.VITORIA_JOGADOR;
        }

        // Verificar se algum jogador possui blackjack (pontuação 21 com duas cartas)
        if (pontosJogador == 21 && jogador.getJogoEmMaos().size() == 2) {
            if (pontosBanca == 21 && banca.getJogoEmMaos().size() == 2) {
                // Ambos têm blackjack, retorna EMPATE
                return ResultadoJogo.EMPATE_BLACKJACK;
            } else {
                // Apenas o jogador tem blackjack, Jogador vence
                return ResultadoJogo.BLACKJACK_JOGADOR;
            }
        } else if (pontosBanca == 21 && banca.getJogoEmMaos().size() == 2) {
            // Apenas a banca tem blackjack, Banca vence
            return ResultadoJogo.BLACKJACK_BANCA;
        }
        return ResultadoJogo.EMPATE;
    }
    public Jogador getBanca() {
        return banca;
    }

    public void setBanca(Jogador banca) {
        this.banca = banca;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }
}
