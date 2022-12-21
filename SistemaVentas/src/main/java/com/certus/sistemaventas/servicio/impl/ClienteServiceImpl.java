package com.certus.sistemaventas.servicio.impl;

import com.certus.sistemaventas.modelo.daos.ClienteDao;
import com.certus.sistemaventas.modelo.daos.impl.DaoFactory;
import com.certus.sistemaventas.modelo.entidades.Cliente;
import com.certus.sistemaventas.servicio.ClienteService;
import com.certus.sistemaventas.util.Util;
import java.util.List;

public class ClienteServiceImpl implements ClienteService{
    ClienteDao dao;

    public ClienteServiceImpl() {
        dao = DaoFactory.getClienteDao(Util.OPC);
    }

    @Override
    public void registrarCliente(Cliente cliente) {
        dao.create(cliente);
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        dao.update(cliente);
    }

    @Override
    public void eliminarCliente(int id) {
        dao.delete(id);
    }

    @Override
    public Cliente buscarCliente(int dni) {
        return dao.find(dni);
    }

    @Override
    public List<Cliente> listarClientes() {
        return dao.findAll();
    }

    @Override
    public Cliente buscarCliente(String nombre) {
        return dao.find(nombre);
    }
    
    
}
