package project;

import java.util.*;

class ClientesRegistrados
{
  private DatosPersonales datosPersonales;
  private DatosContacto datosContacto;
  private PlanesDisponibles plan;
  private Equipo equipo;

  public Cliente ClienteRegistrado1()
  {
    datosPersonales = new DatosPersonales("Alonso Pérez", "01/01/1990", "Calle 123, Ciudad", 12345428, "12.975.678-9");
    datosContacto = new DatosContacto("Calle 456, Ciudad", "555-1234", "oqibz@example.com");
    plan = new PlanesDisponibles("Plan Económico", 8000, false, 60, false, 0, false, 1);
    equipo = new Equipo("Samsung", "Galaxy S21", 12345);
    Cliente cliente = new Cliente(datosPersonales, datosContacto, plan, equipo);
    cliente.agregarFactura("101", 8000, "05/05/2023", true);
    cliente.agregarFactura("102", 8000, "05/06/2023", true);
    cliente.agregarFactura("103", 8000, "05/07/2023", false);
    cliente.agregarFactura("104", 8000, "05/08/2023", false);
    cliente.agregarTarjeta(1, 2, "Alonso Pérez", "1234-5678-9012" , "05/2023", "123");
    cliente.agregarTarjeta(1, 3, "Alonso Pérez", "157-5678-473" , "11/2023", "753");
    return cliente;
  }

  public Cliente ClienteRegistrado2()
  {
    datosPersonales = new DatosPersonales("María García", "15/05/1985", "Avenida Principal, Ciudad", 23456789, "23.456.789-0");
    datosContacto = new DatosContacto("Avenida Secundaria, Ciudad", "555-5678", "tugrp@example.com");
    plan = new PlanesDisponibles("Plan Básico", 12000, false, 120, false, 30, false, 5);
    equipo = new Equipo("Apple", "iPhone 13", 67890);
    Cliente cliente = new Cliente(datosPersonales, datosContacto, plan, equipo);
    cliente.agregarFactura("165", 15000.0, "01/06/2023", false);
    cliente.agregarFactura("278", 25000.0, "01/07/2023", true);
    cliente.agregarTarjeta(2, 3, "María García", "2345-6789-0123" , "05/2023", "456");
    return cliente;
  }

  public Cliente ClienteRegistrado3()
  {
    datosPersonales = new DatosPersonales("Carlitos Paredes", "27/04/2011", "Calle Falsa 123", 2715123, "20.382.115-k");
    datosContacto = new DatosContacto("Calle Falsa 123", "973812212", "carlitos2781@gmail.com");
    plan = new PlanesDisponibles("Plan Básico", 12000, false, 120, false, 30, false, 5);
    equipo = new Equipo("Samsung", "Galaxy S20", 123456);
    Cliente cliente = new Cliente(datosPersonales, datosContacto, plan, equipo);
    cliente.agregarFactura("185", 15000.0, "05/06/2021", false);
    cliente.agregarFactura("230", 25000.0, "05/07/2021", true);
    cliente.agregarTarjeta(1, 2, "Carlitos Paredes", "649-857-2751" , "05/2023", "764");
    return cliente;
  }

  public Cliente ClienteRegistrado4()
  {
    datosPersonales = new DatosPersonales("Mauris Romagnoli", "15/09/1087", "Calle Falsa 321", 2715123, "18.556.139-6");
    datosContacto = new DatosContacto("Calle Falsa 321", "981342172", "Maurisroma87@gmail.com");
    plan = new PlanesDisponibles("Plan Premium", 20000, true, 0, true, 0, true, 0);
    equipo = new Equipo("Xiaomi", "Mi 13", 45687);
    Cliente cliente = new Cliente(datosPersonales, datosContacto, plan, equipo);
    cliente.agregarFactura("197", 20000.0, "02/06/2023", true);
    cliente.agregarFactura("223", 20000.0, "02/07/2023", true);
    cliente.agregarFactura("491", 20000.0, "02/08/2023", true);
    cliente.agregarFactura("370", 20000.0, "02/09/2023", false);
    cliente.agregarTarjeta(1, 2, "Mauris Romagnoli", "6485-7589-6485" , "07/2023", "279");
    cliente.agregarTarjeta(1, 1, "Mauris Romagnoli", "7689-5678-9012" , "05/2024", "753");
    cliente.agregarTarjeta(1, 1, "Mauris Romagnoli", "3596-5798-4725" , "05/2023", "965");
    return cliente;
  }
}