package com.certus.sistemaventas.ui.panels;

import com.certus.sistemaventas.modelo.entidades.Proveedor;
import com.certus.sistemaventas.servicio.ProveedorService;
import com.certus.sistemaventas.servicio.impl.ProveedorServiceImpl;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PanelProveedor extends javax.swing.JPanel {

    private Proveedor proveedor;
    private ProveedorService proveedorService;
    private DefaultTableModel tableModel;

    public PanelProveedor() {
        initComponents();
        listaProveedores();
    }

    private void limpiarTabla() {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            tableModel.removeRow(i);
            i -= 1;
        }
    }

    private void limpiarCampos() {
        proveedor = null;
        txtRucProveedor.setText("");
        txtNombreProveedor.setText("");
        txtTelefonoProveedor.setText("");
        txtDireccionProveedor.setText("");
        txtRazonProveedor.setText("");
    }

    private boolean isCamposVacio() {
        return ("".equals(txtRucProveedor.getText()) || "".equals(txtNombreProveedor.getText()) || "".equals(txtTelefonoProveedor.getText()) || "".equals(txtDireccionProveedor.getText()) || "".equals(txtRazonProveedor.getText()));
    }

    private void listaProveedores() {
        proveedorService = new ProveedorServiceImpl();
        List<Proveedor> proveedores = proveedorService.listarProveedores();
        tableModel = (DefaultTableModel) tblProveedores.getModel();
        Object[] col = new Object[5];
        for (int i = 0; i < proveedores.size(); i++) {
            col[0] = proveedores.get(i).getRuc();
            col[1] = proveedores.get(i).getNombre();
            col[2] = proveedores.get(i).getTelefono();
            col[3] = proveedores.get(i).getDireccion();
            col[4] = proveedores.get(i).getRazonSocial();

            tableModel.addRow(col);
        }
        tblProveedores.setModel(tableModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtRucProveedor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreProveedor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTelefonoProveedor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDireccionProveedor = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        txtRazonProveedor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProveedores = new javax.swing.JTable();
        btnLimpiarCampos = new javax.swing.JButton();
        btnEditarProveedor = new javax.swing.JButton();
        btnEliminarProveedor = new javax.swing.JButton();
        btnRegistrarProveedor = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtRucProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucProveedorKeyTyped(evt);
            }
        });
        jPanel1.add(txtRucProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 240, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(35, 46, 51));
        jLabel6.setText("Registrar proveedor");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 230, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(35, 46, 51));
        jLabel1.setText("RUC");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 80, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(35, 46, 51));
        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 80, 30));
        jPanel1.add(txtNombreProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 240, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(35, 46, 51));
        jLabel3.setText("Telefono");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 80, 30));

        txtTelefonoProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoProveedorKeyTyped(evt);
            }
        });
        jPanel1.add(txtTelefonoProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 240, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(35, 46, 51));
        jLabel5.setText("Dirección");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 120, 30));
        jPanel1.add(txtDireccionProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 240, 30));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 10, 560));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(35, 46, 51));
        jLabel7.setText("Razón social");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 120, 30));
        jPanel1.add(txtRazonProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 240, 30));

        tblProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RUC", "NOMBRE", "TELEFONO", "DIRECCION", "RAZON SOCIAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProveedores.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tblProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProveedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProveedores);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 720, 340));

        btnLimpiarCampos.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiarCampos.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        btnLimpiarCampos.setToolTipText("Limpiar campos");
        btnLimpiarCampos.setBorderPainted(false);
        btnLimpiarCampos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCamposActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiarCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 40, 40));

        btnEditarProveedor.setBackground(new java.awt.Color(255, 255, 255));
        btnEditarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnEditarProveedor.setToolTipText("Editar");
        btnEditarProveedor.setBorderPainted(false);
        btnEditarProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProveedorActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 480, 40, 40));

        btnEliminarProveedor.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btnEliminarProveedor.setToolTipText("Eliminar");
        btnEliminarProveedor.setBorderPainted(false);
        btnEliminarProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProveedorActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, 40, 40));

        btnRegistrarProveedor.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnRegistrarProveedor.setToolTipText("Agregar");
        btnRegistrarProveedor.setBorderPainted(false);
        btnRegistrarProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarProveedorActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 480, 40, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProveedoresMouseClicked
        int fila = tblProveedores.rowAtPoint(evt.getPoint());
        proveedorService = new ProveedorServiceImpl();
        proveedor = proveedorService.buscarProveedor((Integer) tblProveedores.getValueAt(fila, 0));
        txtRucProveedor.setText(tblProveedores.getValueAt(fila, 0).toString());
        txtNombreProveedor.setText(tblProveedores.getValueAt(fila, 1).toString());
        txtTelefonoProveedor.setText(tblProveedores.getValueAt(fila, 2).toString());
        txtDireccionProveedor.setText(tblProveedores.getValueAt(fila, 3).toString());
        txtRazonProveedor.setText(tblProveedores.getValueAt(fila, 4).toString());
    }//GEN-LAST:event_tblProveedoresMouseClicked

    private void btnLimpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCamposActionPerformed
        limpiarCampos();
        tblProveedores.clearSelection();
    }//GEN-LAST:event_btnLimpiarCamposActionPerformed

    private void btnEditarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProveedorActionPerformed
        if (proveedor == null) {
            JOptionPane.showMessageDialog(null, "Seleccione un proveedor", "Editar proveedor", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (!isCamposVacio()) {
                proveedor.setRuc(Integer.parseInt(txtRucProveedor.getText()));
                proveedor.setNombre(txtNombreProveedor.getText());
                proveedor.setTelefono(Integer.parseInt(txtTelefonoProveedor.getText()));
                proveedor.setDireccion(txtDireccionProveedor.getText());
                proveedor.setRazonSocial(txtRazonProveedor.getText());
                proveedorService = new ProveedorServiceImpl();
                proveedorService.actualizarProveedor(proveedor);
                JOptionPane.showMessageDialog(null, "Proveedor editado correctamente", "Registro proveedor", JOptionPane.INFORMATION_MESSAGE);
                limpiarTabla();
                limpiarCampos();
                listaProveedores();
            } else {
                JOptionPane.showMessageDialog(null, "Los campos están vacios");
            }
        }
    }//GEN-LAST:event_btnEditarProveedorActionPerformed

    private void btnEliminarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProveedorActionPerformed
        if (proveedor != null) {
            int respuesta = JOptionPane.showConfirmDialog(null, "Desea eliminar al proveedor?", "Eliminar proveedor", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.OK_OPTION) {
                proveedorService = new ProveedorServiceImpl();
                proveedorService.eliminarProveedor(proveedor.getIdProveedor());
                limpiarTabla();
                limpiarCampos();
                listaProveedores();
            }
        }
    }//GEN-LAST:event_btnEliminarProveedorActionPerformed

    private void btnRegistrarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarProveedorActionPerformed
        if (!isCamposVacio()) {
            String nombre;
            String direccion;
            String razonSocial;
            int ruc;
            int telefono;
            try {
                ruc = Integer.parseInt(txtRucProveedor.getText());
                telefono = Integer.parseInt(txtTelefonoProveedor.getText());
                direccion = txtDireccionProveedor.getText();
                nombre = txtNombreProveedor.getText();
                razonSocial = txtRazonProveedor.getText();
                proveedor = new Proveedor(ruc, nombre, telefono, direccion, razonSocial);
                proveedorService = new ProveedorServiceImpl();
                proveedorService.registrarProveedor(proveedor);
                JOptionPane.showMessageDialog(null, "Proveedor Registrado", "Registro proveedor", JOptionPane.INFORMATION_MESSAGE);
                limpiarTabla();
                limpiarCampos();
                listaProveedores();
                proveedor = null;
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Campos invalidos", "Error de registro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Los campos están vacios");
        }
    }//GEN-LAST:event_btnRegistrarProveedorActionPerformed

    private void txtRucProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucProveedorKeyTyped
        char key = evt.getKeyChar();
        if (Character.isAlphabetic(key)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRucProveedorKeyTyped

    private void txtTelefonoProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoProveedorKeyTyped
        char key = evt.getKeyChar();
        if (Character.isAlphabetic(key)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoProveedorKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarProveedor;
    private javax.swing.JButton btnEliminarProveedor;
    private javax.swing.JButton btnLimpiarCampos;
    private javax.swing.JButton btnRegistrarProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblProveedores;
    private javax.swing.JTextField txtDireccionProveedor;
    private javax.swing.JTextField txtNombreProveedor;
    private javax.swing.JTextField txtRazonProveedor;
    private javax.swing.JTextField txtRucProveedor;
    private javax.swing.JTextField txtTelefonoProveedor;
    // End of variables declaration//GEN-END:variables
}
