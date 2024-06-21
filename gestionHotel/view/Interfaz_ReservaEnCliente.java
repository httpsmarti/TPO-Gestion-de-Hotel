package view;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Interfaz_ReservaEnCliente extends JFrame {

    private JPanel contentPane;
	private JTable tablaHabitacionesDispo;
    private JTable tablaHabitacionSeleccionada;
    static DefaultTableModel tablaFuncional = new DefaultTableModel();
    static DefaultTableModel tablaFuncional2 = new DefaultTableModel();
    private JScrollPane scrollPane;
    private JScrollPane scrollPane_1;
    private JButton btnSiguiente;
    private JButton btnAtras;
    

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Interfaz_ReservaEnCliente frame = new Interfaz_ReservaEnCliente();
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Interfaz_ReservaEnCliente() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1180, 683);
        contentPane = new BackgroundPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1164, 115);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(Interfaz_ReservaEnCliente.class.getResource("/img/BostonResort (6).png")));
        lblNewLabel_1.setBounds(0, 0, 1164, 115);
        panel.add(lblNewLabel_1);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(206, 157, 255), new Color(226, 198, 255), new Color(226, 198, 255), new Color(226, 198, 255)));
        panel_1.setBackground(new Color(206, 157, 255));
        panel_1.setLayout(null);
        panel_1.setBounds(0, 123, 1164, 43);
        contentPane.add(panel_1);

        JLabel lblNewLabel = new JLabel("Seleccione Habitación");
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 18));
        lblNewLabel.setBounds(482, 8, 165, 32);
        panel_1.add(lblNewLabel);

        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel_3.setBackground(new Color(206, 157, 255));
        panel_3.setBounds(0, 588, 1164, 56);
        contentPane.add(panel_3);
        panel_3.setLayout(null);

        btnSiguiente = new JButton("Siguiente");
        /*
        btnSiguiente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Interfaz_Detalle siguiente = new Interfaz_Detalle();
                siguiente.setVisible(true);
                siguiente.setLocationRelativeTo(null); // Centrar la nueva ventana
                dispose(); // Cerrar la ventana actual si lo deseas
            }
        });*/
        
        btnSiguiente.setForeground(new Color(255, 255, 255));
        btnSiguiente.setBackground(new Color(63, 63, 63));
        btnSiguiente.setFont(new Font("Calibri", Font.BOLD, 14));
        btnSiguiente.setBounds(1042, 11, 89, 34);
        panel_3.add(btnSiguiente);

        btnAtras = new JButton("Atrás");
        /*
        btnAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Interfaz_PaginaGerente atras = new Interfaz_PaginaGerente();
                atras.setVisible(true);
                atras.setLocationRelativeTo(null); // Centrar la nueva ventana
                dispose(); // Cerrar la ventana actual si lo deseas
        
      

            }
        });*/
        
        btnAtras.setBackground(new Color(63, 63, 63));
        btnAtras.setForeground(new Color(255, 255, 255));
        btnAtras.setFont(new Font("Calibri", Font.PLAIN, 14));
        btnAtras.setBounds(22, 177, 76, 34);
        contentPane.add(btnAtras);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(159, 224, 895, 148);
        contentPane.add(scrollPane);

        // Definir las columnas antes de establecer el modelo en la tabla
        if (tablaFuncional.getColumnCount() == 0) {
            tablaFuncional.addColumn("Código");
            tablaFuncional.addColumn("Precio");
            tablaFuncional.addColumn("Cantidad Personas");
            tablaFuncional.addColumn("Extras");
            tablaFuncional.addColumn("Disponible");
        }

        tablaHabitacionesDispo = new JTable(tablaFuncional);
        tablaHabitacionesDispo.setFont(new Font("Calibri", Font.PLAIN, 12));
        tablaHabitacionesDispo.setBackground(new Color(255, 255, 255));
        scrollPane.setViewportView(tablaHabitacionesDispo);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(159, 415, 895, 136);
        contentPane.add(scrollPane_1);

        // Definir las columnas antes de establecer el modelo en la tabla
        if (tablaFuncional2.getColumnCount() == 0) {
            tablaFuncional2.addColumn("Código");
            tablaFuncional2.addColumn("Precio");
            tablaFuncional2.addColumn("Cantidad Personas");
            tablaFuncional2.addColumn("Extras");
            tablaFuncional2.addColumn("Disponible");
        }

        tablaHabitacionSeleccionada = new JTable(tablaFuncional2);
        tablaHabitacionSeleccionada.setFont(new Font("Calibri", Font.PLAIN, 12));
        tablaHabitacionSeleccionada.setBackground(Color.WHITE);
        scrollPane_1.setViewportView(tablaHabitacionSeleccionada);
        
        JLabel lblHabitacionesDisponibles = new JLabel("Habitaciones Disponibles");
        lblHabitacionesDisponibles.setFont(new Font("Calibri", Font.BOLD, 16));
        lblHabitacionesDisponibles.setBounds(159, 185, 224, 32);
        contentPane.add(lblHabitacionesDisponibles);
        
        JLabel lblHabitacinSeleccionada = new JLabel("Habitación Seleccionada");
        lblHabitacinSeleccionada.setFont(new Font("Calibri", Font.BOLD, 16));
        lblHabitacinSeleccionada.setBounds(159, 383, 224, 32);
        contentPane.add(lblHabitacinSeleccionada);
    }
    public JTable getTablaHabitacionesDispo() {
		return tablaHabitacionesDispo;
	}

	public JTable getTablaHabitacionSeleccionada() {
		return tablaHabitacionSeleccionada;
	}

	public static DefaultTableModel getTablaFuncional2() {
		return tablaFuncional2;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JScrollPane getScrollPane_1() {
		return scrollPane_1;
	}

    public DefaultTableModel getTablaFuncional() {
        return tablaFuncional;
    }

    public JButton getBtnSiguiente() {
        return btnSiguiente;
    }

    public JButton getBtnAtras() {
        return btnAtras;
    }
}

class BackgroundPanel06 extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel06() {
        // Cargar la imagen
        ImageIcon icon = new ImageIcon("C:\\Users\\marti\\Documents\\GitHub\\Gestion-Hotel\\gestionHoteles\\img\\blob-login.png");
        backgroundImage = icon.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar la imagen escalada para llenar todo el panel
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
