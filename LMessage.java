/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author desarrollo
 */
public class LMessage {
    final int PUERTO = 5555;
    Socket sc;
    PrintWriter salida;
    BufferedReader entrada;

    public void initClient() {
        send("192.168.1.214","hola desde windows!");
    }
    
    public void send(String host, String mensaje) {

        try {
            sc = new Socket(host, PUERTO);
            salida = new PrintWriter(sc.getOutputStream(), true);
            entrada = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            
            salida.println(mensaje);
            JOptionPane.showMessageDialog(null, "Mensaje enviado!");
            
            salida.close();
            entrada.close();
            
            sc.close();
        }catch(Exception e ) {
            System.out.println("Error: "+e.getMessage());
            VentanaMSG.error(e.getMessage());
        }
    }
}
