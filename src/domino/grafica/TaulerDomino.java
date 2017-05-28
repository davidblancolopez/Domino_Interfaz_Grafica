package domino.grafica;

import domino.model.Fitxa;
import domino.model.Joc;
import domino.model.Jugador;
import domino.model.Torn;
import java.awt.BorderLayout;
import java.awt.Color;
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

    private JPanel pNord, PSud, PEst, POest, pCenter;
    public Scanner lector = new Scanner(System.in);
//    private Joc joc;
//    private Torn torn;

    public TaulerDomino() { 
        configuracio();
        this.pack();
        this.setVisible(true);
    }

    TaulerDomino(String num, String fitx) {        
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
        JLabel label1 = new JLabel("Jugador 1:" + jug1);
        pNord.add(label1, BorderLayout.NORTH);

        JLabel label2 = new JLabel("Jugador 2:" + jug2);
        PEst.add(label2, BorderLayout.WEST);

        JLabel label3 = new JLabel("Jugador 3:" + jug3);
        POest.add(label3, BorderLayout.EAST);

        JLabel label4 = new JLabel("Jugador 4:" + jug4);
        PSud.add(label4, BorderLayout.SOUTH);
    }

    public String MostrarTurnoJugador(Jugador jugador) {

        return jugador.nom;
    }

    /**
     * Metode per mostrar les fitxes dels jugadors en el tauler. Les fitxes del
     * jugador es mostren pero les dels contrincants es mostren en negre.
     *
     * @param fitxesJug1
     * @param fitxesJug2
     * @param fitxesJug3
     * @param fitxesJug4
     */
    public void MostrarFitxesJugador(ArrayList<Fitxa> fitxesJug1, ArrayList<Fitxa> fitxesJug2, ArrayList<Fitxa> fitxesJug3, ArrayList<Fitxa> fitxesJug4) {

        ImageIcon iconB = new ImageIcon("Assets/NegreV.png");
        ImageIcon iconB2 = new ImageIcon("Assets/Negre.png");

        for (int i = 0; i < fitxesJug1.size(); i++) {
            JLabel lblT = new JLabel(" ");
            lblT.setPreferredSize(new Dimension(10, 10));
            lblT.setIcon(iconB);
            pNord.add(lblT, BorderLayout.NORTH);
            PSud.setLayout(new GridLayout(1, 8));
        }

        for (int i = 0; i < fitxesJug2.size(); i++) {
            JLabel lblT = new JLabel(" ");
            lblT.setPreferredSize(new Dimension(10, 10));
            lblT.setIcon(iconB2);
            PEst.add(lblT, BorderLayout.WEST);
            PEst.setLayout(new GridLayout(8, 1));
        }

        for (int i = 0; i < fitxesJug3.size(); i++) {
            JLabel lblT = new JLabel(" ");
            lblT.setPreferredSize(new Dimension(10, 10));
            lblT.setIcon(iconB2);
            POest.add(lblT, BorderLayout.EAST);
            POest.setLayout(new GridLayout(8, 1));

        }

        for (int i = 0; i < fitxesJug4.size(); i++) {
            ImageIcon icon = new ImageIcon("Assets/" + fitxesJug4.get(i).valors[0] + fitxesJug4.get(i).valors[1] + "V.png");
            JLabel lblT = new JLabel(" ");
            lblT.setPreferredSize(new Dimension(10, 10));
            lblT.setIcon(icon);
            PSud.add(lblT, BorderLayout.SOUTH);
            PSud.setLayout(new GridLayout(1, 8));

        }
        PEst.updateUI();
        POest.updateUI();
        pNord.updateUI();
        PSud.updateUI();
    }

    /**
     * Metode per mostrar les fitxes del tauler.
     *
     * @param fitxesJugades
     */
    public void MostrarFitxesTaula(ArrayDeque<Fitxa> fitxesJugades) {

        pCenter.removeAll();

        for (Fitxa fitxa : fitxesJugades) {
            ImageIcon icon = new ImageIcon("imagenes/" + fitxa.getValors()[0] + fitxa.getValors()[1] + ".png");
            JLabel fitxesJug = new JLabel(" ");

            fitxesJug.setPreferredSize(new Dimension(50, 50));
            fitxesJug.setIcon(icon);
            pCenter.add(fitxesJug);
        }
        pCenter.updateUI();
    }

    /**
     * Metode per a demanar al jugador si jugar o passar torn.
     *
     * @return
     */
    public String mostraMenu() {
        String p;
        String[] options = {"PASSAR", "JUGAR"};
        int opcion = JOptionPane.showOptionDialog(null, "Escull una opcion:", "OPCIONS", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        p = String.valueOf(opcion);
        return p;
    }

    public boolean elejirLado() {

        boolean conseguido = false;
        String p;
        String[] options = {"ESQUERRA", "DRETA"};
        int opcion = JOptionPane.showOptionDialog(null, "Escull el costat on posar la fitxa", "OPCIONS", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

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

    /**
     * Metode per a mostrar les fitxes que te el jugador per jugar.
     *
     * @param fitxes
     * @return
     */
    public int elejirFitxa(ArrayList<Fitxa> fitxes) {

        String p;

        String[] options = {"", "", "", "", "", "", ""};

        ImageIcon[] imatges = {
            new ImageIcon(""),
            new ImageIcon(""),
            new ImageIcon(""),
            new ImageIcon(""),
            new ImageIcon(""),
            new ImageIcon(""),
            new ImageIcon("")
        };

        /**
         * Bucle per a emplenar les fitxes amb les fitxes del jugador.
         */
        for (int i = 0; i < fitxes.size(); i++) {
            ImageIcon icon = new ImageIcon("Assets/" + fitxes.get(i).valors[0] + fitxes.get(i).valors[1] + "V.png");
            imatges[i] = icon;
        }
        int pos = JOptionPane.showOptionDialog(null, "Selecciona una fitxa: ", "OPCIONS", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, imatges, imatges[0]);
        return pos;
    }

    public void guanyador(Jugador guanyador) {

        PEst.updateUI();
        POest.updateUI();
        pNord.updateUI();
        PSud.updateUI();

        JOptionPane.showMessageDialog(null, "Ha ganado: " + guanyador.getNom());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Color")) {
            this.pNord.setBackground(Color.green);
        }
    }

}
