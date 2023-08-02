package org.calcio.java.progetto;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

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
     */
        String[] names = {"Marco Rossi", "Alessio Bianchi", "Luca Esposito", "Matteo Russo", "Andrea Martini", "Francesco Conti", "Davide Romano", "Simone Marino", "Giorgio Ferrari", "Federico Greco", "Lorenzo Barbieri", "Alessandro Fontana", "Giovanni Santoro", "Riccardo Rizzo", "Stefano Caruso", "Nicola Lombardi", "Filippo Moretti", "Emanuele Giordano", "Maurizio Marchetti", "Fabio Monti"};
        String[] roles = {"portiere", "difensore terzino", "difensore centrale", "centrocampista difensivo", "centrocampista centrale", "centrocampista ala", "attaccante punta centrale", "attaccante seconda punta", "attaccante esterno"};
        String[] strategy = {"difensiva", "offensiva"};


        Team team = new Team();
        Random random = new Random();
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
            team.addPlayer(new Player(names[findName], findAge, roles[findRole]));
        }
        team.setTrainer(new Trainer(names[findNameTrainer], findAgeTrainer, strategy[chooseStrategy]));

        System.out.println("la squadra è composta da: " + team);



    }
}
