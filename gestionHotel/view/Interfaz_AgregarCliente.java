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

public class Interfaz_AgregarCliente extends JFrame {

    private JPanel contentPane;
    
    private JTextField textNombre;
    private JTextField textApellido;
    private JTextField textDNI;
    private JTextField textEdad;
    private JTextField textTelefono;
    private JTextField textMail;
    private JButton btnRegistrar;
    private JComboBox ContactPreferece;
    private JTextField textPassword;


	public Interfaz_AgregarCliente() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 815, 443);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(206, 140, 255));
        contentPane.setForeground(new Color(206, 140, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Registrar Cliente");
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 17));
        lblNewLabel.setBounds(439, 47, 120, 20);
        contentPane.add(lblNewLabel);
        
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre.setBounds(238, 124, 61, 17);
        contentPane.add(lblNombre);
        
        textNombre = new JTextField();
        textNombre.setBounds(319, 117, 149, 26);
        contentPane.add(textNombre);
        textNombre.setColumns(10);
        
        JPanel panel = new JPanel();
        panel.setBounds(20, 31, 180, 303);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(Interfaz_AgregarCliente.class.getResource("/img/vistaBoston.png")));
        lblNewLabel_1.setBounds(0, -20, 182, 340);
        panel.add(lblNewLabel_1);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(231, 198, 255));
        panel_1.setBounds(0, 362, 853, 49);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setFont(new Font("Calibri", Font.PLAIN, 13));
        btnRegistrar.setBackground(new Color(255, 255, 255));
        btnRegistrar.setBounds(667, 11, 93, 23);
        panel_1.add(btnRegistrar);
        
        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblApellido.setBounds(499, 104, 61, 17);
        contentPane.add(lblApellido);
        
        textApellido = new JTextField();
        textApellido.setColumns(10);
        textApellido.setBounds(570, 100, 199, 26);
        contentPane.add(textApellido);
        
        JLabel lblNombre_1_1 = new JLabel("DNI:");
        lblNombre_1_1.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1.setBounds(238, 173, 61, 17);
        contentPane.add(lblNombre_1_1);
        
        textDNI = new JTextField();
        textDNI.setColumns(10);
        textDNI.setBounds(319, 166, 149, 26);
        contentPane.add(textDNI);
        
        textEdad = new JTextField();
        textEdad.setColumns(10);
        textEdad.setBounds(570, 152, 199, 26);
        contentPane.add(textEdad);
        
        JLabel lblNombre_1_1_1 = new JLabel("Edad:");
        lblNombre_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1_1.setBounds(499, 156, 61, 17);
        contentPane.add(lblNombre_1_1_1);
        
        textTelefono = new JTextField();
        textTelefono.setColumns(10);
        textTelefono.setBounds(570, 248, 199, 26);
        contentPane.add(textTelefono);
        
        JLabel lblNombre_1_1_1_1 = new JLabel("Teléfono:");
        lblNombre_1_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1_1_1.setBounds(499, 255, 61, 17);
        contentPane.add(lblNombre_1_1_1_1);
        
        textMail = new JTextField();
        textMail.setColumns(10);
        textMail.setBounds(570, 200, 199, 26);
        contentPane.add(textMail);
        
        JLabel lblNombre_1_1_1_1_1 = new JLabel("Mail:");
        lblNombre_1_1_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1_1_1_1.setBounds(499, 207, 61, 17);
        contentPane.add(lblNombre_1_1_1_1_1);
        
        JLabel lblNombre_1_1_1_1_1_1 = new JLabel("Contacto de preferencia:");
        lblNombre_1_1_1_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1_1_1_1_1.setBounds(244, 311, 170, 17);
        contentPane.add(lblNombre_1_1_1_1_1_1);
        
        ContactPreferece = new JComboBox();
        ContactPreferece.setModel(new DefaultComboBoxModel(new String[] {"Teléfono", "Whatsapp", "Email"}));
        ContactPreferece.setToolTipText("");
        ContactPreferece.setBounds(424, 307, 334, 26);
        contentPane.add(ContactPreferece);
        
        JLabel lblNombre_1_1_1_1_2 = new JLabel("Contraseña:");
        lblNombre_1_1_1_1_2.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1_1_1_2.setBounds(238, 226, 94, 17);
        contentPane.add(lblNombre_1_1_1_1_2);
        
        textPassword = new JTextField();
        textPassword.setColumns(10);
        textPassword.setBounds(320, 219, 149, 26);
        contentPane.add(textPassword);
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

	public JTextField getTextEdad() {
		return textEdad;
	}

	public JTextField getTextTelefono() {
		return textTelefono;
	}

	public JTextField getTextMail() {
		return textMail;
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public JComboBox getContactPreferece() {
		return ContactPreferece;
	}
	
	public JTextField getTextPassword() {
		return textPassword;
	}
    
}