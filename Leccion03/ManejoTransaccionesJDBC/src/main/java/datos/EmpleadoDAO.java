package datos;

import static datos.Conexion.*;
import domain.Empleado;
import java.io.*;
import java.sql.*;
import java.util.*;

public class EmpleadoDAO {

    //Creamos el atributo tipo CONNECTION para el uso de Transacciones con JDBC
    private Connection ConexionTransaccional;

    //Crear la sentencia para obtener la informacion de la base de datos(Mysql)
    private static final String SQL_SELECT = "SELECT ID_Empleado, Primer_Nombre, Segundo_Nombre, Apellido_Paterno, Fecha_Nacimiento, ID_Departamento FROM Empleado";
    private static final String SQL_INSERT = "INSERT INTO Empleado (Primer_Nombre, Segundo_Nombre, Apellido_Paterno, Fecha_Nacimiento, ID_Departamento)VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE Empleado SET Primer_Nombre = ?, Segundo_Nombre = ?, Apellido_Paterno = ?, Fecha_Nacimiento = ?, ID_Departamento = ? WHERE (ID_Empleado =?) ";
    private static final String SQL_DELETE = "DELETE FROM Empleado WHERE (ID_Empleado = ?)";

    public EmpleadoDAO() {
    }

    public EmpleadoDAO(Connection ConexionTransaccional) {
        this.ConexionTransaccional = ConexionTransaccional;
    }

    public List<Empleado> seleccionar() throws SQLException {
        //Conexion.
        Connection conex = null;
        //Instrucción o Sentencia.
        PreparedStatement stmt = null;
        //Resultado de la sentencia
        ResultSet rs = null;
        //Objeto de tipo >Empelado.
        Empleado empleado = null;
        //Lista de arreglos, almacenar varios objetos de tipo empleado.
        List<Empleado> empleados = new ArrayList<>();

        try {
            conex = this.ConexionTransaccional != null ? this.ConexionTransaccional : Conexion.getConexion();
            //Usamos la sentencia para acceder a los datos de mi base de datos.
            stmt = conex.prepareStatement(SQL_SELECT);
            //Muestra los datos de la tabla que se mando a llamar en la sentencia
            rs = stmt.executeQuery();
            //Iteramos toda la tabla que se mando a llamar, para eso se usa NEXT()
            while (rs.next()) {
                int idEmpleado = rs.getInt("ID_Empleado");
                String primerNombre = rs.getString("Primer_Nombre");
                String segundoNombre = rs.getString("Segundo_Nombre");
                String primerApellido = rs.getString("Apellido_Paterno");
                String fechaNacimiento = rs.getString("Fecha_Nacimiento");
                int idDepartamento = rs.getInt("iD_Departamento");
                //Creamos los objeto de tipo Empleados cada vez que se repita el ciclo while
                empleado = new Empleado(idEmpleado, primerNombre, segundoNombre, primerApellido, fechaNacimiento, idDepartamento);
                //Almacenamos cada objeto en la Lista de Arreglos de Empleados
                empleados.add(empleado);
            }
        } finally {
            try {
                //Cerramos cada una de las Conexiones e instrucciones.
                Conexion.close(rs);
                Conexion.close(stmt);
                if (this.ConexionTransaccional == null) {
                    Conexion.close(conex);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return empleados;
    }

    public int insertar(Empleado empleado) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.ConexionTransaccional != null ? this.ConexionTransaccional : getConexion();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, empleado.getPrimerNombre());
            stmt.setString(2, empleado.getSegundoNombre());
            stmt.setString(3, empleado.getPrimerApellido());
            stmt.setString(4, empleado.getFechaNacimiento());
            stmt.setInt(5, empleado.getId_Departamento());

            registros = stmt.executeUpdate();

        } finally {
            try {
                Conexion.close(stmt);
                if (this.ConexionTransaccional == null) {
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int actualizar(Empleado empleado) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.ConexionTransaccional != null ? this.ConexionTransaccional : getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, empleado.getPrimerNombre());
            stmt.setString(2, empleado.getSegundoNombre());
            stmt.setString(3, empleado.getPrimerApellido());
            stmt.setString(4, empleado.getFechaNacimiento());
            stmt.setInt(5, empleado.getId_Departamento());
            stmt.setInt(6, empleado.getIdEmplado());

            registros = stmt.executeUpdate();
            System.out.println("Registros actualizados: "+registros);

        } finally {
            try {
                close(stmt);
                if (this.ConexionTransaccional == null) {
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return registros;
    }

    public int eliminar(Empleado empleado) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            conn = this.ConexionTransaccional != null ? this.ConexionTransaccional : getConexion();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, empleado.getIdEmplado());

            registro = stmt.executeUpdate();

        } finally {
            try {
                close(stmt);
                if (this.ConexionTransaccional == null) {
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registro;
    }

    /*public void mostrar (){
        Empleado empleado = null;
        var archivo1 = "Testo";
        
        
        try {
            File archivo = new File(archivo1);
            PrintWriter escribir = new PrintWriter( new FileWriter(archivo));
            Connection conex = Conexion.getConexion();
            PreparedStatement pstmt = conex.prepareStatement(SQL_SELECT);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                int idEmpleado = rs.getInt("ID_Empleado");
                String primerNombre = rs.getString("Primer_Nombre");
                String segundoNombre = rs.getString("Segundo_Nombre");
                String primerApellido = rs.getString("Apellido_Paterno");
                String fechaNacimiento = rs.getString("Fecha_Nacimiento");
                int idDepartamento = rs.getInt("iD_Departamento");
                
                empleado = new Empleado(idEmpleado, primerNombre, segundoNombre, primerApellido, fechaNacimiento, idDepartamento);
                
                escribir.println(empleado);
                //System.out.println("Empleado = " + empleado);
            } 
            escribir.close();
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conex);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) { 
            ex.printStackTrace(System.out);
        }
       
        
    }*/
}
