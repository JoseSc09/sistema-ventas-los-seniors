package com.certus.sistemaventas.servicio;

import com.certus.sistemaventas.modelo.entidades.Proveedor;
import java.util.List;

public interface ProveedorService {

    public void registrarProveedor(Proveedor proveedor);

    public void actualizarProveedor(Proveedor proveedor);

    public void eliminarProveedor(int id);

    public Proveedor buscarProveedor(int ruc);

    public List<Proveedor> listarProveedores();
}
