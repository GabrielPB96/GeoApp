package view.shapes;
import model.Punto;
import java.util.ArrayList;

/**
 * Write a description of class Square here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TriangleView extends ShapeView{
    private final Punto vertexA;
    private final Punto vertexB;
    private final Punto vertexC;
    public TriangleView(Punto vertexA, Punto vertexB, Punto vertexC) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.vertexC = vertexC;
        shape = new model.shapes.Triangle(this.vertexA, this.vertexB, this.vertexC);
        generatePixels();
    }
}
