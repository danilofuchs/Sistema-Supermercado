/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAELN
 */
public class UsuariosLista {
    
    String filename = "Users.txt";
    ArrayList<Usuario> usuarios;
    
    public UsuariosLista() {
        try {
            getUsuariosArquivo();
        } catch (IOException ex) {
            Logger.getLogger(UsuariosLista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void close() {
        try {
            gravarUsuariosArquivo();
        } catch (IOException ex) {
            Logger.getLogger(UsuariosLista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addUsuario(String nome, String senha, String cargo) {
        usuarios.add(new Usuario(nome, senha, cargo));
    }
    
    
    private void getUsuariosArquivo() throws FileNotFoundException, IOException {
        FileReader file = new FileReader(filename);
        BufferedReader readFile = new BufferedReader(file);

        String input = readFile.readLine();
        String[] usuario = input.split(" ; ");
        usuarios.add(new Usuario(usuario[0], usuario[1], usuario[2]));
        while (input != null) {
            input = readFile.readLine();
            usuario = input.split(" ; ");
            usuarios.add(new Usuario(usuario[0], usuario[1], usuario[2]));
        }
        readFile.close();

    }
    
    public void gravarUsuariosArquivo() throws IOException {
        FileWriter file = new FileWriter(filename);
        PrintWriter writeFile = new PrintWriter(file);
        
        for (Usuario u : usuarios) {
            writeFile.println(String.format("%s ; %s ; %s", u.getNome(), u.getSenha(), u.getCargo()));
        }
        writeFile.close();
    }
}
