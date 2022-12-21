package com.certus.sistemaventas.ui;

import com.certus.sistemaventas.modelo.entidades.Usuario;
import com.certus.sistemaventas.servicio.UsuarioService;
import com.certus.sistemaventas.servicio.impl.UsuarioServiceImpl;
import java.awt.Color;

public class Login extends javax.swing.JFrame {

    private int xMouse, yMouse;
    private UsuarioService usuarioService;
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void login() {
        String username = txtUser.getText();
        String password = String.valueOf(txtPass.getPassword());
        if (!"".equals(username) || !"".equals(password)) {
            Usuario user;
            usuarioService = new UsuarioServiceImpl();
            user = usuarioService.validarUsuario(username, password);
            if (user != null) {
                this.dispose();
                Sistema s = new Sistema();
                s.setUsuario(user);
                s.setVisible(true);
            }else{
                javax.swing.JOptionPane.showMessageDialog(rootPane, "Nombre de usuario o contraseña incorrecta");
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        pnl1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblTitleImg = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        pnlClose = new javax.swing.JPanel();
        btnCloseTxt = new javax.swing.JLabel();
        pnl2 = new javax.swing.JPanel();
        loginImg = new javax.swing.JLabel();
        userImg = new javax.swing.JLabel();
        passImg = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtUser = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        txtPass = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl1.setBackground(new java.awt.Color(31, 39, 45));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("SISTEMA DE VENTAS");
        lblTitle.setToolTipText("");
        lblTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblTitleImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vendedor.png"))); // NOI18N

        javax.swing.GroupLayout pnl1Layout = new javax.swing.GroupLayout(pnl1);
        pnl1.setLayout(pnl1Layout);
        pnl1Layout.setHorizontalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
            .addComponent(lblTitleImg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl1Layout.setVerticalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addComponent(lblTitleImg, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        bg.add(pnl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 540));

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        pnlClose.setBackground(new java.awt.Color(255, 255, 255));
        pnlClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlCloseMouseClicked(evt);
            }
        });
        pnlClose.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCloseTxt.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnCloseTxt.setForeground(new java.awt.Color(0, 0, 0));
        btnCloseTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCloseTxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cerrar_black.png"))); // NOI18N
        pnlClose.add(btnCloseTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(0, 930, Short.MAX_VALUE)
                .addComponent(pnlClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(pnlClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bg.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 30));

        pnl2.setBackground(new java.awt.Color(255, 255, 255));
        pnl2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N
        pnl2.add(loginImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 31, 490, 150));

        userImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        pnl2.add(userImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 199, 60, 60));

        passImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pass.png"))); // NOI18N
        pnl2.add(passImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 290, 64, 64));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        pnl2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 310, 20));

        txtUser.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtUser.setForeground(new java.awt.Color(204, 204, 204));
        txtUser.setText("Ingrese su nombre de usuario");
        txtUser.setBorder(null);
        txtUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserFocusGained(evt);
            }
        });
        pnl2.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 312, 30));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        pnl2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 320, 10));

        txtPass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtPass.setForeground(new java.awt.Color(204, 204, 204));
        txtPass.setText("********");
        txtPass.setBorder(null);
        txtPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPassFocusGained(evt);
            }
        });
        pnl2.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 310, 30));

        btnEntrar.setBackground(new java.awt.Color(31, 39, 45));
        btnEntrar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(220, 220, 220));
        btnEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login_btn.png"))); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.setBorderPainted(false);
        btnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntrar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnEntrar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnEntrar.setIconTextGap(10);
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        pnl2.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 160, 50));
        btnEntrar.putClientProperty( "JButton.buttonType", "roundRect" );

        bg.add(pnl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 490, 540));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void pnlCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_pnlCloseMouseClicked

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        login();
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void txtUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserFocusGained
        if (txtUser.getText().equals("Ingrese su nombre de usuario")) {
            txtUser.setText("");
            txtUser.setForeground(Color.black);
        }
        if (String.valueOf(txtPass.getPassword()).isEmpty()) {
            txtPass.setText("********");
            txtPass.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_txtUserFocusGained

    private void txtPassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassFocusGained
        if (String.valueOf(txtPass.getPassword()).equals("********")) {
            txtPass.setText("");
            txtPass.setForeground(Color.black);
        }
        if (txtUser.getText().isEmpty()) {
            txtUser.setText("Ingrese su nombre de usuario");
            txtUser.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_txtPassFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JLabel btnCloseTxt;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JPanel header;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitleImg;
    private javax.swing.JLabel loginImg;
    private javax.swing.JLabel passImg;
    private javax.swing.JPanel pnl1;
    private javax.swing.JPanel pnl2;
    private javax.swing.JPanel pnlClose;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    private javax.swing.JLabel userImg;
    // End of variables declaration//GEN-END:variables
}
