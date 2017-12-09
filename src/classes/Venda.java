
package classes;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Venda {
    private ArrayList<ItemVenda> itens;
    private int numItens = 0;
    private BigDecimal totalVenda;
    
    public Venda() {
	itens = new ArrayList();
	totalVenda = new BigDecimal("0");
    }
    
    public void addItem(ItemVenda item) {
	itens.add(item);
	calcTotal();
	numItens = itens.size();
    }
    
    public void removeItem(ItemVenda item) {
	if (itens.contains(item)) {
	    itens.remove(item);
	    calcTotal();
	    numItens = itens.size();
	}
    }
    
    public void removeItem(int index) {
	if (index >= 0 && index < itens.size()) {
	    //ItemVenda item = itens.get(index);
	    itens.remove(index);
	    calcTotal();
	    numItens = itens.size();
	}
    }
    
    private void calcTotal() {
	BigDecimal total = new BigDecimal("0.0");
	
	for (ItemVenda i : itens) 
	{
	    total = total.add(i.getPrecoTotalItem());
	}
	totalVenda = total;
    }
    
    public BigDecimal getTotal() {
	calcTotal();
	return totalVenda;
    }

    public int getNumItens() {
	return numItens;
    }

}
