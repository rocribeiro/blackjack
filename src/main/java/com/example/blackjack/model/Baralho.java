package com.example.blackjack.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Component
public class Baralho {
    private List<Carta> cartas;

    public Baralho() {
        cartas = new ArrayList<>();
        String[] numeros = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] naipes = {"Espadas", "Copas", "Ouros", "Paus"};

        for (String naipe : naipes) {
            for (int i = 0; i < numeros.length; i++) {
                int valor;
                if (numeros[i].equals("A")) {
                    valor = 1; // Inicialmente, atribui o valor 1 para a carta A (Ás)
                } else if (i >= 9) {
                    valor = 10; // Atribui o valor 10 para as cartas J, Q e K
                } else {
                    valor = i + 2; // Atribui os valores de 2 a 10 para as outras cartas numéricas
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
