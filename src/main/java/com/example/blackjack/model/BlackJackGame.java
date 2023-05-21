package com.example.blackjack.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class BlackJackGame {
    private Baralho baralho;
    private Jogador banca;
    private Jogador jogador;
    public BlackJackGame() {
        baralho = new Baralho();
        banca = new Jogador("Banca da Casa");
        jogador = new Jogador();
    }

    public void distribuirCartas(){
        for(int i =0; i<2;i++){
            jogador.receberUmaCarta(baralho.pegarCarta());
        }
        banca.receberUmaCarta(baralho.pegarCarta());
    }
    public Baralho getBaralho() {
        return baralho;
    }

    public void setBaralho(Baralho baralho) {
        this.baralho = baralho;
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
