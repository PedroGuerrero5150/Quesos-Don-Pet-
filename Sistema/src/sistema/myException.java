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
public class myException extends Exception
{
    private String msg;
    private int code;
    
    public myException (String message)
    {
        super(message);
    }
    
    public myException (int code)
    {
        super("");
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
    @Override
    public String getMessage()
    {
        switch (code)
        {    
            case 0:
                msg = "ERROR: Ingrese valores mayores a 0";
                break;
            
            case 1:
               msg = "ERROR: El formato es incorrecto, \n"+
                      "Ejemplo formato correcto: 3.45";
               break;
            
            case 2:
               msg = "ERROR: Llene todos los campos primero";
               break;
            
            case 3:
              msg = "ERROR: Debe actualizar las preferencias de cada queso"
                      + " almenos una vez";
              break;
            
            case 4:
              msg = "ERROR: El radio interno debe ser menor al externo";
              break;
              
            case 5:
              msg = "ERROR: Formato en campo Nombre incorrecto\n"+
                      "Ejemplo formato correcto: Noel Pérez";
              break;
            
            case 6:
              msg = "ERROR: Formato en campo Teléfono incorrecto\n"+
                     "Ejemplo formato correcto: 2231539 0 0983347244\n"+
                      "(7 o 9 digitos)";
              break;
              
            case 7:
              msg = "ERROR: Formato en campo ID es incorrecto\n"+
                     "Ejemplo formato correcto: 1234\n"+
                      "(4 digitos numericos)";
              break;
              
            case 8:
              msg = "ERROR: Formato en campo Cantidad es incorrecto\n"+
                     "Cantidad debe ser un entero mayor a 0";
              break; 
              
            case 9:
              msg = "ERROR: En campo ID\n"+
                     "Ya existe una factura con el ID ingresado";
              break;   
              
        
        
        }
        
        return msg;
    }
    
    
    
}
