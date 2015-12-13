package Game;

import lp.motor.Application;
import lp.motor.Context;
import lp.motor.MouseHandler;

import java.awt.*;
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
        int cont = 0;
        int cont2 = 20;
        for (int i = 0; i <= 200; i = i + 50) {
            for (int j = 0; j <= 3; j++) {
                piece1 = new Piece(55 + 2 * i + (1 + j) % 2 * 50, 55 + 50 * j, 1, j + cont);
                pieces1.add(piece1);
            }
            cont += 4;
        }
        for (int i = 0; i <= 200; i = i + 50) {
            for (int j = 0; j <= 3; j++) {
                piece2 = new Piece(55 + 2 * i + (1 + j) % 2 * 50, 355 + 50 * j, 2, j + cont2);
                pieces2.add(piece2);
            }
            cont2 += 4;
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
