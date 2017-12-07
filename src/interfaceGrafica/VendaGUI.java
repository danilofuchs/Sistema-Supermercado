/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceGrafica;

import classes.*;
import exceptions.NameNotFoundException;
import java.awt.Event;
import java.awt.KeyboardFocusManager;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import javax.swing.table.TableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

public class VendaGUI extends javax.swing.JFrame {
    private Venda venda;
    private Estoque estoque;
    private Usuario usuario;
    private CargosLista cargosLista;
    
    private Produto prodTemp;
    private boolean prodTempValido = false;
    
    private MaskFormatter maskFormatterCod = new MaskFormatter();
    private MaskFormatter maskFormatterQtd = new MaskFormatter();
    /**
     * Creates new form VendaGUI
     */
    
    public VendaGUI(Venda venda, Usuario usuario, CargosLista cargosLista) {
	initComponents();
	myInitComponents();
	this.venda = venda;
	this.estoque = new Estoque();
	estoque.inicializarEstoque();
	this.usuario = usuario;
	this.cargosLista = cargosLista;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="My init codes">
    private void myInitComponents() {
	try {
	    maskFormatterCod = new MaskFormatter("* ****** ******");
	    maskFormatterCod.setValidCharacters("1234567890 ");
	    maskFormatterCod.setPlaceholderCharacter(' ');
	    maskFormatterCod.setValueContainsLiteralCharacters(false);
	    
	    maskFormatterQtd = new MaskFormatter("****,***");
	    maskFormatterQtd.setValidCharacters("1234567890 ");
	    maskFormatterQtd.setPlaceholderCharacter('0');
	    maskFormatterQtd.setValueContainsLiteralCharacters(true);
	}
	catch (ParseException ex) {
	    Logger.getLogger(VendaGUI.class.getName()).log(Level.SEVERE, null, ex);
	}

	fmtfd_codProduto.setFormatterFactory(new DefaultFormatterFactory(maskFormatterCod));
	fmtfd_qtdProduto.setFormatterFactory(new DefaultFormatterFactory(maskFormatterQtd));
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_removeProduto = new javax.swing.JButton();
        btn_addProduto = new javax.swing.JButton();
        txtfd_nomeProduto = new javax.swing.JTextField();
        fmtfd_codProduto = new javax.swing.JFormattedTextField();
        fmtfd_qtdProduto = new javax.swing.JFormattedTextField();
        lbl_nome = new javax.swing.JLabel();
        lbl_cod = new javax.swing.JLabel();
        lbl_qtd = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_produtos = new javax.swing.JTable();
        lbl_total = new javax.swing.JLabel();
        txtfd_total = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Nova Venda");
        setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btn_removeProduto.setText("Remover");
        btn_removeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeProdutoActionPerformed(evt);
            }
        });

        btn_addProduto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_addProduto.setText("Adicionar Produto");
        btn_addProduto.setNextFocusableComponent(fmtfd_codProduto);
        btn_addProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addProdutoActionPerformed(evt);
            }
        });
        btn_addProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_addProdutoKeyPressed(evt);
            }
        });

        txtfd_nomeProduto.setEditable(false);
        txtfd_nomeProduto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        fmtfd_codProduto.setAutoscrolls(false);
        fmtfd_codProduto.setNextFocusableComponent(fmtfd_qtdProduto);
        fmtfd_codProduto.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                fmtfd_codProdutoCaretUpdate(evt);
            }
        });

        fmtfd_qtdProduto.setNextFocusableComponent(btn_addProduto);
        fmtfd_qtdProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fmtfd_qtdProdutoFocusGained(evt);
            }
        });
        fmtfd_qtdProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fmtfd_qtdProdutoKeyPressed(evt);
            }
        });

        lbl_nome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_nome.setText("Nome do Produto");

        lbl_cod.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_cod.setText("Código do Produto");

        lbl_qtd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_qtd.setText("Quantidade");

        table_produtos.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        table_produtos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Quantidade", "Preço Unitário", "Subtotal Item"
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
        table_produtos.setRowHeight(30);
        table_produtos.setRowMargin(10);
        table_produtos.setShowVerticalLines(false);
        table_produtos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(table_produtos);
        if (table_produtos.getColumnModel().getColumnCount() > 0) {
            table_produtos.getColumnModel().getColumn(0).setResizable(false);
            table_produtos.getColumnModel().getColumn(0).setPreferredWidth(500);
            table_produtos.getColumnModel().getColumn(1).setResizable(false);
            table_produtos.getColumnModel().getColumn(1).setPreferredWidth(120);
            table_produtos.getColumnModel().getColumn(2).setResizable(false);
            table_produtos.getColumnModel().getColumn(2).setPreferredWidth(120);
            table_produtos.getColumnModel().getColumn(3).setResizable(false);
            table_produtos.getColumnModel().getColumn(3).setPreferredWidth(150);
        }

        lbl_total.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_total.setText("Total");

        txtfd_total.setEditable(false);
        txtfd_total.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtfd_total.setText("R$ 0,00");

        jButton1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton1.setText("Finalizar Venda");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbl_total)
                        .addGap(18, 18, 18)
                        .addComponent(txtfd_total, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(lbl_nome)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtfd_nomeProduto, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lbl_cod)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                                .addComponent(fmtfd_codProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(lbl_qtd)
                                        .addGap(168, 168, 168))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_removeProduto)
                                        .addGap(177, 177, 177)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fmtfd_qtdProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                    .addComponent(btn_addProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(lbl_nome)
                .addGap(18, 18, 18)
                .addComponent(txtfd_nomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_cod)
                    .addComponent(fmtfd_codProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_qtd)
                    .addComponent(fmtfd_qtdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_removeProduto)
                    .addComponent(btn_addProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_total)
                    .addComponent(txtfd_total, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /*private Produto findProduto(String codigo) {
	
    }*/

    private void btn_addProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addProdutoActionPerformed
	addProdutoLista();
    }//GEN-LAST:event_btn_addProdutoActionPerformed

    private void addProdutoLista() {

	if (prodTempValido) {
	    ItemVenda item = new ItemVenda(prodTemp, new BigDecimal(fmtfd_qtdProduto.getText().replaceAll(",", ".")), venda.getNumItens());

	    DefaultTableModel table = (DefaultTableModel) table_produtos.getModel();

	    table.addRow(new Object[]{
		item.getProduto().getNome(),
		String.format("%4.3f %s", item.getQtd(), item.getProduto().getUnidade()),
		String.format("R$%04.2f", item.getProduto().getPreco()),
		String.format("R$%04.2f", item.getPrecoTotalItem())
	    }
	    );
	    venda.addItem(item);
	    txtfd_total.setText(String.format("R$%4.2f", venda.getTotal()));
	} else {
	    
	}
	resetTextFields();
    }
    private void btn_removeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeProdutoActionPerformed
        DefaultTableModel table = (DefaultTableModel) table_produtos.getModel();
	if (venda.getNumItens() > 0) {
	    venda.removeItem(venda.getNumItens()-1);
	    table.removeRow(venda.getNumItens()-1);
	    txtfd_total.setText(String.format("R$%4.2f", venda.getTotal()));
	}
    }//GEN-LAST:event_btn_removeProdutoActionPerformed

    private void fmtfd_codProdutoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_fmtfd_codProdutoCaretUpdate
        if (fmtfd_codProduto.getCaret().getMark() == 15) {
            KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
            manager.focusNextComponent();
	}
    }//GEN-LAST:event_fmtfd_codProdutoCaretUpdate

    private void fmtfd_qtdProdutoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fmtfd_qtdProdutoFocusGained
	updateWindowProduto();
    }//GEN-LAST:event_fmtfd_qtdProdutoFocusGained

    private void fmtfd_qtdProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fmtfd_qtdProdutoKeyPressed
        if (evt.getKeyCode() == Event.ENTER) {
            KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
            manager.focusNextComponent();
	    btn_addProduto.doClick();
	    manager.focusNextComponent();
        }
    }//GEN-LAST:event_fmtfd_qtdProdutoKeyPressed

    private void btn_addProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_addProdutoKeyPressed
        if (evt.getKeyCode() == Event.ENTER) {
            btn_addProduto.doClick();
	    KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
            manager.focusNextComponent();
        }
    }//GEN-LAST:event_btn_addProdutoKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int confirmCancel = JOptionPane.showConfirmDialog(rootPane, "Deseja cancelar a venda?", "Cancelamento de venda", JOptionPane.YES_NO_OPTION);
	if (confirmCancel == JOptionPane.OK_OPTION) {
	    try {
		if (cargosLista.getCargo(usuario.getCargo()).podeCancelarVenda()) {
		    this.dispose();
		} else {
		    int confirmNeedsLogin = JOptionPane.showConfirmDialog(rootPane, "Você não tem permissão necessária, acessar outra conta?", "Cancelamento de venda", JOptionPane.YES_NO_OPTION);
		}
	    }
	    catch (NameNotFoundException ex) {
		Logger.getLogger(VendaGUI.class.getName()).log(Level.SEVERE, null, ex);
	    }
	} else if (confirmCancel == JOptionPane.NO_OPTION) {
	    
	}
    }//GEN-LAST:event_formWindowClosing
    
    private void updateWindowProduto() {
	try {
	    prodTemp = findProduto(fmtfd_codProduto.getText().replaceAll("\\s",""));
	    prodTempValido = true;
	} catch (NameNotFoundException ex) {
	    prodTemp = new Produto("",new BigDecimal("0"),"","");
	    prodTempValido = false;
	    System.err.println("Não encontrado " + fmtfd_codProduto.getText().replaceAll("\\s",""));
	}
	
	txtfd_nomeProduto.setText(prodTemp.getNome());
	txtfd_nomeProduto.setCaretPosition(0);
    }
    
    private void resetTextFields() {

	txtfd_nomeProduto.setText("");
	fmtfd_codProduto.setText("");
	fmtfd_qtdProduto.setText("");
	prodTemp = new Produto("",new BigDecimal("0"),"","");
	prodTempValido = false;
    }
    private Produto findProduto(String codBarras) throws NameNotFoundException {
	codBarras.replaceAll("\\s","");
	codBarras.replaceAll("\\n","");
	ItemEstoque item = estoque.findItem(codBarras);
	return item.getProduto();	
    }
    
    public static void main(String args[]) {
	java.awt.EventQueue.invokeLater(new Runnable() {
		public void run() {
		    CargosLista cargosLista = new CargosLista();
		    
		    VendaGUI dialog = new VendaGUI(new Venda(), new Usuario("","",""), cargosLista);

		    dialog.setVisible(true);
		}
	    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addProduto;
    private javax.swing.JButton btn_removeProduto;
    private javax.swing.JFormattedTextField fmtfd_codProduto;
    private javax.swing.JFormattedTextField fmtfd_qtdProduto;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_cod;
    private javax.swing.JLabel lbl_nome;
    private javax.swing.JLabel lbl_qtd;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JTable table_produtos;
    private javax.swing.JTextField txtfd_nomeProduto;
    private javax.swing.JTextField txtfd_total;
    // End of variables declaration//GEN-END:variables
}
