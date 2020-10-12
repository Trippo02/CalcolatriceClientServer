/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

/**
 *
 * @author Leonardo
 */
public class ServerMain {
    public static void main(String[] args) {
        // TODO code application logic here
        ServerCalcolatore server=new ServerCalcolatore();
        server.attendi();
        server.comunica();
    }
}
