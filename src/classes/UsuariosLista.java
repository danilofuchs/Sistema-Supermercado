package classes;

import exceptions.*;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuariosLista {

    private static String filePath = "Users.txt";
    private ArrayList<Usuario> usuarios = new ArrayList();

    public UsuariosLista() {
	try {
	    getUsuariosArquivo();
	}
	catch (IOException ex) {
	    Logger.getLogger(UsuariosLista.class.getName()).log(Level.FINE, null, ex);
	    try {
		inicializarArquivo();
	    }
	    catch (IOException e) {
		Logger.getLogger(UsuariosLista.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }

    public void close() {
	try {
	    gravarUsuariosArquivo();
	}
	catch (IOException ex) {
	    Logger.getLogger(UsuariosLista.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    public void addUsuario(String nome, String nomeUsuario, String senha, String cargo) throws NameNotUniqueException {
	boolean unique = true;
	if (usuarios.size() >= 1) {
	    for (Usuario u : usuarios) {
		if (nomeUsuario.equals(u.getNomeUsuario())) {
		    unique = false;
		    throw new NameNotUniqueException("Nome de usuário já existente, por favor selecione outro");
		}
	    }
	}
	if (unique) {
	    Usuario u = new Usuario(nome, nomeUsuario, cargo);
	    u.setSenhaRaw(senha);
	    usuarios.add(u);
	}
    }

    public void removeUsuario(String nomeUsuario, String senha) throws PasswordInvalidException, NameNotFoundException {
	boolean found = false;
	if (usuarios.size() >= 1) {
	    for (Usuario u : usuarios) {
		if (nomeUsuario.equals(u.getNomeUsuario())) {
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

	ArrayList<String> usuariosArquivo = (ArrayList) Files.readAllLines(Paths.get(filePath));

	for (String s : usuariosArquivo) {
	    String[] usuario = s.split(" ; "); //gera 3 strings que estavam separadas por ;
	    if (usuario.length == 4) { //numero de parametros separados por ;
		Usuario u = new Usuario(usuario[0], usuario[1], usuario[3]);
		u.setSenhaEncrypted(usuario[2]);
		usuarios.add(u);
	    }
	}
    }

    public void gravarUsuariosArquivo() throws IOException {
	ArrayList<String> usuariosString = new ArrayList<String>();
	for (Usuario u : usuarios) {
	    usuariosString.add(String.format("%s ; %s ; %s ; %s", u.getNome(), u.getNomeUsuario(), u.getSenha(), u.getCargo()));
	}

	try {
	    Files.write(Paths.get(filePath), usuariosString, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);
	}
	catch (IOException e) {
	    inicializarArquivo();
	    Files.write(Paths.get(filePath), usuariosString, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);
	}
    }

    public void inicializarArquivo() throws IOException {
	ArrayList<String> vazio = new ArrayList();
	vazio.add("");
	Files.write(Paths.get(filePath), vazio, StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW);
    }

    public Usuario getUsuario(String nomeUsuario) throws NameNotFoundException {
	boolean found = false;
	Usuario usuario = new Usuario("", "", "");
	for (Usuario u : usuarios) {
	    if (u.getNomeUsuario().equals(nomeUsuario)) {
		usuario = u;
		found = true;
	    }
	}
	if (found) {
	    return usuario;
	} else {
	    throw new NameNotFoundException("Usuário não cadastrado");
	}
    }
}
