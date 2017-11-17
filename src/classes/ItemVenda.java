
package classes;

public class ItemVenda {
    private Produto produto;
    private double qtd;
    private double precoTotalItem;

    public ItemVenda() {
    }

    public ItemVenda(Produto produto, double qtd) {
	this.produto = produto;
	this.qtd = qtd;
	this.precoTotalItem = produto.getPreco() * qtd;
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

    public void setProduto(Produto produto) {
	this.produto = produto;
	precoTotalItem = produto.getPreco() * qtd;
    }

    public void setQtd(double qtd) {
	this.qtd = qtd;
	precoTotalItem = produto.getPreco() * qtd;
    }
    
    
}
