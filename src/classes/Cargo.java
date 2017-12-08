
package classes;

public class Cargo {
    private String nome;
    private boolean podeRemoverProdutoVenda = false;
    private boolean podeCriarVenda = false;
    private boolean podeCancelarVenda = false;
    private boolean podeAdicionarUsuario = false;
    
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

    public void setPodeCancelarVenda(boolean podeCancelarVenda) {
	this.podeCancelarVenda = podeCancelarVenda;
    }

    public void setPodeRemoverProdutoVenda(boolean podeRemoverProdutoVenda) {
        this.podeRemoverProdutoVenda = podeRemoverProdutoVenda;
    }

    public void setPodeAdicionarUsuario(boolean podeAdicionarUsuario) {
	this.podeAdicionarUsuario = podeAdicionarUsuario;
    }
    

    public boolean podeCriarVenda() {
        return podeCriarVenda;
    }
    
    public boolean podeCancelarVenda() {
        return podeCancelarVenda;
    }

    public boolean podeRemoverProdutoVenda() {
        return podeRemoverProdutoVenda;
    }

    public boolean podeAdicionarUsuario() {
	return podeAdicionarUsuario;
    }

    
    

}
