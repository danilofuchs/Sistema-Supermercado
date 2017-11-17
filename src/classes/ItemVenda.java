
package classes;

import java.math.BigDecimal;

public class ItemVenda {
    private Produto produto;
    private BigDecimal qtd;
    private BigDecimal precoTotalItem;

    public ItemVenda() {
    }

    public ItemVenda(Produto produto, BigDecimal qtd) {
	this.produto = produto;
	this.qtd = qtd;
	this.precoTotalItem = produto.getPreco().multiply(qtd);
    }

    public BigDecimal getPrecoTotalItem() {
	return precoTotalItem;
    }

    public Produto getProduto() {
	return produto;
    }
    
    public BigDecimal getQtd() {
	return qtd;
    }

    public void setProduto(Produto produto) {
	this.produto = produto;
	precoTotalItem = this.produto.getPreco().multiply(qtd);
    }

    public void setQtd(BigDecimal qtd) {
	this.qtd = qtd;
	precoTotalItem = produto.getPreco().multiply(qtd);
    }
    
    
}
