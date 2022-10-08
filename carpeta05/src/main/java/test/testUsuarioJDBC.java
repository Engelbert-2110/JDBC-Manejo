package test;

import datos.*;
import domain.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class testUsuarioJDBC {
    public static void main(String[] args) {
      
        Connection conexion = null;
        try {
            conexion = Conexion.getConexion();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            
            UsuarioDao usuariodao = new UsuarioDaoJDBC(conexion);
            
            UsuarioDTO nuevoUsuario = new UsuarioDTO();
            nuevoUsuario.setUsuario("Engelbert");
            nuevoUsuario.setPassword("123engel");
            
            usuariodao.ingresar(nuevoUsuario);
            
            List<UsuarioDTO> usuarios = usuariodao.mostrar();
            
            for (UsuarioDTO usuario : usuarios) {
                System.out.println("usuarioDTO = " + usuario);
            }
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Se muestra rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
        
    }
}
