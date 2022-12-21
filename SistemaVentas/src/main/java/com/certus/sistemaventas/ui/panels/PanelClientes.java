package com.certus.sistemaventas.ui.panels;

import com.certus.sistemaventas.modelo.entidades.Cliente;
import com.certus.sistemaventas.servicio.ClienteService;
import com.certus.sistemaventas.servicio.impl.ClienteServiceImpl;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PanelClientes extends javax.swing.JPanel {

    private Cliente cliente;
    private ClienteService servicio;
    private DefaultTableModel tableModel;

    public PanelClientes() {
        initComponents();
        listarCliente();
    }

    private void limpiarTabla() {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            tableModel.removeRow(i);
            i -= 1;
        }
    }

    private void listarCliente() {
        servicio = new ClienteServiceImpl();
        List<Cliente> clientes = servicio.listarClientes();
        tableModel = (DefaultTableModel) tblClientes.getModel();
        Object[] col = new Object[4];
        for (int i = 0; i < clientes.size(); i++) {
            col[0] = clientes.get(i).getDni();
            col[1] = clientes.get(i).getNombre();
            col[2] = clientes.get(i).getTelefono();
            col[3] = clientes.get(i).getDireccion();
            
            tableModel.addRow(col);
        }
        tblClientes.setModel(tableModel);
    }

    private void limpiarCampos() {
        cliente = null;
        txtDniCliente.setText("");
        txtNombreCliente.setText("");
        txtTelefonoCliente.setText("");
        txtDireccionCliente.setText("");
    }

    private boolean isCamposVacio() {
        return ("".equals(txtDniCliente.getText()) || "".equals(txtNombreCliente.getText()) || "".equals(txtTelefonoCliente.getText()) || "".equals(txtDireccionCliente.getText()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtDniCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTelefonoCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDireccionCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnRegistrarCliente = new javax.swing.JButton();
        btnEliminarCliente = new javax.swing.JButton();
        btnEditarCliente = new javax.swing.JButton();
        btnLimpiarCampos = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(35, 46, 51));
        jLabel6.setText("Registrar cliente");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 140, -1));

        txtDniCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniClienteKeyTyped(evt);
            }
        });
        jPanel1.add(txtDniCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 240, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(35, 46, 51));
        jLabel1.setText("DNI");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 80, 30));
        jPanel1.add(txtNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 240, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(35, 46, 51));
        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 80, 30));

        txtTelefonoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoClienteKeyTyped(evt);
            }
        });
        jPanel1.add(txtTelefonoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 240, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(35, 46, 51));
        jLabel3.setText("Telefono");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 80, 30));
        jPanel1.add(txtDireccionCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 240, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(35, 46, 51));
        jLabel5.setText("Dirección");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 120, 30));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 10, 560));

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "NOMBRE", "TELEFONO", "DIRECCION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClientes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 720, 340));

        btnRegistrarCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnRegistrarCliente.setToolTipText("Agregar");
        btnRegistrarCliente.setBorderPainted(false);
        btnRegistrarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 480, 40, 40));

        btnEliminarCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btnEliminarCliente.setToolTipText("Eliminar");
        btnEliminarCliente.setBorderPainted(false);
        btnEliminarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, 40, 40));

        btnEditarCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnEditarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnEditarCliente.setToolTipText("Editar");
        btnEditarCliente.setBorderPainted(false);
        btnEditarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarClienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 480, 40, 40));

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


    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClienteActionPerformed
        if (!isCamposVacio()) {
            String nombre;
            String direccion;
            int dni;
            int telefono;
            try {
                dni = Integer.parseInt(txtDniCliente.getText());
                telefono = Integer.parseInt(txtTelefonoCliente.getText());
                direccion = txtDireccionCliente.getText();
                nombre = txtNombreCliente.getText();
                cliente = new Cliente(dni, nombre, telefono, direccion);
                servicio = new ClienteServiceImpl();
                servicio.registrarCliente(cliente);
                JOptionPane.showMessageDialog(null, "Cliente Registrado", "Registro cliente", JOptionPane.INFORMATION_MESSAGE);
                limpiarTabla();
                limpiarCampos();
                listarCliente();
                cliente = null;
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Campos invalidos", "Error de registro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Los campos están vacios");
        }
    }//GEN-LAST:event_btnRegistrarClienteActionPerformed

    private void txtDniClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniClienteKeyTyped
        char key = evt.getKeyChar();
        if (Character.isAlphabetic(key)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDniClienteKeyTyped

    private void txtTelefonoClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoClienteKeyTyped
        char key = evt.getKeyChar();
        if (Character.isAlphabetic(key)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoClienteKeyTyped

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        int fila = tblClientes.rowAtPoint(evt.getPoint());
        servicio = new ClienteServiceImpl();
        cliente = servicio.buscarCliente((Integer)tblClientes.getValueAt(fila, 0));
        txtDniCliente.setText(tblClientes.getValueAt(fila, 0).toString());
        txtNombreCliente.setText(tblClientes.getValueAt(fila, 1).toString());
        txtTelefonoCliente.setText(tblClientes.getValueAt(fila, 2).toString());
        txtDireccionCliente.setText(tblClientes.getValueAt(fila, 3).toString());

    }//GEN-LAST:event_tblClientesMouseClicked

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        if (cliente != null) {
            int respuesta = JOptionPane.showConfirmDialog(null, "Desea eliminar el cliente?", "Eliminar cliente", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.OK_OPTION) {
                servicio = new ClienteServiceImpl();
                servicio.eliminarCliente(cliente.getIdCliente());
                limpiarTabla();
                limpiarCampos();
                listarCliente();
            }
        }
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    private void btnLimpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCamposActionPerformed
        limpiarCampos();
        tblClientes.clearSelection();
    }//GEN-LAST:event_btnLimpiarCamposActionPerformed

    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClienteActionPerformed
        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "Seleccione un cliente", "Editar cliente", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (!isCamposVacio()) {
                cliente.setDni(Integer.parseInt(txtDniCliente.getText()));
                cliente.setNombre(txtNombreCliente.getText());
                cliente.setTelefono(Integer.parseInt(txtTelefonoCliente.getText()));
                cliente.setDireccion(txtDireccionCliente.getText());
                servicio = new ClienteServiceImpl();
                servicio.actualizarCliente(cliente);
                JOptionPane.showMessageDialog(null, "Cliente editado correctamente", "Registro cliente", JOptionPane.INFORMATION_MESSAGE);
                limpiarTabla();
                limpiarCampos();
                listarCliente();
            } else {
                JOptionPane.showMessageDialog(null, "Los campos están vacios");
            }
        }
    }//GEN-LAST:event_btnEditarClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnLimpiarCampos;
    private javax.swing.JButton btnRegistrarCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtDireccionCliente;
    private javax.swing.JTextField txtDniCliente;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtTelefonoCliente;
    // End of variables declaration//GEN-END:variables
}
