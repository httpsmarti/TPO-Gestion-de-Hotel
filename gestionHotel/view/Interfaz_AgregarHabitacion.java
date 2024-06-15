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
    private JTextField DNI_EliminarHuesped;
    private JTextField textField;
    private JTextField textField_1;

    public Interfaz_AgregarHabitacion() {
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
        
        JButton btnAgregar = new JButton("Agregar");
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
        
        DNI_EliminarHuesped = new JTextField();
        DNI_EliminarHuesped.setColumns(10);
        DNI_EliminarHuesped.setBounds(324, 53, 236, 25);
        contentPane.add(DNI_EliminarHuesped);
        
        JLabel mensajeErrorDNI = new JLabel("* Campos vacios o Datos incorrectos");
        mensajeErrorDNI.setForeground(Color.RED);
        mensajeErrorDNI.setFont(new Font("Calibri", Font.BOLD, 16));
        mensajeErrorDNI.setBounds(312, 280, 248, 26);
        contentPane.add(mensajeErrorDNI);
        
        JLabel lblNombre_1_1_1 = new JLabel("Nombre:");
        lblNombre_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1_1.setBounds(230, 107, 77, 17);
        contentPane.add(lblNombre_1_1_1);
        
        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(324, 99, 236, 25);
        contentPane.add(textField);
        
        JLabel lblNombre_1_1_2 = new JLabel("Descripción:");
        lblNombre_1_1_2.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1_2.setBounds(230, 145, 84, 17);
        contentPane.add(lblNombre_1_1_2);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(324, 145, 236, 52);
        contentPane.add(textField_1);
        
        JLabel lblNombre_1_1_1_1 = new JLabel("Precio");
        lblNombre_1_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1_1_1.setBounds(230, 216, 72, 17);
        contentPane.add(lblNombre_1_1_1_1);
        
        JLabel lblNombre_1_1_1_1_1 = new JLabel("Estado");
        lblNombre_1_1_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1_1_1_1.setBounds(230, 252, 72, 17);
        contentPane.add(lblNombre_1_1_1_1_1);
        
        JSpinner spinner = new JSpinner();
        spinner.setBounds(324, 208, 77, 25);
        contentPane.add(spinner);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Activo", "Inactivo"}));
        comboBox.setToolTipText("");
        comboBox.setBounds(324, 244, 239, 25);
        contentPane.add(comboBox);

        // Centrar la ventana cuando se hace visible
        setLocationRelativeTo(null);
    }
}
