package classes;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    
    public ArrayList<String> imprimirNota() throws IOException{
        salvaNotaArquivo();
        ArrayList<String> notaArquivo = new ArrayList();
        notaArquivo = (ArrayList) Files.readAllLines(Paths.get("NotaFiscal.txt"));
        
        return notaArquivo;
    }
    public void salvaNotaArquivo() throws IOException{
        ArrayList<String> notaArray = new ArrayList();
        String s = String.format("CNPJ: " + empresa.getCnpj() + " " + 
                empresa.getNome() + "\n" + empresa.getEndereco() + "\n\n" + 
                "Item  Codigo  Descrição  Qtd  Unit  Total");
        notaArray.add(s);
        for(ItemVenda v: venda.getItens()){
            s = String.format(v.getSequencial() + v.getProduto().getCodigoDeBarras() + "  " + 
                    v.getProduto().getNome() + "\n   " + v.getQtd() + "x" + v.getProduto().getUnidade() + 
                    v.getProduto().getPreco().toString() + "  " + v.getPrecoTotalItem().toString());
            notaArray.add(s);
        }
        s = String.format("-------------------------------------------------------\n" + "Qtd. total de itens" + 
                "                                  " + venda.getNumItens() + "\n" + "Valor total R$" + 
                "                                   " + venda.getTotal() + 
                "-------------------------------------------------------\n" + "Operador: " + 
                usuario.getNome() + " (" + usuario.getCargo() + ")");
        notaArray.add(s);
        
        Files.write(Paths.get("NotaFiscal.txt"), notaArray, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);
    }
}
