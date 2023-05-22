package com.example.blackjack.model;

public enum ResultadoJogo {
    VITORIA_JOGADOR("Vitória do Jogador"),
    VITORIA_BANCA("Vitória da Banca"),
    EMPATE("Empate"),
    ESTOURO("Estouro"),
    BLACKJACK_JOGADOR("Blackjack do Jogador"),
    BLACKJACK_BANCA("Blackjack da Banca"),
    EMPATE_BLACKJACK("Empate com Blackjack");

    private String descricao;

    ResultadoJogo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
