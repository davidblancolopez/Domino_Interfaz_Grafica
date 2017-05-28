package domino.grafica;

import domino.model.Joc;
import domino.model.Torn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TaulerDomino extends JFrame implements ActionListener {

    private JPanel pNord, pImatges, PSud, PEst, POest, pCenter;
    public Scanner lector = new Scanner(System.in);
    private Joc joc;
    private Torn torn;
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
