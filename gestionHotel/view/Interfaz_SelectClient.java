package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class Interfaz_SelectClient extends JFrame {

    private JPanel contentPane;
    private JButton btnSiguiente;
    private JButton button;
    private JTable table;
    private DefaultTableModel tablaFuncional = new DefaultTableModel();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Interfaz_SelectClient frame = new Interfaz_SelectClient();
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Interfaz_SelectClient() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1180, 683);
        contentPane = new BackgroundPanel1();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
        panel.setBackground(Color.WHITE);
        panel.setBounds(301, 41, 539, 552);
        contentPane.add(panel);

        btnSiguiente = new JButton("Continuar");
        btnSiguiente.setForeground(Color.WHITE);
        btnSiguiente.setFont(new Font("Calibri", Font.BOLD, 16));
        btnSiguiente.setBackground(new Color(70, 70, 70));
        btnSiguiente.setBounds(29, 481, 483, 41);
        panel.add(btnSiguiente);

        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setForeground(new Color(204, 125, 251));
        panel_1.setBackground(new Color(204, 125, 251));
        panel_1.setBounds(0, 0, 539, 91);
        panel.add(panel_1);

        JLabel lblNewLabel_2_2_2 = new JLabel("A continuación elija el usuario a utilizar...");
        lblNewLabel_2_2_2.setFont(new Font("Calibri", Font.BOLD, 17));
        lblNewLabel_2_2_2.setBounds(20, 32, 309, 32);
        panel_1.add(lblNewLabel_2_2_2);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBackground(Color.WHITE);
        scrollPane.setBounds(45, 160, 444, 210);
        panel.add(scrollPane);

        // Verificar si las columnas ya han sido agregadas
        if (tablaFuncional.getColumnCount() == 0) {
        	tablaFuncional.addColumn("DNI");
            tablaFuncional.addColumn("Nombre");
            tablaFuncional.addColumn("Apellido");
        }

        table = new JTable(tablaFuncional);
        table.setBorder(new LineBorder(new Color(0, 0, 0)));
        table.setFont(new Font("Calibri", Font.PLAIN, 12));
        table.setBackground(Color.WHITE);
        table.getTableHeader().setBackground(new Color(206, 157, 255)); // Color de fondo del header
        table.getTableHeader().setForeground(Color.BLACK); // Color del texto del header

        // Aplicar el renderer personalizado a las celdas
        CustomTableCellRenderer cellRenderer = new CustomTableCellRenderer();
        table.setDefaultRenderer(Object.class, cellRenderer);

        scrollPane.setViewportView(table);

        // Agregar el botón de volver
        button = new JButton("Volver");
        
        button.setFont(new Font("Calibri", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(70, 70, 70));
        button.setBounds(25, 22, 87, 34);
        contentPane.add(button);
    }

    public JButton getBtnRegistrarse() {
        return btnSiguiente;
    }

    public JButton getButton() {
        return button;
    }

    public JTable getTable() {
        return table;
    }

    public DefaultTableModel getTablaFuncional() {
        return tablaFuncional;
    }

    // Renderer personalizado para las celdas
    class CustomTableCellRenderer extends JLabel implements TableCellRenderer {

        public CustomTableCellRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText(value != null ? value.toString() : "");
            setBackground(new Color(206, 157, 255)); // Color de fondo específico
            setForeground(Color.BLACK);
            return this;
        }
    }

    // Panel de fondo personalizado
    class BackgroundPanel1 extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel1() {
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
}