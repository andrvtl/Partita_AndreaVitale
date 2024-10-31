/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulazione_partita;

/**
 *
 * @author andrea vitale
 */
import java.util.Random;

public class Giocatore implements Runnable {
    private int idGiocatore;
    private Random random; // Dichiarazione generatore di numeri casuali
    private Arbitro arbitro; // Riferimento alla classe Arbitro condivisa

    // Costruttore che accetta l'ID del giocatore e l'istanza dell'Arbitro
    public Giocatore(int idGiocatore, Arbitro arbitro) {
        this.idGiocatore = idGiocatore;
        this.arbitro = arbitro;
        random = new Random(); // Inizializza generatore di numeri casuali
    }
    
    public int getIdGiocatore() {
        return idGiocatore;
    }
    
    // Metodo che viene eseguito quando il thread parte
    public void run() {
        while (true) {
            synchronized (arbitro) {
            int num = random.nextInt(2) + 1; // Genera un numero casuale tra 1 e 2
            if (num == 1) { // Effettua un punto con una possibilità del 50%

                /* Quando viene effettuato il punto, lancia aggiornaPunteggio, che prende idGiocatore e in base al
                thread in corso incrementa la rispettiva variabile del punteggio */
                boolean partitaFinita = arbitro.aggiornaPunteggio(idGiocatore); // Aggiorna punteggio tramite l'arbitro
                if (partitaFinita) {
                    arbitro.notify();  // Notifica tutti i thread prima di uscire
                    break; // Interrompe il ciclo se la partita è finita
                }
            } else {
                System.out.println("Il giocatore " + idGiocatore + " non ha effettuato un punto.");
            }

            // Sezione critica: try catch
            try {
                arbitro.wait();  // Il thread si mette in attesa
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break; // Uscita dal ciclo in caso di interruzione
            }
            arbitro.notify();
        }
    }
    }
}
