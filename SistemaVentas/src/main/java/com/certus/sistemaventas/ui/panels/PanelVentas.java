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
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PanelVentas extends javax.swing.JPanel {

    private ProductoService productoService;
    private ClienteService clienteService;
    private VentaService ventaService;
    private DetalleVentaService detalleVentaService;
    private EmpresaService empresaService;
    private Empresa empresa;
    private Venta venta;
    private Producto producto;
    private Cliente cliente;
    private DefaultTableModel tableModel;
    private String ruta;
    private List<Venta> ventas;

    public PanelVentas() {
        initComponents();
        listarVentas();
    }

    private void limpiarTabla() {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            tableModel.removeRow(i);
            i -= 1;
        }
    }

    private void listarVentas() {
        ventaService = new VentaServiceImpl();
        if (ventas == null) {
            tableModel = (DefaultTableModel) tblVentas.getModel();
            ventas = ventaService.listarVentas();
        }
        Object[] col = new Object[4];
        for (int i = 0; i < ventas.size(); i++) {
            col[0] = ventas.get(i).getIdVenta();
            col[1] = ventas.get(i).getCliente();
            col[2] = ventas.get(i).getVendedor();
            col[3] = ventas.get(i).getPagoTotal();

            tableModel.addRow(col);
        }
        tblVentas.setModel(tableModel);
    }

    public void generarPdf() {
        Document document = new Document();
        String rutaBase = System.getProperty("user.home");
        detalleVentaService = new DetalleVentaServiceImpl();
        ventaService = new VentaServiceImpl();
        productoService = new ProductoServiceImpl();
        empresaService = new EmpresaServiceImpl();
        empresa = empresaService.buscarDatos();
        int idVenta = venta.getIdVenta();
        ruta = rutaBase + "/Desktop/BOLETA_" + idVenta + "_" + (cliente.getNombre()).toUpperCase() + "_" + cliente.getDni() + ".pdf";
        List<DetalleVenta> ultimaVenta = detalleVentaService.listarUltimaVenta(idVenta);
        try {
            PdfWriter.getInstance(document, new FileOutputStream(ruta));
            document.open();
            //header
            Paragraph date = new Paragraph();
            date.add(Chunk.NEWLINE);
            Date fecha = new Date();
            date.add("BOLETA DE VENTA\nNº: " + idVenta + "\nFecha: " + new SimpleDateFormat("dd-MM-yyyy").format(fecha));
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
            cols = new float[]{75f, 10f, 15f};
            tblTotal.setWidthPercentage(100);
            tblTotal.getDefaultCell().setBorder(0);
            tblTotal.setHorizontalAlignment(Element.ALIGN_RIGHT);
            tblTotal.setWidths(cols);
            tblTotal.addCell("");
            tblTotal.addCell("Total: ");
            tblTotal.addCell("S/" + String.format("%.2f", venta.getPagoTotal()));
            document.add(tblTotal);
        } catch (FileNotFoundException | DocumentException ex) {
            ex.printStackTrace(System.out);
        } finally {
            document.close();
        }
    }

    private void abrirPdf() {
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
        txtBusqueda = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();
        btnGenerarPdf = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 500, 10));

        txtBusqueda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBusqueda.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtBusqueda.setBorder(null);
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyPressed(evt);
            }
        });
        jPanel1.add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 460, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, 30));

        tblVentas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº Boleta", "CLIENTE", "ENCARGADO", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVentas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tblVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVentasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVentas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 1080, 390));

        btnGenerarPdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/archivo-pdf.png"))); // NOI18N
        btnGenerarPdf.setText("GENERAR PDF");
        btnGenerarPdf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerarPdf.setEnabled(false);
        btnGenerarPdf.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnGenerarPdf.setIconTextGap(30);
        btnGenerarPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarPdfActionPerformed(evt);
            }
        });
        jPanel1.add(btnGenerarPdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 180, 50));

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

    private void tblVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVentasMouseClicked
        int fila = tblVentas.rowAtPoint(evt.getPoint());
        ventaService = new VentaServiceImpl();
        venta = ventaService.buscarVenta((Integer) tblVentas.getValueAt(fila, 0));
        clienteService = new ClienteServiceImpl();
        cliente = clienteService.buscarCliente(tblVentas.getValueAt(fila, 1).toString());
        btnGenerarPdf.setEnabled(true);
    }//GEN-LAST:event_tblVentasMouseClicked

    private void txtBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyPressed
        char key = evt.getKeyChar();
        String busqueda = txtBusqueda.getText();
        if (key == KeyEvent.VK_ENTER) {
            if (!busqueda.equals("")) {
                List<Venta> ventasCliente = ventaService.listarVentasDe(busqueda);
                ventas = ventasCliente;
                limpiarTabla();
                listarVentas();
            } else {
                ventas = ventaService.listarVentas();
                limpiarTabla();
                listarVentas();
            }
        }
    }//GEN-LAST:event_txtBusquedaKeyPressed

    private void btnGenerarPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPdfActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "Desea generar pdf?");
        if (respuesta == 0) {
            generarPdf();
            abrirPdf();
        }
        tblVentas.clearSelection();
        btnGenerarPdf.setEnabled(false);
        cliente = null;
    }//GEN-LAST:event_btnGenerarPdfActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarPdf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblVentas;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
