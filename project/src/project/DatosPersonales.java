package project;

class DatosPersonales
{  
  private String nombreCliente;
  private String fechaNacimiento; 
  private String direccion;
  private int numeroIdentificacion;
  private String rut; 

  //CONSTRUCTOR
  public DatosPersonales(String nombreCliente, String FechaNacimiento, String direccion, int numeroIdentificacion, String rut)
  {
    this.nombreCliente = nombreCliente;
    this.fechaNacimiento = FechaNacimiento;
    this.direccion = direccion;
    this.numeroIdentificacion = numeroIdentificacion;
    this.rut = rut;
  }

  //SETTERS Y GETTERS
  public String getNombreCliente(){ 
    return nombreCliente;
  }

  public void setnombreCliente(String nombreCliente){
    this.nombreCliente = nombreCliente;
  }

  public String getFechaNacimiento(){
    return fechaNacimiento;
  }

  public void setFechaNacimiento(String fechaNacimiento){
    this.fechaNacimiento = fechaNacimiento;
  }

  public String getDireccion(){
    return direccion;
  }

  public void setDireccion(String direccion){
    this.direccion = direccion;
  }

  public int getNumeroIdentificacion(){
    return numeroIdentificacion;
  }

  public void setNumeroIdentificacion(int numeroIdentificacion){
    this.numeroIdentificacion = numeroIdentificacion;
  }

  public String getRut(){
    return rut;
  }

  public void setRut(String rut){
    this.rut = rut;
  }
}