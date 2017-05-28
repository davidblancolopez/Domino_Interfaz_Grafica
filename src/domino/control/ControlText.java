package domino.control;

import domino.grafica.TaulerDomino;
import domino.model.Fitxa;
import domino.model.Joc;
import domino.model.Torn;
import domino.model.Jugador;
import domino.vista.VistaText;
import java.util.List;
import javax.swing.JOptionPane;

public class ControlText {

    private Joc joc;
    private VistaText vText;
    private TaulerDomino vistaDomino;
    private Torn torn;
    private Jugador jugador;
    public String noms[] = new String[4];//VARIABLE posada
    private Fitxa fitxa;

    public ControlText() {
        this.joc = new Joc(4, 28, 7);
        //this.vText = new VistaText();
        this.torn = new Torn(joc);//

    }

    /**
     * Començar joc
     */
    public void JugarJoc() {
        //Iniciem el joc amb els següents metodes.
        recollirNomJugadors();
        joc.iniciar(noms);

        torn.inicial();

        vistaDomino = new TaulerDomino();

        while (!joc.isFinalitzat()) {

            vistaDomino.MostrarNombreJugador(noms[0], noms[1], noms[2], noms[3]);
            vistaDomino.MostrarFitxesJugador(joc.jugadors[0].getFitxes(), joc.jugadors[1].getFitxes(), joc.jugadors[2].getFitxes(), joc.jugadors[3].getFitxes());
            vistaDomino.MostrarFitxesTaula(joc.getFitxesJugades());

            respostaOpcioMenu();

            joc.actualitzarEstat();

        }
        vistaDomino.MostrarNombreJugador(noms[0], noms[1], noms[2], noms[3]);
        vistaDomino.MostrarFitxesJugador(joc.jugadors[0].getFitxes(), joc.jugadors[1].getFitxes(), joc.jugadors[2].getFitxes(), joc.jugadors[3].getFitxes());
        vistaDomino.MostrarFitxesTaula(joc.getFitxesJugades());
        vistaDomino.guanyador(joc.getGuanyador());
        System.out.println(joc.getGuanyador());

        /*
        //Actualitzem l'estat del joc.
        joc.actualitzarEstat();

        do {
            //Imprimim les dades del jugador que li toca.
            vText.imprimirDadesTorn(joc.getTorn(), joc.jugadors[joc.getTorn()]);
            System.out.println();

            //Imprimim les fitxes que s'han jugat fins ara.
            vText.imprimirFitxesJugades(joc.fitxesJugades);
            System.out.println();

            //Imprimim les fitxes del jugador.
            vText.imprimirFitxesJugador(joc.jugadors[joc.getTorn()].getFitxes());
            System.out.println();

            //Passem a mostrar el menú al jugador per a que decideixi com jugar.
            respostaMenuJugada();

            //Actualitzem l'estat del joc.
            joc.actualitzarEstat();

            //Aquest bucle es només per a que no es mostrin tots els torns junts.
            for (int i = 0; i < 25; i++) {
                System.out.println();
            }
        } while (!joc.isFinalitzat());

        vText.imprimirGuanyador(joc.trobarGuanyador());*/
    }

    /**
     * Metode per a recollir el nom de tots els jugadors.
     */
    public void recollirNomJugadors() {
        for (int i = 0; i < 4; i++) {
            noms[i] = JOptionPane.showInputDialog("Introduce nombre jugador " + i + ":");
        }
    }

    /**
     * Metode de resposta del menú de jugada.
     */
    public void respostaOpcioMenu() {

        String accio = vistaDomino.mostraMenu();
        System.out.println(accio);
        switch (accio) {
            case "1":
                posar1Fitxa();
                break;
            case "0":
                torn.passar();
                break;
            default:
                respostaOpcioMenu();

        }
    }

    /**
     * Metode per jugada de 1 fitza.
     */
    public void posar1Fitxa() {
        //Declaració de variables.
        Fitxa f;
        int p1;
        boolean extrem, correcte;

        p1 = vistaDomino.elejirFitxa(joc.jugadors[joc.getTorn()].getFitxes());
        f = joc.jugadors[joc.getTorn()].getFitxes().get(p1);
        extrem = vistaDomino.elejirLado();

        correcte = torn.colocarUnaFitxa(f, extrem);

    }

    /**
     * Metode per a posar 2 dobles.
     */
    /*public boolean posar2Dobles() {
        //Declaració de variables.
        Fitxa d1, d2;
        int p1, p2;
        boolean extremP1, extremP2, correcte;

        //Primer doble.
        System.out.println("1r doble.");
        
        //Agafem la posició amb un int.
        p1 = vText.demanarFitxaJugador(joc.jugadors[joc.getTorn()].getFitxes());
        
        //Agafem l'extrem on es vol posar la ficha amb un boolean,
        //si es vol a l'esquerra serà true sino sera false.
        extremP1 = vText.demanarCostat();
        
        //Agafem la fitxa que correspon fent servir el int anterior.
        d1 = joc.jugadors[joc.getTorn()].getFitxes().get(p1);

        //Segon doble.
        System.out.println("2n doble.");
        
        //Agafem la posició amb un int.
        p2 = vText.demanarFitxaJugador(joc.jugadors[joc.getTorn()].getFitxes());
        
        //Agafem l'extrem on es vol posar la ficha amb un boolean,
        //si es vol a l'esquerra serà true sino sera false.
        extremP2 = vText.demanarCostat();
        
        //Agafem la fitxa que correspon fent servir el int anterior.
        d2 = joc.jugadors[joc.getTorn()].getFitxes().get(p2);

        //Cridem al metode que col·loca els dobles.
        correcte = torn.colocarDosDobles(d1, extremP1, d2, extremP2);

        return correcte;
    }*/
}
