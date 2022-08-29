/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesador.de.textos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;





public class ProcesadorDeTextos {

    public static void main(String[] args) {
        ventanaProcesador p=new ventanaProcesador();
}
    
}
class ventanaProcesador extends JFrame{
    public ventanaProcesador(){
        setBounds(200,200,600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Procesador de textos");
        
        laminaprocesador pro=new laminaprocesador();
        add(pro);
        
    }
}



class laminaprocesador extends JPanel{
        JMenuItem menuitem;
        accionboton accionbotonn;
        Font fuente=new Font("Calibri",Font.PLAIN,12);
        JMenuBar barramenu;
        JPanel barraarriba;
        JTextPane areatexto;
    public laminaprocesador(){
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
         procesadorcontrol(estilo, "Normal", "", "");
         
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
        
        accionbotonn= new accionboton();
        
        if ((menu.getText()).equals("Estilo")){
            menuitem=new JMenuItem(estilo);
        }
        
        else if ((menu.getText()).equals("Fuente")){
            menuitem=new JMenuItem(fuente);
        }
        
        
        else if ((menu.getText()).equals("Tamaño")){
            menuitem=new JMenuItem(tamano);
        }
        
        menuitem.addActionListener(accionbotonn);
        menu.add(menuitem);
       }
    
    
    
    
    private class accionboton implements ActionListener{
        
        public void actionPerformed(ActionEvent e) {
            
            
            //Courier new..............................................................
            if ((e.getActionCommand()).equals("Courier New")){
                fuente=new Font ("Courier New", fuente.getStyle(), fuente.getSize());
                areatexto.setFont(fuente);
                System.out.println("Courier New");
            }
            
            //Gadugi...................................................................
            if ((e.getActionCommand()).equals("Gadugi")){
                fuente=new Font ("Gadugi", fuente.getStyle(), fuente.getSize());
                areatexto.setFont(fuente);
                System.out.println("Gadugi");
            }
            
            //Times New Roman..........................................................
            if ((e.getActionCommand()).equals("Times New Roman")){
                fuente=new Font ("Times New Roman", fuente.getStyle(), fuente.getSize());
                areatexto.setFont(fuente);
                System.out.println("Times New Roman");
            }
            
            //Estilo Negrita............................................................
            if ((e.getActionCommand()).equals("Negrita")){
                
                if(fuente.isItalic()){
                    fuente=new Font (fuente.getFontName(), 3, fuente.getSize());
                areatexto.setFont(fuente);
                }
                else{
                    fuente=new Font (fuente.getFontName(), Font.BOLD, fuente.getSize());
                    areatexto.setFont(fuente);
                }
                
                System.out.println("negritah");
            }
            
            //Estilo Normal..............................................................
            if ((e.getActionCommand()).equals("Normal")){
                fuente=new Font (fuente.getFontName(), Font.PLAIN, fuente.getSize());
                areatexto.setFont(fuente);
                System.out.println("Normal");
            }
            
            //Estilo Cursiva............................................................
            if ((e.getActionCommand()).equals("Cursiva")){
                
                if(fuente.isBold()){
                    fuente=new Font (fuente.getFontName(), 3, fuente.getSize());
                    areatexto.setFont(fuente);
                }
                
                else{fuente=new Font (fuente.getFontName(), Font.ITALIC, fuente.getSize());
                areatexto.setFont(fuente);
                }
                
                System.out.println("Cursiva");
            }
            
            //Tamaños...................................................................
            if ((e.getActionCommand()).equals("12")||(e.getActionCommand()).equals("10")||(e.getActionCommand()).equals("14")){
                fuente=new Font (fuente.getFontName(), fuente.getStyle(), Integer.parseInt(e.getActionCommand()));
                areatexto.setFont(fuente);
                System.out.println("Tamaño: "+e.getActionCommand());
            }
            
            System.out.println ("Nombre fuente: "+fuente.getFontName()+ " Tamaño: "+ fuente.getSize()+ " Estilo: "+ fuente.getStyle());
        }
        
    }
}


