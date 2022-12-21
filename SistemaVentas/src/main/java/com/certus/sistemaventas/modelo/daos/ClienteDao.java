package com.certus.sistemaventas.modelo.daos;

import com.certus.sistemaventas.modelo.entidades.Cliente;
import java.util.List;

public interface ClienteDao {

    public void create(Cliente cliente);

    public void update(Cliente cliente);

    public void delete(int id);

    public Cliente find(int dni);
    
    public Cliente find(String nombre);

    public List<Cliente> findAll();
}
