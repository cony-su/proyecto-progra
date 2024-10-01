package project;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main 
{
  public static void main(String[] args) throws IOException 
  {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Cliente> listaClientes = new ArrayList<Cliente>(); //COLECCIÓN PRINCIPAL
    ClientesRegistrados clientesRegistrados = new ClientesRegistrados();

    Cliente cliente1 = clientesRegistrados.ClienteRegistrado1();
    Cliente cliente2 = clientesRegistrados.ClienteRegistrado2();
    Cliente cliente3 = clientesRegistrados.ClienteRegistrado3();
    Cliente cliente4 = clientesRegistrados.ClienteRegistrado4();
    listaClientes.add(cliente1);
    listaClientes.add(cliente2);
    listaClientes.add(cliente3);
    listaClientes.add(cliente4);
    
    
   // ClientesCSV cargador = new ClientesCSV();
   // cargador.cargarClientesDesdeCSV("clientes.csv", mapaNombre, mapaRut, listaClientes);
   // cargador.FacturasClientesCSV("facturas .csv", listaClientes, mapaIDFactura, mapaNombre, mapaRut);
   // cargador.TarjetasClientesCSV("tarjetas.csv", listaClientes, mapaIDFactura, mapaNombre, mapaRut);
    
    GestorClientes gestorClientes = new GestorClientes();
    Menus menu = new Menus();
    
    while(true)
    {
      menu.MenuPrincipal();
      System.out.println("Ingrese una opción: ");
      String opcionStr = reader.readLine(); // Captura la entrada del usuario como un string
      int opcion = Integer.parseInt(opcionStr);
      
      switch(opcion) 
      {
        case 1:
          menu.limpiarPantalla();
          menu.MenuClientes();
          System.out.println("Ingrese una opción: ");
          int opcion1 = Integer.parseInt(reader.readLine());
          switch(opcion1)
          {
             case 1:
            	 menu.limpiarPantalla();
                 gestorClientes.MostrarClientes(listaClientes);
                 System.out.println("\nDigite una letra para salir: ");
                 String op = reader.readLine();
            	 break;
             case 2:
            	 menu.limpiarPantalla();
                 gestorClientes.registarCliente(listaClientes); 
                 System.out.println("\nDigite una letra para salir: ");
                 String op2 = reader.readLine();
            	 break;
             case 3:
            	 menu.limpiarPantalla();
                 menu.MenuBuscarCliente();
                 gestorClientes.buscarCliente(listaClientes);
                 System.out.println("\nDigite una letra para salir: ");
                 String op3 = reader.readLine();
            	 break;
             case 4:
            	 menu.limpiarPantalla();
                 menu.MenuBuscarCliente();
                 Cliente cliente = gestorClientes.buscarCliente(listaClientes);
                 if(cliente != null) 
                 {
               	  menu.MenuEditarCliente();
               	  gestorClientes.EditarCliente(cliente);
                 }
                 else System.out.println("\nIntente de nuevo");
                 System.out.println("\nDigite una letra para salir: ");
                 String op4 = reader.readLine();
            	 break;
             case 5:
            	 menu.limpiarPantalla();
                 menu.MenuBuscarCliente();
                 Cliente c = gestorClientes.buscarCliente(listaClientes);
               	  if(gestorClientes.EliminarCliente(listaClientes, c)) System.out.println("\nEliminación existosa");
                 else System.out.println("\nIntente de nuevo");
                 System.out.println("\nDigite una letra para salir: ");
                 String op5 = reader.readLine();
                 break;
             case 6:
            	 menu.limpiarPantalla();
                 menu.MenuBuscarCliente();
                 Cliente clienteReporte = gestorClientes.buscarCliente(listaClientes);
                 if(clienteReporte != null) 
                 {
                	 Reportes RI = new Reportes();
                	 RI.Reporte(clienteReporte);
                     System.out.println("\nReporte generado correctamente");
                	 
                 }
                 else System.out.println("\nCliente no encontrado");
                 System.out.println("\nDigite una letra para salir: ");
                 String op6 = reader.readLine();
            	 break;
             default:
            	 break;
          }
          break;
        case 2:
          menu.limpiarPantalla();
          menu.MenuTarjeta();
          System.out.println("Ingrese una opción: ");
          int opcion2 = Integer.parseInt(reader.readLine());
          switch(opcion2)
          {
            case 1:
            	menu.MenuBuscarCliente();
                Cliente c2 = gestorClientes.buscarCliente(listaClientes);
                c2.MostrarTarjetas();
            	System.out.println("\nDigite una letra para salir: ");
                String op = reader.readLine();
            	break;
            case 2:
            	menu.MenuBuscarCliente();
                Cliente c3 = gestorClientes.buscarCliente(listaClientes);
                c3.MostrarTarjetas();
                gestorClientes.EliminarTarjeta(c3); 
            	System.out.println("\nDigite una letra para salir: ");
            	String op2 = reader.readLine(); 
            	break;
            case 3:
            	menu.MenuBuscarCliente();
                Cliente c4 = gestorClientes.buscarCliente(listaClientes);
                if(c4 != null)
                {
                	if(gestorClientes.EditarTarjeta(c4)) System.out.println("Tarjeta editada correctamente");
                	else System.out.println("\nTarjeta no encontrada");
                }
                else System.out.println("\nCliente no encontrado");
                System.out.println("\nDigite una letra para salir: ");
            	String op3 = reader.readLine(); 
            default:
            	break;
          }
          break;
        case 3:
        	menu.limpiarPantalla(); 
            menu.PlanEconomico();
            menu.PlanBasico();
            menu.PlanNormal();
            menu.PlanPremium();
            System.out.println("\nDigite una letra para salir ");
            String op8 = reader.readLine();
            break;
        case 4:
        	menu.limpiarPantalla();
            gestorClientes.PagarFactura(listaClientes);
            System.out.println("\nDigite una letra para salir ");
            String op9 = reader.readLine();
            break;
        case 5:
        	Reportes reporte = new Reportes();
        	reporte.Reporte(listaClientes);
        	System.out.println("\nDigite una letra para salir ");
            String op10 = reader.readLine();
        	break;
        default:
          System.out.println("Opción no válida");
          break;
      }   
      menu.limpiarPantalla();
    }   
  }
}

