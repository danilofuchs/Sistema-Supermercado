package classes;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Estoque {
    private ArrayList<ItemEstoque> itens;
    
    public Estoque(){
        itens = new ArrayList();
    }
    
    public void addItem(ItemEstoque item){
        itens.add(item);
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
}
