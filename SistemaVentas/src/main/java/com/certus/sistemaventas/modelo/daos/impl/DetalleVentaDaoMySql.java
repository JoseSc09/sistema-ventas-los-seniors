package com.certus.sistemaventas.modelo.daos.impl;

import com.certus.sistemaventas.modelo.daos.DetalleVentaDao;
import com.certus.sistemaventas.modelo.entidades.DetalleVenta;
import com.certus.sistemaventas.util.DBConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetalleVentaDaoMySql implements DetalleVentaDao {

    private final List<DetalleVenta> detalleVentas;
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public DetalleVentaDaoMySql() {
        detalleVentas = new ArrayList<>();
    }

    @Override
    public void create(DetalleVenta detalleVenta) {
        String sql = "INSERT INTO detalle_venta (cod_producto,cantidad,precio,id_venta) VALUES(?,?,?,?)";
        try {
            conn = DBConn.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, detalleVenta.getCodProducto());
            ps.setInt(2, detalleVenta.getCantidad());
            ps.setDouble(3, detalleVenta.getPrecio());
            ps.setInt(4, detalleVenta.getIdVenta());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            DBConn.close(ps);
            DBConn.close(conn);
        }
    }

    @Override
    public void update(DetalleVenta detalleVenta) {
        String sql = "UPDATE detalle_venta SET cod_producto = ?, cantidad = ?, precio = ?, id_venta = ? WHERE id_detalle_venta = ?";
        try {
            conn = DBConn.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, detalleVenta.getCodProducto());
            ps.setInt(2, detalleVenta.getCantidad());
            ps.setDouble(3, detalleVenta.getPrecio());
            ps.setInt(4, detalleVenta.getIdVenta());
            ps.setInt(5, detalleVenta.getIdDetalleVenta());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            DBConn.close(ps);
            DBConn.close(conn);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM detalle_venta WHERE id_detalle_venta=?";
        try {
            conn = DBConn.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            DBConn.close(ps);
            DBConn.close(conn);
        }
    }

    @Override
    public DetalleVenta find(int idVenta) {
        String sql = "SELECT * FROM detalle_venta WHERE id_venta = ?";
        try {
            conn = DBConn.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idVenta);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new DetalleVenta(rs.getInt("id_detalle_venta"),
                        rs.getInt("cod_producto"),
                        rs.getInt("cantidad"),
                        rs.getDouble("precio"),
                        rs.getInt("id_venta"));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            DBConn.close(rs);
            DBConn.close(ps);
            DBConn.close(conn);
        }
        return null;
    }

    @Override
    public List<DetalleVenta> findAll() {
        String sql = "SELECT * FROM detalle_venta";
        DetalleVenta detalleVenta;
        try {
            conn = DBConn.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                detalleVenta = new DetalleVenta(rs.getInt("id_detalle_venta"),
                        rs.getInt("cod_producto"),
                        rs.getInt("cantidad"),
                        rs.getDouble("precio"),
                        rs.getInt("id_venta"));
                detalleVentas.add(detalleVenta);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            DBConn.close(rs);
            DBConn.close(ps);
            DBConn.close(conn);
        }
        return detalleVentas;
    }

    @Override
    public List<DetalleVenta> findAll(int idVenta) {
        String sql = "SELECT * FROM detalle_venta WHERE id_venta = ?";
        DetalleVenta detalleVenta;
        try {
            conn = DBConn.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idVenta);
            rs = ps.executeQuery();
            while (rs.next()) {
                detalleVenta = new DetalleVenta(rs.getInt("id_detalle_venta"),
                        rs.getInt("cod_producto"),
                        rs.getInt("cantidad"),
                        rs.getDouble("precio"),
                        rs.getInt("id_venta"));
                detalleVentas.add(detalleVenta);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            DBConn.close(rs);
            DBConn.close(ps);
            DBConn.close(conn);
        }
        return detalleVentas;
    }
}
