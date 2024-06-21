package view;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.TableModel;
import javax.swing.JTextField;

public class Interfaz_ReservarHabitacion extends JFrame {
	
	static DefaultTableModel tablaFuncional = new DefaultTableModel();
	static DefaultTableModel tablaFuncional2 = new DefaultTableModel();
	private JPanel contentPane;

	private JTable tablaHabitacionesDispo;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JButton btnSiguiente; 
	private JButton btnAtras;
	private JTable tablaHabitacionSeleccionada;
	private JTextField textDNICliente;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz_ReservarHabitacion frame = new Interfaz_ReservarHabitacion();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Interfaz_ReservarHabitacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1180, 683);
		contentPane = new BackgroundPanel3();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1164, 115);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Interfaz_ReservarHabitacion.class.getResource("/img/BostonResort (6).png")));
		lblNewLabel_1.setBounds(0, 0, 1164, 115);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(206, 157, 255), new Color(226, 198, 255), new Color(226, 198, 255), new Color(226, 198, 255)));
		panel_1.setBackground(new Color(206, 157, 255));
		panel_1.setLayout(null);
		panel_1.setBounds(0, 123, 1164, 43);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Seleccione Habitación");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel.setBounds(482, 7, 197, 32);
		panel_1.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBackground(new Color(206, 157, 255));
		panel_3.setBounds(0, 588, 1164, 56);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		btnSiguiente = new JButton("Siguiente");
		/*
		btnSiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Interfaz_Detalle siguiente = new Interfaz_Detalle();
				siguiente.setVisible(true);
				siguiente.setLocationRelativeTo(null); // Centrar la nueva ventana
                dispose(); // Cerrar la ventana actual si lo deseas
            }
        });*/
		
		btnSiguiente.setForeground(new Color(255, 255, 255));
		btnSiguiente.setBackground(new Color(63, 63, 63));
		btnSiguiente.setFont(new Font("Calibri", Font.BOLD, 14));
		btnSiguiente.setBounds(1042, 11, 89, 34);
		panel_3.add(btnSiguiente);
		
		btnAtras = new JButton("Atrás");
		/*
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
        		Interfaz_PaginaGerente atras = new Interfaz_PaginaGerente();
        		atras.setVisible(true);
        		atras.setLocationRelativeTo(null); // Centrar la nueva ventana
                dispose(); // Cerrar la ventana actual si lo deseas
        
                
         HOLA JOACO ACA NECESITAMOS QUE CUANDO TOQUE EL BOTON DE ATRAS EN LA INTERFAZ DE RESERVA DESDE CLIENTE, ME REDIRIJA AL INICIO DE INTERFAZ DE CLIENTE, NO DE GERENTE
         
         ACA TE INSERTO EL CODIGO DE CUANDO TOQUE ATRAS ME LLEVE A CLIENTE (ESTO ES LO IMPORTANTE)
         public void mouseClicked(MouseEvent e) {
        		Interfaz_PaginaCliente atras = new Interfaz_PaginaCliente();
        		atras.setVisible(true);
        		atras.setLocationRelativeTo(null); // Centrar la nueva ventana
                dispose(); // Cerrar la ventana actual si lo deseas
         
         --------------------------------------------------------------------------------------------------------------------
         POR LAS DUDAS, (NO CREO Q LO NECESITES PERO IGUAL) TE DEJO LO MISMO PERO CUANDO TE LLEVE A GERENTE
          public void mouseClicked(MouseEvent e) {
        		Interfaz_PaginaGerente atras = new Interfaz_PaginaGerente();
        		atras.setVisible(true);
        		atras.setLocationRelativeTo(null); // Centrar la nueva ventana
                dispose(); // Cerrar la ventana actual si lo deseas

            }
        });*/
		
        btnAtras.setBackground(new Color(63, 63, 63));
        btnAtras.setForeground(new Color(255, 255, 255));
        btnAtras.setFont(new Font("Calibri", Font.PLAIN, 14));
        btnAtras.setBounds(22, 177, 76, 34);
        contentPane.add(btnAtras);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(231, 240, 752, 136);
        contentPane.add(scrollPane);

        // Definir las columnas antes de establecer el modelo en la tabla
        if (tablaFuncional.getColumnCount() == 0) {
            tablaFuncional.addColumn("Código");
            tablaFuncional.addColumn("Precio");
            tablaFuncional.addColumn("Cantidad Personas");
            tablaFuncional.addColumn("Extras");
            tablaFuncional.addColumn("Disponible");
        }

        tablaHabitacionesDispo = new JTable(tablaFuncional);
        tablaHabitacionesDispo.setFont(new Font("Calibri", Font.PLAIN, 12));
        tablaHabitacionesDispo.setBackground(new Color(255, 255, 255));
        scrollPane.setViewportView(tablaHabitacionesDispo);

        scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(231, 423, 752, 136);
        contentPane.add(scrollPane_1);

        if (tablaFuncional2.getColumnCount() == 0) {
            tablaFuncional2.addColumn("Código");
            tablaFuncional2.addColumn("Precio");
            tablaFuncional2.addColumn("Cantidad Personas");
            tablaFuncional2.addColumn("Extras");
            tablaFuncional2.addColumn("Disponible");
        }

        tablaHabitacionSeleccionada = new JTable(tablaFuncional2);
        tablaHabitacionSeleccionada.setFont(new Font("Calibri", Font.PLAIN, 12));
        tablaHabitacionSeleccionada.setBackground(Color.WHITE);
        scrollPane_1.setViewportView(tablaHabitacionSeleccionada);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(22, 349, 186, 94);
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        textDNICliente = new JTextField();
        textDNICliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textDNICliente.setBounds(15, 38, 159, 34);
        panel_2.add(textDNICliente);
        textDNICliente.setColumns(10);
        
                JLabel lblNewLabel_2 = new JLabel("Ingrese DNI del Cliente:");
                lblNewLabel_2.setBounds(14, 11, 173, 26);
                panel_2.add(lblNewLabel_2);
                lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 16));

        JLabel lblHabitacionesDisponibles = new JLabel("Habitaciones Disponibles");
        lblHabitacionesDisponibles.setFont(new Font("Calibri", Font.BOLD, 16));
        lblHabitacionesDisponibles.setBounds(231, 208, 224, 32);
        contentPane.add(lblHabitacionesDisponibles);
		
		JLabel lblHabitacinSeleccionada = new JLabel("Habitación Seleccionada");
		lblHabitacinSeleccionada.setFont(new Font("Calibri", Font.BOLD, 16));
		lblHabitacinSeleccionada.setBounds(231, 387, 224, 32);
		contentPane.add(lblHabitacinSeleccionada);
	}
	
	public DefaultTableModel getTablaFuncional() {
		return tablaFuncional;
	}

	public JButton getBtnSiguiente() {
		return btnSiguiente;
	}

	public JButton getBtnAtras() {
		return btnAtras;
	}
	
	public static DefaultTableModel getTablaFuncional2() {
		return tablaFuncional2;
	}

	public JTable getTablaHabitacionesDispo() {
		return tablaHabitacionesDispo;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JScrollPane getScrollPane_1() {
		return scrollPane_1;
	}

	public JTable getTablaHabitacionSeleccionada() {
		return tablaHabitacionSeleccionada;
	}

	public JTextField getTextDNICliente() {
		return textDNICliente;
	}
}

class BackgroundPanel3 extends JPanel {
	private Image backgroundImage;

	public BackgroundPanel3() {
		// Cargar la imagen
		ImageIcon icon = new ImageIcon("C:\\Users\\marti\\Documents\\GitHub\\Gestion-Hotel\\gestionHoteles\\img\\blob-login.png");
		backgroundImage = icon.getImage();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Dibujar la imagen escalada para llenar todo el panel
		g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	}
}
