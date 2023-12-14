package Main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Utente user = new Utente("Paolo", "Carlino", "1234345", "Cicuci", 123);
        Utente amico = new Utente("Carlo", "Manciari", "1A2B", "Cicuzi", 321);

        System.out.println("Benvenuto Utente " + user.getNomeUtente() + " in che cosa possiamo aiutarti oggi?");
        Scanner input = new Scanner(System.in);
// ---------------- | Variabili run per i while | ---------------
        boolean runMenu = true;
// ---------------- | Variabili scelte | -------------
        int option;
        int optionDenaro;
        int optionSocial;
        int optionImpostazioni;
        String exitMoney;
        String exitSocial;
        String exitImpostazioni;
        String exitMenu;
        while (runMenu) {
            boolean runDenaro = true;
            boolean runSocial = true;
            boolean runImpostazioni = true;
            System.out.println("""
                    1. Denaro
                    2. Social
                    3. Impostazioni
                                        
                    Inserisci numero sezione:
                    """);
            option = input.nextInt();
            switch (option) {
                case 1: // INIZIO OPZIONE DENARO
                    while (runDenaro) {
                        System.out.println("""
                                Optioni denaro:
                                1. Invia denaro
                                2. Controllo saldo
                                """);
                        optionDenaro = input.nextInt();
                        switch (optionDenaro) {
                            case 1:
                                user.InviaDenaro(amico);
                                System.out.println("Vuoi fare altre operazioni sulla sezione 'Denaro'? (Si/No)");
                                input.nextLine();
                                exitMoney = input.nextLine();
                                if (exitMoney.equalsIgnoreCase("si")) {
                                    break;
                                } else {
                                    runDenaro = false;
                                    break;
                                }
                            case 2:
                                user.VisioneMyConto();
                                System.out.println("Vuoi fare altre operazioni sulla sezione 'Denaro'? (Si/No)");
                                input.nextLine();
                                exitMoney = input.nextLine();
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
                    System.out.println("Vuoi fare altre operazioni? (Si/No)");
                    exitMenu = input.nextLine();
                    if (exitMenu.equalsIgnoreCase("si")) {
                        break;
                    } else {
                        runMenu = false;
                        break;
                    }
                case 2: // INIZIO OPZIONE SOCIAL
                    while (runSocial) {
                        System.out.println("""
                                1. aggiungere amico
                                2. Visualizzare lista amici
                                """);
                        optionSocial = input.nextInt();
                        switch (optionSocial) {
                            case 1:
                                user.AggiungiAmico();
                                System.out.println("Vuoi fare altre operazioni sulla sezione 'social'? (Si/No)");
                                input.nextLine();
                                exitSocial = input.nextLine();
                                if (exitSocial.equalsIgnoreCase("si")) {
                                    break;
                                } else {
                                    runSocial = false;
                                    break;
                                }
                            case 2:
                                user.VisioneListaAmici();
                                System.out.println("Vuoi fare altre operazioni sulla sezione 'social'? (Si/No)");
                                input.nextLine();
                                exitSocial = input.nextLine();
                                if (exitSocial.equalsIgnoreCase("si")) {
                                    break;
                                } else {
                                    runSocial = false;
                                    break;
                                }
                        }
                    }
                    System.out.println("Vuoi fare altre operazioni? (Si/No)");
                    exitMenu = input.nextLine();
                    if (exitMenu.equalsIgnoreCase("si")) {
                        break;
                    } else {
                        runMenu = false;
                        break;
                    }
                case 3: // Impostazioni utente
                    while (runImpostazioni){
                        System.out.println("""
                                1. Cambiare password
                                2. Cambiare nome e cognome
                                """);
                        optionImpostazioni = input.nextInt();
                        switch (optionImpostazioni){
                            case 1:
                                user.cambiaPassword();
                                System.out.println("Vuoi fare altre operazioni nella sezione 'Impostazioni'? (Si/No)");
                                input.nextLine();
                                exitImpostazioni = input.nextLine();
                                if (exitImpostazioni.equalsIgnoreCase("si")){
                                    break;
                                } else {
                                    runImpostazioni = false;
                                    break;
                                }
                            case 2:
                                user.cambiaNomeCognome();
                                System.out.println("Vuoi fare altre operazioni nella sezione 'Impostazioni'? (Si/No)");
                                input.nextLine();
                                exitImpostazioni = input.nextLine();
                                if (exitImpostazioni.equalsIgnoreCase("si")){
                                    break;
                                } else {
                                    runImpostazioni = false;
                                    break;
                                }
                        }

                    }
                    System.out.println("Vuoi fare altre operazioni? (Si/No)");
                    exitMenu = input.nextLine();
                    if (exitMenu.equalsIgnoreCase("si")) {
                        break;
                    } else {
                        runMenu = false;
                        break;
                    }
                default:
                    System.out.println("Scelta non valida");
            }
        }
    }
}
