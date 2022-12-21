package com.certus.sistemaventas.servicio;

import com.certus.sistemaventas.modelo.entidades.DetalleVenta;
import java.util.List;

public interface DetalleVentaService {

    public void registrarDetalleVenta(DetalleVenta detalleVenta);

    public void actualizarDetalleVenta(DetalleVenta detalleVenta);

    public void eliminarDetalleVenta(int id);

    public DetalleVenta buscarDetalleVenta(int idVenta);

    public List<DetalleVenta> listarDetalleVentas();
    
    public List<DetalleVenta> listarUltimaVenta(int idVenta);
}
