/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;


import java.lang.Math; 
import java.math.BigDecimal;



/**
 *
 * @author pedro
 */
public class QEsferico extends TQueso implements java.io.Serializable    
{

    
     public QEsferico() 
    {
        super();
        this.precioBase =  0.75;
        this.precioUnitario = 1.50;
        this.radioE = 0.05;
    }

    public QEsferico(double precioBase, double precioUnitario, double radioE) 
    {
        super();
        this.precioBase = precioBase;
        this.precioUnitario = precioUnitario;
        this.radioE = radioE;
    }
    
     public QEsferico(double precioBase, double precioUnitario, double radioE, int cantidad) 
    {
        super();
        this.precioBase = precioBase;
        this.precioUnitario = precioUnitario;
        this.radioE = radioE;
        this.cantidad = cantidad;
    }
    
    
    

    @Override
    public double Volumen() 
    {
       return (Math.pow(radioE,3)*pi*4)/3;
    }

     @Override
    public double getPrecioBase() {
        return this.precioBase;
    }

     @Override
    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

     @Override
    public double getPrecioUnitario() {
        return this.precioUnitario;
    }

     @Override
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

     @Override
    public double getRadioE() {
        return this.radioE;
    }

     @Override
    public void setRadioE(float radioE) {
        this.radioE = radioE;
    }

     @Override
    public double precio() 
    {
        double precio = precioBase + (precioUnitario * Volumen());
        System.out.println(precioBase);
        System.out.println(precioUnitario);
        System.out.println(radioE);
        System.out.println(pi);
        System.out.println(Volumen());
        //System.out.println(precio);
        
                
        return precio;
    }
    
    
    
    
}
