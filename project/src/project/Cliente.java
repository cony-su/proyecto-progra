package project;
import java.io.IOException;
import java.util.*; 

class Cliente
{
  private DatosPersonales datosPersonales;
  private DatosContacto datosContacto; 
  private PlanesDisponibles plan;
  private HashMap<String, Factura> facturas; 
  private HashMap<String, Tarjeta> tarjetasRegistradas; 
  private Equipo equipo;

  //CONSTRUCTOR
  public Cliente(DatosPersonales datosPersonales, DatosContacto datosContacto, PlanesDisponibles plan,Equipo equipo) 
  {
    this.datosPersonales = datosPersonales;
    this.datosContacto = datosContacto;
    this.plan = plan;
    this.equipo = equipo;
    facturas = new HashMap<String, Factura>();
    tarjetasRegistradas = new HashMap<String, Tarjeta>();
  }
  
  //SETTERS Y GETTERS  
  public DatosPersonales getDatosPersonales() {
    return datosPersonales;
  }

  public void setDatosPersonales(DatosPersonales datosPersonales){
    this.datosPersonales = datosPersonales;
  }

  public DatosContacto getDatosContacto() {
    return datosContacto;
  }

  public void setDatosContacto(DatosContacto datosContacto){
    this.datosContacto = datosContacto;
  }

  public PlanesDisponibles getPlan() {
    return plan;
  }

  public void setPlan(PlanesDisponibles plan){
    this.plan = plan;
  }

  public Equipo getEquipo() {
    return equipo;
  }

  public void setEquipo(Equipo equipo){
    this.equipo = equipo;
  }

  public HashMap<String, Factura> getFacturas(){
    return facturas;
  }

  public void setFacturas(HashMap<String, Factura> facturas){
    this.facturas = facturas;
  }

  public HashMap<String, Tarjeta> getTarjetasRegistradas()
  {
    return tarjetasRegistradas;
  }

  public void setTarjetasRegistradas(HashMap<String, Tarjeta> tarjetasRegistradas){
    this.tarjetasRegistradas = tarjetasRegistradas;
  }

  //MÉTODOS PARA FACTURAS
  public void agregarFactura(Factura factura) //SOBRECARGA DE MÉTODOS 1.1
  {
    facturas.put(factura.getIdFactura(), factura);
  }

  public void agregarFactura(String idFactura, double monto, String fechaEmision, boolean pagado) //SOBRECARGA DE MÉTODOS 1.2
  {
    Factura factura = new Factura(idFactura, monto, fechaEmision, pagado);
    facturas.put(factura.getIdFactura(), factura);
  }
  
  public Factura buscarFactura(String id)
  {
	  if(facturas.containsKey(id)) return facturas.get(id);
	  else return null;
  }

  //MÉTODOS PARA TARJETAS
  public void agregarTarjeta(Tarjeta tarjeta) //SOBRECARGA DE MÉTODOS 2.1
  {
    tarjetasRegistradas.put(tarjeta.getNumeroTarjeta(), tarjeta);
  }

  public void agregarTarjeta(int metodoPago, int tipoTarjeta, String nombreTitular, String numeroTarjeta, String fechaVencimiento, String codigoSeguridad) //SOBRECARGA DE MÉTODOS 2.1
  {
    Tarjeta tarjeta = new Tarjeta(metodoPago, tipoTarjeta, nombreTitular, numeroTarjeta, fechaVencimiento, codigoSeguridad);
    tarjetasRegistradas.put(tarjeta.getNumeroTarjeta(), tarjeta);
  }
  
  public Tarjeta buscarTarjeta(String numSerie)
  {
	  if(tarjetasRegistradas.containsKey(numSerie)) return tarjetasRegistradas.get(numSerie);
	  else return null;
  }
  
  public void MostrarTarjetas()
  {
	  int contadorT = 1;
	  if( tarjetasRegistradas == null) 
	  {
		  System.out.println("No hay Tarjetas Registradas");
		  return;
	  }
      for(String NumSerie : getTarjetasRegistradas().keySet())
      {
    	Tarjeta tarjeta = getTarjetasRegistradas().get(NumSerie); 
        System.out.println(contadorT + ". ");
        tarjeta.mostrarTarjeta();
        contadorT++;
      }
  }
  
  public boolean EliminarTarjeta(String numSerie)
  {
	  for(String clave : getTarjetasRegistradas().keySet())
	  {
		  Tarjeta tarjeta = getTarjetasRegistradas().get(clave);
		  if((numSerie).equals(tarjeta.getNumeroTarjeta()))
		  {
			  tarjetasRegistradas.remove(numSerie); 		 
			  return true;
		  }
	  }
	  return false;
  }
  
  //MÉTODOS PARA CLIENTES
  public void mostrarCliente()
  {
	  System.out.println("Nombre: " + getDatosPersonales().getNombreCliente());
	  System.out.println("Rut: " + getDatosPersonales().getRut());
	  System.out.println("Numero de Identificación: " + getDatosPersonales().getNumeroIdentificacion());
	  System.out.println("Dirección: " + getDatosPersonales().getDireccion());
	  System.out.println("Tipo de Plan: " + getPlan().getNombrePlan());
	  System.out.println("Equipo: " + getEquipo().getMarca() + " " + getEquipo().getModelo());
	  System.out.println("Facturas:");

	  if (getFacturas() == null || getFacturas().isEmpty()) System.out.println("  No hay facturas para mostrar.");
	    
	  else 
	  {
		  for(String idFactura : getFacturas().keySet())
		  {
	         Factura factura = getFacturas().get(idFactura); // Obtiene la factura usando el idFactura
	         System.out.print("  - Factura ID: " + factura.getIdFactura() + ", Monto: $" + factura.getMonto() + ", Fecha: " + factura.getFechaEmision() + ", Estado de Factura: ");
	         if (factura.getPagado()) System.out.println("PAGADO");
	         else System.out.println("NO PAGADO");
		  }
	  }	  
	  System.out.println("--------------------------------------------------------------------------------------");
  }
  
}

