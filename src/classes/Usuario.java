package classes;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario {

    private String nome;
    private String nomeUsuario;
    private byte[] senha;
    private String cargo;

    private MessageDigest md;

    public Usuario(String nome, String nomeUsuario, String cargo) {
	this.nome = nome;
	this.nomeUsuario = nomeUsuario;
	this.cargo = cargo;
	try {
	    md = MessageDigest.getInstance("SHA-256");
	}
	catch (NoSuchAlgorithmException ex) {
	    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    public boolean checkPassword(String senha) {
	byte[] hash;
	boolean result = false;

	hash = md.digest(senha.getBytes(StandardCharsets.UTF_8));
	String hashString = new String(hash, StandardCharsets.UTF_8);

	if (hashString.equals(getSenha())) {
	    result = true;
	}

	return result;
    }

    public void setSenhaRaw(String senha) {

	this.senha = md.digest(senha.getBytes(StandardCharsets.UTF_8));

    }

    public void setSenhaEncrypted(String senha) {
	this.senha = senha.getBytes(StandardCharsets.UTF_8);
    }

    public String getSenha() {
	//String encoded = Base64.getEncoder().encodeToString(senha);
	String encoded = new String(senha, StandardCharsets.UTF_8);
	return encoded;

    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getNome() {
	return nome;
    }

    public void setNomeUsuario(String nomeUsuario) {
	this.nomeUsuario = nomeUsuario;
    }

    public String getNomeUsuario() {
	return nomeUsuario;
    }

    public String getCargo() {
	return cargo;
    }

    public void setCargo(String cargo) {
	this.cargo = cargo;
    }
}
