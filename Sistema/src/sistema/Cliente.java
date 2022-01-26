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

class Cliente implements java.io.Serializable
{
    private String Nombre;
    private String Direccion;
    private String Telefono;
    
    public Cliente() 
    {
        this.Nombre = "";
        this.Direccion = "";
        this.Telefono = "";
    }
    

    public Cliente(String Nombre, String Direccion, String Telefono) 
    {
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
    }

    public String getNombre() 
    {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    
    
}
