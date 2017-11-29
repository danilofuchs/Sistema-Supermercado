package classes;
import exceptions.NameNotFoundException;
import interfaceGrafica.VendaGUI;
import exceptions.NegativeStockException;
import exceptions.NameNotUniqueException;
import interfaceGrafica.CadastroUsuarioGUI;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SistemaSupermercadoMain {

    public static void main(String[] args) {
        UsuariosLista usuariosLista = new UsuariosLista();
        try {
            usuariosLista.addUsuario("Danilo", "danilo123", "1234", "Admin");
        } catch (NameNotUniqueException ex) {
            
        }
        
	Venda venda = new Venda();
	VendaGUI vendaWindow = new VendaGUI(venda);
        vendaWindow.setVisible(true);
        
        CargosLista cargosLista = new CargosLista();
        try {
            Cargo admin = new Cargo("Admin");
            admin.setPodeCriarVenda(true);
            admin.setPodeEditarEstoque(true);
            admin.setPodeRemoverProdutoVenda(true);
            admin.setPodeVerEstoque(true);
            cargosLista.addCargo(admin);
        } catch (NameNotUniqueException ex) {
            
        }
        
        CadastroUsuarioGUI cadastroWindow = new CadastroUsuarioGUI(usuariosLista, cargosLista);
        cadastroWindow.setVisible(true);
        
        usuariosLista.close();
    }
    


}
