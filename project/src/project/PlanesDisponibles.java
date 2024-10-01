package project;

class PlanesDisponibles 
{
  private String nombrePlan;
  private int precioPlan;
  private Boolean llamadasNacionalesIlimitadas;
  private int limiteLlamadasNacionales; //se refiere al limite de minutos de llamadas nacionales
  private Boolean llamadasInternacionalesIlimitadas;
  private int limiteLlamadasInternacionales;
  private Boolean datosIlimitados;
  private int limiteDatos;

  public PlanesDisponibles(String nombrePlan, int precioPlan, Boolean llamadasNacionalesIlimitadas, int limiteLlamadasNacionales, Boolean llamadasInternacionalesIlimitadas,int limiteLlamadasInternacionales, Boolean datosIlimitados, int limiteDatos)
  {
    this.nombrePlan = nombrePlan;
    this.precioPlan = precioPlan;
    this.llamadasNacionalesIlimitadas = llamadasNacionalesIlimitadas;
    this.limiteLlamadasNacionales = limiteLlamadasNacionales;
    this.llamadasInternacionalesIlimitadas = llamadasInternacionalesIlimitadas;
    this.limiteLlamadasInternacionales = limiteLlamadasInternacionales;
    this.datosIlimitados = datosIlimitados;
    this.limiteDatos = limiteDatos;
  }

  public String getNombrePlan(){
    return nombrePlan;
  }

  public void setNombrePlan(String nombrePlan){
    this.nombrePlan = nombrePlan;
  }

  public int getPrecioPlan(){
    return precioPlan;
  }

  public void setPrecioPlan(int precioPlan){
    this.precioPlan = precioPlan;
  }

  public Boolean getLlamadasNacionalesIlimitadas(){
    return llamadasNacionalesIlimitadas;
  }

  public void setLlamadasNacionalesIlimitadas(Boolean llamadasNacionalesIlimitadas){
    this.llamadasNacionalesIlimitadas = llamadasNacionalesIlimitadas;
  }

  public int getLimiteLlamadasNacionales(){
    return limiteLlamadasNacionales;
  }

  public void setLimiteLlamadasNacionales(int limiteLlamadasNacionales){
    this.limiteLlamadasNacionales = limiteLlamadasNacionales;
  }

  public Boolean getLlamadasInternacionalesIlimitadas(){
    return llamadasInternacionalesIlimitadas;
  }

  public void setLlamadasInternacionalesIlimitadas(Boolean llamadasInternacionalesIlimitadas){
    this.llamadasInternacionalesIlimitadas = llamadasInternacionalesIlimitadas;
  }

  public int getLimiteLlamadasInternacionales(){
    return limiteLlamadasInternacionales;
  }

  public void setLimiteLlamadasInternacionales(int limiteLlamadasInternacionales){
    this.limiteLlamadasInternacionales = limiteLlamadasInternacionales;
  }

  public Boolean getDatosIlimitados(){
    return datosIlimitados;
  }

  public void setDatosIlimitados(Boolean datosIlimitados){
    this.datosIlimitados = datosIlimitados;
  }

  public int getLimiteDatos(){
    return limiteDatos;
  }
}