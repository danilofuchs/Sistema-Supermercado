package classes;

import java.math.BigDecimal;

public class ItemEstoque {
    private Produto produto;
    private BigDecimal qtd;

    //Construtor
    public ItemEstoque(Produto produto, BigDecimal qtd) {
        this.produto = produto;
        this.qtd = qtd;
    }

    //Getters e Setters
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getQtd() {
        return qtd;
    }

    public void setQtd(BigDecimal qtd) {
        this.qtd = qtd;
    }
    
    public void removeQtdProduto(BigDecimal qtd){
        this.qtd.subtract(qtd);
    }
    
    
    
    
}
