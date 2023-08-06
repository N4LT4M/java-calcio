package org.calcio.java.progetto;

import java.util.Random;
import java.util.Scanner;

public class Match {
        /*
    Creare una classe Persona con gli attributi nome ed età.
Estendere la classe Persona con una classe Giocatore e una classe Allenatore: ogni giocatore ha un ruolo e ogni allenatore ha la sua strategia (es: difensiva o offensiva).
Definire una classe Squadra che contiene una lista di oggetti di tipo Giocatore e un Allenatore.
Creare infine una classe Main e definire al suo interno un array di nomi e un array con i possibili ruoli per i giocatori.
Nel metodo main, generare una Squadra formata da 11 giocatori creati in modo randomico:
prelevare un nome casuale dall’array di nomi
generare l’età in modo casuale
prelevare un ruolo casuale dall’array di possibili ruoli
BONUS: nella classe Persona, al posto dell’età, memorizzare la data di nascita

Parte 2
Creare una classe Arbitro, che estende la classe Persona.
Ogni arbitro ha un ruolo.
Creare una classe Partita che contiene al suo interno una Squadra di casa, una Squadra ospite e un Arbitro.
Implementa un metodo per iniziare la partita (che imposti lo stato della partita come "iniziata")
e un metodo per segnare un goal: scegliere in modo casuale quale delle due squadre ha segnato
e stampare la stringa “Ha segnato la squadra <nomeSquadra>”.
A prescindere da quale squadra ha segnato, incrementare un contatore con il totale dei goal segnati.
NB: non è possibile segnare un goal se la partita non è ancora iniziata!
In questo caso il sistema deve restituire un messaggio d’errore.
Nel metodo main, istanziare 2 oggetti di tipo Squadra e creare una Partita.
Invocare il metodo per iniziare la partita, segnare qualche goal e concludere la partita.
     */
    //attributi
    private Referee referee;

    private Team homeTeam;
    private Team awayTeam;
    private boolean matchIsStarted;
    int goals;


    //costruttore
    public Match (Referee referee, Team homeTeam, Team awayTeam){
        this.referee = referee;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.matchIsStarted = false;
        this.goals = 0;
    }

    //metodo per iniziare la partita
    public void matchStart(){
        matchIsStarted = true;
        System.out.println("the match has begun");
    }

    //metodo per fare goal
    public int goalScored(){
        if (!matchIsStarted){
            System.out.println("la partita non è iniziata, impossibile fare goal");
        }
        Random random = new Random();
        boolean someoneScored = random.nextBoolean();
        boolean homeTeamScored = random.nextBoolean();
        if (someoneScored) {
            if (homeTeamScored) {
                System.out.println(homeTeam.getName() + " ha segnato");
            } else {
                System.out.println(awayTeam.getName() + " ha segnato");
            }
            return goals++;

        } else {
            System.out.println("Nessuno ha segnato, i goal fatti restano: " + goals);
            return goals;  // Restituisce il valore attuale di goals
        }



    }

    /*@Override
    public String toString() {
        return " hanno segnato " + goals + "goal, complimenti, bella partita";
    }
*/

}
