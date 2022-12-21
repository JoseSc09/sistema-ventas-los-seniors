package com.certus.sistemaventas.servicio.impl;

import com.certus.sistemaventas.modelo.daos.VentaDao;
import com.certus.sistemaventas.modelo.daos.impl.DaoFactory;
import com.certus.sistemaventas.modelo.entidades.Venta;
import com.certus.sistemaventas.servicio.VentaService;
import com.certus.sistemaventas.util.Util;
import java.util.List;

public class VentaServiceImpl implements VentaService {

    VentaDao dao;

    public VentaServiceImpl() {
        dao = DaoFactory.getVentaDao(Util.OPC);
    }

    @Override
    public void registrarVenta(Venta venta) {
        dao.create(venta);
    }

    @Override
    public void actualizarVenta(Venta venta) {
        dao.update(venta);
    }

    @Override
    public void eliminarVenta(int id) {
        dao.delete(id);
    }

    @Override
    public int obtenerIdUltimoRegistro() {
        return dao.lastId();
    }

    @Override
    public Venta buscarVenta(int id) {
        return dao.find(id);
    }

    @Override
    public List<Venta> listarVentas() {
        return dao.findAll();
    }

    @Override
    public List<Venta> listarVentasDe(String cliente) {
        return dao.findAllConcurrence(cliente);
    }

}
