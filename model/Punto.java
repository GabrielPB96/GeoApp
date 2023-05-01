package model;
import java.awt.Point;
import java.util.ArrayList;


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

    public void rotate (double grados,int xPuntoRotar,int yPuntoRotar) {
        double seno = Math.sin(Math.toRadians(grados));
        double coseno = Math.cos(Math.toRadians(grados));
        int auxX = this.x;
        int auxY = this.y;
        double xvar = (int) (xPuntoRotar + (auxX - xPuntoRotar)*coseno - (auxY - yPuntoRotar)*seno);
        double yvar = (int) (yPuntoRotar + (auxX - xPuntoRotar)*seno + (auxY - yPuntoRotar)*coseno);
        x = (int) xvar;
        y = (int) yvar;
    }
    
    public void traslate (int dx, int dy) {
        
    }
}
