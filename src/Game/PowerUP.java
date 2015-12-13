package Game;

import lp.motor.Element;

/**
 * Created by Anita on 13-12-15.
 */

public class PowerUP extends Piece {

    private int indicador;


    public PowerUP(int x, int y, int equipo, Element.Type elemento, int indicador) {
        super(x, y, equipo, elemento);
        this.indicador = indicador;
    }




}
