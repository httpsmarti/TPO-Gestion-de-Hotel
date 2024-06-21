package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interfaz_ClienteABM extends JFrame {

	private JPanel contentPane;
	private JTable table;
	static DefaultTableModel tablaFuncional = new DefaultTableModel();
	private JButton btnAgregarCliente;
	private JButton btnModificarCliente;
	private JButton btnEliminarCliente;
	private JButton btnAtras;
	private JScrollPane scrollPane;

	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz_ClienteABM frame = new Interfaz_ClienteABM();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Interfaz_ClienteABM() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1180, 683);
		contentPane = new BackgroundPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1164, 115);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Interfaz_ReservaEnGerente.class.getResource("/img/BostonResort (6).png")));
		lblNewLabel_1.setBounds(0, 0, 1164, 115);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(206, 157, 255), new Color(226, 198, 255), new Color(226, 198, 255), new Color(226, 198, 255)));
		panel_1.setBackground(new Color(206, 157, 255));
		panel_1.setLayout(null);
		panel_1.setBounds(0, 123, 1164, 43);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Crear Cliente");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNewLabel.setBounds(564, 11, 106, 32);
		panel_1.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBackground(new Color(206, 157, 255));
		panel_3.setBounds(0, 588, 1164, 56);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		btnAtras = new JButton("Atrás");
		/*
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
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
		scrollPane.setBounds(285, 238, 649, 219);
		contentPane.add(scrollPane);

		// Definir las columnas antes de establecer el modelo en la tabla
		if (tablaFuncional.getColumnCount() == 0) {
        tablaFuncional.addColumn("Nombre");
        tablaFuncional.addColumn("Apellido");
        tablaFuncional.addColumn("DNI");
        tablaFuncional.addColumn("Edad");
        tablaFuncional.addColumn("Mail");
        tablaFuncional.addColumn("Contacto");
		}

        table = new JTable(tablaFuncional);
        table.setFont(new Font("Calibri", Font.PLAIN, 12));
        table.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(table);
		
		btnAgregarCliente = new JButton("Agregar Cliente");
		btnAgregarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		/*
		btnAgregarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interfaz_AgregarCliente agregarC = new Interfaz_AgregarCliente();
				agregarC.setVisible(true);
				agregarC.setLocationRelativeTo(null); // Centrar la ventana secundaria
			}
		});*/
		
		btnAgregarCliente.setForeground(Color.WHITE);
		btnAgregarCliente.setBackground(Color.DARK_GRAY);
		btnAgregarCliente.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnAgregarCliente.setBounds(348, 488, 153, 43);
		contentPane.add(btnAgregarCliente);
		
		btnModificarCliente = new JButton("Modificar Cliente");
		btnModificarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
			/*Interfaz_ModificarCliente modificarC = new Interfaz_ModificarCliente();
				modificarC.setVisible(true);
				modificarC.setLocationRelativeTo(null); // Centrar la ventana secundaria*/
		});
		
		
		btnModificarCliente.setForeground(Color.WHITE);
		btnModificarCliente.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnModificarCliente.setBackground(Color.DARK_GRAY);
		btnModificarCliente.setBounds(536, 488, 153, 43);
		contentPane.add(btnModificarCliente);
		
		btnEliminarCliente = new JButton("Eliminar Cliente");
		btnEliminarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		/*Interfaz_EliminarCliente eliminarC = new Interfaz_EliminarCliente();
		eliminarC.setVisible(true);
		eliminarC.setLocationRelativeTo(null); // Centrar la ventana secundaria*/
		
		btnEliminarCliente.setForeground(Color.WHITE);
		btnEliminarCliente.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnEliminarCliente.setBackground(Color.DARK_GRAY);
		btnEliminarCliente.setBounds(722, 488, 153, 43);
		contentPane.add(btnEliminarCliente);
	}
	
	public JTable getTable() {
		return table;
	}

	public static DefaultTableModel getTablaFuncional() {
		return tablaFuncional;
	}

	public JButton getBtnAgregarCliente() {
		return btnAgregarCliente;
	}
	public JButton getBtnModificarCliente() {
		return btnModificarCliente;
	}

	public JButton getBtnEliminarCliente() {
		return btnEliminarCliente;
	}


	public JButton getBtnAtras() {
		return btnAtras;
	}
	
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	
}

class BackgroundPanel9 extends JPanel {
	private Image backgroundImage;

	public BackgroundPanel9() {
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
