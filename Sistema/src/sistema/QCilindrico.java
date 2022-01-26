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
public class QCilindrico extends  TQueso implements java.io.Serializable 
{
    protected double longitud;
    
     public QCilindrico()
    {
        super ();
        this.longitud = 0.4;
        this.precioBase = 2;
        this.precioUnitario = 1.50;
        this.radioE = 0.6;
        
    }
     
    public QCilindrico(double longitud, double precioBase, double precioUnitario, double radioE)
   {
       super ();
       this.longitud = longitud;
       this.precioBase = precioBase;
       this.precioUnitario = precioUnitario;
       this.radioE = radioE;

   }
    

    public QCilindrico(double longitud, double precioBase, double precioUnitario, double radioE, int cantidad)
    {
        super ();
        this.longitud = longitud;
        this.precioBase = precioBase;
        this.precioUnitario = precioUnitario;
        this.radioE = radioE;
        this.cantidad = cantidad;
        
    }

    @Override
    public double Volumen() 
    {
       return  Math.pow(radioE,2)*pi* longitud;
    }

    public double getLongitud() {
        return this.longitud;
    }

    public void setLongitud(float longitud) {
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
        return precioBase + (precioUnitario * Volumen());
    }
    
    
}
