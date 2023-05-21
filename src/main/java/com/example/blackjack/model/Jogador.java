package com.example.blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private String nome;
    private List<Carta> jogoEmMaos;
    private int pontuacao;

    public Jogador(){
        jogoEmMaos = new ArrayList<>();
    }
    public Jogador(String nome) {
        this.nome = nome;
        jogoEmMaos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Carta> getJogoEmMaos() {
        return jogoEmMaos;
    }

    public void setJogoEmMaos(List<Carta> jogoEmMaos) {
        this.jogoEmMaos = jogoEmMaos;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public void receberUmaCarta(Carta carta) {
        jogoEmMaos.add(carta);
        setPontuacao(getPontuacao()+carta.getValor());
    }

}