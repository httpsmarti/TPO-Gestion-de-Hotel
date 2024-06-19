package controller;

import model.*;
import view.*;

import java.util.*;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller {

    private List<Cliente> clientes;
    private Gerente gerente;
    private List<AbstractHabitacion> habitaciones;
    private List<Reserva> reservas;
    private List<Huesped> huespedes;
    private GestorDeNotificaciones gestorNotif;
    private Auditoria auditoria;
    
    private Cliente clienteActual;
    
    public Controller(List<Cliente> clientes, Gerente gerente, List<AbstractHabitacion> habitaciones,
            List<Reserva> reservas, List<Huesped> huespedes, GestorDeNotificaciones gestorNotif, Auditoria auditoria, Interfaz_Login vista) {
        super();
        this.clientes = clientes;
        this.gerente = gerente;
        this.habitaciones = habitaciones;
        this.reservas = reservas;
        this.huespedes = huespedes;
        this.gestorNotif = gestorNotif;
        this.auditoria = auditoria;
        
        iniciarVistaLogin();
    }
    
    private void iniciarVistaLogin() {
    	Interfaz_Login vista = new Interfaz_Login();
    	clienteActual = null;
    	vista.setVisible(true);
    	vista.setLocationRelativeTo(null);
        JButton btnCliente = vista.getBtnCliente();
        JButton btnGerente = vista.getBtnGerente();
        
    	if (btnCliente != null) {
    		btnCliente.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				vista.dispose();
    				iniciarVistaSelectClient();
    			}
    		});
        }
        
        if (btnGerente != null) {
        	btnGerente.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				vista.dispose();
    				iniciarVistaGerente();
    			}
    		});
        }
    }
       
    private void iniciarVistaSelectClient() {
    	Interfaz_SelectClient sClient = new Interfaz_SelectClient();
    	sClient.setVisible(true);
    	sClient.setLocationRelativeTo(null);
    	JButton btnRegistrarse = sClient.getBtnRegistrarse();
    	JButton btnVolver = sClient.getButton();
    	JTable tabla = sClient.getTable();
    	DefaultTableModel tablaFuncional = sClient.getTablaFuncional();
    	clienteActual = null;
    	
    	tabla.setRowSelectionAllowed(true);
    	
    	
    	if (tablaFuncional != null) {
    		for (Cliente cliente : clientes) {
    			Object[] linea = {cliente.getDNI(), cliente.getNombre(), cliente.getApellido()};
    			tablaFuncional.addRow(linea);
    		}
    	}
    	
    	if (btnVolver != null) {
    		btnVolver.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				sClient.dispose();
    				iniciarVistaLogin();
    			}
    		});
    	}
    	
    	if (btnRegistrarse != null) {
            btnRegistrarse.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
                    if (clienteActual != null) {
                        System.out.println("Cliente seleccionado: " + clienteActual.getNombre());
                        sClient.dispose();
                        iniciarVistaCliente();
                    }
                }
            });
            
            tabla.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	int filaSeleccionada = tabla.rowAtPoint(e.getPoint());
                    if (filaSeleccionada != -1) {
                        tabla.setRowSelectionInterval(filaSeleccionada, filaSeleccionada);
                        String dni = tablaFuncional.getValueAt(filaSeleccionada, 0).toString();
                        clienteActual = getClienteByDNI(dni);
                    }
                    System.out.println(clienteActual.getNombre());
                }
            });
        }
    	
    }
    
    private Cliente getClienteByDNI(String DNI) {
    	for (Cliente cliente : clientes) {
            if (cliente.getDNI().equals(DNI)) {
                return cliente;
            }
        }
        return null;
    }

    private void iniciarVistaCliente() {
    	Interfaz_PaginaCliente pagCliente = new Interfaz_PaginaCliente();
    	JButton btnVerMisReservas = pagCliente.getBtnVerMisReservas();
    	JButton btnReservar = pagCliente.getBtnReservar();
    	JButton btnCerrarSesion = pagCliente.getBtnCerrarSesion();
    	
    	pagCliente.setVisible(true);
    	pagCliente.setLocationRelativeTo(null);
    	if (btnVerMisReservas != null) {
    		btnVerMisReservas.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				pagCliente.dispose();
    				//no hace nada xd
    			}
    		});
    	}
    	
		if (btnReservar != null) {
			btnReservar.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				pagCliente.dispose();
    				//iniciarVistaReservas();
    				//me lleva a Interfaz_Reserva
    			}
    		});
    	}
		
		if (btnCerrarSesion != null) {
			btnCerrarSesion.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				pagCliente.dispose();
    				iniciarVistaLogin();
    			}
    		});
		}
    }
    
    private void iniciarVistaGerente() {
    	Interfaz_PaginaGerente registro = new Interfaz_PaginaGerente();
    	registro.setVisible(true);
        registro.setLocationRelativeTo(null);
        JButton btnABMHabitaciones = registro.getBtnABM();
        JButton btnReserva = registro.getBtnReserva();
        JButton btnCerrarSession = registro.getBtnCerrarSession();
        JButton btnABMClientes = registro.getBtnABMClientes();
                
        
        if (btnABMHabitaciones != null) {
        	btnABMHabitaciones.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				registro.dispose();
                    iniciarVistaHabitacionABM();
    			}
    		});
        }
        if (btnReserva!= null) {
        	//registro.dispose();
        	//iniciarVistaReserva();
        }
        
        if (btnABMClientes != null) {
        	//registro.dispose();
        	//iniciarVistaClientesABM();
        }
        
        if (btnCerrarSession != null) {
        	btnCerrarSession.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				registro.dispose();
                    iniciarVistaLogin();
    			}
    		});
        }
    }
    
    private void iniciarVistaHabitacionABM() {
    	Interfaz_HabitacionABM habABM = new Interfaz_HabitacionABM();
    	habABM.setVisible(true);
        habABM.setLocationRelativeTo(null);
        //LISTENERS DE ESTA VIEW
    }
}