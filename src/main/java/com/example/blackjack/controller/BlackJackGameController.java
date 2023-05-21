package com.example.blackjack.controller;


import com.example.blackjack.model.BlackJackGame;
import com.example.blackjack.model.Carta;
import com.example.blackjack.model.Jogador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class BlackJackGameController {

    @GetMapping("/")
    public String home() {
        return "index";
    }


    @PostMapping("/start")
    public ModelAndView startGame(@RequestParam(value = "nomeJogador") String nomeJogador) {
        ModelAndView modelAndView = new ModelAndView("jogo");

        if (nomeJogador != null) {
            BlackJackGame jogo = new BlackJackGame();
            jogo.getJogador().setNome(nomeJogador);
            jogo.distribuirCartas();

            if (jogo.getJogador() != null && jogo.getBanca() != null) {
//                modelAndView.addObject("jogador", jogo.getJogador());
//                modelAndView.addObject("banca", jogo.getBanca());
                modelAndView.addObject("jogo", jogo);
            } else {
                // Lidar com o erro de jogador ou banca nulos
            }
        }

        return modelAndView;
    }

    @PostMapping("/comprarNovaCarta")
    public String comprarNovaCarta(@RequestParam(value = "jogoEmMaos") List<Carta> jogoEmMaos,
                                   @RequestParam(value = "nomeJogador") String nomeJogador,
                                   @RequestParam(value = "pontuacao") int pontuacao,
                                   Model model) {
        ModelAndView modelAndView = new ModelAndView("jogo");
        Jogador jogador = new Jogador();
        jogador.setJogoEmMaos(jogoEmMaos);
        jogador.setNome(nomeJogador);
        jogador.setPontuacao(pontuacao);
        jogador.receberUmaCarta(jogador.getBaralho().pegarCarta());
        modelAndView.addObject("jogo", jogo);
        return modelAndView;
    }

//
//    @PostMapping("/stand")
//    public String stand(Model model) {
//        game.bancaComprarCarta();
//        int jogadorPontuacao = jogador.getPontuacao();
//        int bancaPontuacao = game.getBanca().getPontuacao();
//        game.compararMao(jogadorPontuacao, bancaPontuacao);
//        model.addAttribute("jogador", jogador);
//        model.addAttribute("banca", game.getBanca());
//        model.addAttribute("gameOver", gameOver);
//        return "game";
//    }
//
//    @PostMapping("/newgame")
//    public String newGame() {
//        gameOver = false;
//        resetarJogadores();
//        return "redirect:/";
//    }
//
//    private void resetarJogadores() {
//        game.resetarJogadores();
//        jogador = new Jogador();
//    }
}
