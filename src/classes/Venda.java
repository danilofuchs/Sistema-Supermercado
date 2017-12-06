
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
	totalVenda = totalVenda.add(item.getPrecoTotalItem());
	numItens++;
    }
    
    public void removeItem(ItemVenda item) {
	if (itens.contains(item)) {
	    itens.remove(item);
	    totalVenda = totalVenda.add(item.getPrecoTotalItem().negate());
	    numItens--;
	}
    }
    
    public void removeItem(int index) {
	if (itens.size() > index && index > 0) {
	    ItemVenda item = itens.get(index);
	    totalVenda = totalVenda.add(item.getPrecoTotalItem().negate());
	    itens.remove(item);
	    numItens--;
	}
    }
    
    public BigDecimal getTotal() {
	return totalVenda;
    }

    public int getNumItens() {
	return numItens;
    }

}
