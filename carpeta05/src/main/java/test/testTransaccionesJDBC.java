package test;

import datos.*;
import domain.*;
import java.sql.*;
import java.util.*;

public class testTransaccionesJDBC {

    public static void main(String[] args) {
        
        Connection conexion = null;
        try {
             conexion = Conexion.getConexion();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
       //Clase interface   variable        Clase Object
            EmpleadoDao empleadodao = new EmpleadoDaoJDBC(conexion);
            
            //Listamos los registros de la base de datos.
            List<EmpleadoDTO> empleados = empleadodao.select();
            
            for (EmpleadoDTO empleado : empleados) {
                System.out.println("EmpeladoDTO = " + empleado);
            }
            
            //conexion.commit();
            //System.out.println("Se ha echo el commit de transaccion");

        
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Se muestra Rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }          
        }

    }
}
