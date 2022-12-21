package com.certus.sistemaventas.modelo.entidades;

public class DetalleVenta {

    private int idDetalleVenta;
    private int codProducto;
    private int cantidad;
    private double precio;
    private int idVenta;

    public DetalleVenta() {
    }

    public DetalleVenta(int codProducto, int cantidad, double precio, int idVenta) {
        this.codProducto = codProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.idVenta = idVenta;
    }

    public DetalleVenta(int idDetalleVenta, int codProducto, int cantidad, double precio, int idVenta) {
        this.idDetalleVenta = idDetalleVenta;
        this.codProducto = codProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.idVenta = idVenta;
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

}
