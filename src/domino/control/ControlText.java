package domino.control;

import domino.model.Fitxa;
import domino.model.Joc;
import domino.model.Torn;
import domino.model.Jugador;
import domino.vista.VistaText;
import java.util.List;

public class ControlText {

    private Joc joc;
    private VistaText vText;
    private Torn torn;
    private Jugador jugador;
    public String noms[] = new String[4];//VARIABLE posada
    private Fitxa fitxa;

    public ControlText() {
        this.joc = new Joc(4, 28, 7);
        this.vText = new VistaText();
        this.torn = new Torn(joc);//

    }

    /**
     * Començar joc
     */
    public void JugarJoc() {
        recollirNomJugadors();
        joc.iniciar(noms);
        
        torn.inicial();
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

        } while (!joc.isFinalitzat());

//        vText.imprimirGuanyador(joc.trobarGuanyador());
    }

    /**
     * Metode per a recollir el nom de tots els jugadors.
     */
    public void recollirNomJugadors() {
        for (int i = 0; i < 4; i++) {
            noms[i] = vText.demanarNomJugador();
        }
    }

    /**
     * Metode de resposta del menú de jugada.
     */
    public void respostaMenuJugada() {
        int opcio = 0;
        //Mostrem el menú de jugades disponibles per al jugador.
        opcio = vText.menu();

        switch (opcio) {
            case 1:
                do {
                    boolean correcte = posar1Fitxa();
                    if (correcte) {
                        break;
                    }
                } while (true);

            case 2:
                do {
                    boolean correcte = posar2Dobles();
                    if (correcte) {
                        break;
                    }
                } while (true);
            case 3:
                torn.passar();
                break;
            default:
                System.out.println("Opció incorrecta.");
                break;
        }
    }

    /**
     * Metode per jugada de 1 fitza.
     */
    public boolean posar1Fitxa() {
        //Declaració de variables.
        Fitxa f;
        int p1;
        boolean extrem, correcte;

        //Fitxa.
        p1 = vText.demanarFitxaJugador(joc.jugadors[joc.getTorn()].getFitxes());
        f = joc.jugadors[joc.getTorn()].getFitxes().get(p1);
        extrem = vText.demanarCostat();

        //Cridem al metode que col·loca la fitxa.
        correcte = torn.colocarUnaFitxa(f, extrem);

        return correcte;
    }

    /**
     * Metode per a posar 2 dobles.
     */
    public boolean posar2Dobles() {
        //Declaració de variables.
        Fitxa d1, d2;
        int p1, p2;
        boolean extremP1, extremP2, correcte;

        //Primer doble.
        p1 = vText.demanarFitxaJugador(joc.jugadors[joc.getTorn()].getFitxes());
        extremP1 = vText.demanarCostat();
        d1 = jugador.fitxes.get(p1);

        //Segon doble.
        p2 = vText.demanarFitxaJugador(joc.jugadors[joc.getTorn()].getFitxes());
        extremP2 = vText.demanarCostat();
        d2 = jugador.fitxes.get(p2);

        //Cridem al metode que col·loca els dobles.
        correcte = torn.colocarDosDobles(d1, extremP1, d2, extremP2);

        return correcte;
    }

}
