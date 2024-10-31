/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.simulazione_partita;

/**
 *
 * @author andrea vitale
 * Classe principale per avviare la simulazione della partita
 */
public class Simulazione_partita {

    public static void main(String[] args) {
        // Crea un'istanza condivisa dell'Arbitro
        Arbitro arbitro = new Arbitro();
        
        // Crea il primo giocatore e il thread associato
        Giocatore g1 = new Giocatore(1, arbitro);
        Thread t1 = new Thread(g1);
        t1.setPriority(Thread.MAX_PRIORITY); // Imposta la priorità massima per il primo giocatore
        System.out.println("Id giocatore: " + g1.getIdGiocatore() + ", priorità:" + t1.getPriority());
        t1.start(); // Avvia il thread del primo giocatore
        
        // Crea il secondo giocatore e il thread associato
        Giocatore g2 = new Giocatore(2, arbitro);
        Thread t2 = new Thread(g2);
        System.out.println("Id giocatore: " + g2.getIdGiocatore() + ", priorità:" + t2.getPriority());
        t2.start(); // Avvia il thread del primo giocatore
    }
}
