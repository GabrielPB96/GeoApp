package model.shapes;
import model.Punto;
import model.algorithms.CircleAlgorithm;
import model.algorithms.CircleMidPoint;
import java.util.*;

/**
 * Write a description of class Circle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Circle extends Shape
{
    private Punto center;
    private int radio;
    public Circle(Punto center, int radio, CircleAlgorithm algorithm) {
        this.center = center;
        this.radio = radio;
        this.algorithm = algorithm;
        vertexs.add(this.center);
        points= algorithm.generatePoints((int) center.getX(), (int) center.getY(), radio);
    }
    
    public Circle(Punto center, int radio) {  
        this(center, radio, new CircleMidPoint());
    }
    
    public Punto calculateCenterPoint () {
        return new Punto((int)center.getX(), (int)center.getY());
    }
    
    public void recalcular (){
        Punto pRadio = new Punto((int)center.getX(), (int)center.getY() + radio);
        int x1 = (int)(pRadio.getX() * factorEscalacion + center.getX() * (1 - factorEscalacion));
        int y1 = (int)(pRadio.getY() * factorEscalacion + center.getY() * (1 - factorEscalacion));
        pRadio.setLocation(x1, y1);
        int r = (int)center.distance(pRadio);
        points = ((CircleAlgorithm)algorithm).generatePoints((int) center.getX(), (int) center.getY(), r);
    }
    
    public void fill () {
        cuatro_vecinos((int)center.getX(), (int)center.getY());
    }
    
    public void calcularGrosor ()
    {
      for(int i = 1; i < grosor; i++) {
            ArrayList<Punto> up, down;
            up = ((CircleAlgorithm)algorithm).generatePoints((int) center.getX(), (int) center.getY(),(int) radio +i);
            //down = ((CircleAlgorithm)algorithm).generatePoints((int) center.getX(), (int) center.getY(),(int) radio -i);
            points.addAll(up);
            //points.addAll(down);
        }
    }
    
    public void rotar(double grados) {
        center.rotate(grados, (double)0, (double)0);
    }
    
    @Override
    public String toString () {
        return "Center = " + center.toString() +"    Radio = " + radio;
    }
}
