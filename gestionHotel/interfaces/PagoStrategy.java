package interfaces;
import java.util.*;

public interface PagoStrategy {
    void pagar(double monto); //como se hace esto? imprime Cliente X pagó Y con Z metodo?
    boolean estaPagado();
    Date getFechaMaxima();
}
