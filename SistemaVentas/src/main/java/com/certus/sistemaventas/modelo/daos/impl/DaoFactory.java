package com.certus.sistemaventas.modelo.daos.impl;

import com.certus.sistemaventas.modelo.daos.*;

public class DaoFactory {

    public static final int MYSQL = 1;

    public static UsuarioDao getUsuarioDao(int opc) {
        return switch (opc) {
            case MYSQL ->
                new UsuarioDaoMySql();
            default ->
                null;
        };
    }

    public static ClienteDao getClienteDao(int opc) {
        return switch (opc) {
            case MYSQL ->
                new ClienteDaoMySql();
            default ->
                null;
        };
    }

    public static ProveedorDao getProveedorDao(int op) {
        return switch (op) {
            case MYSQL ->
                new ProveedorDaoMySql();
            default ->
                null;
        };
    }

    public static ProductoDao getProductoDao(int op) {
        return switch (op) {
            case MYSQL ->
                new ProductoDaoMySql();
            default ->
                null;
        };
    }

    public static VentaDao getVentaDao(int op) {
        return switch (op) {
            case MYSQL ->
                new VentaDaoMySql();
            default ->
                null;
        };
    }

    public static DetalleVentaDao getDetalleVentaDao(int op) {
        return switch (op) {
            case MYSQL ->
                new DetalleVentaDaoMySql();
            default ->
                null;
        };
    }

    public static EmpresaDao getEmpresaDao(int op) {
        return switch (op) {
            case MYSQL ->
                new EmpresaDaoMySql();
            default ->
                null;
        };
    }
}
