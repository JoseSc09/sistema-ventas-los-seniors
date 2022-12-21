package com.certus.sistemaventas.servicio;

import com.certus.sistemaventas.modelo.entidades.Producto;
import java.util.List;

public interface ProductoService {

    public void registrarProducto(Producto producto);

    public void actualizarProducto(Producto producto);

    public void eliminarProducto(int id);

    public Producto buscarProducto(int codigo);

    public List<Producto> listarProductos();
}
