package com.certus.sistemaventas.modelo.entidades;

public class Venta {
    private int idVenta;
    private String cliente;
    private String vendedor;
    private double pagoTotal;

    public Venta() {
    }

    public Venta(String cliente, String vendedor, double pagoTotal) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.pagoTotal = pagoTotal;
    }

    public Venta(int idVenta, String cliente, String vendedor, double pagoTotal) {
        this.idVenta = idVenta;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.pagoTotal = pagoTotal;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public double getPagoTotal() {
        return pagoTotal;
    }

    public void setPagoTotal(double pagoTotal) {
        this.pagoTotal = pagoTotal;
    }

}
