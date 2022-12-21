package com.certus.sistemaventas.servicio.impl;

import com.certus.sistemaventas.modelo.daos.ProveedorDao;
import com.certus.sistemaventas.modelo.daos.impl.DaoFactory;
import com.certus.sistemaventas.modelo.entidades.Proveedor;
import com.certus.sistemaventas.servicio.ProveedorService;
import com.certus.sistemaventas.util.Util;
import java.util.List;

public class ProveedorServiceImpl implements ProveedorService{
    ProveedorDao dao;

    public ProveedorServiceImpl() {
        dao = DaoFactory.getProveedorDao(Util.OPC);
    }

    @Override
    public void registrarProveedor(Proveedor proveedor) {
        dao.create(proveedor);
    }

    @Override
    public void actualizarProveedor(Proveedor proveedor) {
        dao.update(proveedor);
    }

    @Override
    public void eliminarProveedor(int id) {
        dao.delete(id);
    }

    @Override
    public Proveedor buscarProveedor(int ruc) {
        return dao.find(ruc);
    }

    @Override
    public List<Proveedor> listarProveedores() {
        return dao.findAll();
    }
    
    
}
