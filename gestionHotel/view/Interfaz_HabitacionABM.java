package view;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Interfaz_HabitacionABM extends JFrame {

	private JPanel contentPane;
	private JTable table;
	static DefaultTableModel tablaFuncional = new DefaultTableModel();
	private JButton btnAgregarHabitacion;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz_HabitacionABM frame = new Interfaz_HabitacionABM();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Interfaz_HabitacionABM() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1180, 683);
		contentPane = new BackgroundPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(94, 132, 810, 417);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setForeground(new Color(255, 255, 255));
        table.setModel(tablaFuncional);
        scrollPane.setViewportView(table);
        // poner el if cant columnas == 0
        tablaFuncional.addColumn("Código");
        tablaFuncional.addColumn("Habitacion");
        tablaFuncional.addColumn("Descripción");
        tablaFuncional.addColumn("Cantidad Personas");
        tablaFuncional.addColumn("Tipo");
        tablaFuncional.addColumn("Precio");
        tablaFuncional.addColumn("Activo");

        btnAgregarHabitacion = new JButton("Agregar Habitación");
        /*btnAgregarHabitacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mostrar la ventana de Agregar Habitación
                Interfaz_AgregarHabitacion agregarHabitacion = new Interfaz_AgregarHabitacion();
                agregarHabitacion.setVisible(true);
                agregarHabitacion.setLocationRelativeTo(null); // Centrar la ventana secundaria
            }
        });*/

        
        btnAgregarHabitacion.setForeground(new Color(128, 0, 128));
        btnAgregarHabitacion.setFont(new Font("Calibri", Font.PLAIN, 16));
        btnAgregarHabitacion.setBackground(new Color(255, 255, 255));
        btnAgregarHabitacion.setBounds(946, 258, 181, 40);
        contentPane.add(btnAgregarHabitacion);

        JButton btnEliminarHabitacion = new JButton("Eliminar Habitación");
        btnEliminarHabitacion.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                // Mostrar la ventana de Agregar Habitación
        		Interfaz_EliminarHabitacion eliminarHabitacion = new Interfaz_EliminarHabitacion();
        		eliminarHabitacion.setVisible(true);
        		eliminarHabitacion.setLocationRelativeTo(null); // Centrar la ventana secundaria
            }
        });
        
        btnEliminarHabitacion.setForeground(new Color(128, 0, 128));
        btnEliminarHabitacion.setFont(new Font("Calibri", Font.PLAIN, 16));
        btnEliminarHabitacion.setBackground(Color.WHITE);
        btnEliminarHabitacion.setBounds(946, 327, 181, 40);
        contentPane.add(btnEliminarHabitacion);

        JButton btnModificarHabitacion = new JButton("Modificar Habitación");
        btnModificarHabitacion.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                // Mostrar la ventana de Agregar Habitación
        		Interfaz_ModificarHabitacion modificarHabitacion = new Interfaz_ModificarHabitacion();
        		modificarHabitacion.setVisible(true);
        		modificarHabitacion.setLocationRelativeTo(null); // Centrar la ventana secundaria
            }
        });
        
        btnModificarHabitacion.setForeground(new Color(128, 0, 128));
        btnModificarHabitacion.setFont(new Font("Calibri", Font.PLAIN, 16));
        btnModificarHabitacion.setBackground(Color.WHITE);
        btnModificarHabitacion.setBounds(946, 394, 181, 40);
        contentPane.add(btnModificarHabitacion);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(199, 111, 251));
        panel.setBounds(0, 0, 1164, 66);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("¿Que operación desea realizar?");
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        lblNewLabel.setBounds(430, 23, 286, 23);
        panel.add(lblNewLabel);
        
        JButton btnAtras = new JButton("Atrás");
        btnAtras.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Interfaz_PaginaGerente atras = new Interfaz_PaginaGerente();
        		atras.setVisible(true);
        		atras.setLocationRelativeTo(null); // Centrar la nueva ventana
                dispose(); // Cerrar la ventana actual si lo deseas
            }
        });
        
        btnAtras.setForeground(new Color(255, 255, 255));
        btnAtras.setBackground(new Color(62, 62, 62));
        btnAtras.setFont(new Font("Calibri", Font.BOLD, 16));
        btnAtras.setBounds(20, 21, 77, 28);
        panel.add(btnAtras);
    }
}


class BackgroundPanel2 extends JPanel {
	private Image backgroundImage;

	public BackgroundPanel2() {
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
