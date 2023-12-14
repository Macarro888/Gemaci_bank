package Main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Utente user = new Utente("Paolo", "Carlino", "1234345", "Cicuci", 123); // utente principale
        Utente amico = new Utente("Carlo", "Manciari", "1A2B", "Cicuzi", 321); // "amico" dell'utente principale

        System.out.println("Benvenuto Utente " + user.getNomeUtente() + " in che cosa possiamo aiutarti oggi?");
        Scanner input = new Scanner(System.in);
// ---------------- | Variabili run per i while | ---------------
        boolean runMenu = true;
        // Questa variabile viene utilizzata per il cicli while principale e la inizializzo a true
// ---------------- | Variabili scelte | -------------
        int option; // Questa variabile viene utilizzata per la scelta nello switch principale
        int optionDenaro; // Questa variabile viene utilizzata per la scelta nella sezione "denaro"
        int optionSocial; // Questa variabile viene utilizzata per la scelta nella sezione "social"
        int optionImpostazioni; // Questa variabile viene utilizzata per la scelta nella sezione "impostazioni"
        String exitMoney; // Questa variabile viene utilizzata se l'utente vuole uscire dalla sezione "Denaro"
        String exitSocial; // Questa variabile viene utilizzata se l'utente vuole uscire dalla sezione "Social"
        String exitImpostazioni; // Questa variabile viene utilizzata se l'utente vuole uscire dalla sezione "Impostazioni"
        String exitMenu; // Questa variabile viene utilizzata se l'utente vuole uscire dal menu
        while (runMenu) { // While principale
            boolean runDenaro = true; // boolean che viene "interrogata" dal while della sezione "Denaro"
            boolean runSocial = true; // boolean che viene "interrogata" dal while della sezione "Social"
            boolean runImpostazioni = true; // boolean che viene "interrogata" dal while della sezione "Impostazioni"
            System.out.println("""
                    1. Denaro
                    2. Social
                    3. Impostazioni
                                        
                    Inserisci numero sezione:
                    """);
            option = input.nextInt(); // input principale per lo switch principale
            switch (option) { // switch principale
                case 1: // INIZIO OPZIONE DENARO
                    while (runDenaro) {
                        System.out.println("""
                                Optioni denaro:
                                1. Invia denaro
                                2. Controllo saldo
                                """);
                        optionDenaro = input.nextInt(); // input della scelta per lo switch della sezione "Denaro"
                        switch (optionDenaro) {
                            case 1:
                                user.InviaDenaro(amico); // Run del metodo
                                System.out.println("Vuoi fare altre operazioni sulla sezione 'Denaro'? (Si/No)");
                                input.nextLine(); // bug fix
                                exitMoney = input.nextLine(); //input se vuole uscire dalla sezione
                                if (exitMoney.equalsIgnoreCase("si")) {
                                    break;
                                } else {
                                    runDenaro = false; // Se è no, esce dalla sezione
                                    break;
                                }
                            case 2:
                                user.VisioneMyConto(); // Run del metodo
                                System.out.println("Vuoi fare altre operazioni sulla sezione 'Denaro'? (Si/No)");
                                input.nextLine(); // bug fix
                                exitMoney = input.nextLine(); //input se vuole uscire dalla sezione
                                if (exitMoney.equalsIgnoreCase("si")) {
                                    break;
                                } else {
                                    runDenaro = false;
                                    break;
                                }
                            default:
                                System.out.println("Scelta non valido");
                        }
                    }
                    System.out.println("Vuoi fare altre operazioni? (Si/No)"); // chiede se vuole uscire dal programma
                    exitMenu = input.nextLine(); // input se vuole uscire
                    if (exitMenu.equalsIgnoreCase("si")) {
                        break;
                    } else {
                        runMenu = false; // Se dice di no, esce dal programma
                        break;
                    }
                case 2: // INIZIO OPZIONE SOCIAL
                    while (runSocial) {
                        System.out.println("""
                                1. aggiungere amico
                                2. Visualizzare lista amici
                                """);
                        optionSocial = input.nextInt(); // input per la scelta per l'opzione social
                        switch (optionSocial) {
                            case 1:
                                user.AggiungiAmico(); // Run del metodo
                                System.out.println("Vuoi fare altre operazioni sulla sezione 'social'? (Si/No)");
                                input.nextLine(); // bug fix
                                exitSocial = input.nextLine(); //Input se vuole lasciare la sezione
                                if (exitSocial.equalsIgnoreCase("si")) {
                                    break;
                                } else {
                                    runSocial = false; // Se sceglie di no, esce dalla sezione
                                    break;
                                }
                            case 2:
                                user.VisioneListaAmici(); // run del metodo
                                System.out.println("Vuoi fare altre operazioni sulla sezione 'social'? (Si/No)");
                                input.nextLine(); // bug fix
                                exitSocial = input.nextLine(); //input se vuole lasciare la sezione
                                if (exitSocial.equalsIgnoreCase("si")) {
                                    break;
                                } else {
                                    runSocial = false; // Se sceglie di no, esce dalla sezione
                                    break;
                                }
                        }
                    }
                    System.out.println("Vuoi fare altre operazioni? (Si/No)");
                    exitMenu = input.nextLine(); // input se vuole uscire dal programma
                    if (exitMenu.equalsIgnoreCase("si")) {
                        break;
                    } else {
                        runMenu = false; // se sceglie di no, esce dal programma
                        break;
                    }
                case 3: // Impostazioni utente
                    while (runImpostazioni){
                        System.out.println("""
                                1. Cambiare password
                                2. Cambiare nome e cognome
                                """);
                        optionImpostazioni = input.nextInt(); // input delle opzioni della sezione impostazioni
                        switch (optionImpostazioni){
                            case 1:
                                user.cambiaPassword(); //run del metodo
                                System.out.println("Vuoi fare altre operazioni nella sezione 'Impostazioni'? (Si/No)");
                                input.nextLine(); //scelta se vuole fare altre operazioni
                                exitImpostazioni = input.nextLine(); // input
                                if (exitImpostazioni.equalsIgnoreCase("si")){
                                    break;
                                } else {
                                    runImpostazioni = false; // se dice di no, esce dal sezione
                                    break;
                                }
                            case 2:
                                user.cambiaNomeCognome(); //run del metodo
                                System.out.println("Vuoi fare altre operazioni nella sezione 'Impostazioni'? (Si/No)");
                                input.nextLine(); // bug fix
                                exitImpostazioni = input.nextLine(); //input
                                if (exitImpostazioni.equalsIgnoreCase("si")){
                                    break;
                                } else {
                                    runImpostazioni = false; // se dice di no, esce dalla sezione
                                    break;
                                }
                        }

                    }
                    System.out.println("Vuoi fare altre operazioni? (Si/No)");
                    exitMenu = input.nextLine(); // input se vuole fare altre operazioni
                    if (exitMenu.equalsIgnoreCase("si")) {
                        break;
                    } else {
                        runMenu = false; // se sceglie di no, esce dal programma
                        break;
                    }
                default:
                    System.out.println("Scelta non valida");
            }
        }
    }
}
