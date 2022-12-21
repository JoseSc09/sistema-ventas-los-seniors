package com.certus.sistemaventas.modelo.daos;

import com.certus.sistemaventas.modelo.entidades.Venta;
import java.util.List;

public interface VentaDao {

    public void create(Venta venta);

    public void update(Venta venta);

    public void delete(int id);

    public int lastId();
    
    public Venta find(int id);

    public List<Venta> findAll();
    
    public List<Venta> findAllConcurrence(String cliente);
}
