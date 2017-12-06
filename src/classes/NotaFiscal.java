package classes;

import java.util.ArrayList;

public class NotaFiscal {
    private ArrayList<ItemVenda> itens;

    public NotaFiscal(ArrayList<ItemVenda> itens) {
        this.itens = itens;
    }

    public ArrayList<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemVenda> itens) {
        this.itens = itens;
    }
    
}
