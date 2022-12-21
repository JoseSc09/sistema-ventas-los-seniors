package com.certus.sistemaventas.servicio;

import com.certus.sistemaventas.modelo.entidades.Usuario;
import java.util.List;

public interface UsuarioService {

    public void registrarUsuario(Usuario usuario);

    public void actualizarUsuario(Usuario usuario);

    public void eliminarUsuario(int id);

    public Usuario validarUsuario(String username, String password);

    public Usuario buscarUsuario(String username);
    
    public List<Usuario> listarUsuarios();
}
