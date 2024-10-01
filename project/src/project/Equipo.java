package project;

class Equipo
{
  private String marca;
  private String modelo;
  private int numeroSerie;

  //CONSTRUCTOR
  public Equipo(String marca, String modelo, int numeroSerie)
  {
    this.marca = marca;
    this.modelo = modelo;
    this.numeroSerie = numeroSerie;
  }

  //SETTERS Y GETTERS
  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca){
    this.marca = marca;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo){
    this.modelo = modelo;
  }

  public int getNumeroSerie() {
    return numeroSerie;
  }

  public void setNumeroSerie(int numeroSerie){
    this.numeroSerie = numeroSerie;
  }
}