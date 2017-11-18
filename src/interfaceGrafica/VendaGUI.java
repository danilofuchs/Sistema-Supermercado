/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceGrafica;

import classes.Produto;
import classes.ItemVenda;
import classes.Venda;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import javax.swing.table.TableModel;

public class VendaGUI extends javax.swing.JFrame {
    private Venda venda;
    /**
     * Creates new form VendaGUI
     */
    public VendaGUI() {
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
	    java.util.logging.Logger.getLogger(VendaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(VendaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(VendaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(VendaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	
	//</editor-fold>
	initComponents();
    }
    
    public VendaGUI(Venda venda) {
	
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
	    java.util.logging.Logger.getLogger(VendaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(VendaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(VendaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(VendaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	
	//</editor-fold>
	initComponents();

	this.venda = venda;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_removeProduto = new javax.swing.JButton();
        btn_addProduto = new javax.swing.JButton();
        txtfd_nomeProduto = new javax.swing.JTextField();
        txtfd_codProduto = new javax.swing.JTextField();
        txtfd_qtdProduto = new javax.swing.JTextField();
        lbl_nome = new javax.swing.JLabel();
        lbl_cod = new javax.swing.JLabel();
        lbl_qtd = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_produtos = new javax.swing.JTable();
        lbl_total = new javax.swing.JLabel();
        txtfd_total = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nova Venda");
        setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btn_removeProduto.setText("Remover");
        btn_removeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeProdutoActionPerformed(evt);
            }
        });

        btn_addProduto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_addProduto.setText("Adicionar Produto");
        btn_addProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addProdutoActionPerformed(evt);
            }
        });

        txtfd_nomeProduto.setEditable(false);
        txtfd_nomeProduto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtfd_codProduto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtfd_qtdProduto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lbl_nome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_nome.setText("Nome do Produto");

        lbl_cod.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_cod.setText("Código do Produto");

        lbl_qtd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_qtd.setText("Quantidade");

        table_produtos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        table_produtos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Quantidade", "Preço Unitário", "Preço Item"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_produtos.setRowHeight(20);
        table_produtos.setShowVerticalLines(false);
        table_produtos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(table_produtos);
        if (table_produtos.getColumnModel().getColumnCount() > 0) {
            table_produtos.getColumnModel().getColumn(0).setResizable(false);
            table_produtos.getColumnModel().getColumn(0).setPreferredWidth(200);
            table_produtos.getColumnModel().getColumn(1).setResizable(false);
            table_produtos.getColumnModel().getColumn(1).setPreferredWidth(100);
            table_produtos.getColumnModel().getColumn(2).setResizable(false);
            table_produtos.getColumnModel().getColumn(2).setPreferredWidth(150);
            table_produtos.getColumnModel().getColumn(3).setResizable(false);
            table_produtos.getColumnModel().getColumn(3).setPreferredWidth(150);
        }

        lbl_total.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_total.setText("Total");

        txtfd_total.setEditable(false);
        txtfd_total.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtfd_total.setText("R$ 0,00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_total)
                        .addGap(18, 18, 18)
                        .addComponent(txtfd_total, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_nome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtfd_nomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btn_removeProduto)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_addProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl_qtd)
                                .addComponent(lbl_cod))
                            .addGap(32, 32, 32)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtfd_codProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtfd_qtdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfd_total, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_total))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_nome)
                            .addComponent(txtfd_nomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_cod)
                            .addComponent(txtfd_codProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfd_qtdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_qtd))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_addProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_removeProduto))
                        .addGap(109, 164, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    

    private void btn_addProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addProdutoActionPerformed
	Produto p = new Produto("Feijão", new BigDecimal("1"), new BigDecimal("10"), "1234");
	ItemVenda item = new ItemVenda(p, new BigDecimal("1.5"));

	DefaultTableModel table = (DefaultTableModel) table_produtos.getModel();

	table.addRow(new Object[]{
	    item.getProduto().getNome(),
	    String.format("%4.3f", item.getQtd()),
	    String.format("R$%04.2f", item.getProduto().getPreco()),
	    String.format("R$%04.2f", item.getPrecoTotalItem())
	}
	);
	venda.addItem(item);
	txtfd_total.setText(String.format("R$%4.2f", venda.getTotal()));
    }//GEN-LAST:event_btn_addProdutoActionPerformed

    private void btn_removeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeProdutoActionPerformed
        DefaultTableModel table = (DefaultTableModel) table_produtos.getModel();
	venda.removeItem(table.getRowCount()-1);
	table.removeRow(table.getRowCount()-1);
	txtfd_total.setText(String.format("R$%4.2f", venda.getTotal()));
    }//GEN-LAST:event_btn_removeProdutoActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addProduto;
    private javax.swing.JButton btn_removeProduto;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_cod;
    private javax.swing.JLabel lbl_nome;
    private javax.swing.JLabel lbl_qtd;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JTable table_produtos;
    private javax.swing.JTextField txtfd_codProduto;
    private javax.swing.JTextField txtfd_nomeProduto;
    private javax.swing.JTextField txtfd_qtdProduto;
    private javax.swing.JTextField txtfd_total;
    // End of variables declaration//GEN-END:variables
}
