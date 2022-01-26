/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class CEmpresa implements java.io.Serializable
{
    private ArrayList <CFactura> Facturas;
    private double valorRecaudado;
    
    public CEmpresa ()
    {
        Facturas = new ArrayList <> ();
        valorRecaudado = 0;
    }
    
    
    public ArrayList <CFactura> getFacturas()
    {
        return Facturas;
    }
    
    public double acualizarValorRecaudado ()
    {
        double valor = 0;
                
        for (CFactura fact: Facturas)
        {
           valor = valor +  fact.getValorTotal();
        }
        
        valorRecaudado = valor;
        
        return valorRecaudado;
    }
    
    public String EncontrarFactura(String ID)
    {
        String Contenido = "El ID no concuerda con ninguna Factura";
                
        for (CFactura fact: Facturas)
        {
           if(fact.getId().equals(ID))
           {
               Contenido = fact.printContenido();
           }  
        }
        
        return Contenido;
    }
    
    public Boolean facturaDuplicada (String ID)
    {
        Boolean Duplica = false;
        
        for (CFactura fact: Facturas)
        {
           if(fact.getId().equals(ID))
           {
               Duplica = true;
           }  
        }
        
     return Duplica;
    }
    
    
    
}
