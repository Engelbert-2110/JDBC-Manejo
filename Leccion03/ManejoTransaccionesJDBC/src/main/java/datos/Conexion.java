package datos;

import java.sql.*;

public class Conexion {
    
    //Constantes (URL) mysql, nombre de usuario y contraseña.
    private static final String URL_JDBC = "jdbc:mysql://localhost:3306/mi_empresa?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER_JDBC ="root";
    private static final String PASSWORD_JDBC = "admin"; 
    
    //Conexion a la base de datos, por URL, Usuario y password
    public static Connection getConexion() throws SQLException{
        return DriverManager.getConnection(URL_JDBC, USER_JDBC, PASSWORD_JDBC);
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



