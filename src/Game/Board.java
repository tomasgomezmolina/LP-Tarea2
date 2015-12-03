package Game;


import lp.motor.Context;
import lp.motor.MouseHandler;
import java.awt.*;

public class Board implements Context {

    public void drawBoard(Graphics graphics){

        for (int i = 100 ; i < 500 ; i += 40) {
            for (int j = 100; j < 500; j += 40) {
                if ((i / 40) % 2 == 0) {
                    if ((j / 40) % 2 == 0) {
                        graphics.setColor(Color.cyan);
                        graphics.fillRect(j, i, 40, 40);
                    }
                    else {
                        graphics.setColor(Color.white);
                        graphics.fillRect(j, i, 40, 40);
                    }
                }
                else{
                    if ((j / 40) % 2 == 0) {
                        graphics.setColor(Color.white);
                        graphics.fillRect(j, i, 40, 40);
                    }
                    else {
                        graphics.setColor(Color.cyan);
                        graphics.fillRect(j, i, 40, 40);
                    }

                }
            }
        }
    }

    @Override
    public void update(MouseHandler mouseHandler) {

    }

    @Override
    public void render(Graphics graphics) {

    }
}
