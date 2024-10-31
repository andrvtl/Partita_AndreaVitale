# Progetto Partita di Pallavolo Vitale Andrea

## Scopo pratico del progetto
Il progetto simula una partita di pallavolo tra due giocatori, ognuno gestito da un thread separato. Durante la partita, i due giocatori giocano un turno ciascuno, in cui hanno una probabilità del 50% di effettuare un punto. Il primo giocatore a raggiungere 25 punti vince la partita. Un arbitro monitora il punteggio di entrambi i giocatori e dichiara il vincitore quando uno dei due arriva a 25.

## Classi utilizzate

### Giocatore
Questa classe rappresenta ciascun giocatore nella partita. Ogni giocatore è implementato come un thread che simula i tentativi di segnare punti.

- **Metodi e attributi:**
  - `idGiocatore`: ID del giocatore.
  - `puntiEffettuati`: punti segnati dal giocatore.
  - `run()`: metodo di esecuzione del thread che simula uno scambio, genera un numero casuale con la libreria random per determinare se il giocatore segna un punto.
  - `getIdGiocatore()`: restituisce l'ID del giocatore.

### Arbitro
La classe **Arbitro** gestisce la sincronizzazione tra i due giocatori e monitora i punteggi, verifica quando uno dei giocatori raggiunge 25 punti e dichiara il vincitore.

- **Metodi e attributi:**
  - `controllaPunteggio()`: metodo sincronizzato che viene richiamato dai giocatori per verificare il raggiungimento dei 25 punti. Se un giocatore vince il gioco si interrompe.
  
  La classe **Arbitro** è importante dato che senza la sincronizzazione fornita potrebbero verificarsi conflitti tra i due thread.

## Classe `Thread`

- **`yield()`**: metodo che permette di cedere la cpu ad altri thread, utilizzato per alternare i turni tra i due giocatori dopo ogni tentativo.
- **`start()`**: avvia l'esecuzione del thread.
- **`setPriority(int priority)`**: imposta la priorità di esecuzione del thread.

## Classe `Object`

- **`synchronized`**: funzione usata nel metodo `controllaPunteggio()` per assicurare che solo un thread alla volta possa accedere alla verifica del punteggio. Importante per evitare che più thread interferiscano fra loro nel controllo del punteggio.

## Commento tecnico dell'esecuzione
Durante l'esecuzione del programma, vengono creati i due thread per simulare i giocatori. Ad ogni turno, viene generato un numero casuale che determina se il giocatore segna un punto. Il punteggio viene aggiornato in tempo reale e stampato su console. La classe Arbitro monitora il punteggio totale e interrompe il gioco quando uno dei due giocatori raggiunge i 25 punti, dichiarando il vincitore.
