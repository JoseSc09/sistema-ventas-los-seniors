package com.certus.sistemaventas.modelo.daos.impl;

import com.certus.sistemaventas.modelo.daos.VentaDao;
import com.certus.sistemaventas.modelo.entidades.Venta;
import com.certus.sistemaventas.util.DBConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentaDaoMySql implements VentaDao {

    private List<Venta> ventas;
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public VentaDaoMySql() {
        ventas = new ArrayList<>();
    }

    @Override
    public void create(Venta venta) {
        String sql = "INSERT INTO ventas (cliente,vendedor,total) VALUES(?,?,?)";
        try {
            conn = DBConn.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, venta.getCliente());
            ps.setString(2, venta.getVendedor());
            ps.setDouble(3, venta.getPagoTotal());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            DBConn.close(ps);
            DBConn.close(conn);
        }
    }

    @Override
    public void update(Venta venta) {
        String sql = "UPDATE ventas SET cliente = ?, vendedor = ?, total = ? WHERE id_venta = ?";
        try {
            conn = DBConn.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, venta.getCliente());
            ps.setString(2, venta.getVendedor());
            ps.setDouble(3, venta.getPagoTotal());
            ps.setInt(4, venta.getIdVenta());
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
        String sql = "DELETE FROM ventas WHERE id_venta=?";
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
    public int lastId() {
        int id = 0;
        String sql = "SELECT MAX(id_venta) FROM ventas";
        try {
            conn = DBConn.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            DBConn.close(rs);
            DBConn.close(ps);
            DBConn.close(conn);
        }
        return id;
    }

    @Override
    public Venta find(int id) {
        String sql = "SELECT * FROM ventas WHERE id_venta = ?";
        try {
            conn = DBConn.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Venta(rs.getInt("id_venta"),
                        rs.getString("cliente"),
                        rs.getString("vendedor"),
                        rs.getDouble("total"));
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
    public List<Venta> findAll() {
        String sql = "SELECT * FROM ventas";
        Venta venta;
        try {
            conn = DBConn.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                venta = new Venta(rs.getInt("id_venta"),
                        rs.getString("cliente"),
                        rs.getString("vendedor"),
                        rs.getDouble("total"));

                ventas.add(venta);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            DBConn.close(rs);
            DBConn.close(ps);
            DBConn.close(conn);
        }
        return ventas;
    }

    @Override
    public List<Venta> findAllConcurrence(String cliente) {
        ventas = new ArrayList<>();
        String sql = "SELECT * FROM ventas WHERE cliente LIKE ?";
        Venta venta;
        try {
            conn = DBConn.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, cliente + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                venta = new Venta(rs.getInt("id_venta"),
                        rs.getString("cliente"),
                        rs.getString("vendedor"),
                        rs.getDouble("total"));

                ventas.add(venta);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            DBConn.close(rs);
            DBConn.close(ps);
            DBConn.close(conn);
        }
        return ventas;
    }

}
