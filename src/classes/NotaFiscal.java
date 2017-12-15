package classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import jdk.nashorn.internal.codegen.CompilerConstants;

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
    
    private String getData(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date date = new Date();
	return dateFormat.format(date);
    }
    
    public ArrayList<String> imprimirNota() throws IOException{
        ArrayList<String> notaArray = new ArrayList();
	notaArray.add(getData() + '\n');
	notaArray.add(empresa.getNome() + '\n');
        String s = String.format("CNPJ: " + empresa.getCnpj() + "\n" + 
                 empresa.getEndereco() + "\n\n" + 
                "Item  Codigo  Descrição  Qtd  Unit  Total");
        notaArray.add(s);
        for(ItemVenda v: venda.getItens()){
            s = v.getSequencial() + " " + v.getProduto().getCodigoDeBarras() + "  " + 
                    String.format("%.38s", v.getProduto().getNome()) + "\n   " + v.getQtd() + "x" + v.getProduto().getUnidade() + 
                    String.format(" %5.2f", v.getProduto().getPreco()) + String.format("%38.2f\n", v.getPrecoTotalItem());
            notaArray.add(s);
        }
        s =     "-------------------------------------------------------\n" +
		String.format("Qtd. total de itens%36d\n", venda.getNumItens()) +
		String.format("Valor total R$%41.2f\n", venda.getTotal()) + 
                "-------------------------------------------------------\n"
		+ "Operador: " + usuario.getNome() + " (" + usuario.getCargo() + ")";
        notaArray.add(s);
	
	return (notaArray);
    }
    public void salvaNotaArquivo(ArrayList<String> notaArray) throws IOException{
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();
	String dataHoje = dateFormat.format(date).replaceAll("/", "-");
	
	String workingDirectory = System.getProperty("user.dir");
	int i = 1;
	File file = new File(workingDirectory, "/Notas/" + "Nota " + dataHoje + "-" + i + ".txt");
	while (file.isFile()) {
	    i++;
	    file = new File(workingDirectory, "/Notas/" + "Nota " + dataHoje + "-" + i + ".txt");
	};

	Files.write(Paths.get(workingDirectory, "/Notas/" + "Nota " + dataHoje + "-" + i + ".txt"), notaArray, StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW);
	
    }
}
