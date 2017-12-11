package classes;

import exceptions.NameNotFoundException;
import exceptions.ProductNotUniqueException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

public class Estoque {

    private ArrayList<ItemEstoque> itens;

    public Estoque() {
	itens = new ArrayList();
    }

    public void addItem(ItemEstoque item) throws ProductNotUniqueException {
	boolean foundEqual = false;
	for (ItemEstoque i : itens) {
	    if (i.getProduto().getCodigoDeBarras().equals(item.getProduto().getCodigoDeBarras())) {
		foundEqual = true;
	    }
	}
	if (foundEqual) {
	    throw new ProductNotUniqueException("Código de barras já cadastrado.");
	} else {
	    itens.add(item);
	}
    }

    public void removeItem(ItemEstoque item) {
	itens.remove(item);
    }

    public void removeItem(String codigoDeBarras) {
	for (ItemEstoque i : itens) {
	    if (i.getProduto().getCodigoDeBarras().equals(codigoDeBarras)) {
		removeItem(i);
	    }
	}
    }

    public void removeQtdItem(String codigoDeBarras, BigDecimal qtd) {
	for (ItemEstoque i : itens) {
	    if (i.getProduto().getCodigoDeBarras().equals(codigoDeBarras)) {
		i.removeQtdProduto(qtd);
	    }
	}
    }

    public ItemEstoque findItem(String codigoDeBarras) throws NameNotFoundException {
	ItemEstoque item = null;
	boolean found = false;

	for (ItemEstoque i : itens) {
	    if (i.getProduto().getCodigoDeBarras().equals(codigoDeBarras)) {
		item = i;
		found = true;
	    }
	}
	if (found) {
	    return item;
	} else {
	    throw new NameNotFoundException("Nenhum produto com este código de barras");
	}
    }

    public void inicializarEstoque() {

	ArrayList<String> estoqueArquivo;
	try {
	    estoqueArquivo = (ArrayList) Files.readAllLines(Paths.get("EstoqueJSON.txt"));

	    for (String s : estoqueArquivo) {
		JSONObject obj = new JSONObject(s);
		try {
		    addItem(new ItemEstoque(new Produto(
					    obj.getString("nome"),
					    new BigDecimal(obj.getString("preco")),
					    obj.getString("UN"),
					    obj.getString("codigo de barras").replaceAll("\\n", "")),
			    new BigDecimal(obj.getString("quantidade"))
			    ));
		}
		catch (ProductNotUniqueException ex) {
		    //não fazer nada (não adiciona)
		}
		
	    }
	}
	catch (IOException ex) {
	    Logger.getLogger(Estoque.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    
    public void updateEstoque() throws IOException{
        ArrayList<JSONObject> objArray = new ArrayList();
        ArrayList<String> estoqueString = new ArrayList();
        
        for(ItemEstoque i: itens){
            JSONObject obj = new JSONObject();
            obj.put("nome", i.getProduto().getNome());
            obj.put("UN", i.getProduto().getUnidade());
            obj.put("codigo de barras", i.getProduto().getCodigoDeBarras());
            obj.put("preco", i.getProduto().getPreco().toPlainString());
            obj.put("quantidade", i.getQtd().toPlainString());
            objArray.add(obj);
        }
        
        for(JSONObject o: objArray){
            estoqueString.add(o.toString());
        }
        Files.write(Paths.get("EstoqueJSON.txt"), estoqueString, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);
    }

}
