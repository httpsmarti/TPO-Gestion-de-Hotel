package model;

import java.util.*;

import interfaces.PagoStrategy;

public class Cliente extends AbstractCuenta {
    private int edad;
    private String password;
    private String contactoPref = "mail";

    public Cliente(String nombre, String apellido, String DNI, int edad, String telefono, String mail, String contactoPref, String password) {
        super(nombre, apellido, DNI, telefono, mail);
        this.edad = edad;
        this.password = password;
        setContactoPref(contactoPref);
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getContactoPref() {
        return contactoPref;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
    
    public String getPassword() {
    	return password;
    }

    public void setContactoPref(String contactoPref) {
        if (contactoPref.equals("mail") || contactoPref.equals("wpp") || contactoPref.equals("telefono")) {
            this.contactoPref = contactoPref;
        }
    }
}