package com.certus.sistemaventas.modelo.daos;

import com.certus.sistemaventas.modelo.entidades.Producto;
import java.util.List;

public interface ProductoDao {

    public void create(Producto producto);

    public void update(Producto producto);

    public void delete(int id);

    public Producto find(int codigo);

    public List<Producto> findAll();
}
