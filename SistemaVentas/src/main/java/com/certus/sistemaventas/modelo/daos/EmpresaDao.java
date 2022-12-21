package com.certus.sistemaventas.modelo.daos;

import com.certus.sistemaventas.modelo.entidades.Empresa;

public interface EmpresaDao {

    public void update(Empresa empresa);

    public Empresa find();
    
}
