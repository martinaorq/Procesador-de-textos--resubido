/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesador.de.textos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.StyledEditorKit.*;
import javax.swing.text.*;




public class ProcesadorDeTextosCheckRadioButton {

    public static void main(String[] args) {
        ventanaProcesador4 p=new ventanaProcesador4();
}
    
}
class ventanaProcesador4 extends JFrame{
    public ventanaProcesador4(){
        setBounds(200,200,600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Procesador de textos");
        
        laminaprocesador4 pro=new laminaprocesador4();
        add(pro);
        
    }
}



class laminaprocesador4 extends JPanel{
        JToolBar barraherramienta;
        JMenuItem menuitem;
        JCheckBoxMenuItem menuitembox;
        JRadioButtonMenuItem menuitemradio;
        Font fuente=new Font("Calibri",Font.PLAIN,12);
        JMenuBar barramenu;
        JPanel barraarriba;
        JTextPane areatexto;
        
        
    public laminaprocesador4(){
        //*Agregamos componentes**************************************************
        setLayout(new BorderLayout());
        
        
        barraherramienta=new JToolBar();
        barraarriba= new JPanel();
        barramenu=new JMenuBar();
        areatexto=new JTextPane();
        
        areatexto.setFont(fuente);
        
        JMenu estilo=new JMenu("Estilo");
        JMenu fuente=new JMenu("Fuente");
        JMenu tamano=new JMenu("Tamaño");
        
        barraarriba.setLayout(new BorderLayout());
        barraarriba.add(barramenu, BorderLayout.WEST);
        barraarriba.setBackground(Color.LIGHT_GRAY);
        
        add (barraarriba, BorderLayout.NORTH);
        add (areatexto, BorderLayout.CENTER);
        
        
        //Iconos*****
        ImageIcon negritaicono=new ImageIcon("imagenes/bold.png");
        ImageIcon cursivaicono=new ImageIcon("imagenes/italic.png");
        ImageIcon subrayadoicono=new ImageIcon("imagenes/underline.png");
        
        ImageIcon nadaicono=new ImageIcon("");
        
        //***********
        
         procesadorcontrol(estilo, "Cursiva", "", "",cursivaicono);
         procesadorcontrol(estilo, "Negrita", "", "",negritaicono);
         procesadorcontrol(estilo, "Subrayado", "", "",subrayadoicono);
         
         procesadorcontrol(fuente, "", "", "Courier New",nadaicono);
         procesadorcontrol(fuente, "", "", "Times New Roman",nadaicono);
         procesadorcontrol(fuente, "", "", "Gadugi",nadaicono);
         
         procesadorcontrol(tamano, "", "10", "",nadaicono);
         procesadorcontrol(tamano, "", "12", "",nadaicono);
         procesadorcontrol(tamano, "", "14", "",nadaicono);
         
         
           
        //*************************************************************************
        
        botonesbarraherramienta("Cursiva",cursivaicono);
        botonesbarraherramienta("Negrita",negritaicono);
        botonesbarraherramienta("Subrayado",subrayadoicono);
        
        barraherramienta.addSeparator();
        
        botonesbarraherramienta("Rojo",new ImageIcon("imagenes/rojo.png"));
        botonesbarraherramienta("Verde",new ImageIcon("imagenes/verde.png"));
        botonesbarraherramienta("Azul",new ImageIcon("imagenes/azul.png"));
        
        barraherramienta.addSeparator();
        
        botonesbarraherramienta("Alineacion derecha",new ImageIcon("imagenes/der.png"));
        botonesbarraherramienta("Alineacion izquierda",new ImageIcon("imagenes/izq.png"));
        botonesbarraherramienta("Alineacion centrada",new ImageIcon("imagenes/central.png"));
        botonesbarraherramienta("Justificado",new ImageIcon("imagenes/justificado.png"));
        
        barraarriba.add(barraherramienta,BorderLayout.SOUTH);
        
        
        
        
        
    }
    public void botonesbarraherramienta(String nombre_boton,ImageIcon icon){
        JButton boton=new JButton(icon);
        
        if(nombre_boton.equals("Cursiva")){
                boton.addActionListener(new StyledEditorKit.ItalicAction());
            } 
            if(nombre_boton.equals("Negrita")){
                boton.addActionListener(new StyledEditorKit.BoldAction());
            } 
            if(nombre_boton.equals("Subrayado")){
                boton.addActionListener(new StyledEditorKit.UnderlineAction());
            } 
            if(nombre_boton.equals("Rojo")){
                boton.addActionListener(new StyledEditorKit.ForegroundAction("", Color.RED));
            }
            if(nombre_boton.equals("Azul")){
                boton.addActionListener(new StyledEditorKit.ForegroundAction("", Color.BLUE));
            }
            if(nombre_boton.equals("Verde")){
                boton.addActionListener(new StyledEditorKit.ForegroundAction("", Color.GREEN));
            }
            if(nombre_boton.equals("Alineacion derecha")){
                boton.addActionListener(new StyledEditorKit.AlignmentAction("", 2));
            }
            if(nombre_boton.equals("Alineacion centrada")){
                boton.addActionListener(new StyledEditorKit.AlignmentAction("",1));
            }
            if(nombre_boton.equals("Alineacion izquierda")){
                boton.addActionListener(new StyledEditorKit.AlignmentAction("", 0));
            }
            if(nombre_boton.equals("Justificado")){
                boton.addActionListener(new StyledEditorKit.AlignmentAction("", 3));
            }
            
        barraherramienta.add(boton);
    }
    
    
    
    
    public void procesadorcontrol (JMenu menu, String estilo,String tamano,String fuente, Icon icono){
        barramenu.add(menu);
        
        
        
        if ((menu.getText()).equals("Estilo")){
            menuitem=new JMenuItem(estilo,icono);
            
            if(menuitem.getText().equals("Cursiva")){
                menuitem.addActionListener(new StyledEditorKit.ItalicAction());
            } 
            if(menuitem.getText().equals("Negrita")){
                menuitem.addActionListener(new StyledEditorKit.BoldAction());
            } 
            if(menuitem.getText().equals("Subrayado")){
                menuitem.addActionListener(new StyledEditorKit.UnderlineAction());
            } 
            
        }
        else if ((menu.getText()).equals("Fuente")){
            menuitem=new JMenuItem(fuente,icono);
            menuitem.addActionListener(new StyledEditorKit.FontFamilyAction(menuitem.getText(),menuitem.getText()));
           
        }
        else if ((menu.getText()).equals("Tamaño")){
            menuitem=new JMenuItem(tamano,icono);
            menuitem.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", Integer.parseInt(tamano)));
            
        }
            
            menu.add(menuitem);
            
       }
 }


