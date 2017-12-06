package classes;
import exceptions.NameNotFoundException;
import interfaceGrafica.*;
import exceptions.NegativeStockException;
import exceptions.NameNotUniqueException;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SistemaSupermercadoMain {

    public static void main(String[] args) {
	
	/* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
	 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
	 */
	try {
	    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		if ("Windows".equals(info.getName())) {
		    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		    break;
		}
	    }
	}
	catch (ClassNotFoundException ex) {
	    java.util.logging.Logger.getLogger(LoginDialogGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(LoginDialogGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(LoginDialogGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(LoginDialogGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
        //</editor-fold>

        //UsuariosLista usuariosLista = new UsuariosLista();
	/*
        try {
            usuariosLista.addUsuario("Danilo", "danilo123", "1234", "Admin");
        } catch (NameNotUniqueException ex) {
            
        }*/
        /*
	Venda venda = new Venda();
	VendaGUI vendaWindow = new VendaGUI(venda);
        vendaWindow.setVisible(true);
        

        Usuario usuario = new Usuario("","","");
        LoginGUI log = new LoginGUI(usuariosLista, usuario);
        log.setVisible(true);
        
	if (!log.isActive()) {*/
	MenuPrincipalGUI menu = new MenuPrincipalGUI();
	menu.setVisible(true);
	//}
	
	
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
        /*
        CadastroUsuarioGUI cadastroWindow = new CadastroUsuarioGUI(usuariosLista, cargosLista);
        cadastroWindow.setVisible(true);
	*/
	
	//usuariosLista.close();
    }
    


}
