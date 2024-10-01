package project;
import java.io.IOException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Menus
{
  public void MenuPrincipal()
  {
    System.out.println("Bienvenido al Sistema de Telefonía Celular");
    System.out.println("------------------------------------------");
    System.out.println("1. Mostrar SubMenú de Cliente");
    System.out.println("2. Mostrar SubMenú de Tarjeta");
    System.out.println("3. Mostrar Planes Disponibles");
    System.out.println("4. Pagar Factura ");
    System.out.println("5. Generar Reporte General ");
    System.out.println("6. Salir \n");
  }
  
  public void MenuClientes()
  {
	System.out.println("SubMenú de Clientes");
	System.out.println("-------------------");
    System.out.println("1. Mostrar Clientes");
    System.out.println("2. Registrar Cliente");
    System.out.println("3. Buscar Cliente");
    System.out.println("4. Editar Cliente");
    System.out.println("5. Eliminar Cliente");
    System.out.println("6. Generar Reporte Individual");
    System.out.println("7. Salir \n");
  }
  
  public void MenuTarjeta()
  {
    System.out.println("SubMenú de Tarjetas");
	System.out.println("-------------------");
    System.out.println("1. Mostrar Tarjetas Asociadas ");
    System.out.println("2. Eliminar Tarjeta Asociada");
    System.out.println("3. Editar Tarjeta Asociada");
    System.out.println("4. Salir \n");
  }

  public void limpiarPantalla() 
  {
    String sistemaOperativo = System.getProperty("os.name").toLowerCase();
    try {
        if (sistemaOperativo.contains("win")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
  }

  public void MenuPlanes()
    {
      System.out.println("\n¿Que plan desea registrar?");
      System.out.println("-------------------------");
      System.out.println("1. Plan Económico");
      System.out.println("2. Plan Básico");
      System.out.println("3. Plan Normal");
      System.out.println("4. Plan Premium \n");
    }

  public void PlanEconomico()
  {
    System.out.println("Plan Económico");
    System.out.println("--------------");
    System.out.println("- Llamadas nacionales: 60 minutos");
    System.out.println("- Llamadas internaciones: 0 minutos");
    System.out.println("- Datos móviles: 10 GB");
    System.out.println("Precio: $8000\n");   
  }

  public void PlanBasico()
    {
      System.out.println("Plan Básico");
      System.out.println("-----------");
      System.out.println("- Llamadas nacionales: 120 minutos");
      System.out.println("- Llamadas internaciones: 30 minutos");
      System.out.println("- Datos móviles: 50 GB");
      System.out.println("Precio: $12000\n"); 
    }

  public void PlanNormal()
  {
    System.out.println("Plan Normal");
    System.out.println("--------------");
    System.out.println("- Llamadas nacionales: 200 minutos");
    System.out.println("- Llamadas internaciones: 100 minutos");
    System.out.println("- Datos móviles: 100 GB");
   // System.out.println("- Mensajes: 10 SMS");
    System.out.println("Precio: $15000\n");
  }

  public void PlanPremium()
  {
    System.out.println("Plan Premium");
    System.out.println("------------");
    System.out.println("- Llamadas nacionales: minutos ilimitados");
    System.out.println("- Llamadas internaciones: minutos ilimitados");
    System.out.println("- Datos móviles: GB ilimitados");
    System.out.println("Precio: $20000\n"); 
  }

  public void MenuBuscarCliente()
    {
      System.out.println("Deseas buscar al cliente por:");
      System.out.println("-----------------------------");
      System.out.println("1. Nombre");
      System.out.println("2. Rut");
      System.out.println("3. Número de Identificación");
      System.out.println("4. ID de alguna factura");
      System.out.println("5. Regresar \n");
    }

  public void MenuMedioDePago()
  {
    System.out.println("¿Con que método desea pagar?");
    System.out.println("------------------");
    System.out.println("1. Tarjeta de crédito");
    System.out.println("2. Tarjeta de débito");
    System.out.println("3. Tarjeta previamente registrada");
  }

  public void MenuCredito()
  {
    System.out.println("¿Con que tipo de tarjeta desea pagar?");
    System.out.println("-------------------------------------");
    System.out.println("1. Visa");
    System.out.println("2. MasterCard");
    System.out.println("3. American Express");
    System.out.println("4. Diners Club");
  }

  public void MenuDebito()
    {
      System.out.println("¿Con que tipo de tarjeta desea pagar?");
      System.out.println("-------------------------------------");
      System.out.println("1. Visa Débito");
      System.out.println("2. MasterCard Débito");
      System.out.println("3. Redcompra");
      System.out.println("4. Bank Red");
    } 
  
  public void MenuEditarCliente()
  {
	  System.out.println("¿Que información desea desea editar?");
	  System.out.println("------------------------------------");
      System.out.println("1. Datos personales del cliente");
      System.out.println("2. Datos de contacto del cliente");
      System.out.println("3. Equipo del cliente");
      System.out.println("4. Tipo de plan del cliente");
  }
  
}