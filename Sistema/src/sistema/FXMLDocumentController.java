/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.io.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



/**
 *
 * @author pedro
 */
public class FXMLDocumentController implements Initializable 
{
    
    private CEmpresa Empresa =  new CEmpresa();
    private int ContadorFacturas = 0;
    private int ContadorQuesos = 0;
    private int ContadorClientes = 0;
    private static DecimalFormat df = new DecimalFormat("0.00");
    
    //files 
    //Quesos
    File Quesos; 
    boolean appendQuesos;
    //clientes
    File Clientes = new File ("Clientes.dat");
    boolean appendClientes = Clientes.exists();
    //Facturas
    File Facturas = new File ("Facturas.dat");
    boolean appendFacturas = Facturas.exists();
    
  
    
    //Preferencias Quesos
    //Esferico
    String QEsferico;
    private double radioEsferico= 0;
    private double precioBaseEsferico = 0;
    private double precioUnitarioEsferico = 0;
    //Cilindrico
    String QCilindrico;
    private double radioCilindrico= 0;
    private double longitudCilindrico= 0;
    private double precioBaseCilindrico = 0;
    private double precioUnitarioCilindrico = 0;
    //Cilindrico Hueco
    String QCHueco;
    private double radioCHueco= 0;
    private double radioInternoCHueco= 0;
    private double longitudCHueco= 0;
    private double precioBaseCHueco = 0;
    private double precioUnitarioCHueco = 0;
    
    //
    ArrayList <String> Preferencias = new ArrayList <>();
    
    //preferencias quesos
    @FXML
    private ComboBox cbPreferencias = new ComboBox();
    
    @FXML
    private TextField tfRadio = new TextField();
    
    @FXML
    private TextField tfRadioInterno = new TextField();
    
    @FXML
    private TextField tfLongitud = new TextField();
    
    @FXML
    private TextField tfPrecioBase = new TextField();
    
    @FXML
    private TextField tfPrecioUnitario = new TextField();
    
    @FXML
    private Button btActualizarPreferencias = new Button ();
    
    
    @FXML
    public void cbPreferenciasHandler (ActionEvent event)
    {
       switch(cbPreferencias.getValue().toString()) 
            {
                case "Esférico":
                tfRadio.setDisable(false);
                tfRadioInterno.setDisable(true);
                tfLongitud.setDisable(true);
                tfPrecioUnitario.setDisable(false);
                tfPrecioBase.setDisable(false);
                btActualizarPreferencias.setDisable(false);
                break;
                
                    
                case "Cilíndrico":  
                tfRadio.setDisable(false);
                tfRadioInterno.setDisable(true);
                tfLongitud.setDisable(false);
                tfPrecioUnitario.setDisable(false);
                tfPrecioBase.setDisable(false);
                btActualizarPreferencias.setDisable(false);
                break;
                    
                case "Cilíndrico Hueco": 
                tfRadio.setDisable(false);
                tfRadioInterno.setDisable(false);
                tfLongitud.setDisable(false);
                tfPrecioUnitario.setDisable(false);
                tfPrecioBase.setDisable(false);
                btActualizarPreferencias.setDisable(false);
                break;
            }        
    }
    
    @FXML
    public void btActualizarPreferenciasHandler (ActionEvent event)throws ClassNotFoundException, IOException 
    {
        
        switch(cbPreferencias.getValue().toString()) 
             {
                 case "Esférico":         
                    try
                    {    
                       if (tfRadio.getText().isEmpty()==true ||
                       tfPrecioBase.getText().isEmpty()==true ||
                       tfPrecioUnitario.getText().isEmpty()==true)
                       {
                         throw new myException(2);
                       } 
                        
                        
                        
                       else if ((!tfRadio.getText().matches("[0-9]+.[0-9]+[0-9]") &&
                           !tfRadio.getText().matches("[0-9]+")) ||
                           (!tfPrecioBase.getText().matches("[0-9]+.[0-9]+[0-9]") &&
                           !tfPrecioBase.getText().matches("[0-9]+")) ||
                           (!tfPrecioUnitario.getText().matches("[0-9]+.[0-9]+[0-9]") &&
                           !tfPrecioUnitario.getText().matches("[0-9]+")))
                         
                       {
                         throw new myException(1);
                       }
                        
                       
                     else if (Double.valueOf(tfRadio.getText())<=0 ||
                             Double.valueOf(tfPrecioBase.getText())<=0 ||
                             Double.valueOf(tfPrecioUnitario.getText())<=0)
                     {
                      throw new myException(0);
                     }
                    
                     
                    else    
                        {
                          
                           radioEsferico = Double.valueOf(tfRadio.getText());
                           precioBaseEsferico = Double.valueOf(tfPrecioBase.getText());
                           precioUnitarioEsferico = Double.valueOf(tfPrecioUnitario.getText());
                           taQuesos.setText("-Preferencias Esfericos actualizadas");
                              
                        }      
                    }  
                   

                    catch (myException ex)
                    {
                        Alert x = new Alert (Alert.AlertType.ERROR, ex.getMessage(),
                                             ButtonType.OK);
                        x.show();
                    }
                    
                    
                    
                    
                 break;


                 case "Cilíndrico":  
                     
   
                    try
                    {
                        if (tfRadio.getText().isEmpty() || 
                            tfLongitud.getText().isEmpty() || 
                            tfPrecioBase.getText().isEmpty() || 
                            tfPrecioUnitario.getText().isEmpty())
                            {
                              throw new myException(2);
                            }
                        
                        else if ((!tfRadio.getText().matches("[0-9]+.[0-9]+[0-9]") &&
                           !tfRadio.getText().matches("[0-9]+")) ||
                           (!tfPrecioBase.getText().matches("[0-9]+.[0-9]+[0-9]") &&
                           !tfPrecioBase.getText().matches("[0-9]+")) ||
                           (!tfPrecioUnitario.getText().matches("[0-9]+.[0-9]+[0-9]") &&
                           !tfPrecioUnitario.getText().matches("[0-9]+"))||
                           (!tfLongitud.getText().matches("[0-9]+.[0-9]+[0-9]") &&
                           !tfLongitud.getText().matches("[0-9]+")))
                         
                       {
                         throw new myException(1);
                       }
                        
                        
                        
                        else if (Double.valueOf(tfRadio.getText())<=0 ||
                                 Double.valueOf(tfLongitud.getText())<=0 ||
                                 Double.valueOf(tfPrecioBase.getText())<=0 ||
                                 Double.valueOf(tfPrecioUnitario.getText())<=0)
                        {
                            throw new myException(0);
                        }
                        
                        else
                        {
                            radioCilindrico = Double.valueOf(tfRadio.getText());
                            longitudCilindrico = Double.valueOf(tfLongitud.getText());
                            precioBaseCilindrico = Double.valueOf(tfPrecioBase.getText());
                            precioUnitarioCilindrico = Double.valueOf(tfPrecioUnitario.getText());
                            taQuesos.setText("-Preferencias Quesos Cilindricos actualizadas");
                            
                        
                        }
                    }
                     
                    catch (myException ex)
                    {
                        Alert x = new Alert (Alert.AlertType.ERROR, ex.getMessage(),
                                             ButtonType.OK);
                        x.show();
                    } 

                 break;

                 case "Cilíndrico Hueco": 
                     
                    try
                    {
                        if (tfRadio.getText().isEmpty()|| 
                            tfLongitud.getText().isEmpty()||
                            tfRadioInterno.getText().isEmpty()||
                            tfPrecioBase.getText().isEmpty()||
                            tfPrecioUnitario.getText().isEmpty())

                            {
                              throw new myException(2); 
                            }
                        
                        
                        else if ((!tfRadio.getText().matches("[0-9]+.[0-9]+[0-9]") &&
                           !tfRadio.getText().matches("[0-9]+")) ||
                           (!tfPrecioBase.getText().matches("[0-9]+.[0-9]+[0-9]") &&
                           !tfPrecioBase.getText().matches("[0-9]+")) ||
                           (!tfPrecioUnitario.getText().matches("[0-9]+.[0-9]+[0-9]") &&
                           !tfPrecioUnitario.getText().matches("[0-9]+"))||
                           (!tfLongitud.getText().matches("[0-9]+.[0-9]+[0-9]") &&
                           !tfLongitud.getText().matches("[0-9]+")) ||
                           !tfRadioInterno.getText().matches("[0-9]+.[0-9]+[0-9]") &&
                           !tfRadioInterno.getText().matches("[0-9]+"))
                         
                       {
                         throw new myException(1);
                       }
                         
                        
                        else if (Double.valueOf(tfRadio.getText())<=0 ||
                                 Double.valueOf(tfLongitud.getText())<=0 ||
                                 Double.valueOf(tfRadioInterno.getText())<=0 ||
                                 Double.valueOf(tfPrecioBase.getText())<=0 ||
                                 Double.valueOf(tfPrecioUnitario.getText())<=0)
                        {
                            throw new myException(0);
                        }
                        
                        else if (Double.valueOf(tfRadioInterno.getText()) < 
                                 Double.valueOf(tfRadio.getText())==false)
                        {
                            throw new myException(4);
                        }
                        
                        else
                        {
                            radioCHueco = Double.valueOf(tfRadio.getText());
                            radioInternoCHueco = Double.valueOf(tfRadioInterno.getText());
                            longitudCHueco = Double.valueOf(tfLongitud.getText());
                            precioBaseCHueco = Double.valueOf(tfPrecioBase.getText());
                            precioUnitarioCHueco = Double.valueOf(tfPrecioUnitario.getText());
                            taQuesos.setText("-Preferencias Quesos Cilindricos Huecos actualizadas");
                   
                        }
                        
                    }
                    
                    catch (myException ex)
                    {
                        Alert x = new Alert (Alert.AlertType.ERROR, ex.getMessage(),
                                             ButtonType.OK);
                        x.show();
                    } 
                 break;
             }  
        
        
        QEsferico = "Esferico "+"("+"R="+radioEsferico+")";
        QCilindrico = "Cilindrico "+"("+"R="+radioCilindrico+
                      ","+  " L= "+ longitudCilindrico +  ")";
        QCHueco = "Cilindrico Hueco "+"("+"RE="+radioCHueco +
                   ","+ " RI= "+ radioInternoCHueco + ","+" L= "
                   + longitudCilindrico +")";
                                                                       
                                                                                                                                      
        
        
        
        ObservableList<String> Stock = 
              FXCollections.observableArrayList(QEsferico,QCilindrico,QCHueco );
                                                                                                                 
                                                                        
        
        cbQueso.setItems(Stock);
        
        
        

    }
    
    
    
    
    //datos clientes
    @FXML
    private TextField tfNombre = new TextField();
    
    @FXML
    private TextField tfDireccion = new TextField();
    
    @FXML
    private TextField tfTelefono = new TextField();
    
    @FXML
    private TextField tfID = new TextField();
    
    @FXML
    private Button btGenerarFactura = new Button ();
    
    
    public void btGenerarFacturaHandler (ActionEvent event) throws ClassNotFoundException, IOException
    {
        try 
        {    
            if (tfNombre.getText().isEmpty()||
                tfDireccion.getText().isEmpty()||
                tfTelefono.getText().isEmpty()||
                tfID.getText().isEmpty())
            {
                throw new myException(2);
            }
            
            else if (!tfNombre.getText().matches("[a-zA-Z_]+" + " " +"[a-zA-Z_]+"))
            {
                throw new myException(5);
            }
            
            else if(!tfTelefono.getText().matches("[0-9]+"))
            {
                throw new myException(6);
            }
            
            else if ((tfTelefono.getText().length() != 7 &&
                     tfTelefono.getText().length() != 10))
            {
             throw new myException(6);
            }
            
            else if ((tfTelefono.getText().length() == 10 && 
                      !tfTelefono.getText().startsWith("09")))
            {
             throw new myException(6);
            }
            
            else if (tfID.getText().length() != 4 || 
                      !tfID.getText().matches("[0-9]+"))
            {
             throw new myException(7);
            }
            
            else if (Empresa.facturaDuplicada(tfID.getText()))
            {
             throw new myException(9);
            }

            else
            {
                //Escritura memoria externa
                //Clientes
                try (FileOutputStream fout = new FileOutputStream(Clientes, appendClientes);
                    AppendableObjectOutputStream oout = new AppendableObjectOutputStream(fout,appendClientes);)
                    {       
                        oout.writeObject (new Cliente (tfNombre.getText(), 
                        tfDireccion.getText(), tfTelefono.getText()));    
                        appendClientes = Clientes.exists();
                    }
                


                //Leer file y cargar facturas antiguas memoria interna, contar facturas
                if (appendFacturas)
                {
                    Empresa.getFacturas().clear();
                    try (
                        FileInputStream finput = new FileInputStream("Facturas.dat");
                        ObjectInputStream input = new ObjectInputStream (finput);
                        )

                    {
                        ContadorFacturas = 0;
                        while (true)
                        {
                            Object aux = new Object ();
                            aux = input.readObject();
                            ContadorFacturas++;
                            Empresa.getFacturas().add( (CFactura) aux ); 
                            System.out.println("Se anadio factura 1");
                        }
                        

                    }
                    catch (EOFException ex)
                    {
                       System.out.println("Hay " + ContadorFacturas + " Facturas");
                       
                    }

                    catch (StreamCorruptedException e)
                    {
                        System.out.println("Hay " + ContadorFacturas + " Facturas"); 
                    }

                }
                
                else
                {
                  System.out.println("No habian facturas " +ContadorFacturas ); 
                  
                }
            
                
                
                //contar cuantos clientes en contador clientes y añadirlos a
                //facturas antiguas (sin cliente actual)
                if (appendClientes)
                {

                    try (
                        FileInputStream finput = new FileInputStream("Clientes.dat");
                        ObjectInputStream input = new ObjectInputStream (finput);
                        )

                    {
                        ContadorClientes = 0;

                        while (true)
                        {
                            
                            if(ContadorFacturas==0)
                            {
                                Object aux = new Object ();
                                aux = input.readObject(); 
                                ContadorClientes++;
                            }
                           
                            else
                            {
                                for (int i = 0; i<ContadorFacturas; i++)
                                {
                                    Object aux = new Object ();
                                    aux = input.readObject();
                                    ContadorClientes++;     
                                    Empresa.getFacturas().get(i).setCliente((Cliente) aux);         
                                }
                            }
                            
                        }
                        

                    }
                    catch (EOFException ex)
                    {
                       System.out.println("Hay " + ContadorClientes + " Clientes");
                    
                    }

                    catch (StreamCorruptedException e)
                    {
                        System.out.println("Corrupted File"); 
                    }

                }
                else
                {System.out.println("No hay Clientes"); }
                
    
                //Disable nodes
                tfNombre.setEditable(false);
                tfDireccion.setEditable(false);
                tfTelefono.setEditable(false);
                tfID.setEditable(false);
                cbQueso.setDisable(false);

               //Enable nodes
                btGenerarFactura.setDisable(true);
            }
        }
        
        catch (myException ex)
        {
            Alert x = new Alert (Alert.AlertType.ERROR, ex.getMessage(),
                                 ButtonType.OK);
            x.show();
        } 
        
        Quesos = new File ("Quesos"+ContadorClientes+".dat");
        appendQuesos = Quesos.exists();
        
        taQuesos.clear();
         
    }
    
    

    
   //seleccion producto
    @FXML
    private ComboBox cbQueso = new ComboBox ();
    
    @FXML
    private TextField tfCantidad = new TextField ();;
    
    @FXML
    private TextArea taQuesos = new TextArea();
    
    @FXML
    private Button btAddQuesos = new Button();
    
    @FXML
    private Button btImprimirFactura = new Button();
    
    @FXML
    private Button btNuevaFactura = new Button();
    
    
    //handlers
    
    @FXML
    public void btAddHandler(ActionEvent event) throws ClassNotFoundException, IOException
    {
 
        try
        {
            if(tfCantidad.getText().isEmpty())
            {
              throw new myException(2);
            }
            
            else if (Integer.parseInt(tfCantidad.getText())<=0)
            {
              throw new myException(0);
            }
            
            else if(!tfCantidad.getText().matches("[0-9]+"))
            {
              throw new myException(8);
            }
            
            else if (radioEsferico == 0 || radioCilindrico ==0 ||
                     radioCHueco == 0)
            {
              throw new myException(3);
            }
            
            else  
            { 
 
                    if (cbQueso.getValue().toString()==QEsferico)
                    {
                        try (FileOutputStream fout = new FileOutputStream(Quesos, appendQuesos);
                        AppendableObjectOutputStream oout = new AppendableObjectOutputStream(fout,appendQuesos);)
                            {    
                               appendQuesos = Quesos.exists(); 
                               oout.writeObject(new QEsferico (precioBaseEsferico,
                                precioUnitarioEsferico,
                                radioEsferico,Integer.parseInt(tfCantidad.getText())));
                                appendQuesos = Quesos.exists();
                            }

                        taQuesos.setText(taQuesos.getText()+"\n-"+tfCantidad.getText() + 
                                     " quesos esféricos han "
                                     + "sido añadidos al carrito");
                    }
                     
                 

                    else if (cbQueso.getValue().toString()==QCilindrico)
                    {                     
                        try (FileOutputStream fout = new FileOutputStream(Quesos, appendQuesos);
                        AppendableObjectOutputStream oout = new AppendableObjectOutputStream(fout,appendQuesos);)
                        {
                            appendQuesos = Quesos.exists();
                            oout.writeObject(new QCilindrico (longitudCilindrico,
                            precioBaseCilindrico,
                            precioUnitarioCilindrico,
                            radioCilindrico,
                            Integer.parseInt(tfCantidad.getText())));     
                            appendQuesos = Quesos.exists();
                        }

                         taQuesos.setText(taQuesos.getText()+"\n-"+tfCantidad.getText() + 
                                     " quesos cilíndricos han "
                                     + "sido añadidos al carrito");
                    }

                    else if (cbQueso.getValue().toString()==QCHueco)
                    {    
                        try (FileOutputStream fout = new FileOutputStream(Quesos, appendQuesos);
                        AppendableObjectOutputStream oout = new AppendableObjectOutputStream(fout,appendQuesos);)
                        {     
                            appendQuesos = Quesos.exists();
                            oout.writeObject(new QCHueco(radioInternoCHueco, longitudCHueco,
                            precioBaseCHueco,
                            precioUnitarioCHueco,
                            radioCHueco,Integer.parseInt(tfCantidad.getText())));
                            appendQuesos = Quesos.exists();
                        }

                         taQuesos.setText(taQuesos.getText()+"\n-"+tfCantidad.getText() + 
                                     " quesos cilíndricos huecos han "
                                     + "sido añadidos al carrito");
                    }
                 

                btImprimirFactura.setDisable(false);
                tfCantidad.setDisable(true);
            }
        }
        catch (myException ex)
        {
            Alert x = new Alert (Alert.AlertType.ERROR, ex.getMessage(),
                                 ButtonType.OK);
            x.show();
        } 
    }
    
    @FXML
    public void btImprimirFacturaHandler (ActionEvent event) throws ClassNotFoundException, IOException
    {
      //Disable nodes
      btAddQuesos.setDisable(true);
      btImprimirFactura.setDisable(true);
      cbQueso.setDisable(true);
      
      //Enable nodes
      btNuevaFactura.setDisable(false);
      btActualizar.setDisable(false);
      btBuscarFactura.setDisable(false);
      
      
    /**************************************************************************/
    /* */ ArrayList <TQueso> QuesosA = new ArrayList <TQueso> ();
      
       //leer los quesos para cargarlos a memoria interna
        try (
              FileInputStream finput = new FileInputStream("Quesos"+ContadorClientes+".dat");

              ObjectInputStream input = new ObjectInputStream (finput);
           )   
        {
           Object aux;
           int contador = 0;
            
           while (true)
           {       
                aux = input.readObject();
                contador ++;

                


                if (aux instanceof QEsferico)
                {
                   QEsferico q = (QEsferico) aux;
                   QuesosA.add(q);
                }

                if (aux instanceof QCilindrico)
                {
                    if(aux instanceof QCHueco==false)
                  {
                    QCilindrico u = (QCilindrico) aux;
                    QuesosA.add(u);
                  }
                }
                
                
                if (aux instanceof QCHueco)
                {
                   QCHueco e = (QCHueco) aux;
                   QuesosA.add(e);
                }    
           }
        } 
           
        catch (EOFException ex)
         {
            System.out.println("No hay mas quesos"); 
         }

         catch (StreamCorruptedException e)
         {
             System.out.println("No hay mas quesos"); 
         }
      
    /**************************************************************************/      
     /* */
        
     
    /**************************************************************************/  
     /* */ 
   
        CFactura factura;
        
         try (FileOutputStream fout = new FileOutputStream(Facturas,appendFacturas);
                    AppendableObjectOutputStream oout = new AppendableObjectOutputStream
                   (fout,appendFacturas);)
                   {
                     factura = new CFactura (QuesosA,
                     tfID.getText(),new Cliente (tfNombre.getText(), 
                     tfDireccion.getText(), tfTelefono.getText()));
                       
                     oout.writeObject(factura);
                     appendFacturas = Facturas.exists();
                   }
        
          
        Empresa.getFacturas().add(factura);
        ContadorFacturas++;
        System.out.println("Se anadio factura 2");
        System.out.println("*************************************************");
        System.out.println("Hay "+ContadorClientes+" Clientes");
        System.out.println("Hay "+ContadorFacturas+" Facturas");
        System.out.println("Hay "+Empresa.getFacturas().size()+" Facturas");
        
        //taImpresion.setText(Empresa.getFacturas().get(ContadorFacturas-1).printContenido());
        taImpresion.setText(Empresa.getFacturas().get(ContadorFacturas-1).printContenido()); 
       
    
    
      // taImpresion.setText(factura.printContenido());
      
      //Impersion contendio
      //taImpresion.setText(Empresa.getFacturas().get(ContadorFacturas-1).printContenido());
      
    }
    
    @FXML
    public void btNuevaFacturaHandler (ActionEvent event)
    {
      tfNombre.clear();
      tfNombre.setEditable(true);
      
      tfDireccion.clear();
      tfDireccion.setEditable(true);
      
      tfTelefono.clear();
      tfTelefono.setEditable(true);
      
      tfID.clear();
      tfID.setEditable(true);
      
      taQuesos.clear();
      taImpresion.clear();
      
      btGenerarFactura.setDisable(false);
      cbQueso.setDisable(true);
      btNuevaFactura.setDisable(true);
    }
    

    
    @FXML
    public void cbQuesoHandler(ActionEvent event)
    {
       tfCantidad.setDisable(false);
       btAddQuesos.setDisable(false);
    }
  
    
    //imprmir factura
    
    @FXML
    private TextArea taImpresion = new TextArea ();
    
    @FXML
    private TextArea taDineroRecaudado = new TextArea ();
    
    @FXML
    private Button btActualizar = new Button ();
    
    @FXML
    private Button btBuscarFactura = new Button ();
    
    @FXML
    private TextField tfBuscarFactura = new TextField();
    
   
    @FXML
    public void btActualizarHandler(ActionEvent event)
    {
       taDineroRecaudado.setText(df.format(Empresa.acualizarValorRecaudado()));
       btActualizar.setDisable(true);
    }
    
    
    @FXML
    public void btBuscarFacturaHandler(ActionEvent event)
    {
        try
        {
           if(tfBuscarFactura.getText().isEmpty())
           {
            throw new myException(2);
           }
           
           else if (tfBuscarFactura.getText().length() != 4 || 
                      !tfBuscarFactura.getText().matches("[0-9]+"))
            {
             throw new myException(7);
            }
           
           else 
           {
             taImpresion.setText(Empresa.EncontrarFactura(tfBuscarFactura.getText()));
           }
        }

        catch (myException ex)
       {
           Alert x = new Alert (Alert.AlertType.ERROR, ex.getMessage(),
                                ButtonType.OK);
           x.show();
       } 
    }
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
         //preferencias
        //cbPreferencias
        cbPreferencias.getItems().addAll(
               "Esférico",
               "Cilíndrico",
               "Cilíndrico Hueco");
        
        
        //Textfields
        tfRadio.setDisable(true);
        tfRadioInterno.setDisable(true);
        tfLongitud.setDisable(true);
        tfPrecioUnitario.setDisable(true);
        tfPrecioBase.setDisable(true);
        
        //btGenerarFactura.setDisable(true);
        
        //buttons
        btActualizarPreferencias.setDisable(true);
        
        //Seleccion productos
        //cbQuesos
        cbQueso.getItems().addAll(
               "Esférico",
               "Cilíndrico",
               "Cilíndrico Hueco");
        
        
        
        cbQueso.setDisable(true);

        //tf cantidad
        tfCantidad.setDisable(true);

        //bt add
        btAddQuesos.setDisable(true);
        
         //bt Nueva Factura
        btNuevaFactura.setDisable(true);

        
        //Impresion Facturas
        //bt ImprimirFactura
        btImprimirFactura.setDisable(true);

        //bt Actualizar
        btActualizar.setDisable(true);
        
        //btBuscar
        btBuscarFactura.setDisable(true);
      
        
    }    
   
}
