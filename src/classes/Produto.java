
package classes;
import exceptions.NegativeStockException;
import java.math.BigDecimal;

public class Produto {
    
    private String nome;
    private BigDecimal preco;
    private String unidade;
    
    private BigDecimal quantidadeEstoque;
    private String codigoDeBarras;

    //Construtor:
    public Produto(String nome, BigDecimal preco, String unidade, BigDecimal quantidadeEstoque, String codigoDeBarras) {
        this.preco = preco;
	this.unidade = unidade;
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

    public String getUnidade() {
	return unidade;
    }

    public void setUnidade(String unidade) {
	this.unidade = unidade;
    }

    public BigDecimal getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(BigDecimal quantidadeEstoque) {
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
    
    public void retiraQtdEstoque(BigDecimal qtd) throws NegativeStockException {
        if (quantidadeEstoque.add(qtd.negate()).max(new BigDecimal("0")) != new BigDecimal("0")) {
            this.quantidadeEstoque.add(qtd.negate());
        } else {
            throw new NegativeStockException("Estoque ficaria negativo (" + (quantidadeEstoque.add(qtd.negate())) + ")");
        }
    }
    
}