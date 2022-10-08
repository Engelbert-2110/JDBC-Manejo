package domain;

public class Usuario {
    
    private int idUsuario;
    private String usuario;
    private String password;
    
    //Contructor para eliminar un registro
    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    //Contructor para Mostrar e Ingresar un registro.
    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }
    
    //Contructor para Modificar los registros de la base de datos
    public Usuario(int idUsuario, String usuario, String password) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario = " + idUsuario + ", usuario = " + usuario + ", password = " + password + '}';
    }
    
    
    
    
    
}
