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
    private JTextField textDNI;
    private JTextField id_ModificarHabitacion;
    private JTextField nombre_ModificarHabitacion;
    private JTextField descripcion_ModificarHabitacion;
    private JSpinner spinner_ModificarHabitacion;
    private JComboBox state_ModificarHabitacion;
    private JButton btnGuardar;
    private JLabel mensajeErrorDNI;

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
        
        JButton btnGuardar = new JButton("Guardar Cambios");
        btnGuardar.setBackground(new Color(255, 255, 255));
        btnGuardar.setBounds(439, 8, 134, 23);
        panel_1.add(btnGuardar);
        
        JLabel lblEliminarHusped = new JLabel("Modificar Habitación");
        lblEliminarHusped.setFont(new Font("Calibri", Font.BOLD, 16));
        lblEliminarHusped.setBounds(337, 22, 158, 20);
        contentPane.add(lblEliminarHusped);
        
        JLabel lblNombre_1_1 = new JLabel("Código:");
        lblNombre_1_1.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1.setBounds(230, 61, 62, 17);
        contentPane.add(lblNombre_1_1);
        
        id_ModificarHabitacion = new JTextField();
        id_ModificarHabitacion.setColumns(10);
        id_ModificarHabitacion.setBounds(324, 53, 236, 25);
        contentPane.add(id_ModificarHabitacion);
        
        JLabel mensajeErrorDNI = new JLabel("* Campos vacios o Datos incorrectos");
        mensajeErrorDNI.setForeground(Color.RED);
        mensajeErrorDNI.setFont(new Font("Calibri", Font.BOLD, 16));
        mensajeErrorDNI.setBounds(312, 280, 248, 26);
        contentPane.add(mensajeErrorDNI);
        
        JLabel lblNombre_1_1_1 = new JLabel("Nombre:");
        lblNombre_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1_1.setBounds(230, 107, 77, 17);
        contentPane.add(lblNombre_1_1_1);
        
        nombre_ModificarHabitacion = new JTextField();
        nombre_ModificarHabitacion.setColumns(10);
        nombre_ModificarHabitacion.setBounds(324, 99, 236, 25);
        contentPane.add(nombre_ModificarHabitacion);
        
        JLabel lblNombre_1_1_2 = new JLabel("Descripción:");
        lblNombre_1_1_2.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1_2.setBounds(230, 145, 84, 17);
        contentPane.add(lblNombre_1_1_2);
        
        descripcion_ModificarHabitacion = new JTextField();
        descripcion_ModificarHabitacion.setColumns(10);
        descripcion_ModificarHabitacion.setBounds(324, 145, 236, 52);
        contentPane.add(descripcion_ModificarHabitacion);
        
        JLabel lblNombre_1_1_1_1 = new JLabel("Precio");
        lblNombre_1_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1_1_1.setBounds(230, 216, 72, 17);
        contentPane.add(lblNombre_1_1_1_1);
        
        JLabel lblNombre_1_1_1_1_1 = new JLabel("Estado");
        lblNombre_1_1_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre_1_1_1_1_1.setBounds(230, 252, 72, 17);
        contentPane.add(lblNombre_1_1_1_1_1);
        
        JSpinner spinner_ModificarHabitacion = new JSpinner();
        spinner_ModificarHabitacion.setBounds(324, 208, 77, 25);
        contentPane.add(spinner_ModificarHabitacion);
        
        JComboBox state_ModificarHabitacion = new JComboBox();
        state_ModificarHabitacion.setModel(new DefaultComboBoxModel(new String[] {"Activo", "Inactivo"}));
        state_ModificarHabitacion.setToolTipText("");
        state_ModificarHabitacion.setBounds(324, 244, 239, 25);
        contentPane.add(state_ModificarHabitacion);

        // Centrar la ventana cuando se hace visible
        setLocationRelativeTo(null);
    }
}
