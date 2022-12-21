package com.certus.sistemaventas.ui.panels;

import com.certus.sistemaventas.modelo.entidades.Producto;
import com.certus.sistemaventas.modelo.entidades.Proveedor;
import com.certus.sistemaventas.servicio.ProductoService;
import com.certus.sistemaventas.servicio.ProveedorService;
import com.certus.sistemaventas.servicio.impl.ProductoServiceImpl;
import com.certus.sistemaventas.servicio.impl.ProveedorServiceImpl;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PanelProductos extends javax.swing.JPanel {

    private Producto producto;
    private ProductoService productoService;
    private ProveedorService proveedorService;
    private DefaultTableModel tableModel;

    public PanelProductos() {
        initComponents();
        llenarComboProveedor();
        listaProveedores();
    }

    private void llenarComboProveedor() {
        proveedorService = new ProveedorServiceImpl();
        List<Proveedor> proveedores = proveedorService.listarProveedores();
        proveedores.forEach(proveedor -> {
            cbxProveedorProducto.addItem(proveedor.getNombre());
        });
    }

    private void limpiarTabla() {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            tableModel.removeRow(i);
            i -= 1;
        }
    }

    private void limpiarCampos() {
        producto = null;
        txtCodigoProducto.setText("");
        txtNombreProducto.setText("");
        txtStockProducto.setText("");
        txtPrecioProducto.setText("");
    }

    private boolean isCamposVacio() {
        return ("".equals(txtCodigoProducto.getText())
                || "".equals(txtNombreProducto.getText())
                || "".equals(cbxProveedorProducto.getSelectedItem().toString())
                || "".equals(txtStockProducto.getText())
                || "".equals(txtPrecioProducto.getText()));
    }

    private void listaProveedores() {
        productoService = new ProductoServiceImpl();
        List<Producto> proveedores = productoService.listarProductos();
        tableModel = (DefaultTableModel) tblProductos.getModel();
        Object[] col = new Object[5];
        for (int i = 0; i < proveedores.size(); i++) {
            col[0] = proveedores.get(i).getCodigo();
            col[1] = proveedores.get(i).getNombre();
            col[2] = proveedores.get(i).getProveedor();
            col[3] = proveedores.get(i).getStock();
            col[4] = proveedores.get(i).getPrecio();

            tableModel.addRow(col);
        }
        tblProductos.setModel(tableModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCodigoProducto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPrecioProducto = new javax.swing.JTextField();
        txtStockProducto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        cbxProveedorProducto = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        btnLimpiarCampos = new javax.swing.JButton();
        btnEditarProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        btnRegistrarProducto = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(35, 46, 51));
        jLabel6.setText("Registrar producto");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 170, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(35, 46, 51));
        jLabel1.setText("Código");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 80, 30));

        txtCodigoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoProductoKeyTyped(evt);
            }
        });
        jPanel1.add(txtCodigoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 150, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(35, 46, 51));
        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 80, 30));
        jPanel1.add(txtNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 320, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(35, 46, 51));
        jLabel3.setText("Precio");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 80, 30));

        txtPrecioProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioProductoKeyTyped(evt);
            }
        });
        jPanel1.add(txtPrecioProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 150, 30));

        txtStockProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockProductoKeyTyped(evt);
            }
        });
        jPanel1.add(txtStockProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 150, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(35, 46, 51));
        jLabel5.setText("Stock disponible");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 120, 30));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 10, 560));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(35, 46, 51));
        jLabel7.setText("Proveedor");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 120, 30));

        jPanel1.add(cbxProveedorProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 320, 30));

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "NOMBRE", "PROVEEDOR", "STOCK", "PRECIO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductos);

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

        btnEditarProducto.setBackground(new java.awt.Color(255, 255, 255));
        btnEditarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnEditarProducto.setToolTipText("Editar");
        btnEditarProducto.setBorderPainted(false);
        btnEditarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProductoActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 480, 40, 40));

        btnEliminarProducto.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btnEliminarProducto.setToolTipText("Eliminar");
        btnEliminarProducto.setBorderPainted(false);
        btnEliminarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, 40, 40));

        btnRegistrarProducto.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnRegistrarProducto.setToolTipText("Agregar");
        btnRegistrarProducto.setBorderPainted(false);
        btnRegistrarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarProductoActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 480, 40, 40));

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        int fila = tblProductos.rowAtPoint(evt.getPoint());
        productoService = new ProductoServiceImpl();
        producto = productoService.buscarProducto((Integer) tblProductos.getValueAt(fila, 0));
        txtCodigoProducto.setText(tblProductos.getValueAt(fila, 0).toString());
        txtNombreProducto.setText(tblProductos.getValueAt(fila, 1).toString());
        cbxProveedorProducto.setSelectedItem(tblProductos.getValueAt(fila, 2).toString());
        txtStockProducto.setText(tblProductos.getValueAt(fila, 3).toString());
        txtPrecioProducto.setText(tblProductos.getValueAt(fila, 4).toString());
    }//GEN-LAST:event_tblProductosMouseClicked

    private void btnLimpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCamposActionPerformed
        limpiarCampos();
        tblProductos.clearSelection();
    }//GEN-LAST:event_btnLimpiarCamposActionPerformed

    private void btnEditarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProductoActionPerformed
        if (producto == null) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto", "Editar producto", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (!isCamposVacio()) {
                producto.setCodigo(Integer.parseInt(txtCodigoProducto.getText()));
                producto.setNombre(txtNombreProducto.getText());
                producto.setProveedor(cbxProveedorProducto.getSelectedItem().toString());
                producto.setStock(Integer.parseInt(txtStockProducto.getText()));
                producto.setPrecio(Double.parseDouble(txtPrecioProducto.getText()));
                productoService = new ProductoServiceImpl();
                productoService.actualizarProducto(producto);
                JOptionPane.showMessageDialog(null, "Producto editado correctamente", "Registro producto", JOptionPane.INFORMATION_MESSAGE);
                limpiarTabla();
                limpiarCampos();
                listaProveedores();
            } else {
                JOptionPane.showMessageDialog(null, "Los campos están vacios");
            }
        }
    }//GEN-LAST:event_btnEditarProductoActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        if (producto != null) {
            int respuesta = JOptionPane.showConfirmDialog(null, "Desea eliminar este producto?", "Eliminar producto", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.OK_OPTION) {
                productoService = new ProductoServiceImpl();
                productoService.eliminarProducto(producto.getIdProducto());
                limpiarTabla();
                limpiarCampos();
                listaProveedores();
            }
        }
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnRegistrarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarProductoActionPerformed
        if (!isCamposVacio()) {
            String nombre;
            String proveedor;
            int codigo;
            int stock;
            double precio;
            try {
                codigo = Integer.parseInt(txtCodigoProducto.getText());
                nombre = txtNombreProducto.getText().toUpperCase();
                proveedor = cbxProveedorProducto.getSelectedItem().toString();
                stock = Integer.parseInt(txtStockProducto.getText());
                precio = Double.parseDouble(txtPrecioProducto.getText());
                producto = new Producto(codigo, nombre, proveedor, stock, precio);
                productoService = new ProductoServiceImpl();
                productoService.registrarProducto(producto);
                JOptionPane.showMessageDialog(null, "Producto Registrado", "Registro producto", JOptionPane.INFORMATION_MESSAGE);
                limpiarTabla();
                limpiarCampos();
                listaProveedores();
                producto = null;
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Campos invalidos", "Error de registro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Los campos están vacios");
        }
    }//GEN-LAST:event_btnRegistrarProductoActionPerformed

    private void txtCodigoProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProductoKeyTyped
        char key = evt.getKeyChar();
        if (Character.isAlphabetic(key)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCodigoProductoKeyTyped

    private void txtStockProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockProductoKeyTyped
        char key = evt.getKeyChar();
        if (Character.isAlphabetic(key)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtStockProductoKeyTyped

    private void txtPrecioProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioProductoKeyTyped
        char key = evt.getKeyChar();
        if (Character.isAlphabetic(key)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioProductoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarProducto;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnLimpiarCampos;
    private javax.swing.JButton btnRegistrarProducto;
    private javax.swing.JComboBox<String> cbxProveedorProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtPrecioProducto;
    private javax.swing.JTextField txtStockProducto;
    // End of variables declaration//GEN-END:variables
}
