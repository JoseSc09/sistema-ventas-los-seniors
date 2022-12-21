package com.certus.sistemaventas.modelo.daos.impl;

import com.certus.sistemaventas.modelo.daos.EmpresaDao;
import com.certus.sistemaventas.modelo.entidades.Empresa;
import com.certus.sistemaventas.util.DBConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpresaDaoMySql implements EmpresaDao {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public EmpresaDaoMySql() {
    }

    @Override
    public void update(Empresa empresa) {
        String sql = "UPDATE empresa SET ruc = ?, nombre = ?, telefono = ?, direccion = ?,razon_social = ? WHERE id_empresa = ?";
        try {
            conn = DBConn.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, empresa.getRuc());
            ps.setString(2, empresa.getNombre());
            ps.setInt(3, empresa.getTelefono());
            ps.setString(4, empresa.getDireccion());
            ps.setString(5, empresa.getRazonSocial());
            ps.setInt(6, empresa.getIdEmpresa());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            DBConn.close(ps);
            DBConn.close(conn);
        }
    }

    @Override
    public Empresa find() {
        String sql = "SELECT * FROM empresa";
        Empresa empresa = null;
        try {
            conn = DBConn.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                empresa = new Empresa(rs.getInt("id_empresa"),
                        rs.getInt("ruc"),
                        rs.getString("nombre"),
                        rs.getInt("telefono"),
                        rs.getString("direccion"),
                        rs.getString("razon_social"));
            }
            return empresa;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            DBConn.close(rs);
            DBConn.close(ps);
            DBConn.close(conn);
        }
        return empresa;
    }
}
