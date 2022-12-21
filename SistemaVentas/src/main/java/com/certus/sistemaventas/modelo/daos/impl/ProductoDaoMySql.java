package com.certus.sistemaventas.modelo.daos.impl;

import com.certus.sistemaventas.modelo.daos.ProductoDao;
import com.certus.sistemaventas.modelo.entidades.Producto;
import com.certus.sistemaventas.util.DBConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDaoMySql implements ProductoDao {

    private final List<Producto> productos;
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public ProductoDaoMySql() {
        productos = new ArrayList<>();
    }

    @Override
    public void create(Producto producto) {
        if (find(producto.getCodigo()) == null) {
            String sql = "INSERT INTO productos (codigo,nombre,proveedor,stock,precio) VALUES(?,?,?,?,?)";
            try {
                conn = DBConn.getConnection();
                ps = conn.prepareStatement(sql);
                ps.setInt(1, producto.getCodigo());
                ps.setString(2, producto.getNombre());
                ps.setString(3, producto.getProveedor());
                ps.setInt(4, producto.getStock());
                ps.setDouble(5, producto.getPrecio());
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
    public void update(Producto producto) {
        String sql = "UPDATE productos SET codigo = ?, nombre = ?, proveedor = ?, stock = ?, precio = ? WHERE id_producto = ?";
        try {
            conn = DBConn.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getProveedor());
            ps.setInt(4, producto.getStock());
            ps.setDouble(5, producto.getPrecio());
            ps.setInt(6, producto.getIdProducto());
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
        String sql = "DELETE FROM productos WHERE id_producto=?";
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
    public Producto find(int codigo) {
        String sql = "SELECT * FROM productos WHERE codigo = ?";
        try {
            conn = DBConn.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Producto(rs.getInt("id_producto"),
                        rs.getInt("codigo"),
                        rs.getString("nombre"),
                        rs.getString("proveedor"),
                        rs.getInt("stock"),
                        rs.getDouble("precio"));
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
    public List<Producto> findAll() {
        String sql = "SELECT * FROM productos";
        Producto producto;
        try {
            conn = DBConn.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                producto = new Producto(rs.getInt("id_producto"),
                        rs.getInt("codigo"),
                        rs.getString("nombre"),
                        rs.getString("proveedor"),
                        rs.getInt("stock"),
                        rs.getDouble("precio"));
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            DBConn.close(rs);
            DBConn.close(ps);
            DBConn.close(conn);
        }
        return productos;
    }

}
