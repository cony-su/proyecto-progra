package project;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Reportes 
{
	
	public void Reporte(List<Cliente> listaClientes) //SOBRECARGA DE MÉTODOS 3.1
	{
	    String rutaArchivo = "reporte_general.txt";
	    try (FileWriter writer = new FileWriter(rutaArchivo)) {
	        writer.write("Reporte general del sistema de telefonía\n");
	        writer.write("------------------------------------------------\n");
	        for (Cliente cliente : listaClientes) 
	        {
	        	int index = listaClientes.indexOf(cliente); 
	        	writer.write("Cliente N°: " + (index + 1) + ":");
	        	writer.write("\n-Nombre: " + cliente.getDatosPersonales().getNombreCliente());
	        	writer.write("\n-Rut: " + cliente.getDatosPersonales().getRut());
	        	writer.write("\n-Numero de Identificación: " + cliente.getDatosPersonales().getNumeroIdentificacion());
	        	writer.write("\n-Dirección del Cliente: " + cliente.getDatosPersonales().getDireccion());
	        	writer.write("\n-Tipo de Plan Registrado: " + cliente.getPlan().getNombrePlan());
	        	writer.write("\n-Equipo: " + cliente.getEquipo().getMarca() + " " + cliente.getEquipo().getModelo());
	            
	            writer.write("\n\n");
	        }
	        String os = System.getProperty("os.name").toLowerCase();
	        if (os.contains("win")) {
	            Runtime.getRuntime().exec(new String[] {"cmd.exe", "/c", "start", rutaArchivo});
	        } else if (os.contains("mac")) {
	            Runtime.getRuntime().exec(new String[] {"open", rutaArchivo});
	        } else if (os.contains("nix") || os.contains("nux")) {
	            Runtime.getRuntime().exec(new String[] {"xdg-open", rutaArchivo});
	        }
	    } catch (IOException e) {
	        System.out.println("Error al generar el archivo: " + e.getMessage());
	    }
	}
	
	
	public void Reporte(Cliente cliente) //SOBRECARGA DE MÉTODOS 3.2
	{
		
	    String rutaArchivo = "reporte_individual_cliente_" + cliente.getDatosPersonales().getNumeroIdentificacion() + ".txt";
	    try (FileWriter writer = new FileWriter(rutaArchivo)) 
	    {
	        writer.write("Reporte Individual del Cliente: " + cliente.getDatosPersonales().getNombreCliente());
	        writer.write("\n-------------------------------------------------------\n");
	        writer.write("Nombre: " + cliente.getDatosPersonales().getNombreCliente());
	        writer.write("\nRut: " + cliente.getDatosPersonales().getRut());
	        writer.write("\nNumero de Identificación: " + cliente.getDatosPersonales().getNumeroIdentificacion());
	        writer.write("\nDirección del Cliente: " + cliente.getDatosPersonales().getDireccion());
	        writer.write("\nTipo de Plan Registrado: " + cliente.getPlan().getNombrePlan());
	        writer.write("\nEquipo: " + cliente.getEquipo().getMarca() + " " + cliente.getEquipo().getModelo());
	        writer.write("\n\nFacturas: \n");
	        	
	        if(cliente.getFacturas() == null || cliente.getFacturas().isEmpty()) writer.write("No hay Facturas para mostrar.");
	    	    
	      	else 
	      	{
	      		int contador = 1;
	      		for(String idFactura : cliente.getFacturas().keySet())
	      		{
	      	       Factura factura = cliente.getFacturas().get(idFactura); 
	      	       writer.write("  Factura N°" + contador + ": \n");
	      	       writer.write("    - ID: " + factura.getIdFactura() + "\n");
	      	       writer.write("    - Monto: $" + factura.getMonto() + "\n");
	      	       writer.write("    - Fecha de Emisión: " + factura.getFechaEmision() + "\n");
	      	       writer.write("    - Estado de Factura: ");
	      	       if (factura.getPagado()) writer.write("PAGADO\n");
	      	       else writer.write("NO PAGADO\n");
	      	       contador++;
	      		}
	      	}
	        	
	        writer.write("\n\nTarjetas Asociadas: \n"); 
            if(cliente.getTarjetasRegistradas() == null || cliente.getFacturas().isEmpty()) writer.write("No hay Tarjetas para mostrar.");	    	    
	      	else 
	      	{
	      		int contador2 = 1;
	      		for(String numSerie : cliente.getTarjetasRegistradas().keySet())
	      		{
	      	       Tarjeta tarjeta = cliente.getTarjetasRegistradas().get(numSerie);
	      	       writer.write("  Tarjeta N°" + contador2 + ": \n");
	      	       writer.write("    - Medio de Pago: " + tarjeta.getMetodoPago() + "\n");
	      	       writer.write("    - Tipo de Tarjeta: " + tarjeta.getTipoTarjeta() + "\n");
	      	       writer.write("    - Nombre del Titular: " + tarjeta.getNombreTitular() + "\n");
	      	       writer.write("    - Número de Tarjeta: " + tarjeta.getNumeroTarjeta() + "\n");
	      	       contador2++;
	      		}
	      	}
	            
	        
	        String os = System.getProperty("os.name").toLowerCase();
	        if (os.contains("win")) {
	            Runtime.getRuntime().exec(new String[] {"cmd.exe", "/c", "start", rutaArchivo});
	        } else if (os.contains("mac")) {
	            Runtime.getRuntime().exec(new String[] {"open", rutaArchivo});
	        } else if (os.contains("nix") || os.contains("nux")) {
	            Runtime.getRuntime().exec(new String[] {"xdg-open", rutaArchivo});
	        }

	    } 
		
	    catch (IOException e) {
	    	System.out.println("Error al generar el archivo: " + e.getMessage());
	    }
	    
	}

}



