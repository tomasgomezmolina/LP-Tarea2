package Game;
import lp.motor.MouseHandler;
import java.awt.*;
import java.util.ArrayList;


public class Board {

    int identificador;
    int clics = 0;
    int turno = 0;
    Piece found;

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

    public void movePiece(MouseHandler mouseHandler, Point point, ArrayList<Piece> pieces1, ArrayList<Piece> pieces2) {
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
                if (found.sonIguales(point, pieces1, pieces2)) { // para no ponerse sobre otra ficha
                    if (((point.x / 50) * 50 + 5) < 550 && 50 < ((point.x / 50) * 50 + 5) && ((point.y / 50) * 50 + 5) < 550 && 50 < ((point.y / 50) * 50 + 5)) { //restriccion para no salir del tablero
                        if ( (((((point.x / 50) * 50 + 5) == (found.getX() - 50)) || ((point.x / 50) * 50 + 5) == (found.getX() + 50))
                                && (((point.y / 50) * 50 + 5) == (found.getY() + 50)) )
                                || (found.preComer(point, found, pieces1, pieces2, turno))) { // restriccion para avanzar en diagonal y poder "comer"
                            found.setX((point.x / 50) * 50 + 5);
                            found.setY((point.y / 50) * 50 + 5);
                            clics++;
                            turno++;
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
                if (found.sonIguales(point, pieces1, pieces2)) {
                    if (((point.x / 50) * 50 + 5) < 550 && 50 < ((point.x / 50) * 50 + 5) && ((point.y / 50) * 50 + 5) < 550 && 50 < ((point.y / 50) * 50 + 5)) {
                        if ( (((((point.x / 50) * 50 + 5) == (found.getX() - 50)) || ((point.x / 50) * 50 + 5) == (found.getX() + 50))
                                && (((point.y / 50) * 50 + 5) == (found.getY() - 50)))
                                || (found.preComer(point, found, pieces1, pieces2, turno))) {
                            found.setX(((point.x / 50) * 50 + 5));
                            found.setY((point.y / 50) * 50 + 5);
                            clics++;
                            turno++;
                        }
                    }
                }
            }
        }
    }


}
