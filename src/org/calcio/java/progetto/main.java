package org.calcio.java.progetto;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
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
        Scanner scanner = new Scanner(System.in);
        String[] homeTeamsNames = {"Milan", "Inter", "Yuventus"};
        String[] awayTeamsNames = {"Roma", "Palermo", "Napoli"};
        String[] names = {"Marco Rossi", "Alessio Bianchi", "Luca Esposito", "Matteo Russo", "Andrea Martini", "Francesco Conti", "Davide Romano", "Simone Marino", "Giorgio Ferrari", "Federico Greco", "Lorenzo Barbieri", "Alessandro Fontana", "Giovanni Santoro", "Riccardo Rizzo", "Stefano Caruso", "Nicola Lombardi", "Filippo Moretti", "Emanuele Giordano", "Maurizio Marchetti", "Fabio Monti"};
        String[] roles = {"portiere", "difensore terzino", "difensore centrale", "centrocampista difensivo", "centrocampista centrale", "centrocampista ala", "attaccante punta centrale", "attaccante seconda punta", "attaccante esterno"};
        String[] refereeRoles = {"Arbitro Centrale", "Assistente di Linea"};
        String[] strategy = {"difensiva", "offensiva"};
        Random random = new Random();
        int findHomeTeamName = random.nextInt(0, homeTeamsNames.length);
        int findAwayTeamName = random.nextInt(0, awayTeamsNames.length);
        int findRefereeName = random.nextInt(0, names.length);
        int findRefereeAge = random.nextInt(0,41);
        int findRefereeRole = random.nextInt(0,refereeRoles.length);
        Referee referee = new Referee(names[findRefereeName], findRefereeAge, refereeRoles[findRefereeRole]);

        Team homeTeam = new Team(homeTeamsNames[findHomeTeamName]);
        int chooseStrategy = random.nextInt(0, 2);
        int findName;
        int findRole;
        int findAge;
        int findNameTrainer = random.nextInt(0, names.length);
        int findAgeTrainer = random.nextInt(35, 61);
        for (int i = 0; i < 11; i++) {
            findName = random.nextInt(0, names.length);
            findRole = random.nextInt(0, 4);
            findAge = random.nextInt(18, 41);

            /*
            System.out.println(names[findName]);
            System.out.println(roles[findRole]);
            System.out.println(findAge);
             */
            homeTeam.addPlayer(new Player(names[findName], findAge, roles[findRole]));
        }
        homeTeam.setTrainer(new Trainer(names[findNameTrainer], findAgeTrainer, strategy[chooseStrategy]));

        System.out.println("la squadra di casa è " +homeTeam.getName() + " ed è composta da: " + homeTeam);

        Team awayTeam = new Team(awayTeamsNames[findAwayTeamName]);
        int chooseAwayStrategy = random.nextInt(0, 2);
        int findAwayName;
        int findAwayRole;
        int findAwayAge;
        int findNameAwayTrainer = random.nextInt(0, names.length);
        int findAgeAwayTrainer = random.nextInt(35, 61);
        for (int i = 0; i < 11; i++) {
            findAwayName = random.nextInt(0, names.length);
            findAwayRole = random.nextInt(0, 4);
            findAwayAge = random.nextInt(18, 41);

            /*
            System.out.println(names[findName]);
            System.out.println(roles[findRole]);
            System.out.println(findAge);
             */
            awayTeam.addPlayer(new Player(names[findAwayName], findAwayAge, roles[findAwayRole]));
        }
        awayTeam.setTrainer(new Trainer(names[findNameAwayTrainer], findAgeAwayTrainer, strategy[chooseAwayStrategy]));
        System.out.println("la squadra ospite è " +awayTeam.getName() + " ed è composta da: " + awayTeam);

        Match match = new Match(referee, homeTeam, awayTeam);

        System.out.println("iniziamo la partita ? Y/N");
        String startMatch = scanner.nextLine();

        if (startMatch.equalsIgnoreCase("Y")) {
            match.matchStart();
            System.out.println("le squadre stanno giocando con impegno");
            for (int i = 0; i < 90; i++) {
                match.goalScored();
            }
            System.out.println("la partita è finita, sono stati segnati " + match.goals + " goal");


        } else if (startMatch.equalsIgnoreCase("N")) {
            System.out.println("la partita è annullata");
        } else {
            System.out.println("per favore, scrivi Y per far iniziare una partita o N per annullarla");
        }


    }
}
