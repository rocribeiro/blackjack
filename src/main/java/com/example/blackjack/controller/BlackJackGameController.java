package com.example.blackjack.controller;


import com.example.blackjack.model.Baralho;
import com.example.blackjack.model.BlackJackGame;
import com.example.blackjack.model.Jogador;
import com.example.blackjack.model.ResultadoJogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.blackjack.model.ResultadoJogo.*;


@RestController
public class BlackJackGameController {

    @Autowired
    private BlackJackGame jogo;
    @Autowired
    private Baralho baralho;



    @GetMapping("/novoJogo")
    public @ResponseBody BlackJackGame startGame(@RequestParam String nomeJogador) {
        jogo.getJogador().setNome(nomeJogador);
        jogo.distribuirCartas(baralho);
        return jogo;
    }

    @PostMapping("/comprarNovaCarta")
    public ResponseEntity<?> comprarNovaCarta(@RequestBody BlackJackGame jogo) {
        jogo.getJogador().receberUmaCarta(baralho.pegarCarta());
        ResultadoJogo resultadoJogo = jogo.verificarPontuacaoJogo(jogo.getJogador(), jogo.getBanca());
        if (resultadoJogo.equals(VITORIA_BANCA)) {
            String mensagemVencedor = menssageVencedor(jogo.getBanca());
            return ResponseEntity.ok(mensagemVencedor);
        }if(resultadoJogo.equals(BLACKJACK_JOGADOR)){
            String mensagemVencedor = menssageVencedor(jogo.getJogador());
            return ResponseEntity.ok(mensagemVencedor);
        }
        return ResponseEntity.ok(jogo);
    }

    public String menssageVencedor(Jogador jogadorVencedor){
        return "Jogador: "+jogadorVencedor.getNome()+" Venceu a partida!, Com a pontuacao: "+jogadorVencedor.getPontuacao();
    }

}
