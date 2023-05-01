package model.shapes;
import model.Punto;
import model.algorithms.TriangleBresenham;
import model.algorithms.TriangleAlgorithm;

import java.util.ArrayList;

/**
 * Write a description of class Triangle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Triangle extends Shape {
    private final Punto vertexA;
    private final Punto vertexB;
    private final Punto vertexC;
    public Triangle(Punto vertexA, Punto vertexB, Punto vertexC, TriangleAlgorithm algorithm) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.vertexC = vertexC;
        this.algorithm = algorithm;
        vertexs.add(vertexA);
        vertexs.add(vertexB);
        vertexs.add(vertexC);
        points = algorithm.generatePoints((int) vertexA.getX(), (int) vertexA.getY(), (int) vertexB.getX(),
        (int) vertexB.getY(), (int) vertexC.getX(),
        (int) vertexC.getY());
    }
    
    public Triangle(Punto vertexA, Punto vertexB, Punto vertexC) {
        this(vertexA, vertexB, vertexC, new TriangleBresenham());
    }
    
    public Punto calculateCenterPoint () {
        int x = (int)((vertexA.getX() + vertexB.getX() + vertexC.getX()) / 3);
        int y = (int)((vertexA.getY() + vertexB.getY() + vertexC.getY()) / 3);
        return new Punto(x, y);

    }
    
    public void recalcular (){
        Punto center = calculateCenterPoint();
        int x1 = (int)(vertexA.getX()*factorEscalacion + center.getX() * (1 - factorEscalacion));
        int y1 = (int)(vertexA.getY()*factorEscalacion + center.getY() * (1 - factorEscalacion));
        
        int x2 = (int)(vertexB.getX()*factorEscalacion + center.getX() * (1 - factorEscalacion));
        int y2 = (int)(vertexB.getY()*factorEscalacion + center.getY() * (1 - factorEscalacion));
        
        int x3 = (int)(vertexC.getX()*factorEscalacion + center.getX() * (1 - factorEscalacion));
        int y3 = (int)(vertexC.getY()*factorEscalacion + center.getY() * (1 - factorEscalacion));
        points = ((TriangleAlgorithm)algorithm).generatePoints(x1, y1, x2, y2, x3, y3);
    }
    
    public void fill () {
        Punto center = calculateCenterPoint();
        int x = (int)center.getX();
        int y = (int)center.getY();
        System.out.println(x+", "+y);
        cuatro_vecinos(x, y);
    }

    @Override
    public void rotar(double grados) {
        Punto pr = calculateCenterPoint();

        vertexA.rotate(grados,(int) pr.getX(),(int) pr.getY());
        vertexB.rotate(grados,(int) pr.getX(),(int) pr.getY());
        vertexC.rotate(grados,(int) pr.getX(),(int) pr.getY());

    }

    public void calcularGrosor () {}
}
