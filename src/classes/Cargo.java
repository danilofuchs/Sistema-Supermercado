
package classes;

public class Cargo {
    private String nome;
    private boolean podeRemoverProdutoVenda = false;
    private boolean podeCriarVenda = false;
    private boolean podeVerEstoque = false;
    private boolean podeEditarEstoque = false;
    
    public Cargo(String nome) {
       this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPodeCriarVenda(boolean podeCriarVenda) {
        this.podeCriarVenda = podeCriarVenda;
    }

    public void setPodeEditarEstoque(boolean podeEditarEstoque) {
        this.podeEditarEstoque = podeEditarEstoque;
    }

    public void setPodeRemoverProdutoVenda(boolean podeRemoverProdutoVenda) {
        this.podeRemoverProdutoVenda = podeRemoverProdutoVenda;
    }

    public void setPodeVerEstoque(boolean podeVerEstoque) {
        this.podeVerEstoque = podeVerEstoque;
    }

    public boolean podeCriarVenda() {
        return podeCriarVenda;
    }

    public boolean podeEditarEstoque() {
        return podeEditarEstoque;
    }

    public boolean podeRemoverProdutoVenda() {
        return podeRemoverProdutoVenda;
    }

    public boolean podeVerEstoque() {
        return podeVerEstoque;
    }
    
    

}
