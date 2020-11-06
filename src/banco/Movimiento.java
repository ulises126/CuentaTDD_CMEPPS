package banco;

/**
 *
 * @author ulises126
 */

class Movimiento {
    
    private final double importe;
    private final String concepto;
    
    public Movimiento(double importe, String concepto){
        this.concepto = concepto;
        this.importe = importe;
    }
    
    public double getImporte(){ return this.importe; }
    public String getConcepto(){ return this.concepto; }
}
