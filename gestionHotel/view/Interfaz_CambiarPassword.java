package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class Interfaz_CambiarPassword extends JFrame {

    private JPanel contentPane;
	private JButton btnCambiar;
    private JTextField textPassword;

    public Interfaz_CambiarPassword() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 647, 443);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(206, 140, 255));
        contentPane.setForeground(new Color(206, 140, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Cambar Contraseña");
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 17));
        lblNewLabel.setBounds(332, 43, 155, 20);
        contentPane.add(lblNewLabel);
        
        JPanel panel = new JPanel();
        panel.setBounds(10, 26, 178, 309);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("\r\n");
        lblNewLabel_1.setIcon(new ImageIcon(Interfaz_CambiarPassword.class.getResource("/img/vistaBoston.png")));
        lblNewLabel_1.setBounds(0, -16, 192, 340);
        panel.add(lblNewLabel_1);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(231, 198, 255));
        panel_1.setBounds(0, 362, 640, 49);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        btnCambiar = new JButton("Cambiar");
        btnCambiar.setFont(new Font("Calibri", Font.PLAIN, 13));
        btnCambiar.setBackground(new Color(255, 255, 255));
        btnCambiar.setBounds(505, 11, 93, 23);
        panel_1.add(btnCambiar);
        
        JLabel lblNombre_1_1_1 = new JLabel("Contaseña:");
        lblNombre_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1_1.setBounds(276, 161, 98, 17);
        contentPane.add(lblNombre_1_1_1);
        
        textPassword = new JTextField();
        textPassword.setColumns(10);
        textPassword.setBounds(360, 154, 155, 26);
        contentPane.add(textPassword);
    }

	public JButton getBtnCambiar() {
		return btnCambiar;
	}

	public JTextField getTextPassword() {
		return textPassword;
	}

}