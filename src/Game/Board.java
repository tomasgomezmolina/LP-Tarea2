package Game;
import lp.motor.MouseHandler;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;


public class Board {

    int clics = 0;
    int turno = 0;
    Piece found;
    Point aprox;

    private static ArrayList<Point> bloques = new ArrayList<>();

    public static ArrayList<Point> getBloques() {
        return bloques;
    }


    public void drawBoard(Graphics graphics){
        for (int i = 50 ; i < 550 ; i += 50) {
            for (int j = 50; j < 550; j += 50) {
                if ((i / 50) % 2 == 0) {
                    if ((j / 50) % 2 == 0) {
                        graphics.setColor(Color.white);
                        graphics.fillRect(j, i, 50, 50);

                    }
                    else {
                        graphics.setColor(Color.lightGray);
                        graphics.fillRect(j, i, 50, 50);
                    }
                }
                else{
                    if ((j / 50) % 2 == 0) {
                        graphics.setColor(Color.lightGray);
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

    public void movePiece(MouseHandler mouseHandler, Point point, Vector<Piece> pieces1, Vector<Piece> pieces2) {

        if (turno % 2 == 0) { // turno equipo 1
            if (clics % 2 == 0) {
                for (Piece pieza : pieces1) { // ((point.x/y / 50) * 50 + 5) -> hace que el punto se aproxime a las coordenadas de las piezas
                    if (((point.x / 50) * 50 + 5) == pieza.getX() && ((point.y / 50) * 50 + 5) == pieza.getY() && mouseHandler.isButtonPressed()) {
                        found = pieza;
                        clics++;
                        break;
                    }
                }
            } else if (mouseHandler.isButtonJustPressed()) {
                aprox = found.aproxPunto(point);
                if (found.sonIguales(point, pieces1, pieces2)) { // para no ponerse sobre otra ficha
                    if (aprox.x < 550 && 50 < aprox.x && aprox.y < 550 && 50 < aprox.y) { //restriccion para no salir del tablero
                        if ( (((aprox.x == (found.getX() - 50)) || aprox.x == (found.getX() + 50))
                                && (((point.y / 50) * 50 + 5) == (found.getY() + 50)) )
                                || (found.preComer(point, found, pieces1, pieces2, turno))
                                || (found.getesDama())) { // restriccion para avanzar en diagonal y poder "comer"
                            if ((found.preComer(point, found, pieces1, pieces2, turno))) {
                                if (found.quienGana(found, found.piezaAEliminar(found, aprox, pieces1, pieces2, turno))) {
                                    found.comer(found.piezaAEliminar(found, aprox, pieces1, pieces2, turno), pieces1, pieces2);
                                    found.setX(aprox.x);
                                    found.setY(aprox.y);
                                    clics++;
                                    turno++;
                                    if (found.getY() == 505) found.hacerDama();
                                }
                                else found.comer(found, pieces1, pieces2);
                            }
                            else {
                                found.setX(aprox.x);
                                found.setY(aprox.y);
                                clics++;
                                turno++;
                                System.out.println(found.getY());
                                if (found.getY() == 505 ) found.hacerDama();
                            }
                        }
                    }
                }
            }
        } else {           // turno equipo 2
            if (clics % 2 == 0) {
                for (Piece pieza : pieces2) {
                    if (((point.x / 50) * 50 + 5) == pieza.getX() && ((point.y / 50) * 50 + 5) == pieza.getY() && mouseHandler.isButtonPressed()) {
                        found = pieza;
                        clics++;
                    }
                }
            } else if (mouseHandler.isButtonJustPressed()) {
                aprox = found.aproxPunto(point);
                if (found.sonIguales(point, pieces1, pieces2)) {
                    if ((aprox.x < 550 && 50 < aprox.x) && (aprox.y < 550 && 50 < aprox.y * 50 + 5)) {
                        if (((aprox.x  == (found.getX() - 50)) || aprox.x == (found.getX() + 50))
                                && aprox.y == (found.getY() - 50)
                                || (found.preComer(point, found, pieces1, pieces2, turno))
                                || (found.getesDama())) {
                            if ((found.preComer(point, found, pieces1, pieces2, turno))) {
                                if (found.quienGana(found, found.piezaAEliminar(found, aprox, pieces1, pieces2, turno))) {
                                    found.comer(found.piezaAEliminar(found, aprox, pieces1, pieces2, turno), pieces1, pieces2);
                                    found.setX(aprox.x);
                                    found.setY(aprox.y);
                                    clics++;
                                    turno++;
                                    if (found.getY() == 55) found.hacerDama();
                                }
                                else found.comer(found, pieces1, pieces2);
                            }
                            else {
                                found.setX(aprox.x);
                                found.setY(aprox.y);
                                clics++;
                                turno++;
                                if (found.getY() == 55 ) found.hacerDama();
                            }
                        }
                    }
                }
            }
        }
        //if (turno == 5) found.crearPowerUPs(pieces1, pieces2, found);
    }


}
