package com.certus.sistemaventas.servicio;

import com.certus.sistemaventas.modelo.entidades.Cliente;
import java.util.List;

public interface ClienteService {

    public void registrarCliente(Cliente cliente);

    public void actualizarCliente(Cliente cliente);

    public void eliminarCliente(int id);

    public Cliente buscarCliente(int dni);
    
    public Cliente buscarCliente(String nombre);

    public List<Cliente> listarClientes();
}
