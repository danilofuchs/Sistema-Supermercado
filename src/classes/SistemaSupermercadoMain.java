package classes;
import interfaceGrafica.*;
import exceptions.NameNotUniqueException;

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
	
	CargosLista cargosLista = new CargosLista();
        try {
            Cargo admin = new Cargo("Admin");
            admin.setPodeCriarVenda(true);
	    admin.setPodeCancelarVenda(true);
            admin.setPodeRemoverProdutoVenda(true);
	    admin.setPodeAdicionarUsuario(true);
            cargosLista.addCargo(admin);
	    
	    Cargo gerente = new Cargo("Gerente");
            gerente.setPodeCriarVenda(true);
	    gerente.setPodeCancelarVenda(true);
            gerente.setPodeRemoverProdutoVenda(true);
	    gerente.setPodeAdicionarUsuario(false);
            cargosLista.addCargo(gerente);
	    
	    Cargo caixa = new Cargo("Caixa");
	    caixa.setPodeCriarVenda(true);
	    caixa.setPodeAdicionarUsuario(false);
	    caixa.setPodeCancelarVenda(false);
            caixa.setPodeRemoverProdutoVenda(false);
            cargosLista.addCargo(caixa);
        } catch (NameNotUniqueException ex) {
            
        }
	
	MenuPrincipalGUI menu = new MenuPrincipalGUI(cargosLista);
	menu.setVisible(true);
        /*
        CadastroUsuarioGUI cadastroWindow = new CadastroUsuarioGUI(usuariosLista, cargosLista);
        cadastroWindow.setVisible(true);
	*/

    }
    


}
