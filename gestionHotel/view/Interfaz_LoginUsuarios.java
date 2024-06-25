package view;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Interfaz_LoginUsuarios extends JFrame {

	private JPanel contentPane;

	private JTextField txtIngreseTexto;
	private JPasswordField passwordField;
	private JButton btnSiguiente;
	private JButton btnAtras;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz_Login frame = new Interfaz_Login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Interfaz_LoginUsuarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1180, 683);
		contentPane = new BackgroundPanel011();
		contentPane.setLocation(-303, -94);
		contentPane.setBackground(UIManager.getColor("activeCaption"));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(204, 125, 251));
		panel_1.setBackground(new Color(204, 125, 251));
		panel_1.setBounds(301, 94, 539, 91);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("¡Bienvenido!");
		lblNewLabel.setForeground(new Color(64, 0, 64));
		lblNewLabel.setBackground(new Color(64, 0, 64));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel.setBounds(20, 11, 141, 49);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Por favor ingrese los datos");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(20, 50, 275, 14);
		panel_1.add(lblNewLabel_1);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(301, 94, 539, 407);
		contentPane.add(panel);
		panel.setLayout(null);

		txtIngreseTexto = new JTextField();
		txtIngreseTexto.setForeground(new Color(0, 0, 0));
		txtIngreseTexto.setBackground(new Color(255, 255, 255));
		txtIngreseTexto.setFont(new Font("Calibri", Font.PLAIN, 17));
		txtIngreseTexto.setBounds(29, 145, 483, 41);
		panel.add(txtIngreseTexto);
		txtIngreseTexto.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Usuario");
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(29, 113, 65, 32);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Contraseña");
		lblNewLabel_2_1.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(29, 209, 102, 32);
		panel.add(lblNewLabel_2_1);

		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(0, 0, 0));
		passwordField.setFont(new Font("Calibri", Font.BOLD, 15));
		passwordField.setBackground(new Color(255, 255, 255));
		passwordField.setBounds(29, 240, 483, 41);
		panel.add(passwordField);

		btnSiguiente = new JButton("Iniciar Sesión");
		btnSiguiente.setForeground(new Color(255, 255, 255));
		btnSiguiente.setBackground(new Color(70, 70, 70));
		btnSiguiente.setFont(new Font("Calibri", Font.BOLD, 16));
		btnSiguiente.setBounds(29, 318, 483, 41);
		panel.add(btnSiguiente);
		
		btnAtras = new JButton("Atras\r\n");
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setFont(new Font("Calibri", Font.BOLD, 16));
		btnAtras.setBackground(new Color(70, 70, 70));
		btnAtras.setBounds(31, 22, 81, 36);
		contentPane.add(btnAtras);
		
	}
	public JTextField getTxtMail() {
		return txtIngreseTexto;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JButton getBtnSiguiente() {
		return btnSiguiente;
	}

	public JButton getBtnAtras() {
		return btnAtras;
	}
}

class BackgroundPanel011 extends JPanel {
	private Image backgroundImage;

	public BackgroundPanel011() {
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