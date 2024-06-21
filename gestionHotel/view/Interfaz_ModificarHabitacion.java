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

public class Interfaz_ModificarHabitacion extends JFrame {

    private JPanel contentPane;
	private JComboBox comboBoxTipo;
    private JComboBox comboBoxDisponible;
    private JButton btnGuardar;
    private JSpinner spCantPersonas;
    private JSpinner spPrecio;
    private JTextField textExtras;
    private JTextField textCodigo;

    public Interfaz_ModificarHabitacion() {
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
        
        btnGuardar = new JButton("Guardar Cambios");
        btnGuardar.setBackground(new Color(255, 255, 255));
        btnGuardar.setBounds(439, 8, 134, 23);
        panel_1.add(btnGuardar);
        
        JLabel lblEliminarHusped = new JLabel("Modificar Habitación");
        lblEliminarHusped.setFont(new Font("Calibri", Font.BOLD, 16));
        lblEliminarHusped.setBounds(337, 22, 158, 20);
        contentPane.add(lblEliminarHusped);
        
        JLabel lblNombre_1_1_1_1_1 = new JLabel("Disponible:");
        lblNombre_1_1_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1_1_1_1.setBounds(228, 286, 77, 17);
        contentPane.add(lblNombre_1_1_1_1_1);
        
        comboBoxDisponible = new JComboBox();
        comboBoxDisponible.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
        comboBoxDisponible.setToolTipText("");
        comboBoxDisponible.setBounds(357, 280, 201, 25);
        contentPane.add(comboBoxDisponible);
        
        textExtras = new JTextField();
        textExtras.setColumns(10);
        textExtras.setBounds(357, 242, 201, 25);
        contentPane.add(textExtras);
        
        JLabel lblNombre_1_1_1_2 = new JLabel("Extras:");
        lblNombre_1_1_1_2.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1_1_2.setBounds(228, 248, 77, 17);
        contentPane.add(lblNombre_1_1_1_2);
        
        JLabel lblNombre_1_1_1 = new JLabel("Tipo:");
        lblNombre_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1_1.setBounds(228, 202, 77, 17);
        contentPane.add(lblNombre_1_1_1);
        
        comboBoxTipo = new JComboBox();
        comboBoxTipo.setToolTipText("");
        comboBoxTipo.setBounds(357, 196, 201, 25);
        contentPane.add(comboBoxTipo);
        
        spCantPersonas = new JSpinner();
        spCantPersonas.setBounds(357, 148, 79, 25);
        contentPane.add(spCantPersonas);
        
        spPrecio = new JSpinner();
        spPrecio.setBounds(357, 101, 79, 25);
        contentPane.add(spPrecio);
        
        textCodigo = new JTextField();
        textCodigo.setColumns(10);
        textCodigo.setBounds(357, 53, 201, 25);
        contentPane.add(textCodigo);
        
        JLabel lblNombre_1_1 = new JLabel("Código:");
        lblNombre_1_1.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1.setBounds(228, 61, 62, 17);
        contentPane.add(lblNombre_1_1);
        
        JLabel lblNombre_1_1_1_1 = new JLabel("Precio");
        lblNombre_1_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1_1_1.setBounds(228, 107, 72, 17);
        contentPane.add(lblNombre_1_1_1_1);
        
        JLabel lblNombre_1_1_2 = new JLabel("Cantidad \r\nPersonas:");
        lblNombre_1_1_2.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1_2.setBounds(228, 154, 125, 17);
        contentPane.add(lblNombre_1_1_2);

        // Centrar la ventana cuando se hace visible
        setLocationRelativeTo(null);
    }
    public JPanel getContentPane() {
		return contentPane;
	}

	public JComboBox getComboBoxTipo() {
		return comboBoxTipo;
	}

	public JComboBox getComboBoxDisponible() {
		return comboBoxDisponible;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JSpinner getSpCantPersonas() {
		return spCantPersonas;
	}

	public JSpinner getSpPrecio() {
		return spPrecio;
	}

	public JTextField getTextExtras() {
		return textExtras;
	}

	public JTextField getTextCodigo() {
		return textCodigo;
	}
}
