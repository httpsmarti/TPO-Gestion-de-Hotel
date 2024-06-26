package controller;

import model.*;
import view.*;

import java.util.*;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class Controller {

    private List<Cliente> clientes;
    private Gerente gerente;
    private List<AbstractHabitacion> habitaciones;
    private List<Reserva> reservas;
    private GestorDeNotificaciones gestorNotif;
    private Auditoria auditoria;
    private PoliticasReserva politicas;
    private Cliente clienteActual;
    
    public Controller(List<Cliente> clientes, Gerente gerente, List<AbstractHabitacion> habitaciones,
        List<Reserva> reservas, GestorDeNotificaciones gestorNotif, Auditoria auditoria, PoliticasReserva politicas, Interfaz_Login vista) {
        super();
        this.clientes = clientes;
        this.gerente = gerente;
        this.habitaciones = habitaciones;
        this.reservas = reservas;
        this.gestorNotif = gestorNotif;
        this.politicas = politicas;
        this.auditoria = auditoria;
        
        for (Reserva r : reservas) {
            Date fechaReserva = r.getFechaReserva();
            Date fechaActual = Calendar.getInstance().getTime();
            long diferenciaMillis = fechaActual.getTime() - fechaReserva.getTime();
            long horasTranscurridas = diferenciaMillis / (60 * 60 * 1000);
            if (horasTranscurridas > 24) {
                r.setEstado("Cancelada");
                for (AbstractHabitacion h: r.getHabitaciones()) {
                    for (AbstractHabitacion hab : habitaciones) {
                        if(hab.equals(h)) {
                            hab.setDisponible(true);
                        }
                    }
                }
                auditoria.agregarEvento(Calendar.getInstance().getTime(), "Se cancelo una reserva.", "Se cancelo la reserva con codigo: " + r.getIdReserva() + ", porque no se pago dentro de las 24 horas");
            }
        }
        generarReporteHabitaciones();
        mostrarAuditoria();
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
    				iniciarVistaLoginUsuario();
    				//iniciarVistaSelectClient();
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
    
    private void iniciarVistaLoginUsuario() {
    	Interfaz_LoginUsuarios login = new Interfaz_LoginUsuarios();
    	login.setVisible(true);
    	login.setLocationRelativeTo(null);
    	JTextField txtMail = login.getTxtMail();
    	JTextField txtPassword = login.getPasswordField();
    	JButton btnAtras = login.getBtnAtras();
    	JButton btnIngresar = login.getBtnSiguiente();
    	
    	clienteActual = null;
    	
    	if (btnIngresar != null) {
    		btnIngresar.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				boolean existe = false;
    				for (Cliente c : clientes) {
    					if(c.getMail().equals(txtMail.getText()) && c.getPassword().equals(txtPassword.getText())) {
    						existe = true;
    						clienteActual = c;
    						break;
    					}
    				}
    				
    				if (existe) {
    					System.out.println("Ingresó el cliente: " + clienteActual.getNombre());
                        login.dispose();
                        iniciarVistaCliente();
    				} else {
    					System.out.println("Mail o contraseña incorrectos!!!");
    				}
    			}
    		});
    	}
    	
    	if (btnAtras != null) {
    		btnAtras.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				login.dispose();
    				iniciarVistaLogin();
    			}
    		});
    	}
    }
    
    private void iniciarVistaSelectClient() {//ya no la usamos yipee
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
                    System.out.println("Cliente ingresado: " + clienteActual.getNombre());
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
    
    private void iniciarVistaGerente() {
    	Interfaz_PaginaGerente registro = new Interfaz_PaginaGerente();
    	registro.setVisible(true);
        registro.setLocationRelativeTo(null);
        JButton btnABMHabitaciones = registro.getBtnABM();
        JButton btnReserva = registro.getBtnReserva();
        JButton btnCerrarSession = registro.getBtnCerrarSession();
        JButton btnABMClientes = registro.getBtnABMClientes();
        JButton btnModificarPoliticas = registro.getBtnModificarPoliticas();
        JButton btnVerReservas = registro.getBtnVerReservas();
        
        if (btnABMHabitaciones != null) {
        	btnABMHabitaciones.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				registro.dispose();
                    iniciarVistaHabitacionABM();
    			}
    		});
        }
        
        if (btnReserva!= null) {
        	btnReserva.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			registro.dispose();
                	iniciarVistaReserva();
    			}
        	});
        }
        
        if (btnABMClientes != null) {
        	btnABMClientes.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			registro.dispose();
        			iniciarVistaClientesABM();
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
        if (btnVerReservas != null) {
        	btnVerReservas.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			registro.dispose();
                    iniciarVistaVerReservas();
        		}
        	});
        }
    }
        
    private Reserva getReservaByCodigo(String codigo) {
    	for (Reserva r : reservas) {
    		if (r.getIdReserva().equals(codigo)) {
    			return r;
    		}
    	}
    	return null;
    }
    
    private void iniciarVistaVerReservas() {
    	Interfaz_MiReserva miRes = new Interfaz_MiReserva();
    	miRes.setVisible(true);
		miRes.setLocationRelativeTo(null);
		DefaultTableModel tabla = miRes.getTablaFuncional();
		JButton btnEliminarReserva = miRes.getBtnEliminarReserva();
		JButton btnAtras = miRes.getBtnAtras();
		JTable tablaClick = miRes.getTablaHabitacionesDispo();
		tablaClick.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	int filaSeleccionada = tablaClick.rowAtPoint(e.getPoint());
            	Reserva resSeleccionada = null;
                if (filaSeleccionada != -1) {
                	tablaClick.setRowSelectionInterval(filaSeleccionada, filaSeleccionada);
                    String codigo = tablaClick.getValueAt(filaSeleccionada, 0).toString();
                    resSeleccionada = getReservaByCodigo(codigo);
                    if (resSeleccionada.getEstado() == "Pendiente de pago") {
                    	resSeleccionada.setEstado("Pagada");
                    	resSeleccionada.getPagoContexto().getEstrategia().pagar(resSeleccionada.getPrecio());
                    	Cliente clientePagado = getClienteByDNI(resSeleccionada.getDNIClienteReserva());
                    	gestorNotif.enviarNotificacion(clientePagado, "Pagó su reserva y recibió su factura.", clientePagado.getContactoPref());;
                    	auditoria.agregarEvento(Calendar.getInstance().getTime(), "Se pago una reserva.", "El cliente " + clientePagado.getNombre() + " pago su reserva con codigo " + resSeleccionada.getIdReserva());
                    	tabla.setRowCount(0);
                        for (Reserva res : reservas) {
                        	if (clienteActual == null) {
                        		String huespedes = "";
                            	for (Huesped h : res.getHuespedes()) {
                            		if (huespedes == "") {
                            			huespedes += h.getNombre();
                            		} else {
                            			huespedes += ", " + h.getNombre();
                            		}
                            	}
                            	
                            	Object[] linea = {res.getIdReserva(), res.getDNIClienteReserva(), res.getFechaInicio(), res.getFechaFin(), huespedes, res.getPagoContexto().getTipo(), res.getEstado()};
                    			tabla.addRow(linea);
                    			tabla.fireTableDataChanged();
                        	} else {
                        		if (res.getDNIClienteReserva().equals(clienteActual.getDNI())) {
                        			String huespedes = "";
                                	for (Huesped h : res.getHuespedes()) {
                                		if (huespedes == "") {
                                			huespedes += h.getNombre();
                                		} else {
                                			huespedes += ", " + h.getNombre();
                                		}
                                	}
                                	
                                	Object[] linea = {res.getIdReserva(), res.getDNIClienteReserva(), res.getFechaInicio(), res.getFechaFin(), huespedes, res.getPagoContexto().getTipo(), res.getEstado()};
                        			tabla.addRow(linea);
                        			tabla.fireTableDataChanged();
                        		}
                        	}
                        }
                    }
                }
            }
        });
		
		tabla.setRowCount(0);
        for (Reserva res : reservas) {
        	if (clienteActual == null) {
        		String huespedes = "";
            	for (Huesped h : res.getHuespedes()) {
            		if (huespedes == "") {
            			huespedes += h.getNombre();
            		} else {
            			huespedes += ", " + h.getNombre();
            		}
            	}
            	
            	Object[] linea = {res.getIdReserva(), res.getDNIClienteReserva(), res.getFechaInicio(), res.getFechaFin(), huespedes, res.getPagoContexto().getTipo(), res.getEstado()};
    			tabla.addRow(linea);
    			tabla.fireTableDataChanged();
        	} else {
        		if (res.getDNIClienteReserva().equals(clienteActual.getDNI())) {
        			String huespedes = "";
                	for (Huesped h : res.getHuespedes()) {
                		if (huespedes == "") {
                			huespedes += h.getNombre();
                		} else {
                			huespedes += ", " + h.getNombre();
                		}
                	}
                	
                	Object[] linea = {res.getIdReserva(), res.getDNIClienteReserva(), res.getFechaInicio(), res.getFechaFin(), huespedes, res.getPagoContexto().getTipo(), res.getEstado()};
        			tabla.addRow(linea);
        			tabla.fireTableDataChanged();
        		}
        	}
		}
        
        if (btnAtras != null) {
    		btnAtras.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				miRes.dispose();
    				if (clienteActual == null) {
    					iniciarVistaGerente();
    				} else {
    					iniciarVistaCliente();
    				}
    			}
    		});
    	}
        
        btnEliminarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miRes.dispose();
				iniciarVistaEliminarReserva();
			}
		});
    }
    
    public void iniciarVistaReserva() {
    	Interfaz_ReservarHabitacion interReserva = new Interfaz_ReservarHabitacion();
    	interReserva.setVisible(true);
    	interReserva.setLocationRelativeTo(null);
    	
    	DefaultTableModel tablaAñadir = interReserva.getTablaFuncional();
    	DefaultTableModel tablaRemover = interReserva.getTablaFuncional2();
    	tablaRemover.setRowCount(0);
    	JTable tAñadir = interReserva.getTablaHabitacionesDispo();
    	JTable tRemover = interReserva.getTablaHabitacionSeleccionada();
    	JButton btnAtras = interReserva.getBtnAtras();
    	JButton btnSiguiente = interReserva.getBtnSiguiente();
    	JCheckBox chServicioDespertador = interReserva.getChckbxServicioDespertador();
    	JCheckBox chTV = interReserva.getChckbxTv();
    	JCheckBox chMinibar = interReserva.getChckbxMinibar();
    	JCheckBox chInternet = interReserva.getChckbxInternet();
    	JComboBox comboBoxTipo = interReserva.getComboBoxTipo();
    	JButton btnFiltrar = interReserva.getBtnFiltrar();
    	JComboBox comboboxCantPersonas = interReserva.getComboBoxCantPers();
    	JTextField txtDNI = interReserva.getTextDNICliente();
    	JButton btnReiniciar = interReserva.getBtnReiniciarFiltro();
    	
    	String DNI;
    	
    	
    	
    	if(clienteActual != null) {
    		txtDNI.setText(clienteActual.getDNI());
    		txtDNI.setEnabled(false);
    	}
    	
    	//aca agrego las habitaciones a la tablaAñadir
    	if (tablaAñadir != null) {
    		tablaAñadir.setRowCount(0);
            for (AbstractHabitacion hab : habitaciones) {
            	String extras = "";
            	String disponible = "";
            	if (hab.isDisponible()) {
            		disponible = "Si";
            	} else {
            		disponible = "No";
            	}
            	
            	for (String e : hab.getExtras()) {
            		if (extras == "") {
            			extras += e;
            		} else {
            			extras += ", " + e;
            		}
            	}
            	
    			Object[] linea = {hab.getIdHabitacion(), hab.getPrecioPorNoche(), Integer.toString(hab.getCantPersonas()), hab.getTipo(), extras, disponible};
    			if (hab.isDisponible()) {
    				tablaAñadir.addRow(linea);
    			}
    			tablaAñadir.fireTableDataChanged();
    		}
    	}
    	
    	btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				tablaAñadir.setRowCount(0);
	            for (AbstractHabitacion hab : habitaciones) {
	            	String extras = "";
	            	
	            	
	            	for (String e : hab.getExtras()) {
	            		if (extras == "") {
	            			extras += e;
	            		} else {
	            			extras += ", " + e;
	            		}
	            		
	            	}
	            	
	            	Object[] linea = {hab.getIdHabitacion(), hab.getPrecioPorNoche(), Integer.toString(hab.getCantPersonas()), hab.getTipo(), extras, "Si"};
	            	
	            	if (hab.getCantPersonas() == Integer.parseInt(comboboxCantPersonas.getSelectedItem().toString()) &&
	    				hab.isDisponible() &&
	    				hab.getTipo().equals(comboBoxTipo.getSelectedItem())) {
	    				
	    				boolean cumple = true;
	    				
	    				if (chServicioDespertador.isSelected() && !hab.getExtras().contains("Servicio despertador")) {
	    						cumple = false;
	    				}
	    				if (chTV.isSelected() && !hab.getExtras().contains("TV")) {
		    				cumple = false;
	    				}
	    				if (chInternet.isSelected() && !hab.getExtras().contains("Internet")) {
		    				cumple = false;
	    				}
	    				if (chMinibar.isSelected() && !hab.getExtras().contains("Minibar")) {
		    				cumple = false;
	    				}
	    				if (cumple) {
	    					tablaAñadir.addRow(linea);
	    				}
	    			}
	    			tablaAñadir.fireTableDataChanged();
	    		}
			}
		});
    	
    	List<AbstractHabitacion> listaHabitaciones = new ArrayList<AbstractHabitacion>(); //aca guardo las habitaciones que añado, despues lo agrego todo a la tabla
    	
    	tAñadir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent ev) {
            	int filaSeleccionada = tAñadir.rowAtPoint(ev.getPoint());
                if (filaSeleccionada != -1) {
                	tAñadir.setRowSelectionInterval(filaSeleccionada, filaSeleccionada);
                    String codigo = tAñadir.getValueAt(filaSeleccionada, 0).toString();
                    if (!listaHabitaciones.contains(getHabitacionByCodigo(codigo))) {
                    	listaHabitaciones.add(getHabitacionByCodigo(codigo));
                    }
                    
                    tablaRemover.setRowCount(0);
                    for (AbstractHabitacion hab : listaHabitaciones) {
                    	String extras = "";
                    	String disponible = "";
                    	if (hab.isDisponible()) {
                    		disponible = "Si";
                    	} else {
                    		disponible = "No";
                    	}
                    	
                    	for (String e : hab.getExtras()) {
                    		if (extras == "") {
                    			extras += e;
                    		} else {
                    			extras += ", " + e;
                    		}
                    	}
            			Object[] linea = {hab.getIdHabitacion(), hab.getPrecioPorNoche(), Integer.toString(hab.getCantPersonas()), hab.getTipo(), extras, disponible};
            			tablaRemover.addRow(linea);
            			tablaRemover.fireTableDataChanged();
            		}
                }
            }
        });
    	
    	tRemover.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent ev) {
            	int filaSeleccionada = tRemover.rowAtPoint(ev.getPoint());
                if (filaSeleccionada != -1) {
                	tRemover.setRowSelectionInterval(filaSeleccionada, filaSeleccionada);
                    String codigo = tRemover.getValueAt(filaSeleccionada, 0).toString();
                    if (!listaHabitaciones.contains(getHabitacionByCodigo(codigo))) {
                    	listaHabitaciones.add(getHabitacionByCodigo(codigo));
                    }
                    
                    listaHabitaciones.remove(getHabitacionByCodigo(codigo));
                    
                    tablaRemover.setRowCount(0);
                    for (AbstractHabitacion hab : listaHabitaciones) {
                    	String extras = "";
                    	String disponible = "";
                    	if (hab.isDisponible()) {
                    		disponible = "Si";
                    	} else {
                    		disponible = "No";
                    	}
                    	
                    	for (String e : hab.getExtras()) {
                    		if (extras == "") {
                    			extras += e;
                    		} else {
                    			extras += ", " + e;
                    		}
                    	}
            			Object[] linea = {hab.getIdHabitacion(), hab.getPrecioPorNoche(), Integer.toString(hab.getCantPersonas()), hab.getTipo(), extras, disponible};
            			tablaRemover.addRow(linea);
            			tablaRemover.fireTableDataChanged();
            		}
                }
            }
        });
    	
    	
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
    	
    	btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				tablaAñadir.setRowCount(0);
	            for (AbstractHabitacion hab : habitaciones) {
	            	String extras = "";
	            	String disponible = "";
	            	if (hab.isDisponible()) {
	            		disponible = "Si";
	            	} else {
	            		disponible = "No";
	            	}
	            	
	            	for (String e : hab.getExtras()) {
	            		if (extras == "") {
	            			extras += e;
	            		} else {
	            			extras += ", " + e;
	            		}
	            	}
	            	
	    			Object[] linea = {hab.getIdHabitacion(), hab.getPrecioPorNoche(), Integer.toString(hab.getCantPersonas()), hab.getTipo(), extras, disponible};
	    			if (hab.isDisponible()) {
	    				tablaAñadir.addRow(linea);
	    			}
	    			tablaAñadir.fireTableDataChanged();
	    		}
			}
		});
    	
    	btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interReserva.dispose();
				if (clienteActual == null) {
					iniciarVistaReservaDetalle(listaHabitaciones, txtDNI.getText());
				} else {
					iniciarVistaReservaDetalle(listaHabitaciones, clienteActual.getDNI());
				}
			}
		});	
    }
    
    private AbstractHabitacion getHabitacionByCodigo(String codigo) {
    	for (AbstractHabitacion h : habitaciones) {
    		if(h.getIdHabitacion() == codigo) {
    			return h;
    		}
    	}
    	return null;
    }
    
    private void iniciarVistaReservaDetalle(List<AbstractHabitacion> listaHabitaciones, String DNI) {
    	Interfaz_Detalle detalle = new Interfaz_Detalle();
    	detalle.setVisible(true);
    	detalle.setLocationRelativeTo(null);
    	JButton btnAtras = detalle.getBtnAtras();
    	DefaultTableModel tablaHabitaciones = detalle.getTablaFuncional();
    	DefaultTableModel tablaHuespedes = detalle.getTablaFuncional1();
    	JButton btnReservar = detalle.getBtnReservar();
    	JButton  btnResgistrarHuesped = detalle.getBtnResgistrarHuesped();
    	JButton btnEliminarHuesped = detalle.getBtnEliminarHuesped();
    	JRadioButton rdbtnCredito = detalle.getRdbtnCredito();
    	JRadioButton rdbtnDebito = detalle.getRdbtnDebito();
    	JRadioButton rdbtnTransferencia = detalle.getRdbtnTransferencia();
    	JRadioButton rdbtnEfectivo = detalle.getRdbtnEfectivo();
    	ButtonGroup grupoMetodoPago = detalle.getGrupoMetodoPago();
    	JDateChooser dateCheckIn = detalle.getDateCheckIn();
    	JDateChooser dateCheckOut = detalle.getDateCheckOut();
    	JTextField alias = detalle.getIdTrasferencia();
    	JTextField txtTipoCambio = detalle.getTextTipoCambio();
    	JComboBox comboBoxBanco = detalle.getComboBoxBanco();
    	JLabel precio = detalle.getLprecio();
    	JLabel nombre = detalle.getLNombre();
    	
    	nombre.setText(getClienteByDNI(DNI).getNombre());
    	
    	List<Huesped> huespedes = new ArrayList<Huesped>();
    	
    	tablaHuespedes.setRowCount(0);
    	tablaHabitaciones.setRowCount(0);
    	
        for (AbstractHabitacion hab : listaHabitaciones) {
			Object[] linea = {hab.getIdHabitacion(), hab.getTipo(), hab.getPrecioPorNoche()};
			tablaHabitaciones.addRow(linea);
			tablaHabitaciones.fireTableDataChanged();
		}
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaMasUnDia = fechaActual.plusDays(1);
        Date fechaMaxima = Date.from(fechaMasUnDia.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
		//necesito los listeners de los selectores de fechas para ver si ambos tienen fechas
		// Listener para dateCheckIn
        dateCheckIn.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
            	if (checkFechas(dateCheckIn, dateCheckOut)) {
            		double costoNoches = 0;
    				for (AbstractHabitacion h : listaHabitaciones) {
    					costoNoches += h.getPrecioPorNoche();
    				}
    				
    				//obtengo la cantidad de noches
    				LocalDate localDateCheckIn = dateCheckIn.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    		        LocalDate localDateCheckOut = dateCheckOut.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    		        long cantidadNochesLong = ChronoUnit.DAYS.between(localDateCheckIn, localDateCheckOut);
    		        int cantNoches = (int) cantidadNochesLong;
    				
    		        
    		        double precioTotal = cantNoches*costoNoches;
    		        
    		      //aplico las politicas
    				long diasHastaCheckIn = ChronoUnit.DAYS.between(fechaActual, localDateCheckIn);
    				
    				if (diasHastaCheckIn >= politicas.getCantDiasTemprano()) {
    		            // aplico descuento temprano
    					precioTotal *= 1 - politicas.getDtoTemprano()/100;
    		        } else if (diasHastaCheckIn <= politicas.getCantDiasTarde()) {
    		            // aplico recargo tarde
    		        	precioTotal *= (politicas.getRecragoTarde())/100 + 1;
    		        }
    				precio.setText(String.format("%.2f", precioTotal));
            	}
            }
        });

        // Listener para dateCheckOut
        dateCheckOut.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                	if (checkFechas(dateCheckIn, dateCheckOut)) {
                		double costoNoches = 0;
        				for (AbstractHabitacion h : listaHabitaciones) {
        					costoNoches += h.getPrecioPorNoche();
        				}
        				
        				//obtengo la cantidad de noches
        				LocalDate localDateCheckIn = dateCheckIn.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        		        LocalDate localDateCheckOut = dateCheckOut.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        		        long cantidadNochesLong = ChronoUnit.DAYS.between(localDateCheckIn, localDateCheckOut);
        		        int cantNoches = (int) cantidadNochesLong;
        				
        		        
        		        double precioTotal = cantNoches*costoNoches;
        				//aplico las politicas
        				long diasHastaCheckIn = ChronoUnit.DAYS.between(fechaActual, localDateCheckIn);
        				
        				if (diasHastaCheckIn >= politicas.getCantDiasTemprano()) {
        		            // aplico descuento temprano
        					precioTotal *= 1 - politicas.getDtoTemprano()/100;
        		        } else if (diasHastaCheckIn <= politicas.getCantDiasTarde()) {
        		            // aplico recargo tarde
        		        	precioTotal *= (politicas.getRecragoTarde())/100 + 1;
        		        }                		
        				precio.setText(String.format("%.2f", precioTotal));
                	}
                }
            }
        });
        
        btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PagoContexto pc = new PagoContexto();
				if (rdbtnCredito.isSelected()) {
					pc.setEstrategia(new PagoCredito(fechaMaxima, generarIdReserva(), comboBoxBanco.getSelectedItem().toString()));
				}
				if (rdbtnDebito.isSelected()) {
					pc.setEstrategia(new PagoDebito(fechaMaxima, generarIdReserva(), comboBoxBanco.getSelectedItem().toString()));
				}
				if (rdbtnTransferencia.isSelected()) {
					pc.setEstrategia(new PagoTransferencia(fechaMaxima, generarIdReserva(), alias.getText()));
				}
				if (rdbtnEfectivo.isSelected()) {
					pc.setEstrategia(new PagoEfectivo(fechaMaxima, Double.parseDouble(txtTipoCambio.getText())));
				}
				
				double costoNoches = 0;
				for (AbstractHabitacion h : listaHabitaciones) {
					costoNoches += h.getPrecioPorNoche();
				}
				
				//obtengo la cantidad de noches
				LocalDate localDateCheckIn = dateCheckIn.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		        LocalDate localDateCheckOut = dateCheckOut.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		        long cantidadNochesLong = ChronoUnit.DAYS.between(localDateCheckIn, localDateCheckOut);
		        int cantNoches = (int) cantidadNochesLong;
				
		        
		        double precioTotal = cantNoches*costoNoches;
		        
		        //aplico las politicas
				long diasHastaCheckIn = ChronoUnit.DAYS.between(fechaActual, localDateCheckIn);
				
				if (diasHastaCheckIn >= politicas.getCantDiasTemprano()) {
		            // aplico descuento temprano
					precioTotal *= 1 - politicas.getDtoTemprano()/100;
		        } else if (diasHastaCheckIn <= politicas.getCantDiasTarde()) {
		            // aplico recargo tarde
		        	precioTotal *= politicas.getRecragoTarde()/100 + 1;
		        }
				
				List<AbstractHabitacion> habs = new ArrayList<AbstractHabitacion>();
				
				for (AbstractHabitacion hab : listaHabitaciones) {
					//System.out.println("Se reservo la habitacion " + hab.getIdHabitacion());
					habs.add(hab);
				}
				
		        reservas.add(new Reserva(generarIdReserva(), precioTotal, dateCheckIn.getDate(), dateCheckOut.getDate(), Calendar.getInstance().getTime(), habs, DNI, huespedes, pc, "Pendiente de pago"));
		        //System.out.println("Reserva: " + reservas.get(reservas.size()-1).getHabitaciones().size());
		        auditoria.agregarEvento(Calendar.getInstance().getTime(), "Se hizo una reserva.", "El cliente " + getClienteByDNI(DNI).getNombre() + " hizo una reserva con codigo " + reservas.get(reservas.size()-1).getIdReserva());
		        
		        System.out.println("Reserva exitosa!!!");
		        
		        for (AbstractHabitacion habitacion: listaHabitaciones) {
		        	for (AbstractHabitacion h : habitaciones) {
		        		if (habitacion.getIdHabitacion().equals(h.getIdHabitacion())) {
		        			h.setDisponible(false);
		        		}
		        	}
		        }
		        detalle.dispose();
                iniciarVistaReserva();
			}
		});
        
        
        //listener para dateCheckIn
        dateCheckIn.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                	checkFechas(dateCheckIn, dateCheckOut);
                }
            }
        });

        //listener para dateCheckOut
        dateCheckOut.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                	checkFechas(dateCheckIn, dateCheckOut);
                }
            }
        });
        
        btnResgistrarHuesped.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interfaz_RegistrarHuesped regHue = new Interfaz_RegistrarHuesped();
				regHue.setVisible(true);
				regHue.setLocationRelativeTo(null);
				JTextField txtNombre = regHue.getTextNombre();
				JTextField txtApellido = regHue.getTextApellido();
				JTextField txtDNI = regHue.getTextDNI();
				JButton btnRegistrar = regHue.getBtnRegistrar();
				btnRegistrar.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent ev) {
		                huespedes.add(new Huesped(txtNombre.getText(), txtApellido.getText(), txtDNI.getText()));
		                tablaHuespedes.setRowCount(0);
		                for (Huesped hue : huespedes) {
		                    Object[] linea = {hue.getDNI(), hue.getNombre(), hue.getApellido()};
		                    tablaHuespedes.addRow(linea);
		                }
		                tablaHuespedes.fireTableDataChanged();
		                regHue.dispose();
		            }
		        });
			}
		});
        
    	btnEliminarHuesped.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interfaz_EliminarHuesped eliHue = new Interfaz_EliminarHuesped();
				eliHue.setVisible(true);
				eliHue.setLocationRelativeTo(null);
				
				JButton btnEliminar = eliHue.getBtnEliminar();
				JTextField txtDNI = eliHue.getDNI_EliminarHuesped();
				
				btnEliminar.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent ev) {
		            	if (getHuespedByDNI(huespedes, txtDNI.getText()) != null) {
		            		huespedes.remove(getHuespedByDNI(huespedes, txtDNI.getText()));
		            		tablaHuespedes.setRowCount(0);
			                for (Huesped hue : huespedes) {
			                    Object[] linea = {hue.getDNI(), hue.getNombre(), hue.getApellido()};
			                    tablaHuespedes.addRow(linea);
			                }
			                tablaHuespedes.fireTableDataChanged();
			            	eliHue.dispose();
		            	}
		            }
		        });
			}
		});
        
    	btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				detalle.dispose();
                iniciarVistaReserva();
			}
		});
    }
    
    private boolean checkFechas(JDateChooser dateCheckIn, JDateChooser dateCheckOut) {
        Date checkInDate = dateCheckIn.getDate();
        Date checkOutDate = dateCheckOut.getDate();

        if (checkInDate != null && checkOutDate != null) {
            LocalDate localDateCheckIn = checkInDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate localDateCheckOut = checkOutDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            if (localDateCheckOut.isAfter(localDateCheckIn)) {
                //System.out.println("Fechas válidas: Check-Out es después de Check-In.");
                return true;
            } else {
                //System.out.println("Fecha de Check-Out debe ser posterior a la fecha de Check-In.");
            }
        }
        return false;
    }
    
    private String generarIdReserva() {
    	if (reservas.size() == 0) {
    		return "1";
    	} else {
    		return String.valueOf(Integer.parseInt(reservas.get(reservas.size() - 1).getIdReserva()) + 1); 
    	}
    }
    
    private Huesped getHuespedByDNI(List<Huesped> huespedes, String DNI) {
    	for (Huesped h : huespedes) {
    		if (h.getDNI().equals(DNI)){
    			return h;
    		}
    	}
    	return null;
    }
    
    private void iniciarVistaEliminarReserva() {
    	Interfaz_EliminarReserva eliRes = new Interfaz_EliminarReserva();
    	eliRes.setVisible(true);
    	eliRes.setLocationRelativeTo(null);
    	JTextField txtCod = eliRes.getTextCodigo();
    	JButton btnEliminar = eliRes.getBtnEliminar();
    	
    	btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (clienteActual == null) {
					for (Reserva r : reservas) {
						if (r.getIdReserva().equals(txtCod.getText())){
							r.setEstado("Cancelada");
							auditoria.agregarEvento(Calendar.getInstance().getTime(), "Se cancelo una reserva", "La reserva con codigo " + r.getIdReserva() + " se cancelo manualmente");
							//System.out.println("ASDASDASD " + r.getHabitaciones().size());
							for (AbstractHabitacion h : r.getHabitaciones()) {
								h.setDisponible(true);
								//System.out.println("Habitacion: " + h.getIdHabitacion());
							}
						}
					}
				} else {
					for (Reserva r : reservas) {
						if (r.getIdReserva().equals(txtCod.getText()) && r.getDNIClienteReserva().equals(clienteActual.getDNI())){
							r.setEstado("Cancelada");
							auditoria.agregarEvento(Calendar.getInstance().getTime(), "Se cancelo una reserva", "La reserva con codigo " + r.getIdReserva() + " se cancelo manualmente");
							for (AbstractHabitacion h : r.getHabitaciones()) {
								h.setDisponible(true);
							}
						}
					}
				}
				
				eliRes.dispose();
				iniciarVistaVerReservas();
			}
		});
    	
    	eliRes.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	eliRes.dispose();
                iniciarVistaVerReservas();
            }
        });
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
		
		txtCantDiasTemprano.setText(Integer.toString(politicas.getCantDiasTemprano()));
		txtCantDiasTarde.setText(Integer.toString(politicas.getCantDiasTarde()));
		txtDescuento.setText(Float.toString(politicas.getDtoTemprano()));
		txtRecargo.setText(Float.toString(politicas.getRecragoTarde()));
		
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modPoliticas.dispose();
                iniciarVistaGerente();
			}
		});
		
		btnAplicarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtCantDiasTemprano.getText().equals("") &&
				!txtCantDiasTarde.getText().equals("") &&
				!txtDescuento.getText().equals("") &&
				!txtRecargo.getText().equals("")) {
					politicas = new PoliticasReserva(Integer.parseInt(txtCantDiasTemprano.getText()), 
													Integer.parseInt(txtCantDiasTarde.getText()), 
													Float.parseFloat(txtDescuento.getText()), 
													Float.parseFloat(txtRecargo.getText()));
				}
			}
		});
    }
    
    private void iniciarVistaHabitacionABM() {
    	Interfaz_HabitacionABM habABM = new Interfaz_HabitacionABM();
    	habABM.setVisible(true);
        habABM.setLocationRelativeTo(null);
        JButton btnAtras = habABM.getBtnAtras(); // me lleva a PaginaGerente
        JButton btnAgregar = habABM.getBtnAgregarHabitacion(); // Interfaz_AgregarHabitacion
        JButton btnModificar = habABM.getBtnModificarHabitacion(); // Interfaz_ModificarHabitacion
        JButton btnEliminar = habABM.getBtnEliminarHabitacion(); // Interfaz_EliminarHabitacion
        DefaultTableModel tabla = habABM.getTablaFuncional();
        
        tabla.setRowCount(0);
        for (AbstractHabitacion hab : habitaciones) {
        	String extras = "";
        	String disponible = "";
        	if (hab.isDisponible()) {
        		disponible = "Si";
        	} else {
        		disponible = "No";
        	}
        	
        	for (String e : hab.getExtras()) {
        		if (extras == "") {
        			extras += e;
        		} else {
        			extras += ", " + e;
        		}
        	}
        	
			Object[] linea = {hab.getIdHabitacion(), hab.getPrecioPorNoche(), Integer.toString(hab.getCantPersonas()), hab.getTipo(), extras, disponible};
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
    				iniciarVistaAgregarHabitacion();
    			}
    		});
        }

        if (btnModificar != null) {
        	btnModificar.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				habABM.dispose();
    				iniciarVistaModificarHabitacion();
    			}
    		});
        }

        if (btnEliminar != null) {
        	btnEliminar.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				habABM.dispose();
    				iniciarVistaEliminarHabitacion();
    			}
    		});
        }   
    }
    
    private void iniciarVistaAgregarHabitacion() {
    	Interfaz_AgregarHabitacion agrHab = new Interfaz_AgregarHabitacion();
    	agrHab.setVisible(true);
    	agrHab.setLocationRelativeTo(null);
    	JSpinner spPrecio = agrHab.getSpPrecio();
        JTextField txtCodigo = agrHab.getTxtCodigo();
        JButton btnAgregar = agrHab.getBtnAgregar();
    	JComboBox comboBoxDisponible = agrHab.getComboBoxDisponible();
        JComboBox comboBoxTipo = agrHab.getComboBoxTipo();
        JSpinner spCantPersonas = agrHab.getSpCantPersonas();
        JRadioButton rdbtnInternet = agrHab.getRdbtnInternet();
        JRadioButton rdbtnMinibar = agrHab.getRdbtnMinibar();
        JRadioButton rdbtnServicioDespertador = agrHab.getRdbtnServicioDespertador();
        JRadioButton rdbtnTv = agrHab.getRdbtnTv();
        
        List<String> extras = new ArrayList<String>();
                
        btnAgregar.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			boolean disponible = true;
    			if (comboBoxDisponible.getSelectedItem() == "No") {
    	        	disponible = false;
    	        }
    			if (rdbtnInternet.isSelected()) {
    	        	extras.add("Internet");
    	        }
    	        if (rdbtnMinibar.isSelected()) {
    	        	extras.add("Minibar");
    	        }
    	        if (rdbtnServicioDespertador.isSelected()) {
    	        	extras.add("Servicio despertador");
    	        }
    	        if (rdbtnTv.isSelected()) {
    	        	extras.add("TV");
    	        }
    			if (comboBoxTipo.getSelectedItem() == "Suite") {
    	        	habitaciones.add(gerente.crearSuite(txtCodigo.getText(), ((Number) spPrecio.getValue()).doubleValue(), (int) spCantPersonas.getValue(), "Suite", extras, disponible));
    	        } else {
    	        	habitaciones.add(gerente.crearHabitacion(txtCodigo.getText(), ((Number) spPrecio.getValue()).doubleValue(), (int) spCantPersonas.getValue(), "Habitacion", extras, disponible));
    	        }
    			agrHab.dispose();
    			iniciarVistaHabitacionABM();
    		}
    	});
        
        agrHab.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                agrHab.dispose();
                iniciarVistaHabitacionABM();
            }
        });
    }
    
    private void iniciarVistaModificarHabitacion() {
    	Interfaz_ModificarHabitacion modHab = new Interfaz_ModificarHabitacion();
    	modHab.setVisible(true);
    	modHab.setLocationRelativeTo(null);
    	JSpinner spPrecio = modHab.getSpPrecio();
        JButton btnGuardar = modHab.getBtnGuardar();
    	JComboBox comboBoxDisponible = modHab.getComboBoxDisponible();
        JSpinner spCantPersonas = modHab.getSpCantPersonas();
        JRadioButton rdbtnInternet = modHab.getRdbtnInternet();
        JRadioButton rdbtnMinibar = modHab.getRdbtnMinibar();
        JRadioButton rdbtnServicioDespertador = modHab.getRdbtnServicioDespertador();
        JRadioButton rdbtnTv = modHab.getRdbtnTv();
        JTextField txtCodigo = modHab.getTextCodigo();
        
        List<String> extras = new ArrayList<String>();
        
        btnGuardar.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			boolean disponible = true;
    			if (comboBoxDisponible.getSelectedItem() == "No") {
    	        	disponible = false;
    	        }
    			if (rdbtnInternet.isSelected()) {
    	        	extras.add("Internet");
    	        }
    	        if (rdbtnMinibar.isSelected()) {
    	        	extras.add("Minibar");
    	        }
    	        if (rdbtnServicioDespertador.isSelected()) {
    	        	extras.add("Servicio despertador");
    	        }
    	        if (rdbtnTv.isSelected()) {
    	        	extras.add("TV");
    	        }
    	        
    	        for (AbstractHabitacion hab : habitaciones) {    	        	
    	    		if (hab.getIdHabitacion().equals(txtCodigo.getText())) {
    	    			hab.setCantPersonas((int) spCantPersonas.getValue());
    	    			hab.setDisponible(disponible);
    	    			hab.setExtras(extras);
    	    			hab.setPrecioPorNoche(((Number) spPrecio.getValue()).doubleValue());
    	    		}
    	    	}
    			modHab.dispose();
    			iniciarVistaHabitacionABM();
    		}
    	});
        
        
        modHab.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	modHab.dispose();
                iniciarVistaHabitacionABM();
            }
        });
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
    	
    	eliHab.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	eliHab.dispose();
                iniciarVistaHabitacionABM();
            }
        });
    }
    
    private void eliminarHabitacionById(String id) {
    	for (AbstractHabitacion hab : habitaciones) {
    		if (hab.getIdHabitacion().equals(id)) {
    			habitaciones.remove(hab);
    			break;
    		}
    	}
    }
    
    public void iniciarVistaClientesABM() {
    	Interfaz_ClienteABM cABM = new Interfaz_ClienteABM();
    	cABM.setVisible(true);
    	cABM.setLocationRelativeTo(null);
    	JButton btnAtras = cABM.getBtnAtras();
    	DefaultTableModel tabla = cABM.getTablaFuncional();
    	JButton btnAgregar = cABM.getBtnAgregarCliente();
    	JButton btnModificar = cABM.getBtnModificarCliente();
    	JButton btnEliminar = cABM.getBtnEliminarCliente();
    	
    	tabla.setRowCount(0);
    	for (Cliente c : clientes) {
			Object[] linea = {c.getNombre(), c.getApellido(), c.getDNI(), c.getEdad(), c.getMail(), c.getTelefono()};
			tabla.addRow(linea);
		}
    	
    	btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cABM.dispose();
                iniciarVistaGerente();
			}
		});
    	
    	btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cABM.dispose();
                iniciarVistaAgregarCliente();
			}
		});
    	
    	btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cABM.dispose();
                iniciarVistaModificarCliente();
			}
		});
    	
    	btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cABM.dispose();
                iniciarVistaEliminarCliente();
			}
		});    	
    }
    
    private void iniciarVistaEliminarCliente() {
    	Interfaz_EliminarCliente eliCli = new Interfaz_EliminarCliente();
    	eliCli.setVisible(true);
    	eliCli.setLocationRelativeTo(null);
    	
    	JTextField txtDNI = eliCli.getTextDNI();
    	JButton btnEliminar = eliCli.getBtnEliminar();
    	
    	btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Cliente c : clientes) {
					if (c.getDNI().equals(txtDNI.getText())) {
						clientes.remove(c);
						break;
					}
				}
				eliCli.dispose();
				iniciarVistaClientesABM();
			}
		});
    	
    	eliCli.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	eliCli.dispose();
                iniciarVistaClientesABM();
            }
        });
    }
    
    private void iniciarVistaModificarCliente() {
    	Interfaz_ModificarCliente modCli = new Interfaz_ModificarCliente();
    	modCli.setVisible(true);
    	modCli.setLocationRelativeTo(null);
    	JTextField txtNombre = modCli.getTextNombre();
    	JTextField txtApellido = modCli.getTextApellido();
    	JTextField txtDNI = modCli.getTextDNI();
    	JTextField txtEdad = modCli.getTextEdad();
    	JTextField txtTelefono = modCli.getTextTelefono();
    	JTextField txtMail = modCli.getTextMail();
    	JComboBox comboBoxContactoPref = modCli.getContactPreferece();
    	JButton btnGuardar = modCli.getBtnGuardar();
    	
    	btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String contactoPref = null;
				if (comboBoxContactoPref.getSelectedItem().equals("Teléfono")) {
					contactoPref = "wpp";
				}
				if (comboBoxContactoPref.getSelectedItem().equals("Whatsapp")) {
					contactoPref = "telefono";
				}
				if (comboBoxContactoPref.getSelectedItem().equals("Email")) {
					contactoPref = "mail";
				}
				
				if (txtDNI.getText() != "") {
					for (Cliente c : clientes) {
						if (c.getDNI().equals(txtDNI.getText())) {
							if (!txtApellido.getText().equals("") && txtApellido.getText() != null) {
								c.setApellido(txtApellido.getText());
							}
							if (!txtNombre.getText().equals("") && txtNombre.getText() != null) {
								c.setNombre(txtNombre.getText());
							}
							if (!txtEdad.getText().equals("") && txtEdad.getText() != null) {
								c.setEdad(Integer.parseInt(txtEdad.getText()));
							}
							if (!txtTelefono.getText().equals("") && txtTelefono.getText() != null) {
								c.setTelefono(txtTelefono.getText());
							}
							if (!txtMail.getText().equals("") && txtMail.getText() != null) {
								c.setMail(txtMail.getText());
							}
							c.setContactoPref(contactoPref);
						}
						
					}	
					modCli.dispose();
					iniciarVistaClientesABM();
				}
			}
		});
    	
    	modCli.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	modCli.dispose();
                iniciarVistaClientesABM();
            }
        });
    }
    
    private void iniciarVistaAgregarCliente() {
    	Interfaz_AgregarCliente agrCli = new Interfaz_AgregarCliente();
    	agrCli.setVisible(true);
    	agrCli.setLocationRelativeTo(null);
    	JTextField txtNombre = agrCli.getTextNombre();
    	JTextField txtApellido = agrCli.getTextApellido();
    	JTextField txtDNI = agrCli.getTextDNI();
    	JTextField txtEdad = agrCli.getTextEdad();
    	JTextField txtTelefono = agrCli.getTextTelefono();
    	JTextField txtMail = agrCli.getTextMail();
    	JButton btnRegistrar = agrCli.getBtnRegistrar();
    	JComboBox comboBoxContactoPref = agrCli.getContactPreferece();
    	
    	JTextField txtPassword = agrCli.getTextPassword();
    	
    	btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String contactoPref = null;
				if (comboBoxContactoPref.getSelectedItem().equals("Teléfono")) {
					contactoPref = "wpp";
				}
				if (comboBoxContactoPref.getSelectedItem().equals("Whatsapp")) {
					contactoPref = "telefono";
				}
				if (comboBoxContactoPref.getSelectedItem().equals("Email")) {
					contactoPref = "mail";
				}
				if (!txtNombre.getText().equals("") && !txtApellido.getText().equals("") && !txtDNI.getText().equals("") && !txtEdad.getText().equals("") && !txtTelefono.getText().equals("") && !txtMail.getText().equals("") && !txtPassword.equals("")) {
					clientes.add(new Cliente(txtNombre.getText(), txtApellido.getText(), txtDNI.getText(), Integer.parseInt(txtEdad.getText()), txtTelefono.getText(), txtMail.getText(), contactoPref, txtPassword.getText()));					
					agrCli.dispose();
					iniciarVistaClientesABM();
				}
			}
		});

    	agrCli.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	agrCli.dispose();
                iniciarVistaClientesABM();
            }
        });
    }
    
    private void iniciarVistaCambiarPassword() {
    	Interfaz_CambiarPassword camPass = new Interfaz_CambiarPassword();
    	camPass.setVisible(true);
    	camPass.setLocationRelativeTo(null);
    	JButton btnCambiar = camPass.getBtnCambiar();
    	JTextField txtPassword = camPass.getTextPassword();
    	
    	btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clienteActual.setPassword(txtPassword.getText());
				camPass.dispose();
				iniciarVistaCliente();
			}
		});
    	
    	camPass.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	camPass.dispose();
                iniciarVistaCliente();
            }
        });
    }
    
    private void iniciarVistaCliente() {
    	Interfaz_PaginaCliente pagCliente = new Interfaz_PaginaCliente();
    	JButton btnVerMisReservas = pagCliente.getBtnVerMisReservas();
    	JButton btnReservar = pagCliente.getBtnReservar();
    	JButton btnCerrarSesion = pagCliente.getBtnCerrarSesion();
    	JButton btnCambiarPassword = pagCliente.getBtnCambiarPassword();
    	
    	pagCliente.setVisible(true);
    	pagCliente.setLocationRelativeTo(null);
    	if (btnVerMisReservas != null) {
    		btnVerMisReservas.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				pagCliente.dispose();
    				iniciarVistaVerReservas();
    			}
    		});
    	}
    	
    	if (btnCambiarPassword != null) {
    		btnCambiarPassword.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				pagCliente.dispose();
    				iniciarVistaCambiarPassword();
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
    
    private void generarReporteHabitaciones() {
    	for (AbstractHabitacion h : habitaciones) {
    		String disponible;
    		if (h.isDisponible()) {
    			disponible = "disponible";
    		} else {
    			disponible = "no disponible";
    		}
    		System.out.println("La habitacion " + h.getIdHabitacion() + " se encuentra " + disponible);
    	}
    }
    
    private void mostrarAuditoria() {
    	auditoria.mostrarLogs();
    }
}