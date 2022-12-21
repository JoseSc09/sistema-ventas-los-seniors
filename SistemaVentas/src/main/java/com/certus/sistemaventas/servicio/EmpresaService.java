package com.certus.sistemaventas.servicio;

import com.certus.sistemaventas.modelo.entidades.Empresa;

public interface EmpresaService {

    public void actualizarDatos(Empresa empresa);

    public Empresa buscarDatos();
}
