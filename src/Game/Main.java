package Game;

import lp.motor.Application;
import lp.motor.Context;
import lp.motor.Element;
import lp.motor.MouseHandler;

import java.awt.*;
import java.util.Random;
import java.util.Vector;

public class Main implements Context {
    Board board;
    Piece piece1;
    Piece piece2;
    Vector<Piece> pieces1;
    Vector<Piece> pieces2;


    public Main() {
        pieces1 = new Vector<>();
        pieces2 = new Vector<>();
        board = new Board();

        Element.Type elemento;
        Random generator = new Random();
        int t = generator.nextInt(50);
        int f = generator.nextInt(100);

        for (int i = 0; i <= 200; i = i + 50) {
            for (int j = 0; j <= 3; j++) {
                if (( j + f )%3 == 0) elemento = Element.Type.FIRE;
                else if ((  i + t)%3 == 1) elemento = Element.Type.WATER;
                else   elemento = Element.Type.LEAF;
                piece1 = new Piece(55 + 2 * i + (1 + j) % 2 * 50, 55 + 50 * j, 1, elemento);
                pieces1.add(piece1);
            }
        }
        for (int i = 0; i <= 200; i = i + 50) {
            for (int j = 0; j <= 3; j++) {
                if ((i + f )%3 == 0) elemento = Element.Type.FIRE;
                else if ((t + j )%3 == 1) elemento = Element.Type.WATER;
                else  elemento = Element.Type.LEAF;
                piece2 = new Piece(55 + 2 * i + (1 + j) % 2 * 50, 355 + 50 * j, 2, elemento);
                pieces2.add(piece2);
            }
        }
    }

    @Override
    public void update(MouseHandler mouseHandler) {
        Point point = mouseHandler.getMousePosition();

        board.movePiece(mouseHandler, point, pieces1, pieces2);

        }



    @Override
    public void render(Graphics graphics) {
        // aquí, y solo aquí, puede dibujar cosas en la pantalla.

        // por ejemplo dibujar un círculo verde:
        board.drawBoard(graphics);

        for (Piece pieza : pieces1) {
            pieza.drawPiece(graphics);
        }
        for (Piece pieza : pieces2) {
            pieza.drawPiece(graphics);
        }


    }

    public static void main(String[] args) {
        // el método main solo se encargará de iniciar el sistema.
        Application.start(600, 600, "Elepé!", 60, new Main());
    }
}
