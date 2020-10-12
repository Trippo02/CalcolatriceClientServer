package Client;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.net.*;
/**
 *
 * @author Leonardo
 */
public class ClienteOperazioni {
    String nome_server="127.0.0.1";
    int porta_server=8888;
    Socket socket;
    BufferedReader input_tastiera;
    String messaggio;
    String risposta;
    DataOutputStream dati_al_server;
    BufferedReader dati_dal_server;
    public Socket connetti(){
        System.out.println("Client in esecuzione.");
        try {
            input_tastiera=new BufferedReader(new InputStreamReader(System.in));
            socket=new Socket(nome_server,porta_server);
            dati_al_server=new DataOutputStream(socket.getOutputStream());
            dati_dal_server=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        catch(UnknownHostException e){
            System.err.println("Host non riconosciuto.");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante la connessione.");
            System.exit(1);
        }
        return(socket);
    }
    public void comunica(){
        try {
            System.out.println("Insersci il primo numero:");
            messaggio=input_tastiera.readLine();
            System.out.println("Invio del messaggio al server.");
            dati_al_server.writeBytes(messaggio+'\n');
            risposta=dati_dal_server.readLine();
            System.out.println("Risposta del server: "+risposta);
            messaggio=input_tastiera.readLine();
            System.out.println("Invio del messaggio al server.");
            dati_al_server.writeBytes(messaggio+'\n');
            risposta=dati_dal_server.readLine();
            System.out.println("Risposta del server: "+risposta);
            messaggio=input_tastiera.readLine();
            System.out.println("Invio del messaggio al server.");
            dati_al_server.writeBytes(messaggio+'\n');
            risposta=dati_dal_server.readLine();
            System.out.println("Risposta del server: "+risposta);

            System.out.println("Chiusura dell'esecuzione.");
            socket.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante la comunicazione col server.");
            System.exit(1);
        }
    }
}
