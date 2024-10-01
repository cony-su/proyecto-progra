package project;

import java.util.*; 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class GestorClientes
{
  BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
  
  public Cliente buscarClientePorNombre(List<Cliente> listaClientes, String nombre)
  {
	  for(Cliente cliente : listaClientes) if(nombre.equals(cliente.getDatosPersonales().getNombreCliente())) return cliente;
	  return null;
  }
  
  public Cliente buscarClientePorRut(List<Cliente> listaClientes, String rut)
  {
	  for(Cliente cliente : listaClientes) if(rut.equals(cliente.getDatosPersonales().getRut())) return cliente;
	  return null;
  }
  
  public Cliente buscarClientePorNumeroId(List<Cliente> listaClientes, int numId)
  {
	  for(Cliente cliente : listaClientes) if(numId == cliente.getDatosPersonales().getNumeroIdentificacion()) return cliente;
	  return null;
  }
  
  public Cliente buscarClientePorIDFactura(List<Cliente> listaClientes, String idFactura)
  {
      for(Cliente cliente : listaClientes) if(cliente.buscarFactura(idFactura) != null) return cliente;
      return null;
  }
  
  public boolean EliminarCliente(List<Cliente> listaClientes, Cliente cliente)  
  {
	  if(cliente != null) 
	  {
		  listaClientes.remove(cliente);
		  return true;
	  }
	  return false;
	  
  }
  
  public DatosPersonales registrarDatosPersonales() throws IOException
  {
	  System.out.println("Ingrese el nombre del cliente:");
      String nombreCliente = lector.readLine();
      System.out.println("Ingrese la fecha de nacimiento del cliente (dd/mm/aaaa):");
      String fechaNacimiento = lector.readLine();
      System.out.println("Ingrese la dirección del cliente:");
      String direccion = lector.readLine();
      System.out.println("Ingrese el número de identificación del cliente:");
      String nIdentificacion = lector.readLine();
      int numeroIdentificacion = Integer.parseInt(nIdentificacion);
      System.out.println("Ingrese el rut del cliente:");
      String rut = lector.readLine();

      DatosPersonales datosPersonales = new DatosPersonales(nombreCliente, fechaNacimiento, direccion, numeroIdentificacion, rut);
      return datosPersonales;
  }
  
  public DatosContacto registrarDatosContacto() throws IOException
  {
	  System.out.println("Ingrese la dirección de facturación del cliente:");
      String direccionFacturacion = lector.readLine();
      System.out.println("Ingrese el número de teléfono del cliente:");
      String numeroTelefono = lector.readLine();
      System.out.println("Ingrese el correo electrónico del cliente:");
      String correoElectronico = lector.readLine();

      DatosContacto datosContacto = new DatosContacto(direccionFacturacion, numeroTelefono, correoElectronico);
      return datosContacto;
  }
  
  public Equipo registrarEquipo() throws IOException
  {
	  System.out.println("Ingrese la marca del teléfono del cliente:");
      String marca = lector.readLine();
      System.out.println("Ingrese el modelo de teléfono del cliente:");
      String modelo = lector.readLine();
      System.out.println("Ingrese el número de serie del teléfono del cliente:");
      String numSerie = lector.readLine();
      int numeroSerie = Integer.parseInt(numSerie); // Assign value to numeroSerie
      
      Equipo equipo = new Equipo(marca, modelo, numeroSerie); 
      return equipo;
  }
  
  public Tarjeta registrarTarjeta(int metodoPago) throws IOException
  {
	  System.out.println("Ingrese la opción: ");
	  int tipoTarjeta = Integer.parseInt(lector.readLine());
	  System.out.println("Nombre del Titular: ");
	  String nombreTitular = lector.readLine();
	  System.out.println("Número de tarjeta: ");
	  String numeroTarjeta = lector.readLine();
	  System.out.println("Fecha de Vencimiento: ");
	  String fechaVencimiento = lector.readLine();
	  System.out.println("Código de Seguridad: ");
	  String codigoSeguridad = lector.readLine();
	  
	  Tarjeta tarjeta = new Tarjeta(metodoPago, tipoTarjeta, nombreTitular, numeroTarjeta, fechaVencimiento, codigoSeguridad);
	  return tarjeta;
  }

  public void registarCliente(List <Cliente> listaClientes)
    {
      try 
      {
        DatosPersonales datosPersonales = registrarDatosPersonales();
        DatosContacto datosContacto = registrarDatosContacto();
        Equipo equipo = registrarEquipo(); 
        Menus menu = new Menus();
        menu.MenuPlanes();
        System.out.println("Seleccione un plan disponible:");
        int opcionPlan = Integer.parseInt(lector.readLine());
        PlanesDisponibles plan = null;
        Factura factura1 = null;
        Factura factura2 = null;
        switch(opcionPlan)
        {
          case 1:
            plan = new PlanesDisponibles("Plan Económico", 8000, false, 60, false, 0, false, 10);
            factura1 = new Factura("253", 8000, "2023-06-01", true);
            factura2 = new Factura("257", 8000, "2023-07-01", false);
            break;

          case 2:
            plan = new PlanesDisponibles("Plan Básico", 12000, false, 120, false, 30, false, 50);
            factura1 = new Factura("117", 12000, "2023-06-01", true);
            factura2 = new Factura("115", 12000, "2023-07-01", false);
            break;

          case 3:
            plan = new PlanesDisponibles("Plan Normal", 15000, false, 200, false, 100, false, 100);
            factura1 = new Factura("905", 15000, "2023-06-01", true);
            factura2 = new Factura("902", 15000, "2023-07-01", false);
            break;

          case 4:
            plan = new PlanesDisponibles("Plan Premium", 20000, true, 0, true, 0, true, 0);
            factura1 = new Factura("612", 20000, "2023-06-01", true);
            factura2 = new Factura("614", 20000, "2023-07-01", false);
            break;

          default:
            System.out.println("Opción no válida");
            break;
        }
        Cliente cliente = new Cliente(datosPersonales, datosContacto, plan, equipo);
        cliente.agregarFactura(factura1);
        cliente.agregarFactura(factura2);
        listaClientes.add(cliente);

        System.out.println("el cliente se ha registrado correctamente.");
      }

      catch (IOException e) {
          System.out.println("Ocurrió un error al leer la entrada del usuario. Por favor, intente nuevamente.");
          e.printStackTrace();
      }   
    }


  public void MostrarClientes(List<Cliente> listaClientes) 
  {
        if (listaClientes == null || listaClientes.isEmpty()) 
        {
            System.out.println("No hay clientes para mostrar.");
            return;
        }

        System.out.println("Lista de Clientes:");
        System.out.println("------------------------------------------");

        for (Cliente cliente : listaClientes) cliente.mostrarCliente();
  }

  public boolean mostrarEncontrado(Cliente cliente)
  {
	  if(cliente != null)
      {
      	System.out.println("\nCliente encontrado:");
          System.out.println("-------------------:");
          cliente.mostrarCliente();
          return true;
      }
	  return false;
  }
  
  public Cliente buscarCliente(List<Cliente> listaClientes) throws IOException
  {
    System.out.println("\nIngrese la opción ");
    int opcionbusqueda = Integer.parseInt(lector.readLine());
    switch(opcionbusqueda)
    {
      case 1:
        System.out.println("Ingrese el nombre del cliente a buscar:");
        String nombreCliente = lector.readLine();
        Cliente cliente = buscarClientePorNombre(listaClientes, nombreCliente);
        if(mostrarEncontrado(cliente)) return cliente;
        else System.out.println("No se encontró ningún cliente con ese nombre.");
        return null;

      case 2:
        System.out.println("Ingrese el rut del cliente a buscar:");
        String rutCliente = lector.readLine();      
        Cliente cliente2 = buscarClientePorRut(listaClientes, rutCliente);
        if(mostrarEncontrado(cliente2)) return cliente2;
        else System.out.println("No se encontró ningún cliente con ese rut.");
        return null;

      case 3:
    	  System.out.println("Ingrese el Número de Identificación del cliente a buscar:");
          int numId = Integer.parseInt(lector.readLine());        
          Cliente cliente3 = buscarClientePorNumeroId(listaClientes, numId);
          if(mostrarEncontrado(cliente3)) return cliente3;
          else System.out.println("No se encontró ningún cliente con ese Número de Identificación.");
          return null;
        
      case 4: 
    	  System.out.println("Ingrese el ID de alguna factura del cliente a buscar:");
          String idFactura = lector.readLine();        
          Cliente cliente4 = buscarClientePorRut(listaClientes, idFactura);
          if(mostrarEncontrado(cliente4)) return cliente4;
          else System.out.println("No se encontró ningún cliente con ese ID de factura.");        
    	  return null;
      default:
        break;
    }
    return null;
  }
  
  
  public void MedioDePago(Cliente cliente) throws IOException
  { 
    Menus menu = new Menus();
    menu.limpiarPantalla();
    menu.MenuMedioDePago();
    System.out.println("Ingrese la opción: ");
    int metodoPago = Integer.parseInt(lector.readLine());
    
    switch(metodoPago)
    {
      case 1:
        menu.limpiarPantalla();
        menu.MenuCredito();
        break;
      case 2:
        menu.limpiarPantalla();
        menu.MenuDebito();
        break;
      case 3:
        System.out.println("Tarjetas Registradas");
        System.out.println("--------------------");
        if(cliente.getTarjetasRegistradas() == null) System.out.println("No hay tarjetas registradas.");
        else
        {
          cliente.MostrarTarjetas();
          System.out.println("\nIngrese el número de la tarjeta que desea utilizar:");
          int numeroTarjeta = Integer.parseInt(lector.readLine());
        }
        break;
        
      default:
        break;
    }
    if(metodoPago == 3) return;
    Tarjeta tarjeta = registrarTarjeta(metodoPago);
    cliente.agregarTarjeta(tarjeta);
  }
  
  public void PagarFactura(List<Cliente> listaClientes) throws IOException 
  {
      System.out.println("Pago de Factura");
      System.out.println("---------------");
      System.out.println("Ingrese el ID de la factura a pagar: ");
      String id = lector.readLine();
      boolean encontrado = false;

      for(Cliente cliente : listaClientes)
      {
    	  Factura factura = cliente.buscarFactura(id); 
    	  if(factura != null) 
    	  {
    		  cliente.mostrarCliente();
    		  System.out.println("¿Deseas pagar la factura? (SI/NO): ");
    	      String respuesta = lector.readLine();
    	      if (respuesta.equalsIgnoreCase("SI")) 
    	      {
    	          if(factura.pagarFactura()) 
    	          {
    	        	  MedioDePago(cliente);
    	        	  System.out.println("Factura pagada con éxito.");
    	          }
    	          else System.out.println("La factura ya estaba pagada");
    	          encontrado = true;
    	      }
    	      else return;
    	  }
      }   	  
      if(encontrado == false) System.out.println("Factura no encontrada, proporcione un ID válido");
  }
  
  public void EditarCliente(Cliente cliente) throws IOException
  {
	  System.out.println("\nIngrese la opción: ");
	  int op = Integer.parseInt(lector.readLine());
	  switch(op)
	  {
	  case 1:
		  System.out.println("\n Deseas Cambiar:");
		  System.out.println("-----------------");
		  System.out.println("Nombre (SI/NO)");
		  String respuesta = lector.readLine();
		  if(("SI").equals(respuesta) || ("si").equals(respuesta))
		  {
			  System.out.println("Ingrese el nuevo nombre");
			  String nombre = lector.readLine();
			  cliente.getDatosPersonales().setnombreCliente(nombre);
		  }
		  System.out.println("Fecha de Nacimiento (SI/NO)");
		  String respuesta2 = lector.readLine();
		  if(("SI").equals(respuesta2) || ("si").equals(respuesta2))
		  {
			  System.out.println("Ingrese la nueva Fecha de Nacimiento");
			  String fecha = lector.readLine();
			  cliente.getDatosPersonales().setFechaNacimiento(fecha);
		  }
		  System.out.println("Dirección (SI/NO)");
		  String respuesta3 = lector.readLine();
		  if(("SI").equals(respuesta3) || ("si").equals(respuesta3))
		  {
			  System.out.println("Ingrese la nueva Dirección");
			  String direccion = lector.readLine(); 
			  cliente.getDatosPersonales().setDireccion(direccion);
		  }
		  
		  //el numero de identificacion no lo cambio porque debeeria darlo el sistema (hacerlo al final con randomizador)
		  
		  System.out.println("Rut (SI/NO)");
		  String respuesta4 = lector.readLine();
		  if(("SI").equals(respuesta4) || ("si").equals(respuesta4))
		  {
			  System.out.println("Ingrese el nuevo Rut");
			  String rut = lector.readLine();
			  cliente.getDatosPersonales().setRut(rut);
		  }
		  System.out.println("Edición finalizada con éxito");
		  break;
	  case 2:
		  System.out.println("\n Deseas Cambiar:");
		  System.out.println("-----------------");
		  System.out.println("Dirección de Facturación (SI/NO)");
		  String respuesta5 = lector.readLine();
		  if(("SI").equals(respuesta5) || ("si").equals(respuesta5))
		  {
			  System.out.println("Ingrese la nueva Dirección de Facturación");
			  String direccionFacturacion = lector.readLine();
			  cliente.getDatosContacto().setDireccionFacturacion(direccionFacturacion);
		  }
		  System.out.println("Teléfono (SI/NO)");
		  String respuesta6 = lector.readLine();
		  if(("SI").equals(respuesta6) || ("si").equals(respuesta6))
		  {
			  System.out.println("Ingrese el nuevo Teléfono");
			  String telefono = lector.readLine();
			  cliente.getDatosContacto().setTelefono(telefono);
		  }
		  System.out.println("Correo (SI/NO)");
		  String respuesta7 = lector.readLine();
		  if(("SI").equals(respuesta7) || ("si").equals(respuesta7))
		  {
			  System.out.println("Ingrese el nuevo Correo");
			  String correo = lector.readLine();
			  cliente.getDatosContacto().setCorreo(correo);
		  }
		  System.out.println("Edición finalizada con éxito");
		  break;
	  case 3:
		  System.out.println("\n Deseas Cambiar:");
		  System.out.println("-----------------");
		  System.out.println("Marca del Equipo (SI/NO)");
		  String respuesta8 = lector.readLine();
		  if(("SI").equals(respuesta8) || ("si").equals(respuesta8))
		  {
			  System.out.println("Ingrese la nueva Marca del Equipo");
			  String marca = lector.readLine();
			  cliente.getEquipo().setMarca(marca);
		  }
		  System.out.println("Modelo del Equipo (SI/NO)");
		  String respuesta9 = lector.readLine();
		  if(("SI").equals(respuesta9) || ("si").equals(respuesta9))
		  {
			  System.out.println("Ingrese el nuevo Modelo del Equipo");
			  String modelo = lector.readLine();
			  cliente.getEquipo().setModelo(modelo);
		  }
		  System.out.println("Edición finalizada con éxito");
		  break;
	  case 4:
		  System.out.println("\n ¿A qué Tipo de Plan quieres cambiar?");
		  System.out.println("1. Plan Económico");
	      System.out.println("2. Plan Básico");
	      System.out.println("3. Plan Normal");
	      System.out.println("4. Plan Premium \n");
	      System.out.println("\nIngrese la opción deseada: ");
		  int respuesta10 = Integer.parseInt(lector.readLine());
		  switch(respuesta10)
		  {
		     case 1: 
		    	 PlanesDisponibles PE = new PlanesDisponibles("Plan Económico", 8000, false, 60, false, 0, false, 10);
		    	 cliente.setPlan(PE);
		    	 break;
		     case 2:
		    	 PlanesDisponibles PB = new PlanesDisponibles("Plan Básico", 12000, false, 120, false, 30, false, 50);
		    	 cliente.setPlan(PB);
		    	 break;
		     case 3:
		    	 PlanesDisponibles PN = new PlanesDisponibles("Plan Normal", 15000, false, 200, false, 100, false, 100);
		    	 cliente.setPlan(PN);
		     case 4:
		    	 PlanesDisponibles PP = new PlanesDisponibles("Plan Premium", 20000, true, 0, true, 0, true, 0);
		    	 cliente.setPlan(PP);
		     default:
		    	 System.out.println("Opción inválida");
		    	 return;
		  }
		  System.out.println("Edición finalizada con éxito");
		  break;
	  default:
		  return;
	  }
  }
  
  public boolean EditarTarjeta(Cliente cliente) throws IOException
  {
	  if(cliente == null) return false;
	  System.out.println("¿Que tarjeta quieres modificar?"); 	
	  System.out.println("-------------------------------");
	  cliente.MostrarTarjetas();
	  System.out.println("\nIngresa el Número de Serie de la tarjeta que quieras modificar: ");
	  String numSerie = lector.readLine();
	  Tarjeta tarjeta = cliente.buscarTarjeta(numSerie);
	  if(tarjeta == null) return false;
	  
	  System.out.println("\n Deseas Cambiar:");
	  System.out.println("-----------------");
	  
      System.out.println("Nombre del Titular (SI/NO)");
	  String respuesta = lector.readLine();
	   if(("SI").equals(respuesta) || ("si").equals(respuesta))
	   {
	      System.out.println("Ingrese el nuevo Nombre del Titular");
		  String nombreT = lector.readLine();
		  tarjeta.setNombreTitular(nombreT);
	   }	  

	   System.out.println("Número de serie: (SI/NO)");
	   String respuesta12 = lector.readLine();
	   if(("SI").equals(respuesta12) || ("si").equals(respuesta12))
	   {
		  System.out.println("Ingrese el nuevo Número de Serie: ");
		  String numS = lector.readLine();
		  Tarjeta clon = new Tarjeta(tarjeta.getMetodoPago(), tarjeta.getTipoTarjeta(), tarjeta.getNombreTitular(), numS, tarjeta.getFechaVencimiento(), tarjeta.getCodigoSeguridad());
		  cliente.getTarjetasRegistradas().remove(tarjeta.getNumeroTarjeta());
		  cliente.agregarTarjeta(clon);
	   }		  

		  System.out.println("Fecha de Vencimiento (SI/NO)");
		  String respuesta13 = lector.readLine();
		  if(("SI").equals(respuesta13) || ("si").equals(respuesta13))
		  {
			  System.out.println("Ingrese la nueva Fecha de Vencimiento: ");
			  String fechaV = lector.readLine();
			  tarjeta.setFechaVencimiento(fechaV);
		  }
		  
		  System.out.println("Código de Seguridad (SI/NO)");
		  String respuesta14 = lector.readLine();
		  if(("SI").equals(respuesta14) || ("si").equals(respuesta14))
		  {
			  System.out.println("Ingrese el nuevo Código de Seguridad: ");
			  String codigo = lector.readLine();
			  tarjeta.setCodigoSeguridad(codigo);
		  }
	  
	  return true;
  }
   
  public void EliminarTarjeta(Cliente cliente) throws IOException
  {
	  if(cliente == null) return;
	  else
	  {
		  System.out.println("Ingrese el Número de la Tarjeta a eliminar");
		  String numSerie = lector.readLine();
		  Tarjeta tarjeta = cliente.buscarTarjeta(numSerie);
		  if(tarjeta != null)
		  {
			  if(cliente.EliminarTarjeta(numSerie)) System.out.println("Tarjeta eliminada correctamente");
			  else System.out.println("Tarjeta no se pudo eliminar");
		  }
		  else System.out.println("Tarjeta no encontrada");
	  }
  }
  
}