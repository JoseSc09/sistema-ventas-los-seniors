package com.certus.sistemaventas.ui.panels;

import com.certus.sistemaventas.modelo.entidades.Cliente;
import com.certus.sistemaventas.modelo.entidades.DetalleVenta;
import com.certus.sistemaventas.modelo.entidades.Empresa;
import com.certus.sistemaventas.modelo.entidades.Producto;
import com.certus.sistemaventas.modelo.entidades.Usuario;
import com.certus.sistemaventas.modelo.entidades.Venta;
import com.certus.sistemaventas.servicio.ClienteService;
import com.certus.sistemaventas.servicio.DetalleVentaService;
import com.certus.sistemaventas.servicio.EmpresaService;
import com.certus.sistemaventas.servicio.ProductoService;
import com.certus.sistemaventas.servicio.VentaService;
import com.certus.sistemaventas.servicio.impl.ClienteServiceImpl;
import com.certus.sistemaventas.servicio.impl.DetalleVentaServiceImpl;
import com.certus.sistemaventas.servicio.impl.EmpresaServiceImpl;
import com.certus.sistemaventas.servicio.impl.ProductoServiceImpl;
import com.certus.sistemaventas.servicio.impl.VentaServiceImpl;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PanelNuevaVenta extends javax.swing.JPanel {

    private ProductoService productoService;
    private ClienteService clienteService;
    private VentaService ventaService;
    private DetalleVentaService detalleVentaService;
    private EmpresaService empresaService;
    private Empresa empresa;
    private Venta venta;
    private Producto producto;
    private Cliente cliente;
    private DetalleVenta detalleVenta;
    private Usuario usuario;
    private DefaultTableModel tableModel;
    private int fila;
    private String ruta;
    
    public PanelNuevaVenta() {
        initComponents();
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    private void limpiarCamposProducto() {
        txtCodigoProducto.setText("");
        txtNombreProducto.setText("");
        txtCantidadProducto.setText("");
        txtPrecioProducto.setText("");
        txtStockDisponibleProducto.setText("");
    }

    private void limpiarCamposCliente() {
        txtDniCliente.setText("");
        txtNombreCliente.setText("");
    }

    private void limpiarTabla() {
        tableModel = (DefaultTableModel) tblCart.getModel();
        int fila = tblCart.getRowCount();
        for (int i = 0; i < fila; i++) {
            tableModel.removeRow(0);
        }
    }

    private boolean isCamposProductoVacios() {
        return ("".equals(txtCodigoProducto.getText()) || "".equals(txtNombreProducto.getText()) || "".equals(txtCantidadProducto.getText()) || "".equals(txtPrecioProducto.getText()) || "".equals(txtStockDisponibleProducto.getText()));
    }

    private void addCart(Producto producto, int cantidad) {
        if (!isCamposProductoVacios() && producto != null) {
            double total = Math.round((producto.getPrecio() * cantidad) * 100.0) / 100.0;
            if (!(cantidad > producto.getStock())) {
                tableModel = (DefaultTableModel) tblCart.getModel();
                for (int i = 0; i < tblCart.getRowCount(); i++) {
                    if (tblCart.getValueAt(i, 0).toString().equals(txtCodigoProducto.getText())) {
                        int respuesta = JOptionPane.showConfirmDialog(null, "El producto ya está registrado\nDesea agregar el mismo producto?", "Warning", JOptionPane.YES_NO_OPTION);
                        if (respuesta == 0) {
                            cantidad += (Integer) tblCart.getValueAt(i, 2);
                            if (!(cantidad > producto.getStock())) {
                                tblCart.setValueAt(cantidad, i, 2);
                                total = Math.round((producto.getPrecio() * cantidad) * 100.0) / 100.0;
                                tblCart.setValueAt(total, i, 4);
                                calcularPagoTotal();
                                limpiarCamposProducto();
                                txtCodigoProducto.requestFocus();
                                return;
                            } else {
                                JOptionPane.showMessageDialog(null, "Stock no disponible", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
                Object[] ob = new Object[5];
                ob[0] = producto.getCodigo();
                ob[1] = producto.getNombre();
                ob[2] = cantidad;
                ob[3] = producto.getPrecio();
                ob[4] = total;
                tableModel.addRow(ob);
                tblCart.setModel(tableModel);
                calcularPagoTotal();
                limpiarCamposProducto();
                txtCodigoProducto.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Stock no disponible", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private double calcularPagoTotal() {
        double pagoTotal = 0;
        for (int i = 0; i < tblCart.getRowCount(); i++) {
            pagoTotal += (Double) tblCart.getValueAt(i, 4);
        }
        lblPagoTotal.setText("S/" + String.format("%.2f", pagoTotal));
        return pagoTotal;
    }

    private void generarVenta() {
        ventaService = new VentaServiceImpl();
        venta = new Venta(cliente.getNombre(), (usuario.getNombre()+" "+usuario.getApellido()), calcularPagoTotal());
        ventaService.registrarVenta(venta);
    }

    private void registarDetalleVenta() {
        ventaService = new VentaServiceImpl();
        productoService = new ProductoServiceImpl();
        int idVenta = ventaService.obtenerIdUltimoRegistro();
        for (int i = 0; i < tblCart.getRowCount(); i++) {
            int codigoProducto = (Integer) tblCart.getValueAt(i, 0);
            int cantidad = (Integer) tblCart.getValueAt(i, 2);
            double precio = (Double) tblCart.getValueAt(i, 3);

            producto = productoService.buscarProducto(codigoProducto);
            detalleVenta = new DetalleVenta(codigoProducto, cantidad, precio, idVenta);

            detalleVentaService = new DetalleVentaServiceImpl();
            detalleVentaService.registrarDetalleVenta(detalleVenta);

            producto.setStock(producto.getStock() - cantidad);
            productoService.actualizarProducto(producto);
        }
    }

    public void generarPdf() {
        Document document = new Document();
        String rutaBase = System.getProperty("user.home");
        detalleVentaService = new DetalleVentaServiceImpl();
        ventaService = new VentaServiceImpl();
        productoService = new ProductoServiceImpl();
        empresaService = new EmpresaServiceImpl();
        empresa = empresaService.buscarDatos();
        int lastRegister = ventaService.obtenerIdUltimoRegistro();
        ruta = rutaBase +  "/Desktop/BOLETA_" + lastRegister + "_" + (cliente.getNombre()).toUpperCase() + "_" + cliente.getDni() + ".pdf";
        List<DetalleVenta> ultimaVenta = detalleVentaService.listarUltimaVenta(lastRegister);
        try {
            PdfWriter.getInstance(document, new FileOutputStream(ruta));
            document.open();
            //header
            Paragraph date = new Paragraph();
            date.add(Chunk.NEWLINE);
            Date fecha = new Date();
            date.add("BOLETA DE VENTA\nNº: " + lastRegister + "\nFecha: " + new SimpleDateFormat("dd-MM-yyyy").format(fecha));
            PdfPTable header = new PdfPTable(4);
            header.setWidthPercentage(100);
            header.getDefaultCell().setBorder(0);
            float[] cols = new float[]{10f, 60f, 20f, 30f};
            header.setWidths(cols);
            header.setHorizontalAlignment(Element.ALIGN_LEFT);
            header.addCell("");
            header.addCell("RUC: " + empresa.getRuc() + "\nNombre: "
                    + empresa.getNombre()
                    + "\nTelf.: " + empresa.getTelefono()
                    + "\nDirección: " + empresa.getDireccion()
                    + "\nRazon social: " + empresa.getRazonSocial() + "\n\n");
            header.addCell("");
            header.addCell(date);
            document.add(header);

            //Cliente
            PdfPTable tblCliente = new PdfPTable(3);
            cols = new float[]{10f, 80f, 10f};
            tblCliente.setWidthPercentage(100);
            tblCliente.getDefaultCell().setBorder(0);
            tblCliente.setWidths(cols);
            tblCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            tblCliente.addCell("");
            tblCliente.addCell("Señor(es): " + cliente.getNombre()
                    + "\nDireccion: " + cliente.getDireccion()
                    + "\nDNI: " + cliente.getDni() + "\n\n");
            tblCliente.addCell("");
            document.add(tblCliente);

            //Productos
            PdfPTable tableVenta = new PdfPTable(5);
            cols = new float[]{10f, 10f, 55f, 10f, 15f};
            tableVenta.setWidthPercentage(100);
            tableVenta.setWidths(cols);
            tableVenta.addCell("Codigo prod.");
            tableVenta.addCell("Cantidad");
            tableVenta.addCell("Descripción");
            tableVenta.addCell("Precio Unit.");
            tableVenta.addCell("Total");
            for (DetalleVenta info : ultimaVenta) {
                producto = productoService.buscarProducto(info.getCodProducto());
                String CodProd = String.valueOf(info.getCodProducto());
                String Cantidad = String.valueOf(info.getCantidad());
                String Descrip = producto.getNombre();
                String PrecioUnit = String.valueOf(info.getPrecio());
                String Total = String.format("%.2f", (info.getCantidad() * info.getPrecio()));
                tableVenta.addCell(CodProd);
                tableVenta.addCell(Cantidad);
                tableVenta.addCell(Descrip);
                tableVenta.addCell(PrecioUnit);
                tableVenta.addCell(Total);
            }
            document.add(tableVenta);

            //Total
            PdfPTable tblTotal = new PdfPTable(3);
            cols = new float[]{75f,10f,15f};
            tblTotal.setWidthPercentage(100);
            tblTotal.getDefaultCell().setBorder(0);
            tblTotal.setHorizontalAlignment(Element.ALIGN_RIGHT);
            tblTotal.setWidths(cols);
            tblTotal.addCell("");
            tblTotal.addCell("Total: ");
            tblTotal.addCell("S/"+String.format("%.2f",venta.getPagoTotal()));
            document.add(tblTotal);
        } catch (FileNotFoundException | DocumentException ex) {
            ex.printStackTrace(System.out);
        } finally {
            document.close();
        }
    }

    private void abrirPdf(){
        File file = new File(ruta);
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCart = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        txtCodigoProducto = new javax.swing.JTextField();
        txtCantidadProducto = new javax.swing.JTextField();
        txtPrecioProducto = new javax.swing.JTextField();
        txtStockDisponibleProducto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDniCliente = new javax.swing.JTextField();
        txtNombreCliente = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lblPagoTotal = new javax.swing.JLabel();
        btnBuscarProducto = new javax.swing.JButton();
        btnAddCart = new javax.swing.JButton();
        btnBuscarCliente1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        btnEliminarProducto = new javax.swing.JButton();
        btnGenerarVenta = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 10, 560));

        tblCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "NOMBRE", "CANTIDAD", "PRECIO UNID.", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCart.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tblCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCartMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCart);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 720, 340));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(35, 46, 51));
        jLabel1.setText("Código");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 80, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(35, 46, 51));
        jLabel2.setText("Producto");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 80, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(35, 46, 51));
        jLabel3.setText("Cantidad");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 80, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(35, 46, 51));
        jLabel4.setText("Precio");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 80, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(35, 46, 51));
        jLabel5.setText("Stock disponible");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 120, 30));

        txtNombreProducto.setEditable(false);
        jPanel1.add(txtNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 320, 30));

        txtCodigoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoProductoKeyTyped(evt);
            }
        });
        jPanel1.add(txtCodigoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 150, 30));

        txtCantidadProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadProductoKeyTyped(evt);
            }
        });
        jPanel1.add(txtCantidadProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 150, 30));

        txtPrecioProducto.setEditable(false);
        jPanel1.add(txtPrecioProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 150, 30));

        txtStockDisponibleProducto.setEditable(false);
        jPanel1.add(txtStockDisponibleProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 150, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(35, 46, 51));
        jLabel6.setText("Producto");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 110, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(35, 46, 51));
        jLabel7.setText("Cliente");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 110, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(35, 46, 51));
        jLabel8.setText("DNI");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 80, 30));

        txtDniCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniClienteKeyTyped(evt);
            }
        });
        jPanel1.add(txtDniCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 150, 30));

        txtNombreCliente.setEditable(false);
        jPanel1.add(txtNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 320, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(35, 46, 51));
        jLabel9.setText("Nombre");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 80, 30));

        lblPagoTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPagoTotal.setForeground(new java.awt.Color(35, 46, 51));
        jPanel1.add(lblPagoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 450, 110, 30));

        btnBuscarProducto.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btnBuscarProducto.setToolTipText("Buscar producto");
        btnBuscarProducto.setBorderPainted(false);
        btnBuscarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 40, 40));

        btnAddCart.setBackground(new java.awt.Color(255, 255, 255));
        btnAddCart.setForeground(new java.awt.Color(255, 255, 255));
        btnAddCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shopping-cart.png"))); // NOI18N
        btnAddCart.setToolTipText("Agregar a la lista");
        btnAddCart.setBorderPainted(false);
        btnAddCart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCartActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 40, 40));

        btnBuscarCliente1.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarCliente1.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarCliente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btnBuscarCliente1.setToolTipText("Buscar cliente");
        btnBuscarCliente1.setBorderPainted(false);
        btnBuscarCliente1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCliente1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarCliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, 40, 40));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 343, 340, 10));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(35, 46, 51));
        jLabel11.setText("Pago total:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 450, 90, 30));

        btnEliminarProducto.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btnEliminarProducto.setToolTipText("Eliminar producto");
        btnEliminarProducto.setBorderPainted(false);
        btnEliminarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarProducto.setEnabled(false);
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 30, 40, 40));

        btnGenerarVenta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGenerarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imprimir.png"))); // NOI18N
        btnGenerarVenta.setText("Generar venta");
        btnGenerarVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerarVenta.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnGenerarVenta.setIconTextGap(40);
        btnGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarVentaActionPerformed(evt);
            }
        });
        jPanel1.add(btnGenerarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 440, 210, 50));

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

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        int codigoProducto;
        if (!"".equals(txtCodigoProducto.getText())) {
            try {
                codigoProducto = Integer.parseInt(txtCodigoProducto.getText());
                productoService = new ProductoServiceImpl();
                producto = productoService.buscarProducto(codigoProducto);
                if (producto != null) {
                    txtNombreProducto.setText(producto.getNombre());
                    txtPrecioProducto.setText(String.valueOf(producto.getPrecio()));
                    txtStockDisponibleProducto.setText(String.valueOf(producto.getStock()));
                    txtCantidadProducto.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "Producto no encontrado", "Error de busqueda", JOptionPane.INFORMATION_MESSAGE);
                    txtCodigoProducto.requestFocus();
                    limpiarCamposProducto();
                }
            } catch (HeadlessException | NumberFormatException ex) {
                limpiarCamposProducto();
                JOptionPane.showMessageDialog(null, "Campo no valido", "Error de busqueda", JOptionPane.ERROR_MESSAGE);
                txtCodigoProducto.requestFocus();
            }
        } else {
            limpiarCamposProducto();
            JOptionPane.showMessageDialog(null, "Campo vacio", "Error de busqueda", JOptionPane.INFORMATION_MESSAGE);
            txtCodigoProducto.requestFocus();
        }
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void btnAddCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCartActionPerformed
        int cantidad;
        try {
            cantidad = Integer.parseInt(txtCantidadProducto.getText());
            addCart(producto, cantidad);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Campo no valido", "Error de busqueda", JOptionPane.ERROR_MESSAGE);
            txtCantidadProducto.setText("");
            txtCantidadProducto.requestFocus();
        }
    }//GEN-LAST:event_btnAddCartActionPerformed

    private void tblCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCartMouseClicked
        btnEliminarProducto.setEnabled(true);
        fila = tblCart.rowAtPoint(evt.getPoint());

    }//GEN-LAST:event_tblCartMouseClicked

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        tableModel = (DefaultTableModel) tblCart.getModel();
        tableModel.removeRow(fila);
        calcularPagoTotal();
        limpiarCamposProducto();
        txtCodigoProducto.requestFocus();
        fila = 0;
        btnEliminarProducto.setEnabled(false);
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnBuscarCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCliente1ActionPerformed
        int dni;
        if (!"".equals(txtDniCliente.getText())) {
            try {
                dni = Integer.parseInt(txtDniCliente.getText());
                clienteService = new ClienteServiceImpl();
                cliente = clienteService.buscarCliente(dni);
                if (cliente != null) {
                    txtNombreCliente.setText(cliente.getNombre());
                } else {
                    limpiarCamposCliente();
                    JOptionPane.showMessageDialog(null, "Cliente no encontrado", "Error de busqueda", JOptionPane.INFORMATION_MESSAGE);
                    txtDniCliente.requestFocus();
                }
            } catch (HeadlessException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Campo no valido", "Error de busqueda", JOptionPane.ERROR_MESSAGE);
                limpiarCamposCliente();
                txtDniCliente.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Campo vacio", "Error de busqueda", JOptionPane.INFORMATION_MESSAGE);
            limpiarCamposCliente();
            txtDniCliente.requestFocus();
        }
    }//GEN-LAST:event_btnBuscarCliente1ActionPerformed

    private void btnGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarVentaActionPerformed
        if (tblCart.getRowCount() > 0) {
            int respuesta = JOptionPane.showConfirmDialog(null, "Desea continuar?", "Reporte", JOptionPane.YES_NO_OPTION);
            if (respuesta == 0) {
                if (cliente != null) {
                    generarVenta();
                    registarDetalleVenta();
                    generarPdf();
                    abrirPdf();
                    limpiarTabla();
                    limpiarCamposCliente();
                    limpiarCamposProducto();
                    calcularPagoTotal();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un cliente");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay productos agregados");
        }
    }//GEN-LAST:event_btnGenerarVentaActionPerformed

    private void txtCodigoProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProductoKeyTyped
        char key = evt.getKeyChar();
        if (Character.isAlphabetic(key)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCodigoProductoKeyTyped

    private void txtCantidadProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadProductoKeyTyped
        char key = evt.getKeyChar();
        if (Character.isAlphabetic(key)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadProductoKeyTyped

    private void txtDniClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniClienteKeyTyped
        char key = evt.getKeyChar();
        if (Character.isAlphabetic(key)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDniClienteKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCart;
    private javax.swing.JButton btnBuscarCliente1;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnGenerarVenta;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblPagoTotal;
    private javax.swing.JTable tblCart;
    private javax.swing.JTextField txtCantidadProducto;
    private javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtDniCliente;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtPrecioProducto;
    private javax.swing.JTextField txtStockDisponibleProducto;
    // End of variables declaration//GEN-END:variables
}
