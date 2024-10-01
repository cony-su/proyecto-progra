package project;
//import javax.swing.JFrame;
//import javax.swing.*; 
//import java.awt.*;
//import java.awt.event.*;


//import javax.swing.JFrame;

public class Ventana
{
	private int a;
    public Ventana()
    {
    	a = 3;
    }
	
}


/*

public class Ventana extends JFrame {
	
	public Ventana() {
		
    	setTitle("Sistema de Telefonía Celular");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 1)); // Para alinear los botones verticalmente
        getContentPane().setBackground(Color.decode("#98FB98")); // Fondo negro
        // Título
        JLabel titleLabel = new JLabel("Bienvenido al Sistema de Telefonía Celular");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        titleLabel.setForeground(Color.WHITE); // Color de texto blanco
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); 
        add(titleLabel);

        // Crear botones con esquinas redondeadas
        JButton btnClientes = createRoundedButton("Mostrar SubMenú de Cliente");
        JButton btnTarjetas = createRoundedButton("Mostrar SubMenú de Tarjeta");
        JButton btnPlanes = createRoundedButton("Mostrar Planes Disponibles");
        JButton btnPagarFactura = createRoundedButton("Pagar Factura");
        JButton btnGenerarReporte = createRoundedButton("Generar Reporte General");
        JButton btnSalir = createRoundedButton("Salir");

        // Agregar botones a la ventana
        add(btnClientes);
        add(btnTarjetas);
        add(btnPlanes);
        add(btnPagarFactura);
        add(btnGenerarReporte);
        add(btnSalir);

        // Acciones de los botones
        btnClientes.addActionListener(e -> mostrarSubMenuClientes());
        btnTarjetas.addActionListener(e -> mostrarSubMenuTarjetas());
        btnPlanes.addActionListener(e -> mostrarPlanesDisponibles());
        btnPagarFactura.addActionListener(e -> pagarFactura());
        btnGenerarReporte.addActionListener(e -> generarReporteGeneral());
        btnSalir.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private JButton createRoundedButton(String text) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(getBackground());
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); // Esquinas redondeadas
                super.paintComponent(g);
            }
        };
        button.setForeground(Color.WHITE);
        button.setBackground(Color.GRAY);
        button.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        button.setFocusPainted(false); // Eliminar el borde del foco
        return button;
    }

    private void mostrarSubMenuClientes() {
        JOptionPane.showMessageDialog(this, "SubMenú de Clientes");
        // Aquí puedes agregar la lógica para mostrar el submenú
    }

    private void mostrarSubMenuTarjetas() {
        JOptionPane.showMessageDialog(this, "SubMenú de Tarjetas");
        // Aquí puedes agregar la lógica para mostrar el submenú
    }

    private void mostrarPlanesDisponibles() {
        JOptionPane.showMessageDialog(this, "Planes Disponibles");
        // Aquí puedes agregar la lógica para mostrar los planes
    }

    private void pagarFactura() {
        JOptionPane.showMessageDialog(this, "Pagar Factura");
        // Aquí puedes agregar la lógica para pagar la factura
    }

    private void generarReporteGeneral() {
        JOptionPane.showMessageDialog(this, "Generar Reporte General");
        // Aquí puedes agregar la lógica para generar el reporte
    }

    public static void main(String[] args) {
        new Ventana();
    }
    
	}
    
}

*/