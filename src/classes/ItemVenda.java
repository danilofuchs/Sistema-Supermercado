
package classes;

import java.math.BigDecimal;

public class ItemVenda {
    private Produto produto;
    private BigDecimal qtd;
    private BigDecimal precoTotalItem;
    private int sequencial;

    public ItemVenda() {
    }

    public ItemVenda(Produto produto, BigDecimal qtd, int sequencial) {
	this.produto = produto;
	this.qtd = qtd;
	this.precoTotalItem = produto.getPreco().multiply(qtd);
	this.sequencial = sequencial;
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

    public void setSequencial(int sequencial) {
	this.sequencial = sequencial;
    }

    public int getSequencial() {
	return sequencial;
    }
}
