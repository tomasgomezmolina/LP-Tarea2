package Game;


import lp.motor.Context;
import lp.motor.MouseHandler;
import java.awt.*;
import java.util.ArrayList;


public class Board {

    private static ArrayList<Point> bloques = new ArrayList<>();

    public static ArrayList<Point> getBloques() {
        return bloques;
    }

    //public ArrayList<Piece> pieces = new ArrayList<>();

    public void drawBoard(Graphics graphics){
        for (int i = 50 ; i < 550 ; i += 50) {
            for (int j = 50; j < 550; j += 50) {
                if ((i / 50) % 2 == 0) {
                    if ((j / 50) % 2 == 0) {
                        graphics.setColor(Color.white);
                        graphics.fillRect(j, i, 50, 50);

                    }
                    else {
                        graphics.setColor(Color.pink);
                        graphics.fillRect(j, i, 50, 50);
                    }
                }
                else{
                    if ((j / 50) % 2 == 0) {
                        graphics.setColor(Color.pink);
                        graphics.fillRect(j, i, 50, 50);
                    }
                    else {
                        graphics.setColor(Color.white);
                        graphics.fillRect(j, i, 50, 50);
                    }

                }

                Point bloque = new Point(j + 25 , i + 25);
                bloques.add(bloque);
            }
        }
    }

   /* public Piece getPieceClicked() {
        for (Piece piece : pieces)
            if (piece.wasClicked())
                return piece;

        return null;
    }

    public void updatePieceClicked(MouseHandler mouseHandler) {
        for (Piece piece : pieces)
            piece.setClicked(mouseHandler);

    }*/
}
