package classes;

import exceptions.ProductNotUniqueException;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.json.simple.JSONObject;

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
    
    //Inicializador:
    public void getEstoqueArquivo(){
        JSONObject obj = new JSONObject();
    }
    
}
