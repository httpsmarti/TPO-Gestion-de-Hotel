package interfaces;
import java.util.*;

public interface PagoStrategy {
    void pagar(double monto); //como se hace esto? imprime Cliente X pagó Y con Z metodo? Respuesta: SI!!1!
    boolean estaPagado();
    Date getFechaMaxima();
    String getTipo();
}
