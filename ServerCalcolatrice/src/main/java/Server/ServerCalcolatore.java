/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author Leonardo
 */
public class ServerCalcolatore {
    ServerSocket socket_server=null;
    Socket socket_client=null;
    String messaggio_client=null;
    String risposta_server=null;
    BufferedReader dati_dal_client;
    DataOutputStream dati_al_client;
    
    public Socket attendi(){
        try {
            System.out.println("Server in esecuzione.");
            socket_server=new ServerSocket(8888);
            System.out.println("Server in attesa del client.");
            socket_client=socket_server.accept();
            System.out.println("Client connesso.");
            dati_dal_client=new BufferedReader(new InputStreamReader(socket_client.getInputStream()));
            dati_al_client=new DataOutputStream(socket_client.getOutputStream());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore nell'istanziamento del server.");
            System.exit(1);
        }
        return(socket_client);
    }
    public double Somma(double messaggio1,double messaggio2){
       double somma=messaggio1+messaggio2;
        return somma;
    }
    public double Sottrazione(double messaggio1,double messaggio2){
       double sottrazione=messaggio1-messaggio2;
        return sottrazione;
    }
    public double Moltiplicazione(double messaggio1,double messaggio2){
       double moltiplicazione=messaggio1*messaggio2;
        return moltiplicazione;
    }
    public double Divisione(double messaggio1,double messaggio2){
       double divisione=messaggio1/messaggio2;
        return divisione;
    }
    public void comunica(){
        try {
            System.out.println("In attesa del messaggio da parte del client.");
            messaggio_client=dati_dal_client.readLine();
            System.out.println("Messaggio ricevuto.");
            double messaggio1 = Double.parseDouble(messaggio_client);
            System.out.println("Invio della risposta al client.");
            dati_al_client.writeBytes("Ok, secondo numero?"+'\n');
            messaggio_client=dati_dal_client.readLine();
            System.out.println("Messaggio ricevuto.");
            double messaggio2 = Double.parseDouble(messaggio_client);
            System.out.println("Invio della risposta al client.");
            dati_al_client.writeBytes("Ok, somma(1),sottrazione(2),moltiplicazione(3) o divisione(4)?"+'\n');
            messaggio_client=dati_dal_client.readLine();
            System.out.println("Messaggio ricevuto.");
            int n = Integer.parseInt(messaggio_client);
            double ris=0;
            if(n==1)ris=Somma(messaggio1,messaggio2);
            else if(n==2)ris=Sottrazione(messaggio1,messaggio2);
            else if(n==3)ris=Moltiplicazione(messaggio1,messaggio2);
            else if(n==4)ris=Divisione(messaggio1,messaggio2);
            else System.out.println("Non funge");
            System.out.println("Invio della risposta al client.");
            dati_al_client.writeBytes("Risultato: "+ris+'\n');
            System.out.println("Elaborazione completata.");
            socket_client.close();
        }
        catch (Exception e) {
            System.out.println("Errore durante la comunicazione.");
        }
    }
}