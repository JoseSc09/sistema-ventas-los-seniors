package com.certus.sistemaventas.servicio;

import com.certus.sistemaventas.modelo.entidades.Venta;
import java.util.List;

public interface VentaService {

    public void registrarVenta(Venta venta);

    public void actualizarVenta(Venta venta);

    public void eliminarVenta(int id);

    public int obtenerIdUltimoRegistro();

    public Venta buscarVenta(int id);

    public List<Venta> listarVentas();
    
    public List<Venta> listarVentasDe(String cliente);
}
