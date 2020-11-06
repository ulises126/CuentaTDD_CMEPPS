package banco;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ulises
 */

public class CuentaTest {
    
    Cuenta cuenta;
    
    public CuentaTest() {
    }
    
    @Before
    public void setUp() {
        cuenta = new Cuenta("123","pepe");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testIngresar_basico() {
        System.out.println("TestIngresar:");
        double cantidad = 100.0;
        
        try{   
            cuenta.ingresar(cantidad);     
        } catch (Exception e){
            System.out.println("" + e);
            fail("Excepcion no esperada");
        }
        
        double saldo = cuenta.getSaldo();
        assert(200.0 == saldo); 
    }
    
    public void testIngresar_negativo() {
        System.out.println("TestIngresar_negativo:");
        double cantidad = -100.0;
        
        try{   
            cuenta.ingresar(cantidad); 
            fail("No ha saltado la excepcion esperada");
        } catch (Exception e){
            System.out.println("TestIngresar_negativo:");
            String message = "No se pueden ingresar cantidades negativas";
            assertEquals(message, "" + e);
        } 
    }
    
    @Test
    public void testRetirar_basico() {
        System.out.println("TestRetirar_basico:");
        double cantidad = 100.0;
        
        try{   
            cuenta.retirar(cantidad);     
        } catch (Exception e){
            System.out.println(e.getMessage());
            fail("Excepcion no esperada");
        }
        
        double saldo = cuenta.getSaldo();
        assert(200.0 == saldo);  
    }
    
    @Test
    public void testRetirar_negativo() {
        System.out.println("TestRetirar_negativo:");
        double cantidad = -100.0;
        
        try{   
            cuenta.retirar(cantidad); 
            fail("No ha saltado la excepcion esperada");
        } catch (Exception e){
            String message = "java.lang.Exception: No se puede retirar una "
                    + "cantidad negativa";
            assertEquals(message, "" + e);
        } 
    }
    
    @Test
    public void testRetirar_saldoInsuficiente() {
        System.out.println("TestRetirar_saldoInsuficiente:");
        double cantidad = 300.0;
        
        try{   
            cuenta.retirar(cantidad); 
            fail("No ha saltado la excepcion esperada");
        } catch (Exception e){
            String message = "java.lang.Exception: Saldo insuficiente";
            assertEquals(message, "" + e);
        } 
    }
    
    @Test
    public void testGetSaldo() throws Exception {
        System.out.println("TestGetSaldo:");
        double cantidad = 200.0;
        cuenta.ingresar(cantidad);
        double saldo = cuenta.getSaldo();
        assert(saldo == cantidad);
    }
    
}
