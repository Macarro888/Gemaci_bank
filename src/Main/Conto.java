package Main;

import java.util.Scanner;

public class Conto {
    private double saldoAttuale; // saldo del conto
    public Conto(int saldoAttuale) {
        this.saldoAttuale = saldoAttuale;
    } //Costruttore del conto

// ------------ | Getter e Setter | -----------------


    public double getSaldoAttuale() {
        return saldoAttuale;
    }
    // Getter del saldo

    public void setSaldoAttuale(double saldoAttuale) {
        this.saldoAttuale = saldoAttuale;
    }
    // Setter del saldo


// ------------------- | Metodi | ---------------------

    public void Prelievo () throws InterruptedException {
        Scanner input = new Scanner(System.in); // inizializzazione dell'input
        System.out.print("Inserisca la cifra da prelevare: "); // messaggio di quanto deve prelevare
        int CifraPrelievo = input.nextInt(); // input della cifra
        setSaldoAttuale(getSaldoAttuale()-CifraPrelievo); // Setter del conto
        Thread.sleep(5000); // effetto caricamento
        System.out.println("Hai prelevato: "+CifraPrelievo); // Messaggio di quanto ha prelevato
        System.out.println("Ora il saldo è: "+getSaldoAttuale()); // Messaggio di quanto ha nel saldo
    }
    public void Deposita () throws InterruptedException {
        Scanner input = new Scanner(System.in); // Inizializzazione input
        System.out.print("Quanti vuoi depositare: "); // Messaggio di quanto vuoi depositare
        int Deposit = input.nextInt(); // Input deposita
        System.out.println("Caricamento..."); // Messaggio caricamento
        Thread.sleep(5000); // Pausa programma
        setSaldoAttuale(getSaldoAttuale()+Deposit); // Setter saldo
        System.out.println("Saldo aggiornato: "); // Messaggio
        System.out.println("Depositato: "+Deposit); // Messaggio
        System.out.println("Saldo attuale: "+getSaldoAttuale()); // Messaggio

    }
}
