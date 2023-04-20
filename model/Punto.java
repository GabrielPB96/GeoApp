package model;
import java.awt.Point;


/**
 * Write a description of class Punto here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Punto extends Point{
    public Punto(int x, int y) {
        super(x, y);
    }

    public void rotate (double grados) {
        
    }
    
    public void traslate (int dx, int dy) {
        
    }
    
    @Override
    public boolean equals (Object o) {
        if(this == o) return true;
        if(o instanceof Punto) {
            Punto otro = (Punto)o;
            return otro.getX() == x && otro.getY() == y;
        }
        return false;
    }
}
