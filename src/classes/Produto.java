
package classes;
import exceptions.NegativeStockException;
import java.math.BigDecimal;

public class Produto {
    private BigDecimal preco;
    private double quantidadeEstoque;
    private String codigoDeBarras;
    private String nome;


    //Construtor:
    public Produto(String nome, BigDecimal preco, double quantidadeEstoque, String codigoDeBarras) {
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.codigoDeBarras = codigoDeBarras;
        this.nome = nome;
    }
    
    //Getters e Setters:
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(double quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }
    
    public void setCodigoDeBarrasInt(int codigoDeBarras) {
        this.codigoDeBarras = Integer.toString(codigoDeBarras);
    }
    
    public void retiraQtdEstoque(int qtd) throws NegativeStockException {
        if (quantidadeEstoque - qtd > 0) {
            this.quantidadeEstoque -= qtd;
        } else {
            throw new NegativeStockException("Estoque ficaria negativo (" + (quantidadeEstoque - qtd) + ")");
        }
    }
    
}
