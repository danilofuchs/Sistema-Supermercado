package classes;

import java.util.ArrayList;

public class NotaFiscal {
    private ArrayList<ItemVenda> itens;
    private Empresa empresa;

    public NotaFiscal(ArrayList<ItemVenda> itens, Empresa empresa) {
        this.itens = itens;
        this.empresa = empresa;
    }

    public ArrayList<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemVenda> itens) {
        this.itens = itens;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
}
