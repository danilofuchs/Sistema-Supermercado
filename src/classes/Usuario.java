package classes;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario {

    private String nome;
    private byte[] senha;
    private String cargo;
    
    private MessageDigest md;

    public Usuario(String nome, String senha, String cargo) {
	this.nome = nome;
	this.cargo = cargo;
	try {
	    md = MessageDigest.getInstance("SHA-256");
	    try {
		this.senha = md.digest(senha.getBytes("UTF-8"));
	    }
	    catch (UnsupportedEncodingException ex) {
		Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	catch (NoSuchAlgorithmException ex) {
	    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    public boolean checkPassword(String senha) {
	byte[] hash;
	boolean result = false;

	try {
	    hash = md.digest(senha.getBytes("UTF-8"));
	    if (Arrays.equals(hash,this.senha)) {
		result = true;
	    }
	}
	catch (UnsupportedEncodingException ex) {
	    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	return result;
    }
    
    public void setSenha(String senha) {
	try {
	    this.senha = md.digest(senha.getBytes("UTF-8"));
	} catch (UnsupportedEncodingException ex) {
	    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    
    public void setNome(String nome) {
	this.nome = nome;
    }
    
    public String getNome() {
	return nome;
    }

    public String getCargo() {
	return cargo;
    }

    public void setCargo(String cargo) {
	this.cargo = cargo;
    }
}
