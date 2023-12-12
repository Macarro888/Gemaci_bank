package Main;

import java.util.Scanner;

public class Utente {
    private String nomeUtente; // nome dell'utente
    private String cognomeUtente; // cognome dell'utente
    private String codiceFiscale; // codice fiscale dell'utente
    private String password; // password dell'utente
    private int numeroTelefono; // Numero di telefono dell'utente
    private Conto myConto;

    public Utente(String nomeUtente, String cognomeUtente, String codiceFiscale, String password,Conto myConto) {
        this.nomeUtente = nomeUtente;
        this.cognomeUtente = cognomeUtente;
        this.codiceFiscale = codiceFiscale;
        this.password = password;
        this.myConto = new Conto(10); // di default ogni utente alla registrazione, avrà 10 euro
    } // costruttore della classe Utente

// -----------------| Setter e Getter | --------------------


    public String getNomeUtente() {
        return nomeUtente;
    }
    // Solo il Getter perché il nome non deve essere modificato dall'utente

    public String getCognomeUtente() {
        return cognomeUtente;
    }
    // Solo il Getter perché il cognome non deve essere modificato dall'utente

    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    // Solo il Getter perché il codice fiscale non deve essere modificato dall'utente
    public String getPassword() {
        return password;
    }
    // metodo Getter della variabile Password
    public void setPassword(String password) {
        this.password = password;
    }
    // metodo Setter della variabile Password

// --------------- | Metodi | --------------------
    public void CambiaPassword () throws InterruptedException {
        Scanner input = new Scanner(System.in); // Inizializzo per l'input
        System.out.println("Inserisci password attuale"); // Messaggio di inserire l'attuale password
        String oldPassword = input.nextLine(); // Input della password attuale
        if (oldPassword.equals(getPassword())) { // IF che confronta se la password sia giusta, se è vero entra
            System.out.println("Inserisci nuova password"); // messaggio di inserire la nuova password
            String newPassword = input.nextLine(); // Input della nuova password
            setPassword(newPassword); // Set della nuova password
            Thread.sleep(5000); // Effetto "caricamento"
            System.out.println("Password cambiata"); // messaggio che la password fu cambiata
        } else {
            System.out.println("Password sbagliata"); // Messaggio in caso la password attuale sia sbaglaita
        }
    }

}
