package com.example.blackjack.model;//package com.example.blackjack.domain;

import com.example.blackjack.model.Baralho;
import com.example.blackjack.model.Jogador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackjackGame {
    private Baralho baralho;
    private Jogador banca;
    private Jogador jogador;
    private boolean gameOver = false;
    private Scanner scanner = new Scanner(System.in);

    public BlackjackGame() {
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
    public void iniciarPartida() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite seu Nome:");
        String nomeJogador = scanner.nextLine();
        jogador.setNome(nomeJogador);

        baralho.embaralhar();
        distribuirCartas();



        while (!gameOver) {
            System.out.println("Cartas do jogador: " + jogador.getJogoEmMaos().toString());
            System.out.println("Total do jogador: " + jogador.getPontuacao());
            System.out.println("Carta do Banca: " + banca.getJogoEmMaos().toString());
            System.out.println("Total do Banca: " + banca.getPontuacao());


            System.out.println("Escolha ação: (1) Comprar carta, (2) Parar");

            int escolha = scanner.nextInt();

            if (escolha == 1) {
                jogador.receberUmaCarta(baralho.pegarCarta());
                if (jogador.getPontuacao() > 21) {
                    System.out.println("Jogador estourou Pontos:"+jogador.getPontuacao()+"\n"+"Banca vence!");
                    fimDejogo();
                } else if (jogador.getPontuacao() == 21) {
                    System.out.println("Pontuacao Banca: "+banca.getPontuacao());
                    System.out.println("Jogador vence!");
                    fimDejogo();
                }
            } else if (escolha == 2) {
                banca.receberUmaCarta(baralho.pegarCarta());
                compararMao(jogador.getPontuacao(),banca.getPontuacao());
                if (banca.getPontuacao() > 21) {
                    System.out.println("Banca estourou!, Pontos: "+banca.getPontuacao()+"\n"+"Jogador vence!");
                    fimDejogo();
                }else if(banca.getPontuacao() == 21){
                    System.out.println("Pontuacao jogador: "+jogador.getPontuacao());
                    System.out.println("Banca vence!");
                    fimDejogo();
                }
            }
        }
        System.out.println("Escolha ação: (1) Novo Jogo, (2) Fechar");
        int escolha = scanner.nextInt();
        if(escolha == 1){
            gameOver = false;
            resetarJogadores();
            iniciarPartida();

        }else {
            System.exit(0);
        }
    }

    private void compararMao(int jogadorPonto,int bancaPonto) {
        if (jogadorPonto > bancaPonto) {
            System.out.println("Pontuacao Banca: "+banca.getPontuacao());
            System.out.println("Jogador vence!, Com:"+jogador.getPontuacao());
            fimDejogo();
        } else if (jogadorPonto < bancaPonto) {
            System.out.println("Pontuacao jogador: "+jogador.getPontuacao());
            System.out.println("Banca vence!, Com:"+banca.getPontuacao());
            fimDejogo();
        } else {
            System.out.println("Empate!");
            fimDejogo();
        }
    }
    private void fimDejogo(){
        gameOver = true;
    }
    public void resetarJogadores() {
        jogador.getJogoEmMaos().clear();
        jogador.setPontuacao(0);
        banca.getJogoEmMaos().clear();
        banca.setPontuacao(0);
    }
}