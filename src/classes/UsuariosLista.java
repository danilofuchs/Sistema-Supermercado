/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import exceptions.*;

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
    ArrayList<Usuario> usuarios = new ArrayList();

    public UsuariosLista() {
        try {
            getUsuariosArquivo();
        } catch (IOException ex) {
            Logger.getLogger(UsuariosLista.class.getName()).log(Level.FINE, null, ex);
            try {
                inicializarArquivo();
            } catch (IOException e) {
                Logger.getLogger(UsuariosLista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void close() {
        try {
            gravarUsuariosArquivo();
        } catch (IOException ex) {
            Logger.getLogger(UsuariosLista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addUsuario(String nome, String senha, String cargo) throws NameNotUniqueException {
        boolean unique = true;
        if (usuarios.size() >= 1) {
            for (Usuario u : usuarios) {
                if (nome.equals(u.getNome())) {
                    unique = false;
                    throw new NameNotUniqueException("Nome de usuário já existente, por favor selecione outro");
                }
            }
        }
        if (unique) {
            usuarios.add(new Usuario(nome, senha, cargo));
        }
    }

    public void removeUsuario(String nome, String senha) throws PasswordInvalidException, NameNotFoundException {
        boolean found = false;
        if (usuarios.size() >= 1) {
            for (Usuario u : usuarios) {
                if (nome.equals(nome)) {
                    found = true;
                    if (u.checkPassword(senha) == true) {
                        usuarios.remove(u);

                    } else {
                        throw new PasswordInvalidException("Senha inválida. Usuário não removido.");
                    }
                    break;
                }
            }
        }
        if (!found) {
            throw new NameNotFoundException("Usuário não cadastrado.");
        }

    }

    private void getUsuariosArquivo() throws FileNotFoundException, IOException {
        FileReader file = new FileReader(filename);
        BufferedReader readFile = new BufferedReader(file);

        String input = "";
        String[] usuario;
        while (input != null) {
            input = readFile.readLine();
            if (input != null) {
                usuario = input.split(" ; "); //gera 3 strings que estavam separadas por ;
                if (usuario.length == 3) { //numero de parametros separados por ;
                    usuarios.add(new Usuario(usuario[0], usuario[1], usuario[2]));
                }
            }
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

    public void inicializarArquivo() throws IOException {
        FileWriter file = new FileWriter(filename);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.write("");
        writeFile.close();
    }
}
