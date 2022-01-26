/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema;

import java.math.BigDecimal;

/**
 *
 * @author pedro
 */
public abstract class TQueso implements java.io.Serializable
{
    protected double precioBase;
    protected double precioUnitario;
    protected double radioE;
    protected int cantidad;
    protected double pi =  3.1416;
    
    public TQueso() 
    {
        this.precioBase = 0.0;
        this.precioUnitario =  0.0;
        this.radioE = 0;
    }

    public TQueso(double precioBase, double precioUnitario, double radioE) 
    {
        this.precioBase = precioBase;
        this.precioUnitario = precioUnitario;
        this.radioE = radioE;
    }

    public double getPrecioBase() 
    {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) 
    {
        this.precioBase = precioBase;
    }

    public double getPrecioUnitario() 
    {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) 
    {
        this.precioUnitario = precioUnitario;
    }

    public double getRadioE() 
    {
        return radioE;
    }

    public void setRadioE(float radioE) 
    {
        this.radioE = radioE;
    }
    
    public abstract double Volumen();
    
    public abstract double precio(); 

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPi() {
        return pi;
    }

    public void setPi(double pi) {
        this.pi = pi;
    }
    
    
    
}
