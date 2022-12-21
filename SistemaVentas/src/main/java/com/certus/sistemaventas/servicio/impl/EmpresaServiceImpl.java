package com.certus.sistemaventas.servicio.impl;

import com.certus.sistemaventas.modelo.daos.EmpresaDao;
import com.certus.sistemaventas.modelo.daos.impl.DaoFactory;
import com.certus.sistemaventas.modelo.entidades.Empresa;
import com.certus.sistemaventas.servicio.EmpresaService;
import com.certus.sistemaventas.util.Util;

public class EmpresaServiceImpl implements EmpresaService {

    EmpresaDao dao;

    public EmpresaServiceImpl() {
        dao = DaoFactory.getEmpresaDao(Util.OPC);
    }

    @Override
    public void actualizarDatos(Empresa empresa) {
        dao.update(empresa);
    }

    @Override
    public Empresa buscarDatos() {
        return dao.find();
    }

}
