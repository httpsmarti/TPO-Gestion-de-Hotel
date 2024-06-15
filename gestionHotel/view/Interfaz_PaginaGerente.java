package view;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class Interfaz_PaginaGerente extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz_PaginaGerente frame = new Interfaz_PaginaGerente();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Interfaz_PaginaGerente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1180, 683);
		contentPane = new BackgroundPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Interfaz_PaginaGerente.class.getResource("/img/BostonResort (6).png")));
		lblNewLabel_1.setBounds(0, 0, 1164, 115);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(206, 157, 255), new Color(226, 198, 255), new Color(226, 198, 255), new Color(226, 198, 255)));
		panel_1.setBackground(new Color(206, 157, 255));
		panel_1.setBounds(0, 123, 1164, 43);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblbienvenidoqueDesea = new JLabel("¡Bienvenido!, ¿que desea realizar?");
		lblbienvenidoqueDesea.setBounds(447, 6, 269, 32);
		lblbienvenidoqueDesea.setFont(new Font("Calibri", Font.BOLD, 18));
		panel_1.add(lblbienvenidoqueDesea);
		
		JLabel lblNewLabel = new JLabel("Iniciaste Sesión como Gerente");
		lblNewLabel.setBounds(10, 12, 211, 23);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		
		JButton btnABM = new JButton("ABM Habitacion");
		btnABM.setBackground(new Color(255, 255, 255));
		btnABM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Interfaz_HabitacionABM abm = new Interfaz_HabitacionABM();
				abm.setVisible(true);
				abm.setLocationRelativeTo(null); // Centrar la nueva ventana
                dispose(); // Cerrar la ventana actual si lo deseas
            }
        });
		
		btnABM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnABM.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnABM.setBounds(155, 289, 228, 215);
		contentPane.add(btnABM);
		
		JButton btnReserva = new JButton("Realizar Reserva");
		btnReserva.setBackground(new Color(255, 255, 255));
		btnReserva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Interfaz_Reserva reserva = new Interfaz_Reserva();
				reserva.setVisible(true);
				reserva.setLocationRelativeTo(null); // Centrar la nueva ventana
                dispose(); // Cerrar la ventana actual si lo deseas
            }
        });
		
		btnReserva.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReserva.setBounds(474, 289, 228, 215);
		contentPane.add(btnReserva);
		
		JButton btnCerrarSession = new JButton("Cerrar Sesión");
		btnCerrarSession.setBackground(new Color(255, 255, 255));
		btnCerrarSession.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Interfaz_Login logout = new Interfaz_Login();
        		logout.setVisible(true);
        		logout.setLocationRelativeTo(null); // Centrar la nueva ventana
                dispose(); // Cerrar la ventana actual si lo deseas
            }
        });
		
		btnCerrarSession.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnCerrarSession.setBounds(787, 289, 228, 215);
		contentPane.add(btnCerrarSession);
	}
}

class BackgroundPanel7 extends JPanel {
	private Image backgroundImage;

	public BackgroundPanel7() {
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
