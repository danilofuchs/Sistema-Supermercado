
package classes;

public class ItemVenda {
    private Produto produto;
    private double qtd;
    private double precoTotalItem;

    public ItemVenda() {
    }

    public ItemVenda(Produto produto, double qtd, double precoItem) {
	this.produto = produto;
	this.qtd = qtd;
	this.precoTotalItem = precoItem;
    }

    public double getPrecoTotalItem() {
	return precoTotalItem;
    }

    public Produto getProduto() {
	return produto;
    }
    
    public double getQtd() {
	return qtd;
    }

    public void setPrecoTotalItem(double precoItem) {
	this.precoTotalItem = precoItem;
    }

    public void setProduto(Produto produto) {
	this.produto = produto;
    }

    public void setQtd(double qtd) {
	this.qtd = qtd;
    }
    
    
}
