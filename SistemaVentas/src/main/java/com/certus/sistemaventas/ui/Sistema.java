package com.certus.sistemaventas.ui;

import com.certus.sistemaventas.modelo.entidades.Usuario;
import com.certus.sistemaventas.ui.panels.*;
import java.time.LocalDate;
import javax.swing.JPanel;

public class Sistema extends javax.swing.JFrame {

    int xMouse, yMouse;
    private Usuario usuario;

    public Sistema() {
        initComponents();
        setLocationRelativeTo(null);
        setDate();
        mostrarPanel(new PanelInicio());
    }

    private void setDate() {
        LocalDate date = LocalDate.now();
        int anio = date.getYear();
        int dia = date.getDayOfMonth();
        int mes = date.getMonthValue();
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octube", "Nomviembre", "Diciembre"};
        txtDate.setText("Hoy " + dia + " de " + meses[mes - 1] + " del " + anio);
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        cargarPermisos(usuario);
        lblUserName.setText(usuario.getUsername());
    }

    private void cargarPermisos(Usuario usuario) {
        if (usuario.getRol().equalsIgnoreCase("Usuario")) {
            btnAdministracion.setVisible(false);
            btnVentas.setVisible(false);
            btnProveedor.setVisible(false);
            btnProductos.setVisible(false);
        }
    }

    private void mostrarPanel(JPanel p) {
        p.setSize(1120, 580);
        p.setLocation(0, 0);
        pnlViews.removeAll();
        pnlViews.add(p);
        pnlViews.revalidate();
        pnlViews.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        sideNav = new javax.swing.JPanel();
        pnlLogo = new javax.swing.JPanel();
        lblImgGrupo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        btnInicio = new javax.swing.JButton();
        btnNuevaVenta = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnProveedor = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        btnAdministracion = new javax.swing.JButton();
        headerVentana = new javax.swing.JPanel();
        pnlMin = new javax.swing.JPanel();
        btnMin = new javax.swing.JLabel();
        pnlClose = new javax.swing.JPanel();
        btnCloseTxt = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        txtTitle = new javax.swing.JLabel();
        txtDate = new javax.swing.JLabel();
        pnlViews = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(230, 232, 234));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sideNav.setBackground(new java.awt.Color(31, 39, 45));

        pnlLogo.setBackground(new java.awt.Color(31, 39, 45));

        lblImgGrupo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImgGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_seniors.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(220, 220, 220));
        jLabel1.setText("Bienvenido:");

        lblUserName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(220, 220, 220));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 0));
        jLabel2.setText("LOS");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(220, 220, 220));
        jLabel3.setText("SENIORS");

        btnCerrarSesion.setBackground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cerrar-sesion.png"))); // NOI18N
        btnCerrarSesion.setToolTipText("Cerrar sesión");
        btnCerrarSesion.setBorder(null);
        btnCerrarSesion.setBorderPainted(false);
        btnCerrarSesion.setContentAreaFilled(false);
        btnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLogoLayout = new javax.swing.GroupLayout(pnlLogo);
        pnlLogo.setLayout(pnlLogoLayout);
        pnlLogoLayout.setHorizontalGroup(
            pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLogoLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(lblUserName))
                    .addComponent(jLabel1)
                    .addGroup(pnlLogoLayout.createSequentialGroup()
                        .addComponent(lblImgGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlLogoLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnlLogoLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCerrarSesion)))))
                .addContainerGap())
        );
        pnlLogoLayout.setVerticalGroup(
            pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogoLayout.createSequentialGroup()
                .addGroup(pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLogoLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlLogoLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlLogoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCerrarSesion)
                            .addComponent(lblImgGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        btnInicio.setBackground(new java.awt.Color(31, 39, 45));
        btnInicio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnInicio.setForeground(new java.awt.Color(200, 200, 200));
        btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        btnInicio.setText("Inicio");
        btnInicio.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 15, 1, 1, new java.awt.Color(0, 0, 0)));
        btnInicio.setBorderPainted(false);
        btnInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInicio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnInicio.setIconTextGap(10);
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        btnNuevaVenta.setBackground(new java.awt.Color(31, 39, 45));
        btnNuevaVenta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnNuevaVenta.setForeground(new java.awt.Color(200, 200, 200));
        btnNuevaVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nueva_venta.png"))); // NOI18N
        btnNuevaVenta.setText("Nueva Venta");
        btnNuevaVenta.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 15, 1, 1, new java.awt.Color(0, 0, 0)));
        btnNuevaVenta.setBorderPainted(false);
        btnNuevaVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevaVenta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNuevaVenta.setIconTextGap(10);
        btnNuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaVentaActionPerformed(evt);
            }
        });

        btnProductos.setBackground(new java.awt.Color(31, 39, 45));
        btnProductos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnProductos.setForeground(new java.awt.Color(200, 200, 200));
        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/productos.png"))); // NOI18N
        btnProductos.setText("Productos");
        btnProductos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 15, 1, 1, new java.awt.Color(0, 0, 0)));
        btnProductos.setBorderPainted(false);
        btnProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnProductos.setIconTextGap(10);
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

        btnClientes.setBackground(new java.awt.Color(31, 39, 45));
        btnClientes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnClientes.setForeground(new java.awt.Color(200, 200, 200));
        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clientes.png"))); // NOI18N
        btnClientes.setText("Clientes");
        btnClientes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 15, 1, 1, new java.awt.Color(0, 0, 0)));
        btnClientes.setBorderPainted(false);
        btnClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClientes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnClientes.setIconTextGap(10);
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnProveedor.setBackground(new java.awt.Color(31, 39, 45));
        btnProveedor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnProveedor.setForeground(new java.awt.Color(200, 200, 200));
        btnProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/proveedor.png"))); // NOI18N
        btnProveedor.setText("Proveedor");
        btnProveedor.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 15, 1, 1, new java.awt.Color(0, 0, 0)));
        btnProveedor.setBorderPainted(false);
        btnProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProveedor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnProveedor.setIconTextGap(10);
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });

        btnVentas.setBackground(new java.awt.Color(31, 39, 45));
        btnVentas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVentas.setForeground(new java.awt.Color(200, 200, 200));
        btnVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ventas.png"))); // NOI18N
        btnVentas.setText("Ventas");
        btnVentas.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 15, 1, 1, new java.awt.Color(0, 0, 0)));
        btnVentas.setBorderPainted(false);
        btnVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVentas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVentas.setIconTextGap(10);
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });

        btnAdministracion.setBackground(new java.awt.Color(31, 39, 45));
        btnAdministracion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAdministracion.setForeground(new java.awt.Color(200, 200, 200));
        btnAdministracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/admin.png"))); // NOI18N
        btnAdministracion.setText("Administración");
        btnAdministracion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 15, 1, 1, new java.awt.Color(0, 0, 0)));
        btnAdministracion.setBorderPainted(false);
        btnAdministracion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdministracion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAdministracion.setIconTextGap(10);
        btnAdministracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministracionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sideNavLayout = new javax.swing.GroupLayout(sideNav);
        sideNav.setLayout(sideNavLayout);
        sideNavLayout.setHorizontalGroup(
            sideNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnAdministracion, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        sideNavLayout.setVerticalGroup(
            sideNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideNavLayout.createSequentialGroup()
                .addComponent(pnlLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(btnNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addComponent(btnAdministracion, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bg.add(sideNav, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 720));

        headerVentana.setBackground(new java.awt.Color(35, 46, 51));
        headerVentana.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerVentanaMouseDragged(evt);
            }
        });
        headerVentana.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerVentanaMousePressed(evt);
            }
        });

        pnlMin.setBackground(new java.awt.Color(35, 46, 51));
        pnlMin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlMinMouseClicked(evt);
            }
        });
        pnlMin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMin.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnMin.setForeground(new java.awt.Color(0, 0, 0));
        btnMin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimizar.png"))); // NOI18N
        pnlMin.add(btnMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        pnlClose.setBackground(new java.awt.Color(35, 46, 51));
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
        btnCloseTxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cerrar.png"))); // NOI18N
        pnlClose.add(btnCloseTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        javax.swing.GroupLayout headerVentanaLayout = new javax.swing.GroupLayout(headerVentana);
        headerVentana.setLayout(headerVentanaLayout);
        headerVentanaLayout.setHorizontalGroup(
            headerVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerVentanaLayout.createSequentialGroup()
                .addGap(0, 1298, Short.MAX_VALUE)
                .addComponent(pnlMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerVentanaLayout.setVerticalGroup(
            headerVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerVentanaLayout.createSequentialGroup()
                .addGroup(headerVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bg.add(headerVentana, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 30));

        header.setBackground(new java.awt.Color(35, 46, 51));

        txtTitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txtTitle.setForeground(new java.awt.Color(220, 220, 220));
        txtTitle.setText("SISTEMA DE VENTAS");

        txtDate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDate.setForeground(new java.awt.Color(220, 220, 220));
        txtDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtDate.setText("hoy {day}  de {mes} del {año}");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap(389, Short.MAX_VALUE)
                .addComponent(txtTitle)
                .addGap(181, 181, 181)
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bg.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 1140, 90));

        pnlViews.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlViewsLayout = new javax.swing.GroupLayout(pnlViews);
        pnlViews.setLayout(pnlViewsLayout);
        pnlViewsLayout.setHorizontalGroup(
            pnlViewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1120, Short.MAX_VALUE)
        );
        pnlViewsLayout.setVerticalGroup(
            pnlViewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        bg.add(pnlViews, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 1120, 580));

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

    private void pnlCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_pnlCloseMouseClicked

    private void headerVentanaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerVentanaMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerVentanaMouseDragged

    private void headerVentanaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerVentanaMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerVentanaMousePressed

    private void pnlMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMinMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_pnlMinMouseClicked

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        mostrarPanel(new PanelInicio());
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnNuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaVentaActionPerformed
        PanelNuevaVenta pnlNuevaVenta = new PanelNuevaVenta();
        pnlNuevaVenta.setUsuario(usuario);
        mostrarPanel(pnlNuevaVenta);
    }//GEN-LAST:event_btnNuevaVentaActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        mostrarPanel(new PanelProductos());
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        mostrarPanel(new PanelClientes());
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        mostrarPanel(new PanelProveedor());
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        mostrarPanel(new PanelVentas());
    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnAdministracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministracionActionPerformed
        mostrarPanel(new PanelAdministracion());
    }//GEN-LAST:event_btnAdministracionActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnAdministracion;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnClientes;
    private javax.swing.JLabel btnCloseTxt;
    private javax.swing.JButton btnInicio;
    private javax.swing.JLabel btnMin;
    private javax.swing.JButton btnNuevaVenta;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JButton btnVentas;
    private javax.swing.JPanel header;
    private javax.swing.JPanel headerVentana;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblImgGrupo;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JPanel pnlClose;
    private javax.swing.JPanel pnlLogo;
    private javax.swing.JPanel pnlMin;
    private javax.swing.JPanel pnlViews;
    private javax.swing.JPanel sideNav;
    private javax.swing.JLabel txtDate;
    private javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}
