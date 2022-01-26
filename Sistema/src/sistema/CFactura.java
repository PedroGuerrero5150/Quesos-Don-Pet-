/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import java.util.ArrayList;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *
 * @author pedro
 */
public class CFactura implements java.io.Serializable
{
    private ArrayList <TQueso> Quesos;
    private String id;
    private Cliente Cliente;
    private String Carrito;
    private double valorTotal;
    private static DecimalFormat df = new DecimalFormat("0.00");
    
    
    public CFactura() 
    {
        this.Quesos = new ArrayList<> ();
        this.id = "";
        this.Cliente = new Cliente ();
        this.valorTotal = 0;
    }
    

    public CFactura(ArrayList<TQueso> Quesos, String id, Cliente Cliente) 
    {
        this.Quesos = Quesos;
        this.id = id;
        this.Cliente = Cliente;
        this.Carrito = "";
    }
    
    
    public ArrayList<TQueso> getQuesos() 
    {
        return Quesos;
    }

    public void setQuesos(ArrayList<TQueso> Quesos) 
    {
        this.Quesos = Quesos;
    }

    public String getId() 
    {
        return id;
    }

    public void setId(String id) 
    {
        this.id = id;
    }

    public Cliente getCliente() 
    {
        return Cliente;
    }

    public void setCliente(Cliente Cliente) 
    {
        this.Cliente = Cliente;
    }

    public String getCarrito() {
        return Carrito;
    }

    public void setCarrito(String Carrito) {
        this.Carrito = Carrito;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public static DecimalFormat getDf() {
        return df;
    }

    public static void setDf(DecimalFormat df) {
        CFactura.df = df;
    }
    
    
    
    
  
     public String printContenido ()
    {
        String Contenido = "";
        
        int cantidadEsferico = 0;
        int cantidadCilindrico = 0;
        int cantidadCHueco = 0;
                
        double precioEsferico = 0;
        double precioCilindrico = 0;
        double precioCHueco = 0;
        
        
        for (TQueso obj: Quesos)
        {
            if (obj instanceof QEsferico )
            {
             cantidadEsferico = obj.getCantidad();
             precioEsferico = obj.precio();
            }
            
            if (obj instanceof QCilindrico)
            {
                if(obj instanceof QCHueco==false)
                {
                    cantidadCilindrico = obj.getCantidad();
                    precioCilindrico = obj.precio();
                }
            }
            
            if (obj instanceof QCHueco)
            {
             cantidadCHueco= obj.getCantidad();
             precioCHueco = obj.precio();
            }
        }
        
        valorTotal = cantidadEsferico*precioEsferico +
                            cantidadCilindrico*precioCilindrico +
                            cantidadCHueco*precioCHueco;
        
        
        Contenido = "-------------------------FACTURA--------------------------\n"+
                   "ID: " +  getId()+"\n\n"+
                   "Nombre: " +  Cliente.getNombre()+"\n\n"+
                   "Teléfono: " +  Cliente.getTelefono()+"\n\n"+
                   "Dirección: " +  Cliente.getDireccion()+"\n\n"+
                   "Cantidad Queso Esferico: "+ cantidadEsferico+"\n"+ 
                   "Precio por unidad: " + df.format(precioEsferico)+"\n\n"+
                   "Cantidad Queso Cilindrico: "+ cantidadCilindrico+"\n"+ 
                   "Precio por unidad: " + df.format(precioCilindrico)+"\n\n"+
                   "Cantidad Queso Cilindrico hueco: "+ cantidadCHueco+"\n"+ 
                   "Precio por unidad: " + df.format(precioCHueco)+"\n\n"+
                   "\t\t\t\t\t\t\t"+"Precio Total: " +df.format(valorTotal); 
         
        return Contenido;           
    }
    
}
