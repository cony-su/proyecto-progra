package project;

//cuando ingresan letras en vez de numeros
public class Excep1 extends Exception
{
	public Excep1()
	{
		super("Opción inválida, por favor ingrese un número valido");
	}
}



//IMPLEMENTCION
BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

//Validacion de nombre con apellido
System.out.println("Ingrese su nombre y apellido (con mayusculas)");
String nombre = buffer.readLine();

if (!nombre.matches("^[A-Z].*"))
{
throw new Excepciones("El nombre no es valida");
}

else
System.out.println("Se ingreso su Nombre y apellido con exito");

//Validacion de gmail (editable)
System.out.println("Ingrese su gmail");
String mail = buffer.readLine();

if (!mail.matches("[\\w\\d.%+-]+@gmail.+[\\w]{2,6}"))
{
throw new Excepciones("El gmail no es valida");
}

else
System.out.println("Se ingreso su gmail con exito");

//Validacion numeros de tarjeta
System.out.println("Ingrese su tarjeta");
String tarjeta = buffer.readLine();

if (!tarjeta.matches("\\d{16}"))
{
throw new Excepciones("La tarteja no es valida");
}

else
System.out.println("Se ingreso su tarjeta con exito");

//Validacion numeros del reverso de tarjeta
System.out.println("Ingrese el numero del reverso de su tarjeta");
String n_r_tarjeta = buffer.readLine();

if (!n_r_tarjeta.matches("\\d{3}"))
{
throw new Excepciones("El numero del reverso de su tarteja no es valida");
}

else
System.out.println("Se ingreso el numero del reverso de su su tarjeta con exito");

//Validacion caducidad de tarjeta
System.out.println("Ingrese la fecha de caducidad de su tarjeta (dd/mm/yyyy)");
String fecha_caducidad = buffer.readLine();

if (!fecha_caducidad.matches("^(0[1-9]|[12][0-9]|3[01])/(1[0-2]|0[0-9])/(202[4-9]|20[3-9][0-9])$"))
{
throw new Excepciones("La fecha de caducidad de su tarjeta no es valida o ha caducado");
}

else
System.out.println("Se ingreso la fecha de caducidad de su tarjeta con exito");

//Validacion numero telefonico
System.out.println("Ingrese su numero telefonico (+56 9 XXXX XXXX)");
String numero_telefonico = buffer.readLine();

if (!numero_telefonico.matches("^\\+56 9 [0-9]{4} [0-9]{4}$"))
{
throw new Excepciones("El numero telefonico no es valido");
}

else
System.out.println("Se ingreso su numero telefonico con exito");