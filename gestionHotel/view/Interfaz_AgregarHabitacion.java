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
import javax.swing.JRadioButton;

public class Interfaz_AgregarHabitacion extends JFrame {

    private JPanel contentPane;
    
	private JTextField textDNI;
    private JSpinner spPrecio;
    private JTextField txtCodigo;
    private JButton btnAgregar;
	private JComboBox comboBoxDisponible;
    private JComboBox comboBoxTipo;
    private JSpinner spCantPersonas;
	private JRadioButton rdbtnInternet;
    private JRadioButton rdbtnMinibar;
    private JRadioButton rdbtnServicioDespertador;
    private JRadioButton rdbtnTv;

    public Interfaz_AgregarHabitacion() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 607, 473);
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
        panel_1.setBounds(0, 396, 591, 38);
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
        lblNombre_1_1_1_1_1.setBounds(230, 354, 77, 17);
        contentPane.add(lblNombre_1_1_1_1_1);
        
        spPrecio = new JSpinner();
        spPrecio.setBounds(359, 101, 79, 25);
        contentPane.add(spPrecio);
        
        comboBoxDisponible = new JComboBox();
        comboBoxDisponible.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
        comboBoxDisponible.setToolTipText("");
        comboBoxDisponible.setBounds(359, 348, 201, 25);
        contentPane.add(comboBoxDisponible);
        
        spCantPersonas = new JSpinner();
        spCantPersonas.setBounds(359, 148, 79, 25);
        contentPane.add(spCantPersonas);
        
        comboBoxTipo = new JComboBox();
        comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"Habitación", "Suite"}));
        comboBoxTipo.setToolTipText("");
        comboBoxTipo.setBounds(359, 196, 201, 25);
        contentPane.add(comboBoxTipo);
        
        JLabel lblNombre_1_1_1_2 = new JLabel("Extras:");
        lblNombre_1_1_1_2.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1_1_2.setBounds(230, 248, 77, 17);
        contentPane.add(lblNombre_1_1_1_2);
        
        rdbtnTv = new JRadioButton("TV");
        rdbtnTv.setFont(new Font("Calibri", Font.PLAIN, 15));
        rdbtnTv.setBackground(new Color(206, 140, 255));
        rdbtnTv.setActionCommand("rdbtnTransferencia");
        rdbtnTv.setBounds(521, 259, 47, 23);
        contentPane.add(rdbtnTv);
        
        rdbtnInternet = new JRadioButton("Internet");
        rdbtnInternet.setFont(new Font("Calibri", Font.PLAIN, 15));
        rdbtnInternet.setBackground(new Color(206, 140, 255));
        rdbtnInternet.setActionCommand("rdbtnDebito");
        rdbtnInternet.setBounds(457, 299, 93, 23);
        contentPane.add(rdbtnInternet);
        
        rdbtnServicioDespertador = new JRadioButton("Servicio Despertador");
        rdbtnServicioDespertador.setFont(new Font("Calibri", Font.PLAIN, 15));
        rdbtnServicioDespertador.setBackground(new Color(206, 140, 255));
        rdbtnServicioDespertador.setActionCommand("rdbtnDebito");
        rdbtnServicioDespertador.setBounds(359, 259, 160, 23);
        contentPane.add(rdbtnServicioDespertador);
        
        rdbtnMinibar = new JRadioButton("Minibar");
        rdbtnMinibar.setFont(new Font("Calibri", Font.PLAIN, 15));
        rdbtnMinibar.setBackground(new Color(206, 140, 255));
        rdbtnMinibar.setActionCommand("rdbtnCredito");
        rdbtnMinibar.setBounds(359, 299, 82, 23);
        contentPane.add(rdbtnMinibar);

        // Centrar la ventana cuando se hace visible
        setLocationRelativeTo(null);
    }
    
    public JTextField getTextDNI() {
		return textDNI;
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
	public JSpinner getSpPrecio() {
		return spPrecio;
	}

	public JTextField getTxtCodigo() {
		return txtCodigo;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}
	
    public JRadioButton getRdbtnInternet() {
		return rdbtnInternet;
	}

	public JRadioButton getRdbtnMinibar() {
		return rdbtnMinibar;
	}

	public JRadioButton getRdbtnServicioDespertador() {
		return rdbtnServicioDespertador;
	}

	public JRadioButton getRdbtnTv() {
		return rdbtnTv;
	}
}
