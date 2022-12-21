package com.certus.sistemaventas.servicio.impl;

import com.certus.sistemaventas.modelo.daos.ProductoDao;
import com.certus.sistemaventas.modelo.daos.impl.DaoFactory;
import com.certus.sistemaventas.modelo.entidades.Producto;
import com.certus.sistemaventas.servicio.ProductoService;
import com.certus.sistemaventas.util.Util;
import java.util.List;

public class ProductoServiceImpl implements ProductoService{

    ProductoDao dao;

    public ProductoServiceImpl() {
        dao = DaoFactory.getProductoDao(Util.OPC);
    }

    @Override
    public void registrarProducto(Producto producto) {
        dao.create(producto);
    }

    @Override
    public void actualizarProducto(Producto producto) {
        dao.update(producto);
    }

    @Override
    public void eliminarProducto(int id) {
        dao.delete(id);
    }

    @Override
    public Producto buscarProducto(int codigo) {
        return dao.find(codigo);
    }

    @Override
    public List<Producto> listarProductos() {
        return dao.findAll();
    }
}
