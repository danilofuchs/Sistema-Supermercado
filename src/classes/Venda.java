
package classes;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Venda {
    private ArrayList<ItemVenda> itens;
    private BigDecimal totalVenda;
    
    public Venda() {
	itens = new ArrayList();
	totalVenda = new BigDecimal("0");
    }
    
    public void addItem(ItemVenda item) {
	itens.add(item);
	totalVenda = totalVenda.add(item.getPrecoTotalItem());
    }
    
    public void removeItem(ItemVenda item) {
	itens.remove(item);
	totalVenda = totalVenda.add(item.getPrecoTotalItem().negate());
    }
    
    public void removeItem(int index) {
	ItemVenda item = itens.get(index);
	totalVenda = totalVenda.add(item.getPrecoTotalItem().negate());
	itens.remove(item);
    }
    
    public BigDecimal getTotal() {
	return totalVenda;
    }
    
}
