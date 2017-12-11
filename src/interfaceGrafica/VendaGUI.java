/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceGrafica;

import classes.*;
import exceptions.NameNotFoundException;
import exceptions.PasswordInvalidException;
import java.awt.AWTException;
import java.awt.Event;
import java.awt.Frame;
import java.awt.KeyboardFocusManager;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class VendaGUI extends javax.swing.JFrame {

    private Venda venda;
    private Estoque estoque;
    private Usuario usuario;
    private CargosLista cargosLista;

    private BigDecimal qtdProduto;
    
    private Produto prodTemp;
    private boolean prodTempValido = false;

    private MaskFormatter maskFormatterCod = new MaskFormatter();
    private MaskFormatter maskFormatterQtd = new MaskFormatter();
    
    JPopupMenu popUp;

    /**
     * Creates new form VendaGUI
     */
    public VendaGUI(Venda venda, Usuario usuario, CargosLista cargosLista) {
	initComponents();
	this.venda = venda;
	this.estoque = new Estoque();
	estoque.inicializarEstoque();
	this.usuario = usuario;
	this.cargosLista = cargosLista;
	qtdProduto = new BigDecimal("0.000");
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
	try {
	    maskFormatterCod = new MaskFormatter("* ****** ******");
	    maskFormatterCod.setValidCharacters("1234567890 ");
	    maskFormatterCod.setPlaceholderCharacter(' ');
	    maskFormatterCod.setValueContainsLiteralCharacters(false);
	}
	catch (ParseException ex) {
	    Logger.getLogger(VendaGUI.class.getName()).log(Level.SEVERE, null, ex);
	}
	txtfd_qtdProduto.setText("0,000");
	fmtfd_codProduto.setFormatterFactory(new DefaultFormatterFactory(maskFormatterCod));
	fmtfd_codProduto.requestFocus();
	lbl_vendedor.setText("Vendedor: " + usuario.getNome());
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_addProduto = new javax.swing.JButton();
        txtfd_nomeProduto = new javax.swing.JTextField();
        fmtfd_codProduto = new javax.swing.JFormattedTextField();
        lbl_nome = new javax.swing.JLabel();
        lbl_cod = new javax.swing.JLabel();
        lbl_qtd = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_produtos = new javax.swing.JTable();
        lbl_total = new javax.swing.JLabel();
        txtfd_total = new javax.swing.JTextField();
        btn_finalizarVenda = new javax.swing.JButton();
        lbl_vendedor = new javax.swing.JLabel();
        txtfd_qtdProduto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Nova Venda");
        setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        setIconImage(new ImageIcon(getClass().getResource("/interfaceGrafica/cartIcon.png")).getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btn_addProduto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_addProduto.setText("Adicionar Produto");
        btn_addProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        fmtfd_codProduto.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        fmtfd_codProduto.setNextFocusableComponent(txtfd_qtdProduto);
        fmtfd_codProduto.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                fmtfd_codProdutoCaretUpdate(evt);
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
                "Seq", "Produto", "Quantidade", "Preço Unitário", "Subtotal Item"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
        table_produtos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_produtosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_produtos);
        if (table_produtos.getColumnModel().getColumnCount() > 0) {
            table_produtos.getColumnModel().getColumn(0).setResizable(false);
            table_produtos.getColumnModel().getColumn(0).setPreferredWidth(50);
            table_produtos.getColumnModel().getColumn(1).setResizable(false);
            table_produtos.getColumnModel().getColumn(1).setPreferredWidth(500);
            table_produtos.getColumnModel().getColumn(2).setResizable(false);
            table_produtos.getColumnModel().getColumn(2).setPreferredWidth(120);
            table_produtos.getColumnModel().getColumn(3).setResizable(false);
            table_produtos.getColumnModel().getColumn(3).setPreferredWidth(120);
            table_produtos.getColumnModel().getColumn(4).setResizable(false);
            table_produtos.getColumnModel().getColumn(4).setPreferredWidth(150);
        }

        lbl_total.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_total.setText("Total");

        txtfd_total.setEditable(false);
        txtfd_total.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtfd_total.setText("R$0,00");

        btn_finalizarVenda.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btn_finalizarVenda.setText("Finalizar Venda");
        btn_finalizarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_finalizarVendaActionPerformed(evt);
            }
        });

        lbl_vendedor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbl_vendedor.setText("Vendedor:");

        txtfd_qtdProduto.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtfd_qtdProduto.setNextFocusableComponent(btn_addProduto);
        txtfd_qtdProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfd_qtdProdutoFocusGained(evt);
            }
        });
        txtfd_qtdProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtfd_qtdProdutoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfd_qtdProdutoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_vendedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                            .addComponent(txtfd_nomeProduto)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_cod)
                                    .addComponent(lbl_qtd))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(92, 92, 92)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btn_addProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                            .addComponent(btn_finalizarVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtfd_qtdProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                                            .addComponent(fmtfd_codProduto, javax.swing.GroupLayout.Alignment.TRAILING))))))
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
                    .addComponent(txtfd_qtdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_qtd))
                .addGap(26, 26, 26)
                .addComponent(btn_addProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_finalizarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_total)
                    .addComponent(txtfd_total, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_vendedor))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addQtdProduto(char key) {
	if (key >= '0' && key <= '9') {
	    qtdProduto = qtdProduto.multiply(new BigDecimal("10"));
	    qtdProduto = qtdProduto.add(new BigDecimal(String.valueOf(key)).scaleByPowerOfTen(-3));
	} else if (key == KeyEvent.VK_BACK_SPACE) {
	    qtdProduto = qtdProduto.setScale(2,RoundingMode.DOWN).divide(new BigDecimal("10")).setScale(3);
	}
	txtfd_qtdProduto.setText(String.format("%.3f", qtdProduto));
    }


    private void btn_addProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addProdutoActionPerformed
	addProdutoLista();
    }//GEN-LAST:event_btn_addProdutoActionPerformed

    private void addProdutoLista() {

	if (prodTempValido) {
	    ItemVenda item = new ItemVenda(prodTemp, qtdProduto, venda.getNumItens() + 1);

	    DefaultTableModel table = (DefaultTableModel) table_produtos.getModel();

	    table.addRow(new Object[]{
		item.getSequencial(),
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
    private void fmtfd_codProdutoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_fmtfd_codProdutoCaretUpdate
	if (fmtfd_codProduto.getCaret().getMark() == 15 && !fmtfd_codProduto.getText().equals("               ")) {
	    txtfd_qtdProduto.requestFocus();
	}
    }//GEN-LAST:event_fmtfd_codProdutoCaretUpdate

    private void btn_addProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_addProdutoKeyPressed
	if (evt.getKeyCode() == Event.ENTER) {
	    btn_addProduto.doClick();
	}
    }//GEN-LAST:event_btn_addProdutoKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

	int confirmCancel = JOptionPane.showConfirmDialog(rootPane, "Deseja cancelar a venda?", "Cancelamento de venda", JOptionPane.YES_NO_OPTION);

	if (confirmCancel == JOptionPane.OK_OPTION) {
	    try {
		int confirmNeedsLogin = JOptionPane.NO_OPTION;
		if (cargosLista.getCargo(usuario.getCargo()).podeCancelarVenda()) {
		    this.dispose();
		} else {
		    confirmNeedsLogin = JOptionPane.showConfirmDialog(rootPane, "Você não tem permissão necessária, acessar outra conta?", "Cancelamento de venda", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		    if (confirmNeedsLogin == JOptionPane.YES_OPTION) {
			Usuario usuarioAdmin;
			try {
			    usuarioAdmin = fazerLoginPermissao();
			    if (cargosLista.getCargo(usuarioAdmin.getCargo()).podeCancelarVenda()) {
				JOptionPane.showMessageDialog(rootPane, "Venda cancelada com sucesso!", "Venda Cancelada", JOptionPane.INFORMATION_MESSAGE);
				this.dispose();
			    }
			}
			catch (PasswordInvalidException ex) {
			    Logger.getLogger(VendaGUI.class.getName()).log(Level.SEVERE, null, ex);
			}

		    }
		}

	    }
	    catch (NameNotFoundException ex) {
		Logger.getLogger(VendaGUI.class.getName()).log(Level.SEVERE, null, ex);
	    }
	} else if (confirmCancel == JOptionPane.NO_OPTION) {

	}
    }//GEN-LAST:event_formWindowClosing

    private Usuario fazerLoginPermissao() throws PasswordInvalidException {
	Usuario usuarioAdmin = new Usuario("", "", "");
	Frame frame = new Frame("");
	LoginDialogGUI login = new LoginDialogGUI(frame, true);
	login.setVisible(true);
	int statusLogin = login.getStatus();
	if (statusLogin == LoginDialogGUI.ACERTOU_LOGIN) {
	    usuarioAdmin = login.getUsuario();
	} else {
	    throw new PasswordInvalidException("Erro no login");
	}

	return usuarioAdmin;

    }

    private void table_produtosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_produtosMouseClicked
	if (SwingUtilities.isRightMouseButton(evt)) {
	    popUp = new JPopupMenu();
	    JButton btn_removeProduto = new JButton("Remover este produto");
	    btn_removeProduto.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		    popUp.setVisible(false);
		    try {
			if (cargosLista.getCargo(usuario.getCargo()).podeRemoverProdutoVenda()) {
			    int row = table_produtos.getSelectedRow();
			    if (row >= 0) {
				removeProdutoLista(table_produtos.getSelectedRow());
			    }
			} else {
			    int confirmNeedsLogin = JOptionPane.showConfirmDialog(rootPane, "Você não tem permissão necessária, acessar outra conta?", "Remoção de produto", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			    if (confirmNeedsLogin == JOptionPane.YES_OPTION) {
				Usuario usuarioAdmin;
				try {
				    usuarioAdmin = fazerLoginPermissao();
				    if (cargosLista.getCargo(usuarioAdmin.getCargo()).podeRemoverProdutoVenda()) {
					removeProdutoLista(table_produtos.getSelectedRow());
				    }
				}
				catch (PasswordInvalidException ex) {
				    Logger.getLogger(VendaGUI.class.getName()).log(Level.SEVERE, null, ex);
				}

			    }
			}
		    }
		    catch (NameNotFoundException ex) {
			Logger.getLogger(VendaGUI.class.getName()).log(Level.SEVERE, null, ex);
		    }
		}
	    });
	    popUp.add(btn_removeProduto);
	    popUp.show(evt.getComponent(), evt.getX(), evt.getY());
	}
    }//GEN-LAST:event_table_produtosMouseClicked

    private void btn_finalizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_finalizarVendaActionPerformed
        CheckoutDialogGUI checkout = new CheckoutDialogGUI(this, true, venda, usuario, cargosLista);
	checkout.setVisible(true);
    }//GEN-LAST:event_btn_finalizarVendaActionPerformed

    private void txtfd_qtdProdutoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfd_qtdProdutoFocusGained
        updateWindowProduto();
    }//GEN-LAST:event_txtfd_qtdProdutoFocusGained

    private void txtfd_qtdProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfd_qtdProdutoKeyReleased
        addQtdProduto(evt.getKeyChar());
    }//GEN-LAST:event_txtfd_qtdProdutoKeyReleased

    private void txtfd_qtdProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfd_qtdProdutoKeyPressed
        if (evt.getKeyCode() == Event.ENTER) {
            btn_addProduto.doClick();
	    fmtfd_codProduto.requestFocus();
        }
    }//GEN-LAST:event_txtfd_qtdProdutoKeyPressed

    private void removeProdutoLista(int row) {

	DefaultTableModel table = (DefaultTableModel) table_produtos.getModel();
	if (venda.getNumItens() > 0) {
	    venda.removeItem(row);
	    table.removeRow(row);
	    txtfd_total.setText(String.format("R$%4.2f", venda.getTotal()));
	}

    }

    private void updateWindowProduto() {
	try {
	    prodTemp = findProduto(fmtfd_codProduto.getText().replaceAll("\\s", ""));
	    prodTempValido = true;
	}
	catch (NameNotFoundException ex) {
	    prodTemp = new Produto("", new BigDecimal("0"), "", "");
	    prodTempValido = false;
	    System.err.println("Não encontrado " + fmtfd_codProduto.getText().replaceAll("\\s", ""));
	}

	txtfd_nomeProduto.setText(prodTemp.getNome());
	txtfd_nomeProduto.setCaretPosition(0);
    }

    private void resetTextFields() {

	txtfd_nomeProduto.setText("");
	fmtfd_codProduto.setText("");
	txtfd_qtdProduto.setText("0,000");
	qtdProduto = new BigDecimal("0.000");
	prodTemp = new Produto("", new BigDecimal("0"), "", "");
	prodTempValido = false;
	fmtfd_codProduto.requestFocus();
    }

    private Produto findProduto(String codBarras) throws NameNotFoundException {
	codBarras.replaceAll("\\s", "");
	codBarras.replaceAll("\\n", "");
	ItemEstoque item = estoque.findItem(codBarras);
	return item.getProduto();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addProduto;
    private javax.swing.JButton btn_finalizarVenda;
    private javax.swing.JFormattedTextField fmtfd_codProduto;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_cod;
    private javax.swing.JLabel lbl_nome;
    private javax.swing.JLabel lbl_qtd;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JLabel lbl_vendedor;
    private javax.swing.JTable table_produtos;
    private javax.swing.JTextField txtfd_nomeProduto;
    private javax.swing.JTextField txtfd_qtdProduto;
    private javax.swing.JTextField txtfd_total;
    // End of variables declaration//GEN-END:variables
}
