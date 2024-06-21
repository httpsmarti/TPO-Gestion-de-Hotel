package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Interfaz_AgregarHabitacion extends JFrame {

    private JPanel contentPane;
	private JTextField textDNI;
    private JSpinner spPrecio;
    private JTextField txtCodigo;
    private JButton btnAgregar;
	private JComboBox comboBoxDisponible;
    private JTextField textExtras;
    private JComboBox comboBoxTipo;
    private JSpinner spCantPersonas;
    
    
 Interfaz_AgregarHabitacion() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 607, 408);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(206, 140, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(10, 11, 179, 311);
        contentPane.add(panel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBackground(new Color(231, 198, 255));
        panel_1.setBounds(0, 332, 591, 38);
        contentPane.add(panel_1);
        
        btnAgregar = new JButton("Agregar");
        btnAgregar.setBackground(new Color(255, 255, 255));
        btnAgregar.setBounds(487, 8, 86, 23);
        panel_1.add(btnAgregar);
        
        JLabel lblEliminarHusped = new JLabel("Agregar Habitación");
        lblEliminarHusped.setFont(new Font("Calibri", Font.BOLD, 16));
        lblEliminarHusped.setBounds(337, 22, 142, 20);
        contentPane.add(lblEliminarHusped);
        
        JLabel lblNombre_1_1 = new JLabel("Código:");
        lblNombre_1_1.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1.setBounds(230, 61, 62, 17);
        contentPane.add(lblNombre_1_1);
        
        txtCodigo = new JTextField();
        txtCodigo.setColumns(10);
        txtCodigo.setBounds(359, 53, 201, 25);
        contentPane.add(txtCodigo);
        
        JLabel lblNombre_1_1_1 = new JLabel("Tipo:");
        lblNombre_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1_1.setBounds(230, 202, 77, 17);
        contentPane.add(lblNombre_1_1_1);
        
        JLabel lblNombre_1_1_2 = new JLabel("Cantidad \r\nPersonas:");
        lblNombre_1_1_2.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1_2.setBounds(230, 154, 125, 17);
        contentPane.add(lblNombre_1_1_2);
        
        JLabel lblNombre_1_1_1_1 = new JLabel("Precio");
        lblNombre_1_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1_1_1.setBounds(230, 107, 72, 17);
        contentPane.add(lblNombre_1_1_1_1);
        
        JLabel lblNombre_1_1_1_1_1 = new JLabel("Disponible:");
        lblNombre_1_1_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1_1_1_1.setBounds(230, 286, 77, 17);
        contentPane.add(lblNombre_1_1_1_1_1);
        
        spPrecio = new JSpinner();
        spPrecio.setBounds(359, 101, 79, 25);
        contentPane.add(spPrecio);
        
        comboBoxDisponible = new JComboBox();
        comboBoxDisponible.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
        comboBoxDisponible.setToolTipText("");
        comboBoxDisponible.setBounds(359, 280, 201, 25);
        contentPane.add(comboBoxDisponible);
        
        spCantPersonas = new JSpinner();
        spCantPersonas.setBounds(359, 148, 79, 25);
        contentPane.add(spCantPersonas);
        
        comboBoxTipo = new JComboBox();
        comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"Habitación", "Suite"}));
        comboBoxTipo.setToolTipText("");
        comboBoxTipo.setBounds(359, 196, 201, 25);
        contentPane.add(comboBoxTipo);
        
        textExtras = new JTextField();
        textExtras.setColumns(10);
        textExtras.setBounds(359, 242, 201, 25);
        contentPane.add(textExtras);
        
        JLabel lblNombre_1_1_1_2 = new JLabel("Extras:");
        lblNombre_1_1_1_2.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1_1_2.setBounds(230, 248, 77, 17);
        contentPane.add(lblNombre_1_1_1_2);

        // Centrar la ventana cuando se hace visible
        setLocationRelativeTo(null);
    }
    
 public JTextField getTextDNI() {
		return textDNI;
	}

	public JTextField getTextExtras() {
		return textExtras;
	}

	public JComboBox getComboBoxTipo() {
		return comboBoxTipo;
	}
    public JComboBox getComboBoxDisponible() {
		return comboBoxDisponible;
	}

	public JSpinner getSpCantPersonas() {
		return spCantPersonas;
	}

	public void setSpPrecio(JSpinner spPrecio) {
		this.spPrecio = spPrecio;
	}

	public void setTxtCodigo(JTextField txtCodigo) {
		this.txtCodigo = txtCodigo;
	}

	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}
}
