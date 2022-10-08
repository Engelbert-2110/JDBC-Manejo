package test;

import datos.EmpleadoDAO;
import domain.Empleado;
import java.io.*;
import java.util.*;

public class testManejoJDBC {

    public static void main(String[] args) {
        EmpleadoDAO empleadodao = new EmpleadoDAO();
        
        //Eliminar Registro de la Base de Datos
        Empleado eliminarEmpleado = new Empleado(6);
        empleadodao.eliminar(eliminarEmpleado);
        
//        //Modificar el registro en la Base de Datos.
//        Empleado modificarEmpleado = new Empleado(9, "Alexander", "Emanuel", "Bravo", "2021-09-25", 1);
//        empleadodao.actualizar(modificarEmpleado);

        // --Clase---Variable--:--Var..Lista----
        /*for (Empleado empleado : empleados) {
            System.out.println("empleado = " + empleado); 
        }*/
        
        //Insertar un nuevo registro a la base de datos
//        Empleado empleadoNuevo = new Empleado("Elvis", "Lizandro", "Aguilar", "2000/02/28", 3);
//        empleadodao.insertar(empleadoNuevo);

       List<Empleado> empleados = empleadodao.seleccionar();
        for (int i = 0; i < empleados.size(); i++) {
            System.out.println("Empleado = " + empleados.get(i));
        }
      

    }
}
