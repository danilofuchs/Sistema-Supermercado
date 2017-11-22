package classes;
import interfaceGrafica.VendaGUI;
import exceptions.NegativeStockException;
import exceptions.UsernameNotUniqueException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SistemaSupermercadoMain {

    public static void main(String[] args) {
        UsuariosLista usuariosLista = new UsuariosLista();
        try {
            usuariosLista.addUsuario("Danilo", "1234", "Admin");
        } catch (UsernameNotUniqueException ex) {
            
        }
        
	Venda venda = new Venda();
	VendaGUI vendaWindow = new VendaGUI(venda);
        vendaWindow.setVisible(true);
        
        usuariosLista.close();
    }
    


}
