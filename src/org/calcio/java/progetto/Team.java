package org.calcio.java.progetto;

import java.util.ArrayList;
import java.util.List;

public class Team {
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
    String name;
    private List<Player> players = new ArrayList<>();

    private Trainer trainer;

    public Team(String name) {
        this.name = name;
    }

    //getter e setter
    public String getName(){
        return name;
    }


    public List<Player> getPlayers() {

        return players;
    }

    public void setPlayers(List<Player> players) {

        this.players = players;
    }

    public void setTrainer(Trainer trainer){

        this.trainer = trainer;
    }

    //aggiungere giocatori alla squadra
    public void addPlayer(Player player){

        players.add(player);
    }

    //tostring
    @Override
    public String toString(){

        return players.toString() + "\n" + "l'allenatore è " + trainer.toString();
    }



}
