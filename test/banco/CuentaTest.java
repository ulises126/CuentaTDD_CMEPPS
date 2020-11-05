/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usuario
 */
public class CuentaTest {
    
    Cuenta cuenta;
    
    public CuentaTest() {
    }
    
    @Before
    public void setUp() {
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
            System.out.println(e.getMessage());
            fail("Excepcion no esperada");
        }
        
        double saldo = cuenta.getSaldo();
        assertEquals(saldo, 100.0); 
    }
    
    public void testIngresar_negativo() {
        System.out.println("TestIngresar_negativo:");
        double cantidad = 100.0;
        
        try{   
            cuenta.ingresar(cantidad); 
            fail("No ha saltado la excepcion esperada");
        } catch (Exception e){
            assertEquals(e.getMessage(), "No se pueden ingresar cantidades "
                    + "negativas");
        } 
    }
    
    @Test
    public void testRetirar_basico() {
        System.out.println("TestRetirar_basico:");
        cuenta = new Cuenta("1234.1234.12.123456789", "Matt Damon");
        cuenta.ingresar(900.0);
        double cantidad = 100.0;
        
        try{   
            cuenta.retirar(cantidad);     
        } catch (Exception e){
            System.out.println(e.getMessage());
            fail("Excepcion no esperada");
        }
        
        double saldo = cuenta.getSaldo();
        assertEquals(800.0, saldo);  
    }
    
    @Test
    public void testRetirar_negativo() {
        System.out.println("TestRetirar_negativo:");
        double cantidad = -100.0;
        
        try{   
            cuenta.retirar(cantidad); 
            fail("No ha saltado la excepcion esperada");
        } catch (Exception e){
            assertEquals(e.getMessage(), "No se pueden retirar cantidades "
                    + "negativas");
        } 
    }
    
    @Test
    public void testRetirar_saldoInsuficiente() {
        System.out.println("TestRetirar_saldoInsuficiente:");
        cuenta = new Cuenta("1234.1234.12.123456789", "Matt Damon");
        cuenta.ingresar(100.0);
        double cantidad = 300.0;
        
        try{   
            cuenta.retirar(cantidad); 
            fail("No ha saltado la excepcion esperada");
        } catch (Exception e){
            assertEquals(e.getMessage(), "Saldo insuficiente");
        } 
    }
}
