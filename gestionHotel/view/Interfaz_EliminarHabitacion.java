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
import javax.swing.ImageIcon;

public class Interfaz_EliminarHabitacion extends JFrame {

    private JPanel contentPane;
    
    private JTextField ID_EliminarHabitacion;
    private JButton btnEliminar;

    public Interfaz_EliminarHabitacion() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 607, 408);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(206, 140, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(20, 21, 169, 290);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(Interfaz_EliminarHabitacion.class.getResource("/img/vistaBoston.png")));
        lblNewLabel.setBounds(0, 0, 169, 290);
        panel.add(lblNewLabel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBackground(new Color(231, 198, 255));
        panel_1.setBounds(0, 332, 591, 38);
        contentPane.add(panel_1);
        
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBackground(new Color(255, 255, 255));
        btnEliminar.setBounds(473, 8, 100, 23);
        panel_1.add(btnEliminar);
        
        JLabel lblEliminarHabitacion = new JLabel("Eliminar Habitación");
        lblEliminarHabitacion.setFont(new Font("Calibri", Font.BOLD, 16));
        lblEliminarHabitacion.setBounds(335, 84, 146, 20);
        contentPane.add(lblEliminarHabitacion);
        
        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblCodigo.setBounds(231, 144, 62, 17);
        contentPane.add(lblCodigo);
        
        ID_EliminarHabitacion = new JTextField();
        ID_EliminarHabitacion.setColumns(10);
        ID_EliminarHabitacion.setBounds(313, 138, 200, 25);
        contentPane.add(ID_EliminarHabitacion);

        // Centrar la ventana cuando se hace visible
        setLocationRelativeTo(null);
    }
    
    public JButton getBtnEliminar() {
    	return btnEliminar;
    }
    
    public JTextField getID_EliminarHabitacion() {
    	return ID_EliminarHabitacion;
    }
}
