package test;

import datos.UsuarioDAO;
import domain.Usuario;
import java.util.*;

public class testUsuarioJDBC {
    public static void main(String[] args) {
        
        UsuarioDAO usuariodao = new UsuarioDAO();
        
        //Modificar Registro en Base de Datos
        Usuario modificarUsuario = new Usuario(2, "Alejandra", "Lamanca69");
        usuariodao.modificar(modificarUsuario);
        
        //Ingresar registro a la Base de Datos
//        Usuario ingresarUsuario = new Usuario("Antonio", "La Loca36");
//        usuariodao.ingresar(ingresarUsuario);

        //Eliminar Registro de BD
//        Usuario eliminarUsuario = new Usuario(3);
//        usuariodao.eliminar(eliminarUsuario);
        
        
        //Imprimir los Registros de la Base de Datos
        List<Usuario> usuarios = new ArrayList<>();
        usuarios = usuariodao.mostrar();
        for (Usuario usuario : usuarios) {
            System.out.println("usuario = " + usuario);
        }
    }
}
