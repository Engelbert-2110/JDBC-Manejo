package datos;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
    
    //Constantes (URL) mysql, nombre de usuario y contraseña.
    private static final String URL_JDBC = "jdbc:mysql://localhost:3306/mi_empresa?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER_JDBC ="root";
    private static final String PASSWORD_JDBC = "admin"; 
    
    
    public static DataSource getDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(URL_JDBC);
        ds.setUsername(USER_JDBC);
        ds.setPassword(PASSWORD_JDBC);
        ds.setInitialSize(5);//Cinco conexiones 
        return ds;
    }
    //POLL de conexiones
    public static Connection getConexion() throws SQLException{
        return getDataSource().getConnection();
    }
    
    //Metodos para cerrar conexion
    public static void close(Connection conex) throws SQLException{
        conex.close();
    }
    //Metodo para cerrar resulSet
    public static void close (ResultSet rs) throws SQLException{
        rs.close();
    }
    //Metodo para cerrar la sentencia (Instruccion)
    public static void close (Statement stmt) throws SQLException{
        stmt.close();
    }
    
     //Metodo para cerrar la sentencia (Instruccion)
    public static void close (PreparedStatement stmt) throws SQLException{
        stmt.close();
    }
}



