package Client;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leonardo
 */
public class ClientMain {
    public static void main(String[] args) {
        // TODO code application logic here
        ClienteOperazioni client=new ClienteOperazioni();
        client.connetti();
        client.comunica();
    }
}
