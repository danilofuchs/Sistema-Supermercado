/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceGrafica;

import classes.*;
import exceptions.NameNotFoundException;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 *
 * @author danil
 */
public class MenuPrincipalGUI extends javax.swing.JFrame {

    private static Usuario usuario;
    private static UsuariosLista usuariosLista;
    private CargosLista cargosLista;
    private static boolean logado = false;

    /**
     * Creates new form MenuPrincipalGUI
     */
    public MenuPrincipalGUI(CargosLista cargosLista) {
	this.cargosLista = cargosLista;
	initComponents();
	myInitComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="My Init Codes">
    private void myInitComponents() {
	ImageIcon icon = (ImageIcon) btn_novaVenda.getIcon();
	Image img = icon.getImage();
	Image newimg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
	icon = new ImageIcon(newimg);
	btn_novaVenda.setIcon(icon);
	btn_novaVenda.setVerticalTextPosition(SwingConstants.BOTTOM);
	btn_novaVenda.setHorizontalTextPosition(SwingConstants.CENTER);
	btn_novaVenda.requestFocus();

	JFrame frame = new JFrame("");
	LoginDialogGUI loginDlg = new LoginDialogGUI(frame, true);
	loginDlg.setVisible(true);
	
	// if logon successfully
	int statusLogin = loginDlg.getStatus();
	if (statusLogin == LoginDialogGUI.ACERTOU_LOGIN) {
	    usuario = loginDlg.getUsuario();
	    lbl_bemVindo.setText("Bem-vindo " + usuario.getNome() + " (" + usuario.getCargo() + ")");
	    loginDlg.dispose();
	} else if (statusLogin == LoginDialogGUI.FECHOU_LOGIN) {
	    this.dispose();
	    System.exit(0);
	} else if (statusLogin == LoginDialogGUI.ERROU_LOGIN) {
	    this.dispose();
	}
	try {
	    if (cargosLista.getCargo(usuario.getCargo()).podeAdicionarUsuario()) {
		btn_addUsuario.setEnabled(true);
	    }
	    if (cargosLista.getCargo(usuario.getCargo()).podeCriarVenda()) {
		btn_novaVenda.setEnabled(true);
	    }
	}
	catch (NameNotFoundException ex) {
	    
	}
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_novaVenda = new javax.swing.JButton();
        btn_sair = new javax.swing.JButton();
        lbl_bemVindo = new javax.swing.JLabel();
        btn_logout = new javax.swing.JButton();
        btn_addUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btn_novaVenda.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_novaVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaceGrafica/cart.png"))); // NOI18N
        btn_novaVenda.setText("Nova venda");
        btn_novaVenda.setEnabled(false);
        btn_novaVenda.setNextFocusableComponent(btn_sair);
        btn_novaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novaVendaActionPerformed(evt);
            }
        });

        btn_sair.setText("Sair");
        btn_sair.setNextFocusableComponent(btn_logout);
        btn_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sairActionPerformed(evt);
            }
        });

        lbl_bemVindo.setText("Bem-vindo");

        btn_logout.setText("Logout");
        btn_logout.setNextFocusableComponent(btn_novaVenda);
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        btn_addUsuario.setText("Adicionar usuário");
        btn_addUsuario.setEnabled(false);
        btn_addUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_sair)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_addUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_logout)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbl_bemVindo)
                        .addGap(284, 284, 284))))
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(btn_novaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_bemVindo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(btn_novaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_sair)
                    .addComponent(btn_logout)
                    .addComponent(btn_addUsuario))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
	JFrame frame = new JFrame("");
	LoginDialogGUI loginDlg = new LoginDialogGUI(frame, true);
	loginDlg.setVisible(true);
	
	// if logon successfully
	int statusLogin = loginDlg.getStatus();
	if (statusLogin == LoginDialogGUI.ACERTOU_LOGIN) {
	    usuario = loginDlg.getUsuario();
	    lbl_bemVindo.setText("Bem-vindo " + usuario.getNome() + " (" + usuario.getCargo() + ")");
	    loginDlg.dispose();
	} else if (statusLogin == LoginDialogGUI.FECHOU_LOGIN) {
	    this.dispose();
	    System.exit(0);
	} else if (statusLogin == LoginDialogGUI.ERROU_LOGIN) {
	    this.dispose();
	}
	try {
	    if (cargosLista.getCargo(usuario.getCargo()).podeAdicionarUsuario()) {
		btn_addUsuario.setEnabled(true);
	    }
	}
	catch (NameNotFoundException ex) {
	    
	}
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void btn_novaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novaVendaActionPerformed
	try {
	    if (cargosLista.getCargo(usuario.getCargo()).podeCriarVenda()) {
		Venda venda = new Venda();
		VendaGUI vendaGUI = new VendaGUI(venda, usuario, cargosLista);
		vendaGUI.setVisible(true);
	    } else {
		JOptionPane.showMessageDialog(rootPane, "Você não tem permissões suficientes para fazer esta ação", "Permissão insuficiente", JOptionPane.WARNING_MESSAGE);
	    }
	}
	catch (NameNotFoundException ex) {
	    Logger.getLogger(MenuPrincipalGUI.class.getName()).log(Level.SEVERE, null, ex);
	}
    }//GEN-LAST:event_btn_novaVendaActionPerformed

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed
        this.dispose();
	System.exit(0);
    }//GEN-LAST:event_btn_sairActionPerformed

    private void btn_addUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addUsuarioActionPerformed
        Frame frame = new Frame("");
	CadastroUsuarioDialogGUI cad = new CadastroUsuarioDialogGUI(frame, false, cargosLista);
	cad.setVisible(true);
    }//GEN-LAST:event_btn_addUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addUsuario;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_novaVenda;
    private javax.swing.JButton btn_sair;
    private javax.swing.JLabel lbl_bemVindo;
    // End of variables declaration//GEN-END:variables
}
