package com.example.blackjack.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {
    private List<Carta> cartas;

    public Baralho() {
        cartas = new ArrayList<>();
        String[] numeros = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] naipes = {"Espadas", "Copas", "Ouros", "Paus"};

        for (String naipe : naipes) {
            for (int i = 0; i < numeros.length; i++) {
                int valor = i + 2;
                if (i >= 9) {
                    valor = 10;
                }
                cartas.add(new Carta(numeros[i], naipe, valor));
            }
        }

        embaralhar();
    }

    public void embaralhar() {
        Collections.shuffle(cartas);
    }

    public Carta pegarCarta() {
        if (cartas.isEmpty()) {
            return null;
        }
        return cartas.remove(cartas.size() - 1);
    }
}
