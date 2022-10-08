package datos;

import domain.EmpleadoDTO;
import java.sql.SQLException;
import java.util.List;

public interface EmpleadoDao {
    
    public List<EmpleadoDTO> select() throws SQLException;
    
    public int insert(EmpleadoDTO empleado) throws SQLException;
    
    public int update(EmpleadoDTO empleado) throws SQLException;
    
    public int delete(EmpleadoDTO empleado) throws SQLException;
    
    
}
