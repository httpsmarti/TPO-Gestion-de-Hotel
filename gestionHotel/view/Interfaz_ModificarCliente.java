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
        lblNombre.setBounds(241, 173, 61, 17);
        contentPane.add(lblNombre);
        
        textNombre = new JTextField();
        textNombre.setBounds(312, 169, 149, 26);
        contentPane.add(textNombre);
        textNombre.setColumns(10);
        
        JPanel panel = new JPanel();
        panel.setBounds(10, 25, 180, 313);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("\r\n");
        lblNewLabel_1.setIcon(new ImageIcon(Interfaz_ModificarCliente.class.getResource("/img/vistaBoston.png")));
        lblNewLabel_1.setBounds(0, 0, 202, 315);
        panel.add(lblNewLabel_1);
        
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
        lblApellido.setBounds(485, 178, 61, 17);
        contentPane.add(lblApellido);
        
        textApellido = new JTextField();
        textApellido.setColumns(10);
        textApellido.setBounds(556, 174, 199, 26);
        contentPane.add(textApellido);
        
        JLabel lblDNI = new JLabel("DNI:");
        lblDNI.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblDNI.setBounds(381, 110, 61, 17);
        contentPane.add(lblDNI);
        
        textDNI = new JTextField();
        textDNI.setColumns(10);
        textDNI.setBounds(452, 106, 149, 26);
        contentPane.add(textDNI);
        
        textEdad = new JTextField();
        textEdad.setColumns(10);
        textEdad.setBounds(556, 227, 199, 26);
        contentPane.add(textEdad);
        
        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblEdad.setBounds(485, 231, 61, 17);
        contentPane.add(lblEdad);
        
        textTelefono = new JTextField();
        textTelefono.setColumns(10);
        textTelefono.setBounds(312, 227, 149, 26);
        contentPane.add(textTelefono);
        
        JLabel lbltelefono = new JLabel("Teléfono:");
        lbltelefono.setFont(new Font("Calibri", Font.PLAIN, 16));
        lbltelefono.setBounds(241, 234, 61, 17);
        contentPane.add(lbltelefono);
        
        textMail = new JTextField();
        textMail.setColumns(10);
        textMail.setBounds(556, 281, 199, 26);
        contentPane.add(textMail);
        
        JLabel lblmail = new JLabel("Mail:");
        lblmail.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblmail.setBounds(485, 281, 61, 17);
        contentPane.add(lblmail);
        
        JLabel lblNombre_1_1_1_1_1_1 = new JLabel("Contacto:");
        lblNombre_1_1_1_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1_1_1_1_1.setBounds(241, 281, 69, 17);
        contentPane.add(lblNombre_1_1_1_1_1_1);
        
        ContactPreferece = new JComboBox();
        ContactPreferece.setModel(new DefaultComboBoxModel(new String[] {"Teléfono", "Whatsapp", "Email"}));
        ContactPreferece.setToolTipText("");
        ContactPreferece.setBounds(312, 274, 149, 26);
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