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

public class Interfaz_Reserva extends JFrame {

	private JPanel contentPane;
	private JTable table;
	static DefaultTableModel tablaFuncional = new DefaultTableModel();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz_Reserva frame = new Interfaz_Reserva();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Interfaz_Reserva() {
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
		lblNewLabel_1.setIcon(new ImageIcon(Interfaz_Reserva.class.getResource("/img/BostonResort (6).png")));
		lblNewLabel_1.setBounds(0, 0, 1164, 115);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(206, 157, 255), new Color(226, 198, 255), new Color(226, 198, 255), new Color(226, 198, 255)));
		panel_1.setBackground(new Color(206, 157, 255));
		panel_1.setLayout(null);
		panel_1.setBounds(0, 123, 1164, 43);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Seleccione Habitación");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNewLabel.setBounds(482, 8, 165, 32);
		panel_1.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBackground(new Color(206, 157, 255));
		panel_3.setBounds(0, 588, 1164, 56);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton = new JButton("Siguiente");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Interfaz_Detalle siguiente = new Interfaz_Detalle();
				siguiente.setVisible(true);
				siguiente.setLocationRelativeTo(null); // Centrar la nueva ventana
                dispose(); // Cerrar la ventana actual si lo deseas
            }
        });
		
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(63, 63, 63));
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 14));
		btnNewButton.setBounds(1042, 11, 89, 34);
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Atrás");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
        		Interfaz_PaginaGerente atras = new Interfaz_PaginaGerente();
        		atras.setVisible(true);
        		atras.setLocationRelativeTo(null); // Centrar la nueva ventana
                dispose(); // Cerrar la ventana actual si lo deseas
            }
        });
		
		btnNewButton_1.setBackground(new Color(63, 63, 63));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnNewButton_1.setBounds(22, 177, 76, 34);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(248, 211, 649, 339);
		contentPane.add(scrollPane);

		// Definir las columnas antes de establecer el modelo en la tabla
        tablaFuncional.addColumn("Habitacion");
        tablaFuncional.addColumn("Descripción");
        tablaFuncional.addColumn("Precio");
        tablaFuncional.addColumn("Activo");

        table = new JTable(tablaFuncional);
        table.setFont(new Font("Calibri", Font.PLAIN, 12));
        table.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(table);		
		
		JLabel lblSeleccioneUna = new JLabel("* Seleccione una habitación para continuar");
		lblSeleccioneUna.setForeground(Color.RED);
		lblSeleccioneUna.setFont(new Font("Calibri", Font.BOLD, 16));
		lblSeleccioneUna.setBounds(837, 561, 297, 26);
		contentPane.add(lblSeleccioneUna);
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
