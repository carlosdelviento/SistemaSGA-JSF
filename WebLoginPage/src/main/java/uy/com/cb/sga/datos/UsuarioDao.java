package uy.com.cb.sga.datos;

import java.util.List;
import uy.com.cb.sga.domain.Usuario;

public interface UsuarioDao {
    public List<Usuario> findAllUsuarios();
    
    public Usuario findUsuarioById(Usuario usuario);
    
    //public Usuario findUsuarioByUsername(Usuario usuario);
    
    public Usuario findUsuarioByUsername(String username);
    
    public void insertUsuario(Usuario usuario);
    
    public void updateUsuario(Usuario usuario);
    
    public void deleteUsuario(Usuario usuario);

}
