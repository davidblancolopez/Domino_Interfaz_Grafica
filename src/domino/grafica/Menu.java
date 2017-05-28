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
public class Menu extends JFrame implements ActionListener{
    private JMenuBar mb;
    private JMenu menu1;
    private JMenuItem menuItem1, menuItem2;
    public JTextField textfield1;
    public JLabel label1;
    public JButton boton1;

    public Menu() {
        setLayout(null);
        mb = new JMenuBar();
        setJMenuBar(mb);
        menu1 = new JMenu("Opcions");
        mb.add(menu1);
        menuItem1 = new JMenuItem("Jugar");
        menuItem1.addActionListener(this);
        menu1.add(menuItem1);
        menuItem2 = new JMenuItem("Acerca de");
        menuItem2.addActionListener(this);
        menu1.add(menuItem2);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Container f = this.getContentPane();

        if (e.getSource() == menuItem1) {
            f.removeAll();
            menuItem1.removeAll();
            f.setBackground(new Color(204, 255, 153));

                    ControlText control = new ControlText();
                    control.JugarJoc();

        }
        if (e.getSource() == menuItem2) {

            AcercaDe inst = new AcercaDe();
            inst.setVisible(true);

        }
    }
    
    
}
