package view;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

	public class Interfaz_PaginaCliente extends JFrame {

		private JPanel contentPane;
		
		private JButton btnVerMisReservas;
	    private JButton btnReservar;
	    private JButton btnCerrarSesion;

	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    Interfaz_PaginaCliente frame = new Interfaz_PaginaCliente();
	                    frame.setVisible(true);
	                    frame.setLocationRelativeTo(null);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }

	    public Interfaz_PaginaCliente() {
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 1180, 683);
	        contentPane = new BackgroundPanel8();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        JLabel lblNewLabel_2_1 = new JLabel("Mis Reservas");
	        lblNewLabel_2_1.setFont(new Font("Calibri", Font.BOLD, 16));
	        lblNewLabel_2_1.setBounds(222, 480, 90, 20);
	        contentPane.add(lblNewLabel_2_1);

	        JLabel lblNewLabel_2 = new JLabel("Reservar");
	        lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 16));
	        lblNewLabel_2.setBounds(562, 480, 66, 20);
	        contentPane.add(lblNewLabel_2);

	        JLabel lblNewLabel = new JLabel("Cerrar Sesión");
	        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 16));
	        lblNewLabel.setBounds(864, 480, 90, 20);
	        contentPane.add(lblNewLabel);

	        JLabel lblNewLabel_1 = new JLabel("");
	        lblNewLabel_1.setIcon(new ImageIcon(Interfaz_PaginaGerente.class.getResource("/img/BostonResort (6).png")));
	        lblNewLabel_1.setBounds(0, 0, 1164, 115);
	        contentPane.add(lblNewLabel_1);

	        JPanel panel_1 = new JPanel();
	        panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(206, 157, 255), new Color(226, 198, 255), new Color(226, 198, 255), new Color(226, 198, 255)));
	        panel_1.setBackground(new Color(206, 157, 255));
	        panel_1.setBounds(0, 123, 1164, 43);
	        contentPane.add(panel_1);
	        panel_1.setLayout(null);

	        JLabel lblbienvenidoqueDesea = new JLabel("¡Bienvenido!, ¿que desea realizar?");
	        lblbienvenidoqueDesea.setBounds(452, 6, 269, 32);
	        lblbienvenidoqueDesea.setFont(new Font("Calibri", Font.BOLD, 18));
	        panel_1.add(lblbienvenidoqueDesea);

	        JLabel lblIniciasteSesinComo = new JLabel("Iniciaste Sesión como Cliente");
	        lblIniciasteSesinComo.setFont(new Font("Calibri", Font.BOLD, 16));
	        lblIniciasteSesinComo.setBounds(10, 12, 211, 23);
	        panel_1.add(lblIniciasteSesinComo);

	        btnVerMisReservas = new JButton("");
	        btnVerMisReservas.setIcon(new ImageIcon(Interfaz_PaginaCliente.class.getResource("/img/misReservas.png")));
	        btnVerMisReservas.setBackground(new Color(255, 255, 255));
	        btnVerMisReservas.setFont(new Font("Calibri", Font.PLAIN, 15));
	        btnVerMisReservas.setBounds(181, 307, 168, 162);
	        contentPane.add(btnVerMisReservas);

	        btnReservar = new JButton("\r\n");
	        btnReservar.setIcon(new ImageIcon(Interfaz_PaginaCliente.class.getResource("/img/reserva.png")));
	        btnReservar.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                Interfaz_ReservarHabitacion reserva = new Interfaz_ReservarHabitacion();
	                reserva.setVisible(true);
	                reserva.setLocationRelativeTo(null); // Centrar la nueva ventana
	                dispose(); // Cerrar la ventana actual si lo deseas
	            }
	        });
	        btnReservar.setBackground(new Color(255, 255, 255));
	        btnReservar.setFont(new Font("Calibri", Font.PLAIN, 15));
	        btnReservar.setBounds(507, 307, 168, 162);
	        contentPane.add(btnReservar);

	        btnCerrarSesion = new JButton("");
	        btnCerrarSesion.setIcon(new ImageIcon(Interfaz_PaginaCliente.class.getResource("/img/salida.png")));
	        btnCerrarSesion.setBackground(new Color(255, 255, 255));
	        btnCerrarSesion.setFont(new Font("Calibri", Font.PLAIN, 15));
	        btnCerrarSesion.setBounds(828, 307, 168, 162);
	        contentPane.add(btnCerrarSesion);
	    }

	    public JButton getBtnVerMisReservas() {
	        return btnVerMisReservas;
	    }

	    public JButton getBtnReservar() {
	        return btnReservar;
	    }

	    public JButton getBtnCerrarSesion() {
	        return btnCerrarSesion;
	    }
	}

	class BackgroundPanel8 extends JPanel {
	    private Image backgroundImage;

	    public BackgroundPanel8() {
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
