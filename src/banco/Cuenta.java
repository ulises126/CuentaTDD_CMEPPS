package banco;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ulises
 */
public class Cuenta {
    
    protected String mNumero;
    protected String nTitular;
    protected ArrayList<Movimiento> mMovimientos;
    
    public Cuenta(String numero, String nombre){
        mNumero = numero;
        nTitular = nombre;
        mMovimientos = new ArrayList<>();
    }
    
}
