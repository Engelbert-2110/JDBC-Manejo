package test;

import java.sql.*;

public class testMysqlJDBC {
    public static void main(String[] args) {
        //definimos nuestra conexion a la base de datos con una variable url 
        var url = "jdbc:mysql://localhost:3306/mi_empresa?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "root", "admin");
            var sql = "SELECT Id_departamento, nombre FROM Departamento";
            PreparedStatement instruccion = conexion.prepareStatement(sql);  
            ResultSet resultado = instruccion.executeQuery();
            while (resultado.next()) {
                System.out.print("id_departamento:"+ resultado.getInt("iD_Departamento"));
                System.out.print(" Nombre:"+resultado.getString("Nombre"));
                System.out.println("");
            }
            resultado.close();
            instruccion.close();
            conexion.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
            
           
}
