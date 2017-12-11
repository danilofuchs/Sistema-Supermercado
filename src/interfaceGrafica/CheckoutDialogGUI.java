
package interfaceGrafica;

import classes.*;
import exceptions.*;
import java.awt.Event;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class CheckoutDialogGUI extends javax.swing.JDialog {

    private Venda venda;
    private Usuario usuario;
    private CargosLista cargosLista;
    private BigDecimal pago;
    private BigDecimal troco;
    
    private MaskFormatter maskFormatterPago = new MaskFormatter();

    /**
     * Creates new form CheckoutDialogGUI
     */
    public CheckoutDialogGUI(java.awt.Frame parent, boolean modal, Venda venda, Usuario usuario, CargosLista cargosLista) {
	super(parent, modal);
	this.venda = venda;
	this.usuario = usuario;
	this.cargosLista = cargosLista;
	pago = new BigDecimal("0.00");
	troco = new BigDecimal("0.00");
	initComponents();
	myInitComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="My init codes">
    private void myInitComponents() {
	txtfd_total.setText(String.format("%.2f", venda.getTotal()));
	
	combo_metodos.addItem("Dinheiro");
	combo_metodos.addItem("Cartão de crédito");
	combo_metodos.addItem("Cartão de débito");
	
	txtfd_pago.requestFocus();
	lbl_vendedor.setText("Vendedor: " + usuario.getNome());
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtfd_total = new javax.swing.JTextField();
        lbl_total = new javax.swing.JLabel();
        lbl_vendedor = new javax.swing.JLabel();
        lbl_pago = new javax.swing.JLabel();
        txtfd_troco = new javax.swing.JTextField();
        lbl_troco = new javax.swing.JLabel();
        combo_metodos = new javax.swing.JComboBox();
        lbl_metodoPagamento = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtarea_notaFiscal = new javax.swing.JTextArea();
        lbl_rs1 = new javax.swing.JLabel();
        lbl_rs2 = new javax.swing.JLabel();
        lbl_rs3 = new javax.swing.JLabel();
        btn_finalizarVenda = new javax.swing.JButton();
        txtfd_pago = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Finalizar venda");
        setIconImage(new ImageIcon(getClass().getResource("/interfaceGrafica/cartIcon.png")).getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
        setPreferredSize(new java.awt.Dimension(530, 720));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        txtfd_total.setEditable(false);
        txtfd_total.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtfd_total.setText("0,00");

        lbl_total.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_total.setText("Total");

        lbl_vendedor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbl_vendedor.setText("Vendedor:");

        lbl_pago.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_pago.setText("Pago");

        txtfd_troco.setEditable(false);
        txtfd_troco.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtfd_troco.setText("0,00");

        lbl_troco.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_troco.setText("Troco");

        combo_metodos.setNextFocusableComponent(txtfd_pago);
        combo_metodos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_metodosItemStateChanged(evt);
            }
        });

        lbl_metodoPagamento.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_metodoPagamento.setText("Método de Pagamento");

        txtarea_notaFiscal.setColumns(20);
        txtarea_notaFiscal.setRows(5);
        jScrollPane1.setViewportView(txtarea_notaFiscal);

        lbl_rs1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_rs1.setText("R$");

        lbl_rs2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_rs2.setText("R$");

        lbl_rs3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_rs3.setText("R$");

        btn_finalizarVenda.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btn_finalizarVenda.setText("Finalizar Venda");
        btn_finalizarVenda.setName(""); // NOI18N
        btn_finalizarVenda.setNextFocusableComponent(combo_metodos);
        btn_finalizarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_finalizarVendaActionPerformed(evt);
            }
        });

        txtfd_pago.setEditable(false);
        txtfd_pago.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtfd_pago.setNextFocusableComponent(btn_finalizarVenda);
        txtfd_pago.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtfd_pagoPropertyChange(evt);
            }
        });
        txtfd_pago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtfd_pagoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfd_pagoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_vendedor)
                        .addGap(86, 86, 86)
                        .addComponent(btn_finalizarVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_troco)
                                .addGap(12, 12, 12))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_pago)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_rs3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtfd_troco, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_rs1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtfd_pago, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_metodoPagamento)
                            .addComponent(lbl_total))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_rs2)
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfd_total, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_metodos, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_total)
                    .addComponent(txtfd_total, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_rs2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_metodos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_metodoPagamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_rs1)
                    .addComponent(lbl_pago)
                    .addComponent(txtfd_pago, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfd_troco, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_rs3)
                    .addComponent(lbl_troco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_finalizarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_vendedor))
                .addGap(24, 24, 24))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void combo_metodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_metodosItemStateChanged
        String metodoPagamento = (String)combo_metodos.getSelectedItem();
	if (metodoPagamento.equals("Dinheiro")) {
	    pago = new BigDecimal("0.00");
	    txtfd_pago.setText("0,00");
	    txtfd_pago.setEditable(true);
	} else if (metodoPagamento.equals("Cartão de crédito")) {
	    pago = venda.getTotal();
	    txtfd_pago.setText(String.format("%.2f", venda.getTotal().setScale(2)));
	    txtfd_pago.setEditable(false);
	} else if (metodoPagamento.equals("Cartão de débito")) {
	    pago = venda.getTotal();
	    txtfd_pago.setText(String.format("%.2f", venda.getTotal().setScale(2)));
	    txtfd_pago.setEditable(false);
	}
	updateTroco();
    }//GEN-LAST:event_combo_metodosItemStateChanged

    private void txtfd_pagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfd_pagoKeyReleased
        if (txtfd_pago.isEditable()) {
	    addValuePago(evt.getKeyChar());
	}
    }//GEN-LAST:event_txtfd_pagoKeyReleased

    private void txtfd_pagoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtfd_pagoPropertyChange
        updateTroco();
    }//GEN-LAST:event_txtfd_pagoPropertyChange

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
	int confirmExit = JOptionPane.showConfirmDialog(rootPane, "Deseja editar a venda?", "Editar venda", JOptionPane.YES_NO_OPTION);

	if (confirmExit == JOptionPane.OK_OPTION) {
	    this.dispose();
	} else if (confirmExit == JOptionPane.NO_OPTION) {

	}
    }//GEN-LAST:event_formWindowClosing

    private void btn_finalizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_finalizarVendaActionPerformed
        Estoque estoque = new Estoque();
	estoque.inicializarEstoque();
	for (int i = 0; i < venda.getNumItens(); i++) {
	    Produto prod = venda.getItemVenda(i).getProduto();
	    estoque.removeQtdItem(prod.getCodigoDeBarras(), venda.getItemVenda(i).getQtd());
	}
	try {
	    estoque.updateEstoque();
	}
	catch (IOException ex) {
	    Logger.getLogger(CheckoutDialogGUI.class.getName()).log(Level.SEVERE, null, ex);
	}
	Empresa empresa = new Empresa("Supermercado Silva", "06.990.590/0001-23");
	NotaFiscal nota = new NotaFiscal(venda, empresa);
	txtarea_notaFiscal.setText(nota.imprimirNota());
	nota.salvaNotaArquivo();
    }//GEN-LAST:event_btn_finalizarVendaActionPerformed

    private void txtfd_pagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfd_pagoKeyPressed
        if (evt.getKeyCode() == Event.ENTER) {
	    btn_finalizarVenda.doClick();
	}
    }//GEN-LAST:event_txtfd_pagoKeyPressed

    private void updateTroco() {
	troco = pago.subtract(venda.getTotal());
	txtfd_troco.setText(String.format("%.2f", troco));
    }
    
    private void addValuePago(char key) {
	if (key >= '0' && key <= '9') {
	    pago = pago.multiply(new BigDecimal("10"));
	    pago = pago.add(new BigDecimal(String.valueOf(key)).scaleByPowerOfTen(-2));
	} else if (key == KeyEvent.VK_BACK_SPACE) {
	    pago = pago.setScale(1,RoundingMode.DOWN).divide(new BigDecimal("10")).setScale(2);
	}
	txtfd_pago.setText(String.format("%.2f", pago));
	updateTroco();
    }
    
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
	    java.util.logging.Logger.getLogger(CheckoutDialogGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(CheckoutDialogGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(CheckoutDialogGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(CheckoutDialogGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
        //</editor-fold>

	/* Create and display the dialog */
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		CheckoutDialogGUI dialog = new CheckoutDialogGUI(new javax.swing.JFrame(), true, new Venda(), new Usuario("", "", ""), new CargosLista());
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
    private javax.swing.JButton btn_finalizarVenda;
    private javax.swing.JComboBox combo_metodos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_metodoPagamento;
    private javax.swing.JLabel lbl_pago;
    private javax.swing.JLabel lbl_rs1;
    private javax.swing.JLabel lbl_rs2;
    private javax.swing.JLabel lbl_rs3;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JLabel lbl_troco;
    private javax.swing.JLabel lbl_vendedor;
    private javax.swing.JTextArea txtarea_notaFiscal;
    private javax.swing.JTextField txtfd_pago;
    private javax.swing.JTextField txtfd_total;
    private javax.swing.JTextField txtfd_troco;
    // End of variables declaration//GEN-END:variables
}
