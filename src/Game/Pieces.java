package Game;

import lp.motor.Context;
import lp.motor.MouseHandler;
import java.awt.*;
import java.util.ArrayList;


public class Pieces implements Context{

    private int x,y,equipo;

    public Pieces(int x, int y, int equipo) {
        this.x = x;
        this.y = y;
        this.equipo = equipo;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getEquipo() {
        return equipo;
    }

    public void setEquipo(int equipo) {
        this.equipo = equipo;
    }

    public void drawPiece(Graphics graphics) {
        if (equipo == 1){
            graphics.setColor(Color.black);
        }
        else{
            graphics.setColor(Color.green);

        }
        graphics.fillOval(x , y , 40 , 40);
    }


    @Override
    public void update(MouseHandler mouseHandler) {

    }

    @Override
    public void render(Graphics graphics) {

    }

}
