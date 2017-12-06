package classes;

import exceptions.NameNotFoundException;
import exceptions.ProductNotUniqueException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
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
	for (ItemEstoque i : itens) {
	    if (i == item) {
		throw new ProductNotUniqueException("Código de barras já cadastrado.");
	    }
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
			    new BigDecimal(obj.getString("preco")), obj.getString("UN"),
			    obj.getString("codigo de barras")),
			    new BigDecimal(obj.getString("quantidade")
			    )));
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

}
