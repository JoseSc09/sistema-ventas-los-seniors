package com.certus.sistemaventas.modelo.daos.impl;

import com.certus.sistemaventas.modelo.daos.UsuarioDao;
import com.certus.sistemaventas.modelo.entidades.Usuario;
import com.certus.sistemaventas.util.DBConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoMySql implements UsuarioDao {

    private List<Usuario> usuarios;
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public UsuarioDaoMySql() {
        usuarios = new ArrayList<>();
    }

    @Override
    public void create(Usuario usuario) {
        String sql = "INSERT INTO usuarios (username,nombre,apellido,email,password,rol) VALUES(?,?,?,?,?,?)";
        try {
            conn = DBConn.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getApellido());
            ps.setString(4, usuario.getEmail());
            ps.setString(5, usuario.getPassword());
            ps.setString(6, usuario.getRol());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            DBConn.close(ps);
            DBConn.close(conn);
        }
    }

    @Override
    public void update(Usuario usuario) {
        String sql = "UPDATE usuarios SET username = ?, nombre = ?, apellido = ?, email = ?,password=? ,rol = ?WHERE id_usuario = ?";
        try {
            conn = DBConn.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getApellido());
            ps.setString(4, usuario.getEmail());
            ps.setString(5, usuario.getPassword());
            ps.setString(6, usuario.getRol());
            ps.setInt(7, usuario.getIdUsuario());
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
        String sql = "DELETE FROM usuarios WHERE id_usuario=?";
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
    public Usuario find(String username, String password) {
        Usuario user = null;
        String sql = "SELECT * FROM usuarios WHERE username=? AND password=?";
        try {
            conn = DBConn.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Usuario(rs.getInt("id_usuario"),
                        rs.getString("username"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("rol"));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            DBConn.close(rs);
            DBConn.close(ps);
            DBConn.close(conn);
        }
        return user;
    }

    @Override
    public Usuario find(String username) {
        Usuario user = null;
        String sql = "SELECT * FROM usuarios WHERE username=?";
        try {
            conn = DBConn.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Usuario(rs.getInt("id_usuario"),
                        rs.getString("username"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("rol"));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            DBConn.close(rs);
            DBConn.close(ps);
            DBConn.close(conn);
        }
        return user;
    }

    @Override
    public List<Usuario> findAll() {
        String sql = "SELECT * FROM usuarios";
        Usuario cliente;
        try {
            conn = DBConn.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cliente = new Usuario(rs.getInt("id_usuario"),
                        rs.getString("username"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("rol"));
                usuarios.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            DBConn.close(rs);
            DBConn.close(ps);
            DBConn.close(conn);
        }
        return usuarios;
    }

}
