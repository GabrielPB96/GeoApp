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
        int newX = this.x + dx;
        int newY = this.y + dy;
        this.setLocation(newX, newY);
    }
}
