package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class Interfaz_ModificarHabitacion extends JFrame {

    private JPanel contentPane;
    
    private JComboBox comboBoxDisponible;
    private JButton btnGuardar;
    private JSpinner spCantPersonas;
    private JSpinner spPrecio;
    private JTextField textCodigo;
	private JRadioButton rdbtnInternet;
    private JRadioButton rdbtnMinibar;
    private JRadioButton rdbtnServicioDespertador;
    private JRadioButton rdbtnTv;
    private JLabel lblNewLabel;

	public Interfaz_ModificarHabitacion() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 607, 415);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(206, 140, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(20, 22, 169, 292);
        contentPane.add(panel);
        panel.setLayout(null);
        
        lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(Interfaz_ModificarHabitacion.class.getResource("/img/vistaBoston.png")));
        lblNewLabel.setBounds(0, 0, 169, 292);
        panel.add(lblNewLabel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBackground(new Color(231, 198, 255));
        panel_1.setBounds(-2, 340, 596, 38);
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
        lblNombre_1_1_1_1_1.setBounds(226, 284, 77, 17);
        contentPane.add(lblNombre_1_1_1_1_1);
        
        comboBoxDisponible = new JComboBox();
        comboBoxDisponible.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
        comboBoxDisponible.setToolTipText("");
        comboBoxDisponible.setBounds(356, 287, 201, 25);
        contentPane.add(comboBoxDisponible);
        
        JLabel lblNombre_1_1_1_2 = new JLabel("Extras:");
        lblNombre_1_1_1_2.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1_1_2.setBounds(227, 201, 77, 17);
        contentPane.add(lblNombre_1_1_1_2);
        
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
        
        rdbtnServicioDespertador = new JRadioButton("Servicio Despertador");
        rdbtnServicioDespertador.setFont(new Font("Calibri", Font.PLAIN, 15));
        rdbtnServicioDespertador.setBackground(new Color(206, 140, 255));
        rdbtnServicioDespertador.setActionCommand("rdbtnDebito");
        rdbtnServicioDespertador.setBounds(355, 201, 160, 23);
        contentPane.add(rdbtnServicioDespertador);
        
        rdbtnMinibar = new JRadioButton("Minibar");
        rdbtnMinibar.setFont(new Font("Calibri", Font.PLAIN, 15));
        rdbtnMinibar.setBackground(new Color(206, 140, 255));
        rdbtnMinibar.setActionCommand("rdbtnCredito");
        rdbtnMinibar.setBounds(355, 241, 82, 23);
        contentPane.add(rdbtnMinibar);
        
        rdbtnTv = new JRadioButton("TV");
        rdbtnTv.setFont(new Font("Calibri", Font.PLAIN, 15));
        rdbtnTv.setBackground(new Color(206, 140, 255));
        rdbtnTv.setActionCommand("rdbtnTransferencia");
        rdbtnTv.setBounds(517, 201, 47, 23);
        contentPane.add(rdbtnTv);
        
        rdbtnInternet = new JRadioButton("Internet");
        rdbtnInternet.setFont(new Font("Calibri", Font.PLAIN, 15));
        rdbtnInternet.setBackground(new Color(206, 140, 255));
        rdbtnInternet.setActionCommand("rdbtnDebito");
        rdbtnInternet.setBounds(453, 241, 93, 23);
        contentPane.add(rdbtnInternet);

        // Centrar la ventana cuando se hace visible
        setLocationRelativeTo(null);
    }
    public JPanel getContentPane() {
		return contentPane;
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

	public JTextField getTextCodigo() {
		return textCodigo;
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
