/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceGrafica;

import classes.*;
import exceptions.*;
import java.awt.Event;
import java.awt.KeyboardFocusManager;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author danil
 */
public class LoginDialogGUI extends javax.swing.JDialog {
    private UsuariosLista usuariosLista;
    private Usuario usuario;
    public static int ACERTOU_LOGIN = 1;
    public static int ERROU_LOGIN = 2;
    public static int FECHOU_LOGIN = 0;
    
    private int status;

    /**
     * Creates new form LoginDialogGUI
     */
    public LoginDialogGUI(java.awt.Frame parent, boolean modal) {
	
	super(parent, modal);
	status = ERROU_LOGIN;
	usuariosLista = new UsuariosLista();
	initComponents();
	myInitComponents();
    }
    
    public Usuario getUsuario() {
	return usuario;
    }
    
    public int getStatus() {
	return status;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="My Init Codes">
    private void myInitComponents() {

    }
//</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_nomeUsuario = new javax.swing.JLabel();
        txtfd_nomeUsuario = new javax.swing.JTextField();
        lbl_senha = new javax.swing.JLabel();
        pass_senha = new javax.swing.JPasswordField();
        btn_sair = new javax.swing.JButton();
        btn_entrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/interfaceGrafica/cartIcon.png")).getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lbl_nomeUsuario.setText("Nome de usuário:");

        txtfd_nomeUsuario.setNextFocusableComponent(pass_senha);
        txtfd_nomeUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtfd_nomeUsuarioKeyPressed(evt);
            }
        });

        lbl_senha.setText("Senha:");

        pass_senha.setNextFocusableComponent(btn_entrar);
        pass_senha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pass_senhaKeyPressed(evt);
            }
        });

        btn_sair.setText("Sair");
        btn_sair.setNextFocusableComponent(txtfd_nomeUsuario);
        btn_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sairActionPerformed(evt);
            }
        });

        btn_entrar.setText("Entrar");
        btn_entrar.setNextFocusableComponent(btn_sair);
        btn_entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_entrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_sair)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_entrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_senha)
                            .addComponent(lbl_nomeUsuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfd_nomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pass_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfd_nomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nomeUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pass_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_senha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_entrar)
                    .addComponent(btn_sair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    
    private void txtfd_nomeUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfd_nomeUsuarioKeyPressed
        if (evt.getKeyCode() == Event.ENTER) {
            KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
            manager.focusNextComponent();
        }
    }//GEN-LAST:event_txtfd_nomeUsuarioKeyPressed

    private void pass_senhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass_senhaKeyPressed
        if (evt.getKeyCode() == Event.ENTER) {
            btn_entrar.doClick();
        }
    }//GEN-LAST:event_pass_senhaKeyPressed

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed
        status = FECHOU_LOGIN;
	this.dispose();
    }//GEN-LAST:event_btn_sairActionPerformed

    private void btn_entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_entrarActionPerformed
        String nomeUsuario = txtfd_nomeUsuario.getText();
        String senha = String.valueOf(pass_senha.getPassword());
        Usuario user = new Usuario("","","");
        boolean error = false;
        try {
            user = usuariosLista.getUsuario(nomeUsuario);
            if (user.checkPassword(senha)) {

            } else {
                error = true;
            }
        } catch (NameNotFoundException ex) {
            error = true;
        }
        if (error) {
            JOptionPane.showMessageDialog(null, "Nome de usuário ou senha incorretos", "Erro" , JOptionPane.WARNING_MESSAGE);
        } else {
            usuario = user;
	    status = ACERTOU_LOGIN;
	    this.dispose();
        }
    }//GEN-LAST:event_btn_entrarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        status = FECHOU_LOGIN;
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
	/* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
	 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
	 */
	try {
	    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		if ("Nimbus".equals(info.getName())) {
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

	/* Create and display the dialog */
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		LoginDialogGUI dialog = new LoginDialogGUI(new javax.swing.JFrame(), true);
		dialog.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent e) {
			
			System.exit(0);
		    }
		});
		dialog.setVisible(true);
	    }
	});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_entrar;
    private javax.swing.JButton btn_sair;
    private javax.swing.JLabel lbl_nomeUsuario;
    private javax.swing.JLabel lbl_senha;
    private javax.swing.JPasswordField pass_senha;
    private javax.swing.JTextField txtfd_nomeUsuario;
    // End of variables declaration//GEN-END:variables
}
