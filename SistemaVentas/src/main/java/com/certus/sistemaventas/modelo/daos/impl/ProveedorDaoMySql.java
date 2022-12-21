package com.certus.sistemaventas.modelo.daos.impl;

import com.certus.sistemaventas.modelo.daos.ProveedorDao;
import com.certus.sistemaventas.modelo.entidades.Proveedor;
import com.certus.sistemaventas.util.DBConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDaoMySql implements ProveedorDao {

    private final List<Proveedor> proveedores;
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public ProveedorDaoMySql() {
        proveedores = new ArrayList<>();
    }

    @Override
    public void create(Proveedor proveedor) {
        if (find(proveedor.getRuc()) == null) {
            String sql = "INSERT INTO proveedores (ruc,nombre,telefono,direccion,razon_social) VALUES(?,?,?,?,?)";
            try {
                conn = DBConn.getConnection();
                ps = conn.prepareStatement(sql);
                ps.setInt(1, proveedor.getRuc());
                ps.setString(2, proveedor.getNombre());
                ps.setInt(3, proveedor.getTelefono());
                ps.setString(4, proveedor.getDireccion());
                ps.setString(5, proveedor.getRazonSocial());
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            } finally {
                DBConn.close(ps);
                DBConn.close(conn);
            }
        }
    }

    @Override
    public void update(Proveedor proveedor) {
        String sql = "UPDATE proveedores SET ruc = ?, nombre = ?, telefono = ?, direccion = ?, razon_social = ? WHERE id_proveedor = ?";
        try {
            conn = DBConn.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, proveedor.getRuc());
            ps.setString(2, proveedor.getNombre());
            ps.setInt(3, proveedor.getTelefono());
            ps.setString(4, proveedor.getDireccion());
            ps.setString(5, proveedor.getRazonSocial());
            ps.setInt(6, proveedor.getIdProveedor());
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
        String sql = "DELETE FROM proveedores WHERE id_proveedor=?";
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
    public Proveedor find(int ruc) {
        String sql = "SELECT * FROM proveedores WHERE ruc = ?";
        try {
            conn = DBConn.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ruc);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Proveedor(rs.getInt("id_proveedor"),
                        rs.getInt("ruc"),
                        rs.getString("nombre"),
                        rs.getInt("telefono"),
                        rs.getString("direccion"),
                        rs.getString("razon_social"));
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
    public List<Proveedor> findAll() {
        String sql = "SELECT * FROM proveedores";
        Proveedor proveedor;
        try {
            conn = DBConn.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                proveedor = new Proveedor(rs.getInt("id_proveedor"),
                        rs.getInt("ruc"),
                        rs.getString("nombre"),
                        rs.getInt("telefono"),
                        rs.getString("direccion"),
                        rs.getString("razon_social"));
                proveedores.add(proveedor);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            DBConn.close(rs);
            DBConn.close(ps);
            DBConn.close(conn);
        }
        return proveedores;
    }

}
