package classes;

import exceptions.ProductNotUniqueException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.json.JSONObject;

public class Estoque {
    private ArrayList<ItemEstoque> itens;
    
    public Estoque(){
        itens = new ArrayList();
    }
    
    public void addItem(ItemEstoque item) throws ProductNotUniqueException {
        for(ItemEstoque i: itens){
            if(i == item){
                throw new ProductNotUniqueException("Código de barras já cadastrado.");
            }
        }
    }
    
    public void removeItem(ItemEstoque item){
        itens.remove(item);
    }
    
    public void removeItem(String codigoDeBarras){
        for(ItemEstoque i: itens){
            if(i.getProduto().getCodigoDeBarras().equals(codigoDeBarras)){
                removeItem(i);
            }
        }
    }
    
    public void removeQtdItem(String codigoDeBarras, BigDecimal qtd){
        for(ItemEstoque i: itens){
            if(i.getProduto().getCodigoDeBarras().equals(codigoDeBarras)){
                i.removeQtdProduto(qtd);
            }
        }
    }
    
    public ItemEstoque findItem(String codigoDeBarras){
        ItemEstoque item = null;
        
        for(ItemEstoque i: itens){
            if(i.getProduto().getCodigoDeBarras().equals(codigoDeBarras)){
                item = i;
            }
        }
        
        return item;
    }
    
    public void inicializarEstoque() throws IOException, ProductNotUniqueException{
        ArrayList<String> estoqueArquivo = (ArrayList)Files.readAllLines(Paths.get("EstoqueJSON.txt"));
        
        for(String s: estoqueArquivo){
            JSONObject obj = new JSONObject(s);
            
            addItem(new ItemEstoque(new Produto(obj.getString("nome"), 
            new BigDecimal(obj.getString("preco")), obj.getString("UN"),
            obj.getString("codigo de barras")),
            new BigDecimal(obj.getString("quantidade"))));
        }
        
    }
    
}
