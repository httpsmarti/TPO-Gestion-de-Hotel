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
        
        //cancelar reservas Pendientes de pago con mas de 24 horas si
        
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
    
    private void iniciarVistaGerente() { //falta terminar
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
        if (btnVerReservas != null) {
        	btnVerReservas.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			registro.dispose();
                    iniciarVistaVerReservas();
        		}
        	});
        }
    }
    
    private void iniciarVistaVerReservas() {
    	Interfaz_MiReserva miRes = new Interfaz_MiReserva();
    	miRes.setVisible(true);
		miRes.setLocationRelativeTo(null);
		DefaultTableModel tabla = miRes.getTablaFuncional();
		JButton btnEliminarReserva = miRes.getBtnEliminarReserva();
		JButton btnAtras = miRes.getBtnAtras();
		
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
    
    public void iniciarVistaReserva() { //se puede avanzar sin haber seleccionado habitaciones CORREGIR
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
    	
    	String DNI;
    	
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
	            	
	            	System.out.println((comboboxCantPersonas.getSelectedItem().toString()));
	            	
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
				if (listaHabitaciones.size() > 0) {
					if (clienteActual == null) {
						interReserva.dispose();
		                iniciarVistaGerente();
					} else {
						interReserva.dispose();
		                iniciarVistaCliente();
					}
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
    
    private void iniciarVistaReservaDetalle(List<AbstractHabitacion> listaHabitaciones, String DNI) { //SIN TERMINAR
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
    	List<Huesped> huespedes = new ArrayList<Huesped>();
    	
    	tablaHabitaciones.setRowCount(0);
        for (AbstractHabitacion hab : listaHabitaciones) {
			Object[] linea = {hab.getIdHabitacion(), hab.getTipo(), hab.getPrecioPorNoche()};
			tablaHabitaciones.addRow(linea);
			tablaHabitaciones.fireTableDataChanged();
		}
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaMasUnDia = fechaActual.plusDays(1);
        Date fechaMaxima = Date.from(fechaMasUnDia.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		//
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
    					precioTotal *= politicas.getDtoTemprano()/100;
    		        } else if (diasHastaCheckIn <= politicas.getCantDiasTarde()) {
    		            // aplico recargo tarde
    		        	precioTotal *= (politicas.getRecragoTarde())/100 + 1;
    		        }
    				
    				if (diasHastaCheckIn >= politicas.getCantDiasTemprano()) {
    		            // aplico descuento temprano
    					precioTotal *= politicas.getDtoTemprano()/100;
    		        } else if (diasHastaCheckIn <= politicas.getCantDiasTarde()) {
    		            // aplico recargo tarde
    		        	precioTotal *= (politicas.getRecragoTarde())/100 + 1;
    		        }
            		
            		
            		precio.setText(String.valueOf(precioTotal));
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
        					precioTotal *= politicas.getDtoTemprano()/100;
        		        } else if (diasHastaCheckIn <= politicas.getCantDiasTarde()) {
        		            // aplico recargo tarde
        		        	precioTotal *= (politicas.getRecragoTarde())/100 + 1;
        		        }
        				
        				if (diasHastaCheckIn >= politicas.getCantDiasTemprano()) {
        		            // aplico descuento temprano
        					precioTotal *= politicas.getDtoTemprano()/100;
        		        } else if (diasHastaCheckIn <= politicas.getCantDiasTarde()) {
        		            // aplico recargo tarde
        		        	precioTotal *= (politicas.getRecragoTarde())/100 + 1;
        		        }
                		
                		
                		precio.setText(String.valueOf(precioTotal));
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
					pc.setEstrategia(new PagoEfectivo(fechaMaxima, Double.parseDouble(comboBoxBanco.getSelectedItem().toString())));
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
					precioTotal *= politicas.getDtoTemprano()/100;
		        } else if (diasHastaCheckIn <= politicas.getCantDiasTarde()) {
		            // aplico recargo tarde
		        	precioTotal *= (politicas.getRecragoTarde())/100 + 1;
		        }
				
				if (diasHastaCheckIn >= politicas.getCantDiasTemprano()) {
		            // aplico descuento temprano
					precioTotal *= politicas.getDtoTemprano()/100;
		        } else if (diasHastaCheckIn <= politicas.getCantDiasTarde()) {
		            // aplico recargo tarde
		        	precioTotal *= (politicas.getRecragoTarde())/100 + 1;
		        }
				
				
				
		        reservas.add(new Reserva(generarIdReserva(), precioTotal, dateCheckIn.getDate(), dateCheckOut.getDate(), Calendar.getInstance().getTime(), listaHabitaciones, DNI, huespedes, pc, "Pendiente de pago"));
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
                System.out.println("Fechas válidas: Check-Out es después de Check-In.");
                return true;
            } else {
                System.out.println("Fecha de Check-Out debe ser posterior a la fecha de Check-In.");
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
    
    private void iniciarVistaEliminarReserva() { //checkear si anda
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
							for (AbstractHabitacion h : r.getHabitaciones()) {
								h.setDisponible(true);
							}
						}
					}
				} else {
					for (Reserva r : reservas) {
						if (r.getIdReserva().equals(txtCod.getText()) && r.getDNIClienteReserva().equals(clienteActual.getDNI())){
							r.setEstado("Cancelada");
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
    				iniciarVistaModificarHabitacion(); //sin terminar
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
    	    			System.out.println("Entro al if");
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
				
				
				if (txtNombre.getText() != "" && txtApellido.getText() != "" && txtDNI.getText() != "" && txtEdad.getText() != "" && txtTelefono.getText() != "" && txtMail.getText() != "") {
					clientes.add(new Cliente(txtNombre.getText(), txtApellido.getText(), txtDNI.getText(), Integer.parseInt(txtEdad.getText()), txtTelefono.getText(), txtMail.getText(), contactoPref));					
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
    				//Interfaz_MiReserva
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