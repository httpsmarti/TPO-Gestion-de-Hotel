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
import javax.swing.JTextField;
import javax.swing.DropMode;

public class Interfaz_ModificarPoliticas extends JFrame {

	private JPanel contentPane;
	private JButton btnAplicarCambios;
	private JButton btnAtras;
	private JTextField txtCantDiasTemprano;
	private JTextField txtCantDiasTarde;
	private JTextField txtDescuento;
	private JTextField txtRecargo;

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

	public Interfaz_ModificarPoliticas() {
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
		lblNewLabel_1.setIcon(new ImageIcon(Interfaz_ReservaEnGerente.class.getResource("/img/BostonResort (6).png")));
		lblNewLabel_1.setBounds(0, 0, 1164, 115);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(206, 157, 255), new Color(226, 198, 255), new Color(226, 198, 255), new Color(226, 198, 255)));
		panel_1.setBackground(new Color(206, 157, 255));
		panel_1.setLayout(null);
		panel_1.setBounds(0, 123, 1164, 43);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Modificar Políticas");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNewLabel.setBounds(533, 11, 151, 32);
		panel_1.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBackground(new Color(206, 157, 255));
		panel_3.setBounds(0, 588, 1164, 56);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		btnAplicarCambios = new JButton("Aplicar cambios");
		btnAplicarCambios.setForeground(Color.WHITE);
		btnAplicarCambios.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnAplicarCambios.setBackground(new Color(63, 63, 63));
		btnAplicarCambios.setBounds(962, 11, 161, 34);
		panel_3.add(btnAplicarCambios);
		
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(218, 243, 720, 280);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Cantidad de días temprano:");
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(61, 67, 175, 26);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Cantidad de días tarde:");
		lblNewLabel_2_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(61, 167, 175, 26);
		panel_2.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Descuento (%)");
		lblNewLabel_2_1_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(426, 67, 98, 26);
		panel_2.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Recargo (%)");
		lblNewLabel_2_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1.setBounds(426, 167, 86, 26);
		panel_2.add(lblNewLabel_2_1_1_1);
		
		txtCantDiasTemprano = new JTextField();
		txtCantDiasTemprano.setText("poner algo");
		txtCantDiasTemprano.setBounds(246, 67, 86, 25);
		panel_2.add(txtCantDiasTemprano);
		txtCantDiasTemprano.setColumns(10);
		
		txtCantDiasTarde = new JTextField();
		txtCantDiasTarde.setText("poner algo");
		txtCantDiasTarde.setColumns(10);
		txtCantDiasTarde.setBounds(246, 168, 86, 25);
		panel_2.add(txtCantDiasTarde);
		
		txtDescuento = new JTextField();
		txtDescuento.setText("poner algo");
		txtDescuento.setColumns(10);
		txtDescuento.setBounds(534, 68, 86, 25);
		panel_2.add(txtDescuento);
		
		txtRecargo = new JTextField();
		txtRecargo.setText("poner algo");
		txtRecargo.setColumns(10);
		txtRecargo.setBounds(534, 168, 86, 25);
		panel_2.add(txtRecargo);
	}
	
	
	public JButton getBtnAplicarCambios() {
		return btnAplicarCambios;
	}

	public JButton getBtnAtras() {
		return btnAtras;
	}

	public JTextField getTxtCantDiasTemprano() {
		return txtCantDiasTemprano;
	}

	public JTextField getTxtCantDiasTarde() {
		return txtCantDiasTarde;
	}

	public JTextField getTxtDescuento() {
		return txtDescuento;
	}

	public JTextField getTxtRecargo() {
		return txtRecargo;
	}


}

class BackgroundPanel20 extends JPanel {
	private Image backgroundImage;

	public BackgroundPanel20() {
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
