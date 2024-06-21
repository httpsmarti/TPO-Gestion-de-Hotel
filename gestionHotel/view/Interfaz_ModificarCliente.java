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

public class Interfaz_ModificarCliente extends JFrame {

    private JPanel contentPane;
    
    private JTextField textNombre;
    private JTextField textApellido;
    private JTextField textDNI;
    private JTextField textEdad;
    private JTextField textTelefono;
    private JTextField textMail;
    private JButton btnGuardar;
    private JComboBox ContactPreferece;

    public Interfaz_ModificarCliente() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 815, 443);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(206, 140, 255));
        contentPane.setForeground(new Color(206, 140, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Modificar Cliente");
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 17));
        lblNewLabel.setBounds(439, 47, 136, 20);
        contentPane.add(lblNewLabel);
        
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre.setBounds(244, 118, 61, 17);
        contentPane.add(lblNombre);
        
        textNombre = new JTextField();
        textNombre.setBounds(315, 114, 149, 26);
        contentPane.add(textNombre);
        textNombre.setColumns(10);
        
        JPanel panel = new JPanel();
        panel.setBounds(10, 11, 192, 340);
        contentPane.add(panel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(231, 198, 255));
        panel_1.setBounds(0, 362, 853, 49);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("Calibri", Font.PLAIN, 13));
        btnGuardar.setBackground(new Color(255, 255, 255));
        btnGuardar.setBounds(667, 11, 93, 23);
        panel_1.add(btnGuardar);
        
        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblApellido.setBounds(488, 118, 61, 17);
        contentPane.add(lblApellido);
        
        textApellido = new JTextField();
        textApellido.setColumns(10);
        textApellido.setBounds(559, 114, 199, 26);
        contentPane.add(textApellido);
        
        JLabel lblNombre_1_1 = new JLabel("DNI:");
        lblNombre_1_1.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1.setBounds(244, 170, 61, 17);
        contentPane.add(lblNombre_1_1);
        
        textDNI = new JTextField();
        textDNI.setColumns(10);
        textDNI.setBounds(315, 166, 149, 26);
        contentPane.add(textDNI);
        
        textEdad = new JTextField();
        textEdad.setColumns(10);
        textEdad.setBounds(559, 166, 199, 26);
        contentPane.add(textEdad);
        
        JLabel lblNombre_1_1_1 = new JLabel("Edad:");
        lblNombre_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1_1.setBounds(488, 170, 61, 17);
        contentPane.add(lblNombre_1_1_1);
        
        textTelefono = new JTextField();
        textTelefono.setColumns(10);
        textTelefono.setBounds(315, 214, 149, 26);
        contentPane.add(textTelefono);
        
        JLabel lblNombre_1_1_1_1 = new JLabel("Teléfono:");
        lblNombre_1_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1_1_1.setBounds(244, 221, 61, 17);
        contentPane.add(lblNombre_1_1_1_1);
        
        textMail = new JTextField();
        textMail.setColumns(10);
        textMail.setBounds(559, 214, 199, 26);
        contentPane.add(textMail);
        
        JLabel lblNombre_1_1_1_1_1 = new JLabel("Mail:");
        lblNombre_1_1_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1_1_1_1.setBounds(488, 221, 61, 17);
        contentPane.add(lblNombre_1_1_1_1_1);
        
        JLabel lblNombre_1_1_1_1_1_1 = new JLabel("Contacto de preferencia:");
        lblNombre_1_1_1_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1_1_1_1_1.setBounds(244, 279, 170, 17);
        contentPane.add(lblNombre_1_1_1_1_1_1);
        
        ContactPreferece = new JComboBox();
        ContactPreferece.setModel(new DefaultComboBoxModel(new String[] {"SMS", "Whatsapp", "Email"}));
        ContactPreferece.setToolTipText("");
        ContactPreferece.setBounds(424, 275, 334, 26);
        contentPane.add(ContactPreferece);
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

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JComboBox getContactPreferece() {
		return ContactPreferece;
	}
    
}