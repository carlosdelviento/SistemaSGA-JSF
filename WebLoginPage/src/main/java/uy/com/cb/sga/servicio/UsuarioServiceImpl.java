package uy.com.cb.sga.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import uy.com.cb.sga.datos.UsuarioDao;
import uy.com.cb.sga.domain.Usuario;

@Stateless
public abstract class UsuarioServiceImpl implements UsuarioServiceRemote, UsuarioService{

    @Inject
    private UsuarioDao usuarioDao;
    
    @Override
    public List<Usuario> listarUsuarios() {
       return usuarioDao.findAllUsuarios();
    }

    @Override
    public Usuario encontrarUsuarioPorId(Usuario usuario) {
        return usuarioDao.findUsuarioById(usuario);
    }

    
    /*@Override
    public Usuario encontrarUsuarioPorUsername(Usuario usuario) {
        return usuarioDao.findUsuarioByUsername(usuario);
    }*/
    
    public Usuario encontrarUsuarioPorUsername(String username) {
        return usuarioDao.findUsuarioByUsername(username);
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        usuarioDao.insertUsuario(usuario);
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
        usuarioDao.updateUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuarioDao.deleteUsuario(usuario);
    }
    
}
