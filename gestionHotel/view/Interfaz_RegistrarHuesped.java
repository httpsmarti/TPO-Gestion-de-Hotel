package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class Interfaz_RegistrarHuesped extends JFrame {

    private JPanel contentPane;
	private JTextField textNombre;
    private JTextField textApellido;
    private JTextField textDNI;
    private JButton btnRegistrar;

    public Interfaz_RegistrarHuesped() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 607, 408);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(206, 140, 255));
        contentPane.setForeground(new Color(206, 140, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Registrar Huésped");
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 16));
        lblNewLabel.setBounds(339, 63, 129, 20);
        contentPane.add(lblNewLabel);
        
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre.setBounds(231, 118, 61, 17);
        contentPane.add(lblNombre);
        
        textNombre = new JTextField();
        textNombre.setBounds(302, 114, 247, 20);
        contentPane.add(textNombre);
        textNombre.setColumns(10);
        
        JPanel panel = new JPanel();
        panel.setBounds(10, 11, 192, 311);
        contentPane.add(panel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(231, 198, 255));
        panel_1.setBounds(-3, 332, 595, 38);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBackground(new Color(255, 255, 255));
        btnRegistrar.setBounds(480, 8, 93, 23);
        panel_1.add(btnRegistrar);
        
        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblApellido.setBounds(231, 162, 61, 17);
        contentPane.add(lblApellido);
        
        textApellido = new JTextField();
        textApellido.setColumns(10);
        textApellido.setBounds(302, 158, 247, 20);
        contentPane.add(textApellido);
        
        JLabel lblNombre_1_1 = new JLabel("DNI:");
        lblNombre_1_1.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1.setBounds(231, 206, 61, 17);
        contentPane.add(lblNombre_1_1);
        
        textDNI = new JTextField();
        textDNI.setColumns(10);
        textDNI.setBounds(302, 202, 247, 20);
        contentPane.add(textDNI);
    }

	public JTextField getTextNombre() {
		return textNombre;
	}

	public JTextField getTextApellido() {
		return textApellido;
	}

	public JTextField getTextDNI() {
		return textDNI;
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

}
