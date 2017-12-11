package classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NotaFiscal {
    private Venda venda;
    private Empresa empresa;
    private Usuario usuario;

    public NotaFiscal(Venda venda, Empresa empresa, Usuario usuario) {
        this.venda = venda;
        this.empresa = empresa;
        this.usuario = usuario;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
    
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String getData(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date date = new Date();
	return dateFormat.format(date);
    }
    
    public String imprimirNota(){
        return "";
    }
    public void salvaNotaArquivo(){
        
    }
}
