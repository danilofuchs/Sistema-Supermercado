/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceGrafica;

import classes.*;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 *
 * @author danil
 */
public class MenuPrincipalGUI extends javax.swing.JFrame {

    private static Usuario usuario;
    private static UsuariosLista usuariosLista;
    private static CargosLista cargosLista;
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
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_novaVenda = new javax.swing.JButton();
        btn_sair = new javax.swing.JButton();
        lbl_bemVindo = new javax.swing.JLabel();
        btn_logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_novaVenda.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_novaVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaceGrafica/cart.png"))); // NOI18N
        btn_novaVenda.setText("Nova venda");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_bemVindo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_logout))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btn_sair))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(btn_novaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 68, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_bemVindo)
                    .addComponent(btn_logout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(btn_novaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(btn_sair)
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
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void btn_novaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novaVendaActionPerformed
        Venda venda = new Venda();
	VendaGUI vendaGUI = new VendaGUI(venda, usuario, cargosLista);
	vendaGUI.setVisible(true);
    }//GEN-LAST:event_btn_novaVendaActionPerformed

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_sairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_novaVenda;
    private javax.swing.JButton btn_sair;
    private javax.swing.JLabel lbl_bemVindo;
    // End of variables declaration//GEN-END:variables
}
