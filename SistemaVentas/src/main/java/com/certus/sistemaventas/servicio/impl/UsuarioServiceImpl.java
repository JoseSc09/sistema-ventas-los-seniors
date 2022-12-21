package com.certus.sistemaventas.servicio.impl;

import com.certus.sistemaventas.modelo.daos.UsuarioDao;
import com.certus.sistemaventas.modelo.daos.impl.DaoFactory;
import com.certus.sistemaventas.modelo.entidades.Usuario;
import com.certus.sistemaventas.servicio.UsuarioService;
import com.certus.sistemaventas.util.Util;
import java.util.List;

public class UsuarioServiceImpl implements UsuarioService {

    UsuarioDao dao;

    public UsuarioServiceImpl() {
        dao = DaoFactory.getUsuarioDao(Util.OPC);
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        dao.create(usuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        dao.update(usuario);
    }

    @Override
    public void eliminarUsuario(int id) {
        dao.delete(id);
    }

    @Override
    public Usuario validarUsuario(String username, String password) {
        return dao.find(username, password);
    }

    @Override
    public Usuario buscarUsuario(String username) {
        return dao.find(username);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return dao.findAll();
    }

}
