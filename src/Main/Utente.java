package Main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Utente {
    private String nomeUtente; // nome dell'utente
    private String cognomeUtente; // cognome dell'utente
    private String codiceFiscale; // codice fiscale dell'utente
    private String password; // password dell'utente
    private int numeroTelefono; // Numero di telefono dell'utente
    private Conto myConto = new Conto(10); // inizializza un conto di 10 euro
    private int codiceUtente;
    private Map<Integer, String> listaAmici;

    public Utente(String nomeUtente, String cognomeUtente, String codiceFiscale, String password,int codiceUtente) {
        this.nomeUtente = nomeUtente;
        this.cognomeUtente = cognomeUtente;
        this.codiceFiscale = codiceFiscale;
        this.password = password;
        this.codiceUtente = codiceUtente; // servirà per identificare l'utente
        this.listaAmici = new HashMap<>();
    } // costruttore della classe Utente

// -----------------| Setter e Getter | --------------------


    public String getNomeUtente() {
        return nomeUtente;
    }
    // Solo il Getter perché il nome non deve essere modificato dall'utente

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public String getCognomeUtente() {
        return cognomeUtente;
    }
    // Solo il Getter perché il cognome non deve essere modificato dall'utente
    public void setCognomeUtente(String cognomeUtente) {
        this.cognomeUtente = cognomeUtente;
    }

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
    public void cambiaPassword() throws InterruptedException {
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
    public void cambiaNomeCognome () throws InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.println("Inserisca password");
        String pass = input.nextLine();
            if (pass.equals(getPassword())){
                Thread.sleep(2000);
                System.out.println("Inserisca il nuovo nome");
                String nome = input.nextLine();
                System.out.println("Inserisca il nuovo cognome");
                String cognome = input.nextLine();
                setCognomeUtente(cognome);
                setNomeUtente(nome);
                Thread.sleep(3000);
                System.out.println("Nome e Cognome Aggiornato!");
            } else {
                System.out.println("Password sbagliata");
            }
    }

// ------------- | Metodi Sociali | -----------
    public void AggiungiAmico (){
        Scanner input = new Scanner(System.in); // inizializzazione dell'input
        System.out.println("Inserisci codice utente"); // messaggio che ti avvisa di inserire codice utente
        int codiceAmico = input.nextInt(); // input codiceAmico
        input.nextLine(); // risoluzione bug
        System.out.println("Inserisci nome utente"); // Messaggio che ti avvisa di inserire il nome dell'amico
        String nomeAmico = input.nextLine(); // input del nome
        listaAmici.put(codiceAmico,nomeAmico); // inserimento nella lista amici
    }
    public void VisioneListaAmici (){
        for (Map.Entry<Integer,String> entry : listaAmici.entrySet() ){
            System.out.println("Codice amico: "+entry.getKey()+" Nome: "+entry.getValue()); //Stampa la chiave e il nome dell'amico
        }
    }

// ---------------- | Metodi Economici | --------------

    public void InviaDenaro (Utente Destinatario) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.print("Quanto vuoi inviare?: ");
        int cifra = input.nextInt();
        if (cifra <= myConto.getSaldoAttuale()){
            System.out.println("Invio denaro a "+Destinatario.getNomeUtente()+ "...");
            myConto.setSaldoAttuale(myConto.getSaldoAttuale()-cifra);
            Destinatario.myConto.setSaldoAttuale(Destinatario.myConto.getSaldoAttuale()+cifra);
            Thread.sleep(3000);
            System.out.println("Denaro inviato!");
        } else {
            System.out.println("Non è possibile inviare il denaro");
        }
    }
    public void VisioneMyConto (){
        System.out.println(myConto.getSaldoAttuale()+ " Euro");
    }
}
