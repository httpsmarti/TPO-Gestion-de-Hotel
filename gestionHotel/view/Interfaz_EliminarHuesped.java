package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class Interfaz_EliminarHuesped extends JFrame {

    private JPanel contentPane;
    private JTextField textDNI;
    private JTextField DNI_EliminarHuesped;

    public Interfaz_EliminarHuesped() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 607, 408);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(206, 140, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(10, 11, 192, 311);
        contentPane.add(panel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBackground(new Color(231, 198, 255));
        panel_1.setBounds(0, 332, 591, 38);
        contentPane.add(panel_1);
        
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBackground(new Color(255, 255, 255));
        btnEliminar.setBounds(487, 8, 86, 23);
        panel_1.add(btnEliminar);
        
        JLabel lblEliminarHusped = new JLabel("Eliminar Huésped");
        lblEliminarHusped.setFont(new Font("Calibri", Font.BOLD, 16));
        lblEliminarHusped.setBounds(338, 116, 129, 20);
        contentPane.add(lblEliminarHusped);
        
        JLabel lblDNI = new JLabel("DNI:");
        lblDNI.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblDNI.setBounds(252, 176, 42, 17);
        contentPane.add(lblDNI);
        
        DNI_EliminarHuesped = new JTextField();
        DNI_EliminarHuesped.setColumns(10);
        DNI_EliminarHuesped.setBounds(294, 170, 226, 25);
        contentPane.add(DNI_EliminarHuesped);
        
        JLabel mensajeErrorDNI = new JLabel("* Campos vacios o Datos incorrectos");
        mensajeErrorDNI.setForeground(Color.RED);
        mensajeErrorDNI.setFont(new Font("Calibri", Font.BOLD, 16));
        mensajeErrorDNI.setBounds(294, 208, 248, 26);
        contentPane.add(mensajeErrorDNI);

        // Centrar la ventana cuando se hace visible
        setLocationRelativeTo(null);
    }
}
