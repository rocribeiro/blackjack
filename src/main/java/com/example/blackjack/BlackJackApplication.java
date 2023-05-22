package com.example.blackjack;

import com.example.blackjack.model.BlackjackGame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlackJackApplication {
    public static void main(String[] args) {
        BlackjackGame jogo = new BlackjackGame();
        jogo.iniciarPartida();
    }
}
