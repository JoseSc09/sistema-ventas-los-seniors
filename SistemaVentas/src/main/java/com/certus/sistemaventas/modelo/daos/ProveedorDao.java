package com.certus.sistemaventas.modelo.daos;

import com.certus.sistemaventas.modelo.entidades.Proveedor;
import java.util.List;

public interface ProveedorDao {

    public void create(Proveedor proveedor);

    public void update(Proveedor proveedor);

    public void delete(int id);

    public Proveedor find(int ruc);

    public List<Proveedor> findAll();
}
