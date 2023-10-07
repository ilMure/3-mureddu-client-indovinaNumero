package it.fi.meucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    protected String serverName = "localhost";
    protected int serverPort = 6789;
    protected Socket mioSocket;
    protected BufferedReader tastiera;
    protected String stringaUtente;
    protected String rispostaServer;
    protected DataOutputStream dataToServer;
    protected BufferedReader dataFromServer;

    public Socket connetti(){
        System.out.println("CLIENT is running...");
        try {
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            mioSocket = new Socket(serverName, serverPort);
            dataToServer = new DataOutputStream(mioSocket.getOutputStream());
            dataFromServer = new BufferedReader(new InputStreamReader(mioSocket.getInputStream()));
        } catch (Exception e) {
            System.out.println("Errore nella connessione");
        } 
        return mioSocket;
    }

    public void comunica(){
        for(;;){
            try {
                System.out.println("Inserisci la stringa numerica da trasmettere al server:"+"\n");
                stringaUtente = tastiera.readLine();
                System.out.println("invio dati al server");
                dataToServer.writeBytes(stringaUtente + "\n");
    
                rispostaServer = dataFromServer.readLine();
                System.out.println("risposta dal server " + "\n" + rispostaServer);
                // se la stringa dell'utente è 'BYE' chiudo la connessione
                if (rispostaServer.equals("Hai indovinato")){
                    System.out.println("CLIENT : ending connection");
                    mioSocket.close();
                    break;
                }
            } catch (Exception e) {
                System.out.println("Errore nella comunicazione");
            }
        }
        
    }
}
