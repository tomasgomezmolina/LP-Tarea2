package Game;

import lp.motor.Application;
import lp.motor.Context;
import lp.motor.MouseHandler;


import java.awt.*;
import java.util.ArrayList;

public class Main implements Context
{
    Board board;
    Piece piece1;
    Piece piece2;
    Piece piece3;
    ArrayList<Piece> pieces;
    Piece currentPiece = null;
    int identificador;
    int clics = 0;


    public Main()
    {
        pieces = new ArrayList<>();
        board = new Board();
        int cont = 0;
        int cont2 = 20;
        for (int i = 0; i <= 200; i=i+50) {
            for (int j = 0; j <= 3 ; j++) {
                piece1 = new Piece(55+2*i+(1+j)%2*50 , 55+50*j, 1, j+cont);
                pieces.add(piece1);
            }
            cont += 4;
        }
        for (int i = 0; i <= 200 ; i=i+50) {
            for (int j = 0; j <=3 ; j++) {
                piece2 = new Piece(55+2*i+(1+j)%2*50 , 355+50*j , 2, j+cont2);
                pieces.add(piece2);
            }
            cont2 += 4;
        }
        //piece3 = new Piece(55, 55, 1, 21);
        // aquí puede inicializar valores y crear los objetos de juego.
    }

    @Override
    public void update(MouseHandler mouseHandler)
    {
        Point point = mouseHandler.getMousePosition();

        /*currentPiece = board.getPieceClicked();

        board.updatePieceClicked(mouseHandler);

        if(currentPiece != null) {

        } */

        if (clics%2 == 0) {
            for (Piece pieza : pieces) {
                if (((point.x / 50) * 50 +5)== pieza.getX() && ((point.y / 50) * 50+ 5) == pieza.getY() && mouseHandler.isButtonPressed()) {
                    identificador = pieza.getIdentificador();
                    clics++;
                    System.out.println(identificador);
                    System.out.println("chao");
                }
            }
        }
        else if(clics%2 == 1) {
            for (Piece pieza : pieces){
                int id = pieza.getIdentificador();
                System.out.println(id);
                if (id == identificador ) {
                    System.out.println("Hola");
                    pieza.setX((point.x / 50) * 50 + 5);
                    System.out.println(pieza.getX());
                    pieza.setY((point.y / 50) * 50 + 5);
                    clics++;
                }
            }
        }





        // aquí actualice sus objetos para que puedan interactuar con input de usuario o entre los mismos
        // objetos.

        // por ejemplo imprimir algo si el mouse está cerca de la esquina superior izquierda:
       //Point point = mouseHandler.getMousePosition();
        //if (point.x < 200 && point.y < 200)
          //  System.out.println(point);
    }

    @Override
    public void render(Graphics graphics)
    {
        // aquí, y solo aquí, puede dibujar cosas en la pantalla.

        // por ejemplo dibujar un círculo verde:
        board.drawBoard(graphics);

        for (Piece pieza:pieces) {
            pieza.drawPiece(graphics);
        }


        if (currentPiece != null) {

        }
        //piece3.drawPiece(graphics);
    }

    public static void main(String[] args)
    {
        // el método main solo se encargará de iniciar el sistema.
        Application.start(600, 600, "Elepé!", 60, new Main());
    }
}