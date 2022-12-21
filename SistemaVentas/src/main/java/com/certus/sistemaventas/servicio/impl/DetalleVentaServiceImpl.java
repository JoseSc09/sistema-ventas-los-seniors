package com.certus.sistemaventas.servicio.impl;

import com.certus.sistemaventas.modelo.daos.DetalleVentaDao;
import com.certus.sistemaventas.modelo.daos.impl.DaoFactory;
import com.certus.sistemaventas.modelo.entidades.DetalleVenta;
import com.certus.sistemaventas.servicio.DetalleVentaService;
import com.certus.sistemaventas.util.Util;
import java.util.List;

public class DetalleVentaServiceImpl implements DetalleVentaService{
    DetalleVentaDao dao;

    public DetalleVentaServiceImpl() {
        dao = DaoFactory.getDetalleVentaDao(Util.OPC);
    }

    @Override
    public void registrarDetalleVenta(DetalleVenta detalleVenta) {
        dao.create(detalleVenta);
    }

    @Override
    public void actualizarDetalleVenta(DetalleVenta detalleVenta) {
        dao.update(detalleVenta);
    }

    @Override
    public void eliminarDetalleVenta(int id) {
        dao.delete(id);
    }

    @Override
    public DetalleVenta buscarDetalleVenta(int idVenta) {
        return dao.find(idVenta);
    }

    @Override
    public List<DetalleVenta> listarDetalleVentas() {
        return dao.findAll();
    }

    @Override
    public List<DetalleVenta> listarUltimaVenta(int idVenta) {
        return dao.findAll(idVenta);
    }
    
    
    
}
