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




public class ProcesadorDeTextosStyledEditorKit {

    public static void main(String[] args) {
        ventanaProcesador2 p=new ventanaProcesador2();
}
    
}
class ventanaProcesador2 extends JFrame{
    public ventanaProcesador2(){
        setBounds(200,200,600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Procesador de textos");
        
        laminaprocesador2 pro=new laminaprocesador2();
        add(pro);
        
    }
}



class laminaprocesador2 extends JPanel{
    
       JMenuItem menuitem;
        Font fuente=new Font("Calibri",Font.PLAIN,12);
        JMenuBar barramenu;
        JPanel barraarriba;
        JTextPane areatexto;
        
        
    public laminaprocesador2(){
        //*Agregamos componentes**************************************************
        setLayout(new BorderLayout());
        
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
        
         procesadorcontrol(estilo, "Cursiva", "", "");
         procesadorcontrol(estilo, "Negrita", "", "");
         procesadorcontrol(estilo, "Subrayado", "", "");
         
         procesadorcontrol(fuente, "", "", "Courier New");
         procesadorcontrol(fuente, "", "", "Times New Roman");
         procesadorcontrol(fuente, "", "", "Gadugi");
         
         procesadorcontrol(tamano, "", "10", "");
         procesadorcontrol(tamano, "", "12", "");
         procesadorcontrol(tamano, "", "14", "");
           
        //*************************************************************************
        
        
        
       
        
        
        
        
        
        
    }
    public void procesadorcontrol (JMenu menu, String estilo,String tamano,String fuente){
        barramenu.add(menu);
        
        
        
        if ((menu.getText()).equals("Estilo")){
            menuitem=new JMenuItem(estilo);
            
            if(menuitem.getText().equals("Cursiva")){
                menuitem.addActionListener(new StyledEditorKit.ItalicAction());
                menuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));
            } 
            if(menuitem.getText().equals("Negrita")){
                menuitem.addActionListener(new StyledEditorKit.BoldAction());
            } 
            if(menuitem.getText().equals("Subrayado")){
                menuitem.addActionListener(new StyledEditorKit.UnderlineAction());
            } 
            
        }
        else if ((menu.getText()).equals("Fuente")){
            menuitem=new JMenuItem(fuente);
            menuitem.addActionListener(new StyledEditorKit.FontFamilyAction(menuitem.getText(),menuitem.getText()));
           
        }
        else if ((menu.getText()).equals("Tamaño")){
            menuitem=new JMenuItem(tamano);
            menuitem.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", Integer.parseInt(tamano)));
            
        }
            
            menu.add(menuitem);
            
       }
 }


