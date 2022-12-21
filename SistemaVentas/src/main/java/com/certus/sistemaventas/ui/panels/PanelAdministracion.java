package com.certus.sistemaventas.ui.panels;

import com.certus.sistemaventas.modelo.entidades.Empresa;
import com.certus.sistemaventas.modelo.entidades.Usuario;
import com.certus.sistemaventas.servicio.EmpresaService;
import com.certus.sistemaventas.servicio.UsuarioService;
import com.certus.sistemaventas.servicio.impl.EmpresaServiceImpl;
import com.certus.sistemaventas.servicio.impl.UsuarioServiceImpl;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PanelAdministracion extends javax.swing.JPanel {

    private EmpresaService empresaService;
    private UsuarioService usuarioService;
    private Empresa empresa;
    private Usuario usuario;
    private DefaultTableModel tableModel;

    public PanelAdministracion() {
        initComponents();
        iniciarDatosEmpresa();
        listarUsuarios();
    }

    private void limpiarTabla() {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            tableModel.removeRow(i);
            i -= 1;
        }
    }

    private void limpiarCampos() {
        usuario = null;
        txtNombreUsuario.setText("");
        txtApellidoUsuario.setText("");
        txtPasswordUsuario.setText("");
    }

    private void iniciarDatosEmpresa() {
        empresaService = new EmpresaServiceImpl();
        empresa = empresaService.buscarDatos();
        txtRucEmpresa.setText("" + empresa.getRuc());
        txtNombreEmpresa.setText(empresa.getNombre());
        txtTelefonoEmpresa.setText("" + empresa.getTelefono());
        txtDireccionEmpresa.setText("" + empresa.getDireccion());
        txtRazonEmpresa.setText("" + empresa.getRazonSocial());
    }

    private void listarUsuarios() {
        usuarioService = new UsuarioServiceImpl();
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        tableModel = (DefaultTableModel) tblUsuarios.getModel();
        Object[] col = new Object[5];
        for (int i = 0; i < usuarios.size(); i++) {
            col[0] = usuarios.get(i).getUsername();
            col[1] = usuarios.get(i).getNombre();
            col[2] = usuarios.get(i).getApellido();
            col[3] = usuarios.get(i).getEmail();
            col[4] = usuarios.get(i).getRol();

            tableModel.addRow(col);
        }
        tblUsuarios.setModel(tableModel);
    }

    private boolean isCamposEmpresaVacio() {
        return ("".equals(txtRucEmpresa.getText()) || "".equals(txtNombreEmpresa.getText()) || "".equals(txtTelefonoEmpresa.getText()) || "".equals(txtDireccionEmpresa.getText()) || "".equals(txtRazonEmpresa.getText()));
    }

    private boolean isCamposUsuarioVacio() {
        return ("".equals(txtNombreUsuario.getText()) || "".equals(txtApellidoUsuario.getText()) || "".equals(String.valueOf(txtPasswordUsuario.getPassword())));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtRucEmpresa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombreEmpresa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTelefonoEmpresa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDireccionEmpresa = new javax.swing.JTextField();
        txtRazonEmpresa = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtApellidoUsuario = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbxRolUsuario = new javax.swing.JComboBox<>();
        btnEditarEmpresa = new javax.swing.JButton();
        btnActualizarCamposEmpresa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        txtPasswordUsuario = new javax.swing.JPasswordField();
        btnEditarUsuario = new javax.swing.JButton();
        btnEliminarUsuario = new javax.swing.JButton();
        btnRegistrarUsuario = new javax.swing.JButton();
        btnLimpiarCampos = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 10, 560));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(35, 46, 51));
        jLabel6.setText("Registrar usuario");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, 150, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(35, 46, 51));
        jLabel7.setText("Datos de la empresa");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 180, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(35, 46, 51));
        jLabel1.setText("RUC");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 80, 30));
        jPanel1.add(txtRucEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 240, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(35, 46, 51));
        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 80, 30));
        jPanel1.add(txtNombreEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 240, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(35, 46, 51));
        jLabel3.setText("Telefono");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 80, 30));
        jPanel1.add(txtTelefonoEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 240, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(35, 46, 51));
        jLabel5.setText("Dirección");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 120, 30));
        jPanel1.add(txtDireccionEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 240, 30));
        jPanel1.add(txtRazonEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 240, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(35, 46, 51));
        jLabel8.setText("Razon social");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 120, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(35, 46, 51));
        jLabel4.setText("Nombre");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 80, 30));
        jPanel1.add(txtNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 240, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(35, 46, 51));
        jLabel9.setText("Apellido");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 80, 30));
        jPanel1.add(txtApellidoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 100, 240, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(35, 46, 51));
        jLabel10.setText("Contraseña");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 80, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(35, 46, 51));
        jLabel11.setText("Rol");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 140, 80, 30));

        cbxRolUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Usuario" }));
        jPanel1.add(cbxRolUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 170, 240, 30));

        btnEditarEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        btnEditarEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnEditarEmpresa.setToolTipText("Editar");
        btnEditarEmpresa.setBorderPainted(false);
        btnEditarEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarEmpresaActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditarEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, 40, 40));

        btnActualizarCamposEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizarCamposEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarCamposEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        btnActualizarCamposEmpresa.setToolTipText("Refrescar");
        btnActualizarCamposEmpresa.setBorderPainted(false);
        btnActualizarCamposEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizarCamposEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarCamposEmpresaActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizarCamposEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 40, 40));

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "USERNAME", "NOMBRE", "APELLIDO", "EMAIL", "ROL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUsuarios.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 720, 340));
        jPanel1.add(txtPasswordUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 240, 30));

        btnEditarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        btnEditarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnEditarUsuario.setToolTipText("Editar");
        btnEditarUsuario.setBorderPainted(false);
        btnEditarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 160, 40, 40));

        btnEliminarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btnEliminarUsuario.setToolTipText("Eliminar");
        btnEliminarUsuario.setBorderPainted(false);
        btnEliminarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 160, 40, 40));

        btnRegistrarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnRegistrarUsuario.setToolTipText("Agregar");
        btnRegistrarUsuario.setBorderPainted(false);
        btnRegistrarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 90, 40, 40));

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
        jPanel1.add(btnLimpiarCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 90, 40, 40));

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

    private void btnEditarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarEmpresaActionPerformed
        if (empresa != null) {
            if (!isCamposEmpresaVacio()) {
                empresa.setRuc(Integer.parseInt(txtRucEmpresa.getText()));
                empresa.setNombre(txtNombreEmpresa.getText());
                empresa.setTelefono(Integer.parseInt(txtTelefonoEmpresa.getText()));
                empresa.setDireccion(txtDireccionEmpresa.getText());
                empresa.setRazonSocial(txtRazonEmpresa.getText());
                empresaService = new EmpresaServiceImpl();
                empresaService.actualizarDatos(empresa);
                JOptionPane.showMessageDialog(null, "Datos empresa editado correctamente", "Datos empresa", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Los campos están vacios");
            }
        }

    }//GEN-LAST:event_btnEditarEmpresaActionPerformed

    private void btnActualizarCamposEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarCamposEmpresaActionPerformed
        iniciarDatosEmpresa();
    }//GEN-LAST:event_btnActualizarCamposEmpresaActionPerformed

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        int fila = tblUsuarios.rowAtPoint(evt.getPoint());
        usuarioService = new UsuarioServiceImpl();
        usuario = usuarioService.buscarUsuario(tblUsuarios.getValueAt(fila, 0).toString());
        txtNombreUsuario.setText(tblUsuarios.getValueAt(fila, 1).toString());
        txtApellidoUsuario.setText(tblUsuarios.getValueAt(fila, 2).toString());
        cbxRolUsuario.setSelectedItem(tblUsuarios.getValueAt(fila, 4).toString());
    }//GEN-LAST:event_tblUsuariosMouseClicked

    private void btnEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarUsuarioActionPerformed
        if (usuario == null || "admin".equals(usuario.getUsername())) {
            JOptionPane.showMessageDialog(null, "Seleccione un usuario", "Editar usuario", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (!isCamposUsuarioVacio()) {
                usuario.setNombre(txtNombreUsuario.getText());
                usuario.setApellido(txtApellidoUsuario.getText());
                usuario.setRol(cbxRolUsuario.getSelectedItem().toString());
                usuario.setPassword(String.valueOf(txtPasswordUsuario.getPassword()));
                usuario.setUsername((usuario.getNombre() + "." + usuario.getApellido()).toLowerCase());
                usuario.setEmail(usuario.getUsername() + "@gmail.com");
                usuarioService = new UsuarioServiceImpl();
                usuarioService.actualizarUsuario(usuario);
                JOptionPane.showMessageDialog(null, "Usuario editado correctamente", "Registro usuario", JOptionPane.INFORMATION_MESSAGE);
                limpiarTabla();
                limpiarCampos();
                listarUsuarios();
            } else {
                JOptionPane.showMessageDialog(null, "Los campos están vacios");
            }
        }
    }//GEN-LAST:event_btnEditarUsuarioActionPerformed

    private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioActionPerformed
        if (usuario != null && !"admin".equals(usuario.getUsername())) {
            int respuesta = JOptionPane.showConfirmDialog(null, "Desea eliminar el usuario?", "Eliminar usuario", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.OK_OPTION) {
                usuarioService = new UsuarioServiceImpl();
                usuarioService.eliminarUsuario(usuario.getIdUsuario());
                limpiarTabla();
                limpiarCampos();
                listarUsuarios();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un usuario", "Editar usuario", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed

    private void btnRegistrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarUsuarioActionPerformed
        if (!isCamposUsuarioVacio()) {
            String nombre = txtNombreUsuario.getText();
            String apellido = txtApellidoUsuario.getText();
            String password = String.valueOf(txtPasswordUsuario.getPassword());
            String rol = cbxRolUsuario.getSelectedItem().toString();
            String username = (nombre + "." + apellido).toLowerCase();
            String email = username + "@gmail.com";
            usuario = new Usuario(username, nombre, apellido, email, password, rol);
            usuarioService = new UsuarioServiceImpl();
            usuarioService.registrarUsuario(usuario);
            JOptionPane.showMessageDialog(null, "Usuario Registrado", "Registro usuario", JOptionPane.INFORMATION_MESSAGE);
            limpiarTabla();
            limpiarCampos();
            listarUsuarios();
            usuario = null;
        } else {
            JOptionPane.showMessageDialog(null, "Los campos están vacios");
        }
    }//GEN-LAST:event_btnRegistrarUsuarioActionPerformed

    private void btnLimpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCamposActionPerformed
        limpiarCampos();
        tblUsuarios.clearSelection();
    }//GEN-LAST:event_btnLimpiarCamposActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarCamposEmpresa;
    private javax.swing.JButton btnEditarEmpresa;
    private javax.swing.JButton btnEditarUsuario;
    private javax.swing.JButton btnEliminarUsuario;
    private javax.swing.JButton btnLimpiarCampos;
    private javax.swing.JButton btnRegistrarUsuario;
    private javax.swing.JComboBox<String> cbxRolUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtApellidoUsuario;
    private javax.swing.JTextField txtDireccionEmpresa;
    private javax.swing.JTextField txtNombreEmpresa;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JPasswordField txtPasswordUsuario;
    private javax.swing.JTextField txtRazonEmpresa;
    private javax.swing.JTextField txtRucEmpresa;
    private javax.swing.JTextField txtTelefonoEmpresa;
    // End of variables declaration//GEN-END:variables
}
