package view;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interfaz_Login extends JFrame {

	private JPanel contentPane;
	private JButton btnCliente;
	private JButton btnGerente;

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

	public Interfaz_Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1180, 683);
		contentPane = new BackgroundPanel();
		contentPane.setLocation(-303, -94);
		contentPane.setBackground(UIManager.getColor("activeCaption"));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(204, 125, 251));
		panel_1.setBackground(new Color(204, 125, 251));
		panel_1.setBounds(307, 146, 525, 119);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("¡Bienvenido!");
		lblNewLabel.setBounds(193, 38, 141, 49);
		panel_1.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(64, 0, 64));
		lblNewLabel.setBackground(new Color(64, 0, 64));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(307, 264, 525, 276);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnCliente = new JButton("Cliente");
		

		btnCliente.setForeground(new Color(255, 255, 255));
		btnCliente.setBackground(new Color(70, 70, 70));
		btnCliente.setFont(new Font("Calibri", Font.BOLD, 24));
		btnCliente.setBounds(27, 107, 215, 76);
		panel.add(btnCliente);
		
		JButton btnGerente = new JButton("Gerente");
		
		
		btnGerente.setForeground(Color.WHITE);
		btnGerente.setFont(new Font("Calibri", Font.BOLD, 24));
		btnGerente.setBackground(new Color(70, 70, 70));
		btnGerente.setBounds(280, 107, 215, 76);
		panel.add(btnGerente);
		
		JLabel lblNewLabel_1 = new JLabel("Ingresar como");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(203, 55, 112, 24);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(505, 56, 125, 60);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(Interfaz_Login.class.getResource("/img/logo.png")));
	}
	
    public JButton getBtnCliente() {
        Component[] components = contentPane.getComponents();
        for (Component component : components) {
            if (component instanceof JPanel) {
                Component[] panelComponents = ((JPanel) component).getComponents();
                for (Component panelComponent : panelComponents) {
                    if (panelComponent instanceof JButton && ((JButton) panelComponent).getText().equals("Cliente")) {
                        return (JButton) panelComponent;
                    }
                }
            }
        }
        return null;
    }

    public JButton getBtnGerente() {
        Component[] components = contentPane.getComponents();
        for (Component component : components) {
            if (component instanceof JPanel) {
                Component[] panelComponents = ((JPanel) component).getComponents();
                for (Component panelComponent : panelComponents) {
                    if (panelComponent instanceof JButton && ((JButton) panelComponent).getText().equals("Gerente")) {
                        return (JButton) panelComponent;
                    }
                }
            }
        }
        return null;
    }
}

class BackgroundPanel extends JPanel {
	private Image backgroundImage;

	public BackgroundPanel() {
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