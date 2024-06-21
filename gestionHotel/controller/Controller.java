package controller;

import model.*;
import view.*;

import java.util.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
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
    private PoliticasReserva politicas;
    private Cliente clienteActual;
    
    public Controller(List<Cliente> clientes, Gerente gerente, List<AbstractHabitacion> habitaciones,
            List<Reserva> reservas, List<Huesped> huespedes, GestorDeNotificaciones gestorNotif, Auditoria auditoria, PoliticasReserva politicas, Interfaz_Login vista) {
        super();
        this.clientes = clientes;
        this.gerente = gerente;
        this.habitaciones = habitaciones;
        this.reservas = reservas;
        this.huespedes = huespedes;
        this.gestorNotif = gestorNotif;
        this.politicas = politicas;
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
    
    private void iniciarVistaGerente() { //falta terminar, por ahora paso al cliente
    	Interfaz_PaginaGerente registro = new Interfaz_PaginaGerente();
    	registro.setVisible(true);
        registro.setLocationRelativeTo(null);
        JButton btnABMHabitaciones = registro.getBtnABM();
        JButton btnReserva = registro.getBtnReserva();
        JButton btnCerrarSession = registro.getBtnCerrarSession();
        JButton btnABMClientes = registro.getBtnABMClientes();
        JButton btnModificarPoliticas = registro.getBtnModificarPoliticas();
        
        if (btnABMHabitaciones != null) {
        	btnABMHabitaciones.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				registro.dispose();
                    iniciarVistaHabitacionABM(); //faltan agregar y modificar
    			}
    		});
        }
        
        if (btnReserva!= null) {
        	btnReserva.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			registro.dispose();
                	iniciarVistaReserva(); // sin terminar
    			}
        	});
        }
        
        if (btnABMClientes != null) {
        	btnABMClientes.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			registro.dispose();
        			iniciarVistaClientesABM(); //no hay vista para esto
    			}
        	});
        }
        
        if (btnCerrarSession != null) {
        	btnCerrarSession.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				registro.dispose();
                    iniciarVistaLogin();
    			}
    		});
        }
        
        if (btnModificarPoliticas != null) {
        	btnModificarPoliticas.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				registro.dispose();
                    iniciarVistaPoliticas();
    			}
    		});
        }
    }
    
    private void iniciarVistaPoliticas() {
    	Interfaz_ModificarPoliticas modPoliticas = new Interfaz_ModificarPoliticas();
		modPoliticas.setVisible(true);
		modPoliticas.setLocationRelativeTo(null);
		
		JButton btnAplicarCambios = modPoliticas.getBtnAplicarCambios();
		JButton btnAtras = modPoliticas.getBtnAtras();
		JTextField txtCantDiasTemprano = modPoliticas.getTxtCantDiasTemprano();
		JTextField txtCantDiasTarde = modPoliticas.getTxtCantDiasTarde();
		JTextField txtDescuento = modPoliticas.getTxtDescuento();
		JTextField txtRecargo = modPoliticas.getTxtRecargo();
		
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modPoliticas.dispose();
                iniciarVistaGerente();
			}
		});
		
		btnAplicarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtCantDiasTemprano.getText() != "" &&
				txtCantDiasTarde.getText() != "" &&
				txtDescuento.getText() != "" &&
				txtRecargo.getText() != "") {
					modPoliticas.dispose();
					politicas = new PoliticasReserva(Integer.parseInt(txtCantDiasTemprano.getText()), 
													Integer.parseInt(txtCantDiasTarde.getText()), 
													Float.parseFloat(txtDescuento.getText()), 
													Float.parseFloat(txtRecargo.getText()));
				}
			}
		});
    }
    
    private void iniciarVistaHabitacionABM() { //falta agregar y modificar
    	Interfaz_HabitacionABM habABM = new Interfaz_HabitacionABM();
    	habABM.setVisible(true);
        habABM.setLocationRelativeTo(null);
        JButton btnAtras = habABM.getBtnAtras(); // me lleva a PaginaGerente
        JButton btnAgregar = habABM.getBtnAgregarHabitacion(); // Interfaz_AgregarHabitacion
        JButton btnModificar = habABM.getBtnModificarHabitacion(); // Interfaz_ModificarHabitacion
        JButton btnEliminar = habABM.getBtnEliminarHabitacion(); // Interfaz_EliminarHabitacion
        DefaultTableModel tabla = habABM.getTablaFuncional();
        
        for (AbstractHabitacion hab : habitaciones) {
        	String extras = "";
        	String disponible = "";
        	if (hab.isDisponible()) {
        		disponible = "Si";
        	} else {
        		disponible = "No";
        	}
        	
        	for (String e : hab.getExtras()) {
        		extras += e;
        	}
        	
        	
			Object[] linea = {hab.getIdHabitacion(), hab.getPrecioPorNoche(), Integer.toString(hab.getCantPersonas()), hab.getTipo(), extras, disponible};
			System.out.println(linea);
			tabla.addRow(linea);
			
			tabla.fireTableDataChanged();
			habABM.getTable().revalidate();
			habABM.getTable().repaint();
		}
        
        if (btnAtras != null) {
        	btnAtras.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				habABM.dispose();
    				iniciarVistaGerente();
    			}
    		});
        }

        if (btnAgregar != null) {
        	btnAgregar.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				habABM.dispose();
    				iniciarVistaAgregarHabitacion(); //sin terminar
    			}
    		});
        }

        if (btnModificar != null) {
        	btnModificar.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				habABM.dispose();
    				iniciarVistaModificarHabitacion(); //sin terminar
    			}
    		});
        }

        if (btnEliminar != null) {
        	btnEliminar.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				habABM.dispose();
    				iniciarVistaEliminarHabitacion(); //sin terminar
    			}
    		});
        }   
    }
    
    private void iniciarVistaAgregarHabitacion() { //HABLAR DESPUES CON MARTIS, VER NOTAS
    	Interfaz_AgregarHabitacion agrHab = new Interfaz_AgregarHabitacion();
    	agrHab.setVisible(true);
    	agrHab.setLocationRelativeTo(null);
    	JSpinner spPrecio = agrHab.getSpPrecio();
        JTextField txtCodigo = agrHab.getTxtCodigo();
        JButton btnAgregar = agrHab.getBtnAgregar();
    	JComboBox comboBoxDisponible = agrHab.getComboBoxDisponible();
        JComboBox comboBoxTipo = agrHab.getComboBoxTipo();
        JSpinner spCantPersonas = agrHab.getSpCantPersonas();
    	
    }
    
    private void iniciarVistaModificarHabitacion() { //mismo problema que en agregar habitacion
    	Interfaz_ModificarHabitacion modHab = new Interfaz_ModificarHabitacion();
    	modHab.setVisible(true);
    	modHab.setLocationRelativeTo(null);
    }
    
    private void iniciarVistaEliminarHabitacion() {
    	Interfaz_EliminarHabitacion eliHab = new Interfaz_EliminarHabitacion();
    	eliHab.setVisible(true);
    	eliHab.setLocationRelativeTo(null);
    	JTextField id = eliHab.getID_EliminarHabitacion();
    	JButton btnEliminar = eliHab.getBtnEliminar();
    	btnEliminar.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			eliminarHabitacionById(id.getText());
    			eliHab.dispose();
    			iniciarVistaHabitacionABM();
    		}
    	});
    }
    
    private void eliminarHabitacionById(String id) {
    	for (AbstractHabitacion hab : habitaciones) {
    		if (hab.getIdHabitacion().equals(id)) {
    			habitaciones.remove(hab);
    		}
    	}
    }
    
    
    public void iniciarVistaReserva() { //hablar con martis ---- voy a tener que pasarle al detalle de la reserva los datos de la habitación para que desde ahí pueda crear la reserva entera
    	Interfaz_ReservarHabitacion interReserva = new Interfaz_ReservarHabitacion();
    	interReserva.setVisible(true);
    	interReserva.setLocationRelativeTo(null);
    	
    	DefaultTableModel tablaAñadir = interReserva.getTablaFuncional();
    	//DefaultTableModel tablaRemover = interReserva.getTablaRemover(); //esto es para la tabla que muestra las habitaciones que ya tengo seleccionadas
    	JButton btnAtras = interReserva.getBtnAtras();
    	JButton btnSiguiente = interReserva.getBtnSiguiente();
    	
    	//aca agrego las habitaciones a la tablaAñadir
    	if (tablaAñadir != null) {
    		for (AbstractHabitacion hab : habitaciones) {
    			Object[] linea = {}; //estas lineas coinciden con las columnas de la tabla, que deberian coincidir mejor con las caracteristicas de una habitacion
    			tablaAñadir.addRow(linea);
    		}
    	}
    	
    	List<AbstractHabitacion> listaHabitaciones = new ArrayList<AbstractHabitacion>(); //aca guardo las habitaciones que añado, despues lo agrego todo a la tabla
    	
    	btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (clienteActual == null) {
					interReserva.dispose();
	                iniciarVistaGerente();
				} else {
					interReserva.dispose();
	                iniciarVistaCliente();
				}
				
			}
		});
    	
    	btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interReserva.dispose();
                //iniciarVistaReservaDetalle(listaHabitaciones); //again, aca paso la lista de habitaciones para que pueda hacer bien la reserva
			}
		});
    	
    	
    }
    
    public void iniciarVistaClientesABM() {
    	//me faltaría la pantalla de clientes abm...
    }
    
    
    private void iniciarVistaCliente() { //LO SIGO CUANDO TERMINE CON LA PARTE DEL GERENTE
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
    				//martis haceme la view porfa D:
    			}
    		});
    	}
    	
		if (btnReservar != null) {
			btnReservar.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				pagCliente.dispose();
    				iniciarVistaReserva();
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
    
    
    
    
    
}