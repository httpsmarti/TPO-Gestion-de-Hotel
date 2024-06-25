package interfaces;
import java.util.*;

public interface PagoStrategy {
    void pagar(double monto); 
    boolean estaPagado();
    Date getFechaMaxima();
    String getTipo();
}
