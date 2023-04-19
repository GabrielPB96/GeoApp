package model.shapes;
import model.Punto;
import model.algorithms.TriangleBresenham;
import model.algorithms.TriangleAlgorithm;
/**
 * Write a description of class Triangle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Triangle extends Shape {
    private Punto vertexA, vertexB, vertexC;
    public Triangle(Punto vertexA, Punto vertexB, Punto vertexC, TriangleAlgorithm algorithm) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.vertexC = vertexC;
        this.algorithm = algorithm;
        points = algorithm.generatePoints((int) vertexA.getX(), (int) vertexA.getY(), (int) vertexB.getX(),
        (int) vertexB.getY(), (int) vertexC.getX(),
        (int) vertexC.getY());
    }
    
    public Triangle(Punto vertexA, Punto vertexB, Punto vertexC) {
        this(vertexA, vertexB, vertexC, new TriangleBresenham());
    }
    
    public Punto calculateCenterPoint () {
        return null;
    }
    
    public void recalcular (){
        points = ((TriangleAlgorithm)algorithm).generatePoints((int) vertexA.getX(), (int) vertexA.getY(), (int) vertexB.getX(),
        (int) vertexB.getY(), (int) vertexC.getX(),
        (int) vertexC.getY());
    }
    
    public void fill () {
        int x = (int)vertexB.getX();
        int y = (int)vertexB.getY() - (int)(vertexB.getY() - vertexA.getY()) / 2;
        cuatro_vecinos(x, y);
    }
}
