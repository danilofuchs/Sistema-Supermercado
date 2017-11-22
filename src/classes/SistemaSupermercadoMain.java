package classes;
import interfaceGrafica.VendaGUI;
import exceptions.NegativeStockException;

public class SistemaSupermercadoMain {

    public static void main(String[] args) {
        UsuariosLista usuariosLista = new UsuariosLista();
        
	Venda venda = new Venda();
	VendaGUI vendaWindow = new VendaGUI(venda);
        vendaWindow.setVisible(true);
        
        usuariosLista.close();
    }
    


}
