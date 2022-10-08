package domain;

public class Empleado {
    private int idEmplado;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String fechaNacimiento;
    private int id_Departamento;

    public Empleado() {
    }
    
    //Elimiar un registro en la BD, se necesita el ID
    public Empleado(int idEmplado) {
        this.idEmplado = idEmplado;
    }
    
    
    //Insertar un nuevo registro en la BD con la primaru key en aumento, ID_Persona.
    public Empleado(String primerNombre, String segundoNombre, String primerApellido, String fechaNacimiento, int id_Departamento) {
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.id_Departamento = id_Departamento;
    }

    //modificar un registro  en BD 
    public Empleado(int idEmplado, String primerNombre, String segundoNombre, String primerApellido, String fechaNacimiento, int id_Departamento) {
        this.idEmplado = idEmplado; 
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.id_Departamento = id_Departamento;
    }

    public int getIdEmplado() {
        return idEmplado;
    }

    public void setIdEmplado(int idEmplado) {
        this.idEmplado = idEmplado;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getId_Departamento() {
        return id_Departamento;
    }

    public void setId_Departamento(int id_Departamento) {
        this.id_Departamento = id_Departamento;
    }

    @Override
    public String toString() {
        return "Empleado{" + "idEmplado = " + idEmplado + ", primerNombre = " + primerNombre + ", segundoNombre = " + segundoNombre + ", primerApellido = " + primerApellido + ", fechaNacimiento = " + fechaNacimiento + ", id_Departamento = " + id_Departamento + '}';
    }

}
