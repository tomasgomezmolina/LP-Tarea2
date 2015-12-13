package Game;import java.awt.*;import java.util.Vector;public class Piece {    public static Piece movingPiece = null;    private int x, y, equipo, identificador;    private boolean clicked = false;    Piece aEliminar;    public Piece(int x, int y, int equipo, int identificador) {        this.x = x;        this.y = y;        this.equipo = equipo;        this.identificador = identificador;    }    public int getX() {        return x;    }    public void setX(int x) {        this.x = x;    }    public int getY() {        return y;    }    public void setY(int y) {        this.y = y;    }    public int getEquipo() {        return equipo;    }    public void setEquipo(int equipo) {        this.equipo = equipo;    }    public int getIdentificador() {        return identificador;    }    public void setIdentificador() {        this.identificador = identificador;    }    public void drawPiece(Graphics graphics) {        if (equipo == 1) {            graphics.setColor(Color.blue);        } else {            graphics.setColor(Color.red);        }        graphics.fillOval(x, y, 40, 40);    }    public boolean sonIguales(Point point, Vector<Piece> pieces1, Vector<Piece> pieces2) {        for (Piece pieza : pieces1) {            if (((point.x / 50) * 50 + 5) == pieza.getX() && ((point.y / 50) * 50 + 5) == pieza.getY()) {                return false;            }        }        for (Piece pieza : pieces2) {            if (((point.x / 50) * 50 + 5) == pieza.getX() && ((point.y / 50) * 50 + 5) == pieza.getY()) {                return false;            }        }        return true;    }    public boolean vacio(int x, int y, Vector<Piece> pieces1, Vector<Piece> pieces2) {        for (Piece pieza : pieces1) {            if (pieza.x == x && pieza.y == y) {                return false;            }        }        for (Piece pieza : pieces2) {            if (pieza.x == x && pieza.y == y) {                return false;            }        }        return true;    }    /* public Point obtenerPunto(Point point) {        Point nuevoPunto = null;        nuevoPunto.x = (((point.x / 50) * 50 + 5));        nuevoPunto.y = (((point.y / 50) * 50 + 5));        return nuevoPunto;    }*/    public boolean preComer(Point point, Piece piezaEnMovimiento, Vector<Piece> pieces1, Vector<Piece> pieces2, int turno) {        if (turno % 2 == 0) {            for (Piece pieza : pieces2) {                if ((piezaEnMovimiento.x + 50 == pieza.x) && (piezaEnMovimiento.y + 50 == pieza.y)) { //existe pieza en la diagonal                    if (pieza.vacio((pieza.x) + 50, (pieza.y) + 50, pieces1, pieces2)) { // el sieguiente espacio en la diagonal esta vacio                        return true;                    }                } else if ((piezaEnMovimiento.x - 50 == pieza.x) && (piezaEnMovimiento.y + 50 == pieza.y)) {                    if (pieza.vacio((pieza.x) - 50, (pieza.y) + 50, pieces1, pieces2)) {                        return true;                    }                }            }        } else {            for (Piece pieza : pieces1) {                if ((piezaEnMovimiento.x + 50 == pieza.x) && (piezaEnMovimiento.y - 50 == pieza.y)) { //existe pieza en la diagonal                    if (pieza.vacio((pieza.x) + 50, (pieza.y) - 50, pieces1, pieces2)) { // el sieguiente espacio en la diagonal esta vacio                        return true;                    }                } else if ((piezaEnMovimiento.x - 50 == pieza.x) && (piezaEnMovimiento.y - 50 == pieza.y)) {                    if (pieza.vacio((pieza.x) - 50, (pieza.y) - 50, pieces1, pieces2)) {                        return true;                    }                }            }        }        return false;    }    public Piece piezaAEliminar( Piece piezaEnMovimiento, Vector<Piece> pieces1, Vector<Piece> pieces2, int turno) {        if (turno % 2 == 0) {            for (Piece pieza : pieces2) {                if ((piezaEnMovimiento.x + 50 == pieza.x) && (piezaEnMovimiento.y + 50 == pieza.y)) { //existe pieza en la diagonal                    return pieza;                } else if ((piezaEnMovimiento.x - 50 == pieza.x) && (piezaEnMovimiento.y + 50 == pieza.y)) {                    return pieza;                }            }        }        else {        for (Piece pieza : pieces1) {            if ((piezaEnMovimiento.x + 50 == pieza.x) && (piezaEnMovimiento.y - 50 == pieza.y)) { //existe pieza en la diagonal                return pieza;            } else if ((piezaEnMovimiento.x - 50 == pieza.x) && (piezaEnMovimiento.y - 50 == pieza.y)) {                return pieza;            }        }    }        return null;}    public void comer(Piece pieza, Vector<Piece> pieces1, Vector<Piece> pieces2) { // eliminar pieza comida        if (pieza.getEquipo() ==  1) {            pieces1.remove(pieza);        }        else {            pieces2.remove(pieza);        }    }    public Point aproxPunto(Point point) {        point.x = (point.x / 50) * 50 + 5;        point.y = (point.y / 50) * 50 + 5;        return point;    }}