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
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interfaz_MiReserva extends JFrame {
	
	static DefaultTableModel tablaFuncional = new DefaultTableModel();
	static DefaultTableModel tablaFuncional2 = new DefaultTableModel();
	private JPanel contentPane;

	private JTable tablaHabitacionesDispo;
	private JScrollPane scrollPane;
	private JButton btnSiguiente; 
	private JButton btnAtras;
	private JButton btnEliminarReserva;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz_MiReserva frame = new Interfaz_MiReserva();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Interfaz_MiReserva() {
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
		lblNewLabel_1.setIcon(new ImageIcon(Interfaz_MiReserva.class.getResource("/img/BostonResort (6).png")));
		lblNewLabel_1.setBounds(0, 0, 1164, 115);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(206, 157, 255), new Color(226, 198, 255), new Color(226, 198, 255), new Color(226, 198, 255)));
		panel_1.setBackground(new Color(206, 157, 255));
		panel_1.setLayout(null);
		panel_1.setBounds(-3, 121, 1170, 56);
		contentPane.add(panel_1);
		
		btnAtras = new JButton("Atrás");
		btnAtras.setBounds(21, 11, 76, 34);
		panel_1.add(btnAtras);
		
        btnAtras.setBackground(new Color(63, 63, 63));
        btnAtras.setForeground(new Color(255, 255, 255));
        btnAtras.setFont(new Font("Calibri", Font.PLAIN, 14));
        
	    JLabel lblHabitacionesDisponibles = new JLabel("Reservas Realizadas");
	    lblHabitacionesDisponibles.setBounds(494, 11, 178, 32);
	    panel_1.add(lblHabitacionesDisponibles);
	    lblHabitacionesDisponibles.setFont(new Font("Calibri", Font.BOLD, 20));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBackground(new Color(206, 157, 255));
		panel_3.setBounds(0, 588, 1164, 56);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		

        scrollPane = new JScrollPane();
        scrollPane.setBounds(198, 240, 792, 203);
        contentPane.add(scrollPane);

        // Definir las columnas antes de establecer el modelo en la tabla
        if (tablaFuncional.getColumnCount() == 0) {
            tablaFuncional.addColumn("Código");
            tablaFuncional.addColumn("Cliente");
            tablaFuncional.addColumn("Check In");
            tablaFuncional.addColumn("Check Out");
            tablaFuncional.addColumn("Huéspedes");
            tablaFuncional.addColumn("Medio de Pago");
            tablaFuncional.addColumn("Estado");
        }

        tablaHabitacionesDispo = new JTable(tablaFuncional);
        tablaHabitacionesDispo.setFont(new Font("Calibri", Font.PLAIN, 12));
        tablaHabitacionesDispo.setBackground(new Color(255, 255, 255));
        scrollPane.setViewportView(tablaHabitacionesDispo);

        btnEliminarReserva = new JButton("Eliminar Reserva");
        /*btnEliminarReserva.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Interfaz_EliminarReserva eReserva = new Interfaz_EliminarReserva();
        		eReserva.setVisible(true);
        		eReserva.setLocationRelativeTo(null); // Centrar la ventana secundaria
        	}
        });*/
        btnEliminarReserva.setForeground(Color.WHITE);
        btnEliminarReserva.setFont(new Font("Calibri", Font.PLAIN, 14));
        btnEliminarReserva.setBackground(new Color(63, 63, 63));
        btnEliminarReserva.setBounds(534, 470, 142, 39);
        contentPane.add(btnEliminarReserva);
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

	public JTable getTablaHabitacionesDispo() {
		return tablaHabitacionesDispo;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public JButton getBtnEliminarReserva() {
		return btnEliminarReserva;
	}
}

class BackgroundPanel02 extends JPanel {
	private Image backgroundImage;

	public BackgroundPanel02() {
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
