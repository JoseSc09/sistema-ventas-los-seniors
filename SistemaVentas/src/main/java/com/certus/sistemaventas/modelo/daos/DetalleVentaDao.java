package com.certus.sistemaventas.modelo.daos;

import com.certus.sistemaventas.modelo.entidades.DetalleVenta;
import java.util.List;

public interface DetalleVentaDao {

    public void create(DetalleVenta detalleVenta);

    public void update(DetalleVenta detalleVenta);

    public void delete(int id);

    public DetalleVenta find(int idVenta);

    public List<DetalleVenta> findAll();
    
    public List<DetalleVenta> findAll(int idVenta);
}
