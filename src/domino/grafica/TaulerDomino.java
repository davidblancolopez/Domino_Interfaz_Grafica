/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino.grafica;

import domino.control.ControlText;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

/**
 *
 * @author dblan
 */
public class TaulerDomino extends JFrame implements ActionListener{
    private JMenuBar mb;
    private JMenu menu1;
    private JMenuItem mi1, mi2, mi3;
    public JTextField textfield1;
    public JLabel label1;
    public JButton boton1;

    public TaulerDomino() {
        setLayout(null);
        mb = new JMenuBar();
        setJMenuBar(mb);
        menu1 = new JMenu("Opciones");
        mb.add(menu1);
        mi1 = new JMenuItem("Jugar!");
        mi1.addActionListener(this);
        menu1.add(mi1);
        mi2 = new JMenuItem("Instrucciones modo de juego");
        mi2.addActionListener(this);
        menu1.add(mi2);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Container f = this.getContentPane();
       
        if (e.getSource() == mi1) {
            
            f.setBackground(new Color(204, 255, 153));
            
            JButton bot1 = new JButton("Jugar Modo 1");
            bot1.setBounds(100, 10, 200, 30);
            add(bot1);
            
            JButton bot2 = new JButton("Jugar Modo 2");
            bot2.setBounds(100, 40, 200, 30);
            add(bot2);
            
            
            bot1.addActionListener(new java.awt.event.ActionListener() {
                
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                ControlText control = new ControlText();
                control.JugarJoc();
                
            }

        });
            }
        if (e.getSource() == mi2) {
            f.setBackground(new Color(0, 255, 0));
        }
    }
    
    
}
