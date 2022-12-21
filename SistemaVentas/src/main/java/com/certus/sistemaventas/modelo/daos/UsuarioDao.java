package com.certus.sistemaventas.modelo.daos;

import com.certus.sistemaventas.modelo.entidades.Usuario;
import java.util.List;

public interface UsuarioDao {

    public void create(Usuario usuario);

    public void update(Usuario usuario);

    public void delete(int id);

    public Usuario find(String username,String password);

    public Usuario find(String username);
    
    public List<Usuario> findAll();
}
