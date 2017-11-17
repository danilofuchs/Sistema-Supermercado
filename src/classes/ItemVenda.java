
package classes;

public class ItemVenda {
    private Produto produto;
    private double qtd;
    private double precoItem;

    public ItemVenda() {
    }

    public ItemVenda(Produto produto, double qtd, double precoItem) {
	this.produto = produto;
	this.qtd = qtd;
	this.precoItem = precoItem;
    }

    public double getPrecoItem() {
	return precoItem;
    }

    public Produto getProduto() {
	return produto;
    }
    
    public double getQtd() {
	return qtd;
    }

    public void setPrecoItem(double precoItem) {
	this.precoItem = precoItem;
    }

    public void setProduto(Produto produto) {
	this.produto = produto;
    }

    public void setQtd(double qtd) {
	this.qtd = qtd;
    }
    
    
}
