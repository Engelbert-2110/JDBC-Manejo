package test;

import datos.*;
import domain.*;
import java.sql.*;
import java.util.*;

public class testManejoJDBC {

    public static void main(String[] args) {
        
        Connection conexion = null;
        try {
             conexion = Conexion.getConexion();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            
            EmpleadoDAO empleadodao = new EmpleadoDAO(conexion);
            //Ingresamos empleado
//            Empleado nuevoEmpleado = new Empleado();
//            nuevoEmpleado.setPrimerNombre("Engelbert");
//            nuevoEmpleado.setSegundoNombre("Emanuel");
//            nuevoEmpleado.setPrimerApellido("Estrada");
//            nuevoEmpleado.setFechaNacimiento("1999-08-02");
//            nuevoEmpleado.setId_Departamento(3);
//            
//            empleadodao.insertar(nuevoEmpleado);
            

            //Modifiacamos un registro de emppleados.
            Empleado cambioEmpleado = new Empleado();
            cambioEmpleado.setIdEmplado(9);
            cambioEmpleado.setPrimerNombre("Alexander");
            cambioEmpleado.setSegundoNombre("David");
            cambioEmpleado.setPrimerApellido("Bravoo");
            cambioEmpleado.setFechaNacimiento("2020-09-21");
            cambioEmpleado.setId_Departamento(2);
           
            empleadodao.actualizar(cambioEmpleado);
            
            //Listamos los registros de la base de datos.
            List<Empleado> mostrarempelados = new ArrayList<>();
            mostrarempelados = empleadodao.seleccionar();
            for(Empleado empleado : mostrarempelados){
                System.out.println("empleado = " + empleado);
            }
                   
            conexion.commit();
            System.out.println("Se ha echo el commit de transaccion");

        
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
