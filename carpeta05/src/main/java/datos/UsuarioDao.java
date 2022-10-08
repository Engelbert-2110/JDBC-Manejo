package datos;

import domain.UsuarioDTO;
import java.sql.SQLException;
import java.util.List;

public interface UsuarioDao {
    public List<UsuarioDTO> mostrar() throws SQLException;
    
    public int ingresar(UsuarioDTO usuario) throws SQLException;
    
    public int modificar(UsuarioDTO usuario) throws SQLException;
    
    public int eliminar(UsuarioDTO usuario) throws SQLException;
}
