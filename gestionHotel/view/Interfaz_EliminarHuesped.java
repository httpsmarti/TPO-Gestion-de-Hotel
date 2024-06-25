package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Interfaz_EliminarHuesped extends JFrame {


	private JPanel contentPane;
	
    private JTextField textDNI;
    private JTextField DNI_EliminarHuesped;
    private JButton btnEliminar;

    public Interfaz_EliminarHuesped() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 607, 408);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(206, 140, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(23, 22, 173, 286);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(Interfaz_EliminarHuesped.class.getResource("/img/vistaBoston.png")));
        lblNewLabel.setBounds(0, 0, 173, 286);
        panel.add(lblNewLabel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBackground(new Color(231, 198, 255));
        panel_1.setBounds(0, 332, 591, 38);
        contentPane.add(panel_1);
        
        btnEliminar = new JButton("Eliminar");
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

        // Centrar la ventana cuando se hace visible
        setLocationRelativeTo(null);
    }
    
    public JTextField getTextDNI() {
		return textDNI;
	}

	public JTextField getDNI_EliminarHuesped() {
		return DNI_EliminarHuesped;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}
}
