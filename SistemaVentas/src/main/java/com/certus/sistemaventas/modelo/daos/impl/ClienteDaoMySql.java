package com.certus.sistemaventas.modelo.daos.impl;

import com.certus.sistemaventas.modelo.daos.ClienteDao;
import com.certus.sistemaventas.modelo.entidades.Cliente;
import com.certus.sistemaventas.util.DBConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoMySql implements ClienteDao {

    private final List<Cliente> clientes;
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public ClienteDaoMySql() {
        clientes = new ArrayList<>();
    }

    @Override
    public void create(Cliente cliente) {
        if (find(cliente.getDni()) == null) {
            String sql = "INSERT INTO clientes (dni,nombre,telefono,direccion) VALUES(?,?,?,?)";
            try {
                conn = DBConn.getConnection();
                ps = conn.prepareStatement(sql);
                ps.setInt(1, cliente.getDni());
                ps.setString(2, cliente.getNombre());
                ps.setInt(3, cliente.getTelefono());
                ps.setString(4, cliente.getDireccion());
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
    public void update(Cliente cliente) {
        String sql = "UPDATE clientes SET dni = ?, nombre = ?, telefono = ?, direccion = ? WHERE id_cliente = ?";
        try {
            conn = DBConn.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cliente.getDni());
            ps.setString(2, cliente.getNombre());
            ps.setInt(3, cliente.getTelefono());
            ps.setString(4, cliente.getDireccion());
            ps.setInt(5, cliente.getIdCliente());
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
        String sql = "DELETE FROM clientes WHERE id_cliente=?";
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
    public Cliente find(int dni) {
        String sql = "SELECT * FROM clientes WHERE dni = ?";
        try {
            conn = DBConn.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, dni);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Cliente(rs.getInt("id_cliente"),
                        rs.getInt("dni"),
                        rs.getString("nombre"),
                        rs.getInt("telefono"),
                        rs.getString("direccion"));
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
    public List<Cliente> findAll() {
        String sql = "SELECT * FROM clientes";
        Cliente cliente;
        try {
            conn = DBConn.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cliente = new Cliente(rs.getInt("id_cliente"),
                        rs.getInt("dni"),
                        rs.getString("nombre"),
                        rs.getInt("telefono"),
                        rs.getString("direccion")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            DBConn.close(rs);
            DBConn.close(ps);
            DBConn.close(conn);
        }
        return clientes;
    }

    @Override
    public Cliente find(String nombre) {
        String sql = "SELECT * FROM clientes WHERE nombre = ?";
        try {
            conn = DBConn.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Cliente(rs.getInt("id_cliente"),
                        rs.getInt("dni"),
                        rs.getString("nombre"),
                        rs.getInt("telefono"),
                        rs.getString("direccion"));
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

}
