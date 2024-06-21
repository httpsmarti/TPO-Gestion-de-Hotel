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

public class Interfaz_EliminarCliente extends JFrame {

    private JPanel contentPane;
    private JTextField textDNI;
    private JButton btnEliminar;

    public Interfaz_EliminarCliente() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 815, 443);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(206, 140, 255));
        contentPane.setForeground(new Color(206, 140, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Eliminar Cliente");
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 17));
        lblNewLabel.setBounds(440, 33, 120, 20);
        contentPane.add(lblNewLabel);
        
        JPanel panel = new JPanel();
        panel.setBounds(10, 11, 192, 340);
        contentPane.add(panel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(231, 198, 255));
        panel_1.setBounds(0, 362, 853, 49);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Calibri", Font.PLAIN, 13));
        btnEliminar.setBackground(new Color(255, 255, 255));
        btnEliminar.setBounds(667, 11, 93, 23);
        panel_1.add(btnEliminar);
        
        JLabel lblNombre_1_1 = new JLabel("DNI:");
        lblNombre_1_1.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1.setBounds(368, 153, 226, 17);
        contentPane.add(lblNombre_1_1);
        
        textDNI = new JTextField();
        textDNI.setColumns(10);
        textDNI.setBounds(439, 146, 155, 26);
        contentPane.add(textDNI);
    }

	public JTextField getTextDNI() {
		return textDNI;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}
    
}