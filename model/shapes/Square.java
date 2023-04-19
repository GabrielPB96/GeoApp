package model.shapes;
import model.Punto;

import model.algorithms.SquareMidPoint;
import model.algorithms.SquareAlgorithm;

/**
 * Write a description of class Square here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Square extends Shape {
    private Punto topLeftVertex, bottomRightVertex;
    public Square(Punto topLV, Punto bottomRV, SquareAlgorithm algorithm) {
        this.topLeftVertex = topLV;
        this.bottomRightVertex = bottomRV;
        this.algorithm = algorithm;
        vertexs.add(topLeftVertex);
        vertexs.add(bottomRightVertex);
        points= algorithm.generatePoints((int) topLeftVertex.getX(), (int) topLeftVertex.getY(), (int) bottomRightVertex.getX(),
        (int) bottomRightVertex.getY());
    }
    
    public Square(Punto topLV, Punto bottomRV) {
        this(topLV, bottomRV, new SquareMidPoint());
    }
    
    public Punto calculateCenterPoint () {
        int x = (int)((bottomRightVertex.getX() + topLeftVertex.getX()) / 2);
        int y = (int)((topLeftVertex.getY() + (int)bottomRightVertex.getY()) / 2);
        return new Punto(x, y);
    }
    
    public void recalcular () {
        points = ((SquareAlgorithm)algorithm).generatePoints((int) topLeftVertex.getX(), (int) topLeftVertex.getY(), (int) bottomRightVertex.getX(),
                (int) bottomRightVertex.getY());
    }
    
    public void fill () {
        int x = (int)topLeftVertex.getX() + (int)(bottomRightVertex.getX() - topLeftVertex.getX()) / 2;
        int y = (int)topLeftVertex.getY() - (int)(topLeftVertex.getY() - bottomRightVertex.getY()) / 2;
        cuatro_vecinos(x, y);
    }
}
