/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulazione_partita;

/**
 *
 * @author andrea vitale
 * Classe Arbitro per monitorare i punteggi dei giocatori e dichiarare il vincitore
 */
public class Arbitro {
    private int punteggioGiocatore1 = 0; 
    private int punteggioGiocatore2 = 0; 
    private final int PUNTEGGIO_VINCITA = 25; 
    private boolean partitaFinita = false; 

    // Metodo che aggiorna il punteggio e verifica il vincitore
    public synchronized boolean aggiornaPunteggio(int idGiocatore) {
        if (partitaFinita) {
            return true; // Se la partita è già finita, ritorna true
        }

        // Aggiorna i punteggi
        if (idGiocatore == 1) {
            punteggioGiocatore1++;
            System.out.println("Giocatore 1 ha effettuato un punto. Punteggio attuale: " + punteggioGiocatore1);
        } else {
            punteggioGiocatore2++;
            System.out.println("Giocatore 2 ha effettuato un punto. Punteggio attuale: " + punteggioGiocatore2);
        }

        // Verifica vincitore
        if (punteggioGiocatore1 >= PUNTEGGIO_VINCITA) {
            System.out.println("Giocatore 1 ha vinto!");
            partitaFinita = true;
        } else if (punteggioGiocatore2 >= PUNTEGGIO_VINCITA) {
            System.out.println("Giocatore 2 ha vinto!");
            partitaFinita = true;
        }

        return partitaFinita; // Ritorna true se la partita è finita
    }
}
