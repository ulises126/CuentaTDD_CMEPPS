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
    protected List<Movimiento> mMovimientos;
    
    public Cuenta(String numero, String nombre)
    {
        mNumero = numero;
        nTitular = nombre;
        mMovimientos = new ArrayList<>();
    }
    
    public void ingresar(double cantidad) throws Exception
    {
        if (cantidad <= 0)
            throw new Exception("No se puede ingresar una cantidad negativa");
        
        Movimiento m = new Movimiento(cantidad, "Ingreso en efectivo");
        this.mMovimientos.add(m);
    }
    
    public void retirar(double cantidad) throws Exception
    {
        if(cantidad <= 0)
            throw new Exception("No se puede retirar una cantidad negativa");
        
        if(this.getSaldo() < cantidad)
            throw new Exception("Saldo insuficiente");
        
        Movimiento m = new Movimiento(-cantidad, "Retirada de efectivo");
        this.mMovimientos.add(m);
    }
    
    public double getSaldo()
    {
        double saldo = 0.0;
        for(int i=0; i < mMovimientos.size(); i++)
        {
            saldo += mMovimientos.get(i).getImporte();
        }
        return saldo;
    }
}
