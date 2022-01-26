/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

/**
 *
 * @author pedro
 */
public class QCHueco extends QCilindrico implements java.io.Serializable 
{
    private double radioI;

    public QCHueco() 
    {
        super ();
        this.radioI =0.2;
    }
    
    public QCHueco(double radioI, double longitud, double precioBase,
                   double precioUnitario, double radioE) 
    {
        super();
        
        this.longitud = longitud;
        this.precioBase = precioBase;
        this.precioUnitario = precioUnitario;
        this.radioE = radioE;
        this.radioI = radioI;
    }
    
    public QCHueco(double radioI, double longitud, double precioBase,
                   double precioUnitario, double radioE, int cantidad) 
    {
        super();
        
        this.longitud = longitud;
        this.precioBase = precioBase;
        this.precioUnitario = precioUnitario;
        this.radioE = radioE;
        this.radioI = radioI;
        this.cantidad = cantidad;
    }
    
    @Override
    public double Volumen() 
    {
       return (Math.pow(radioE,2)-Math.pow(radioI,2))* pi * longitud;
    }

    public double getRadioI() 
    {
        return radioI;
    }

    public void setRadioI(float radioI) 
    {
        this.radioI = radioI;
    }

    @Override
    public double getLongitud() 
    {
        return this.longitud;
    }

    @Override
    public void setLongitud(float longitud) 
    {
        this.longitud = longitud;
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
        
                
        return precio;
    }
}
