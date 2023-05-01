package view.shapes;

import model.Punto;
import java.util.ArrayList;

import model.algorithms.CircleAlgorithm;
import model.algorithms.CircleMidPoint;

public class CircleView extends ShapeView {
    private final Punto center;
    private final int radio;
    public CircleView(Punto center, int radio) {
        this.center = center;
        this.radio = radio;
        shape = new model.shapes.Circle(this.center, this.radio);
        generatePixels();
    }
}
