package domino.grafica;

import domino.model.Fitxa;
import domino.model.Joc;
import domino.model.Jugador;
import domino.model.Torn;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TaulerDomino extends JFrame implements ActionListener {

    private JPanel pNord, pImatges, PSud, PEst, POest, pCenter;
    public Scanner lector = new Scanner(System.in);
    private Joc joc;
    private Torn torn;

    public TaulerDomino() {
        super("Exemple BorderLayout");
        configuracio();
        this.pack();
        this.setVisible(true);
    }
    
    
    TaulerDomino(String num, String fitx) {

        super("Exemple BorderLayout");
        configuracio();
        this.pack();
        this.setVisible(true);
    }

    public void configuracio() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(300, 300);
        this.setPreferredSize(new Dimension(600, 400));
        this.setLayout(new BorderLayout());

        pNord = new JPanel();
        PSud = new JPanel();
        PEst = new JPanel();
        POest = new JPanel();
        pCenter = new JPanel();

        this.add(pNord, BorderLayout.NORTH);
        this.add(PSud, BorderLayout.SOUTH);
        this.add(PEst, BorderLayout.WEST);
        this.add(POest, BorderLayout.EAST);
        this.add(pCenter, BorderLayout.CENTER);

    }

    public void MostrarNombreJugador(String jug1, String jug2, String jug3, String jug4) {

        PEst.removeAll();
        POest.removeAll();
        pNord.removeAll();
        PSud.removeAll();
        JLabel lbl1 = new JLabel("Jugador 1:" + jug1);
        pNord.add(lbl1, BorderLayout.NORTH);

        JLabel lbl2 = new JLabel("Jugador 2:" + jug2);
        PEst.add(lbl2, BorderLayout.WEST);

        JLabel lbl3 = new JLabel("Jugador 3:" + jug3);
        POest.add(lbl3, BorderLayout.EAST);

        JLabel lbl4 = new JLabel("Jugador 4:" + jug4);
        PSud.add(lbl4, BorderLayout.SOUTH);
    }

    public String MostrarTurnoJugador(Jugador jugador) {

        return jugador.nom;
    }

    public void MostrarFitxasJugador(ArrayList<Fitxa> fitxesJug1, ArrayList<Fitxa> fitxesJug2, ArrayList<Fitxa> fitxesJug3, ArrayList<Fitxa> fitxesJug4) {

        ImageIcon iconB = new ImageIcon("imagenes/backv.gif");
        ImageIcon iconB2 = new ImageIcon("imagenes/back.gif");

        for (int i = 0; i < fitxesJug1.size(); i++) {
            JLabel lblT = new JLabel(" ");
            lblT.setPreferredSize(new Dimension(50, 50));
            lblT.setIcon(iconB);
            pNord.add(lblT, BorderLayout.NORTH);
            PSud.setLayout(new GridLayout(1, 8));
            System.out.println("**" + fitxesJug1.get(i).valors[0] + "|" + fitxesJug1.get(i).valors[1] + "**");
        }

        for (int i = 0; i < fitxesJug2.size(); i++) {
            JLabel lblT = new JLabel(" ");
            lblT.setPreferredSize(new Dimension(50, 50));
            lblT.setIcon(iconB2);
            PEst.add(lblT, BorderLayout.WEST);
            PEst.setLayout(new GridLayout(8, 1));

        }

        for (int i = 0; i < fitxesJug3.size(); i++) {
            JLabel lblT = new JLabel(" ");
            lblT.setPreferredSize(new Dimension(50, 50));
            lblT.setIcon(iconB2);
            POest.add(lblT, BorderLayout.EAST);
            POest.setLayout(new GridLayout(8, 1));

        }

        for (int i = 0; i < fitxesJug4.size(); i++) {
            ImageIcon icon = new ImageIcon("imagenes/" + fitxesJug4.get(i).valors[0] + fitxesJug4.get(i).valors[1] + "v.gif");
            JLabel lblT = new JLabel(" ");
            lblT.setPreferredSize(new Dimension(50, 50));
            lblT.setIcon(icon);
            PSud.add(lblT, BorderLayout.SOUTH);
            PSud.setLayout(new GridLayout(1, 8));

        }
        PEst.updateUI();
        POest.updateUI();
        pNord.updateUI();
        PSud.updateUI();
    }

    public void MostrarFitxasMesa(ArrayDeque<Fitxa> fitxesJugades) {

        pCenter.removeAll();

        for (Fitxa fitxa : fitxesJugades) {
            System.out.println("*fitxasMesa*" + fitxa.getValors()[0] + "|" + fitxa.getValors()[0] + "**");

            ImageIcon icon = new ImageIcon("imagenes/" + fitxa.getValors()[0] + fitxa.getValors()[1] + ".gif");
            JLabel lblFM = new JLabel(" ");

            lblFM.setPreferredSize(new Dimension(50, 50));
            lblFM.setIcon(icon);
            pCenter.add(lblFM);

        }

        pCenter.updateUI();
    }
    
    
    public String mostraMenu() {
        String p;
        String[] options = {"Passar", "jugar"};
        int opcion = JOptionPane.showOptionDialog(null, "Escoje una Opcion:", "opciones", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        p = String.valueOf(opcion);
        return p;
    }

    public boolean elejirLado() {

        boolean conseguido = false;
        String p;
        String[] options = {"Izquiera", "Derecha"};
        int opcion = JOptionPane.showOptionDialog(null, "En que lado quieres colocar la ficha?", "opciones", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        int x = opcion;
        if (x == 0) {
            conseguido = true;
        }
        if (x == 1) {
            conseguido = false;
        }
        pCenter.removeAll();
        return conseguido;
    }

    public int elejirFitxa(ArrayList<Fitxa> fitxes) {

        String p;
        int numbot = fitxes.size();

        String[] options = {"", "", "", "", "", "", ""};

        ImageIcon[] Image = {
            new ImageIcon(""),
            new ImageIcon(""),
            new ImageIcon(""),
            new ImageIcon(""),
            new ImageIcon(""),
            new ImageIcon(""),
            new ImageIcon("")
        };

        for (int i = 0; i < fitxes.size(); i++) {
            ImageIcon icon = new ImageIcon("imagenes/" + fitxes.get(i).valors[0] + fitxes.get(i).valors[1] + ".gif");
            Image[i] = icon;
        }
        int pos = JOptionPane.showOptionDialog(null, "Selecciona la ficha con la que jugar", "opciones", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, Image, Image[0]);

        System.out.println("Has escollit **" + fitxes.get(pos).valors[1] + "|" + fitxes.get(pos).valors[0] + "**");

        return pos;
    }

    public void decirGanador(Jugador guanyador) {

        PEst.updateUI();
        POest.updateUI();
        pNord.updateUI();
        PSud.updateUI();

        JOptionPane.showMessageDialog(null, "Ha ganado: " + guanyador.getNom());

    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
